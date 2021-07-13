package by.epam.onlineShop.connection;

import by.epam.onlineShop.exeptions.ConnectionException;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private Queue<ProxyConnection> availableConnections;
    private Queue<ProxyConnection> connectionsInUse;
    private static final ReentrantLock FIRST_LOCK = new ReentrantLock();
    private static final ReentrantLock SECOND_LOCK = new ReentrantLock();
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);
    private static ConnectionPool instance;
    private static final int POOL_SIZE = 10;

    private ConnectionPool() throws ConnectionException {
        availableConnections = new ArrayDeque<>(POOL_SIZE);
        connectionsInUse = new ArrayDeque<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            ProxyConnection connection = ConnectionFactory.createConnection();
            availableConnections.offer(connection);
        }
    }

    public static ConnectionPool getInstance() throws ConnectionException {
        if (!instanceCreated.get()) {
            FIRST_LOCK.lock();
            if (!instanceCreated.get()) {
                instance = new ConnectionPool();
                instanceCreated.set(true);
            }
            FIRST_LOCK.unlock();
        }
        return instance;
    }

    public void releaseConnection(ProxyConnection proxyConnection) {
        SECOND_LOCK.lock();
        try {
            if (connectionsInUse.contains(proxyConnection)) {
                availableConnections.offer(proxyConnection);
                connectionsInUse.remove(proxyConnection);
            }
        } finally {
            SECOND_LOCK.unlock();
        }
    }

    public ProxyConnection getConnection() {
        ProxyConnection toReturn = availableConnections.remove();
        connectionsInUse.add(toReturn);
        return toReturn;
    }

    public void destroy() throws ConnectionException {
        for (ProxyConnection connection : getInstance().connectionsInUse) {
            this.releaseConnection(connection);
        }
        for (ProxyConnection connection : getInstance().availableConnections) {
            connection.closeConnection();
        }
    }
}
