<%--
  Created by IntelliJ IDEA.
  User: Angelika
  Date: 28.07.2021
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>My Orders | Online-shop</title>
    <jsp:include page="fragments/headerLinks.jsp"/>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>
<div class="p-3">
    <div class="row justify-content-center">
        <c:if test="${sessionScope.user == null}">
            <div class="alert alert-danger fade show " role="alert">
                <fmt:message bundle="${loc}" key="language.noRights"/>
            </div>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.orderId"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.title"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.number"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.address"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.orderDate"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.deliveryDate"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.status"/></th>
                </tr>
                </thead>
                <c:forEach var="userOrder" items="${userOrders}">
                    <tr>
                        <th scope="row">#<c:out value="${userOrder.id}"/></th>
                        <td class="text-primary">
                            <c:forEach var="order" items="${orders}">
                                <c:forEach var="product" items="${products}">
                                    <c:if test="${product.id == order.productId && userOrder.id == order.userOrderId}">
                                        <p><c:out value="${product.name}"/></p>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </td>
                        <td class="text-primary">
                            <c:forEach var="order" items="${orders}">
                                <c:if test="${userOrder.id == order.userOrderId}">
                                    <p><c:out value="${order.number}"/></p>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td><c:out value="${userOrder.address}"/></td>
                        <td><c:out value="${userOrder.orderDate}"/></td>
                        <td><c:out value="${userOrder.deliveryDate}"/></td>
                        <c:if test="${userOrder.status == 'получен'}">
                            <td class="text-success"><c:out value="${userOrder.status}"/></td>
                        </c:if>
                        <c:if test="${userOrder.status == 'ожидается'}">
                            <td class="text-active"><c:out value="${userOrder.status}"/></td>
                        </c:if>
                        <c:if test="${userOrder.status == 'отменен'}">
                            <td class="text-danger"><c:out value="${userOrder.status}"/></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>
