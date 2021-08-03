<%--
  Created by IntelliJ IDEA.
  User: Angelika
  Date: 01.08.2021
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>View orders | Online-shop</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>

<c:if test="${sessionScope.role.name != 'admin'}">
    <div class="container">
        <div class="row justify-content-center">
            <div class="alert alert-danger fade show " role="alert">
                <fmt:message bundle="${loc}" key="language.noRights"/>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${sessionScope.role.name == 'admin'}">
    <div class="p-3">
        <div class="row justify-content-center">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.orderId"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.fullName"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.mobilePhone"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.title"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.number"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.address"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.orderDate"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.deliveryDate"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.status"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.action"/></th>
                </tr>
                </thead>
                <c:forEach var="userOrder" items="${userOrders}">
                    <tr>
                        <th width="50" scope="row">#<c:out value="${userOrder.id}"/></th>
                        <td width="150" class="text-primary">
                            <c:set scope="request" var="informationNumberFlag" value="0"/>
                            <c:forEach var="order" items="${orders}">
                                <c:forEach var="user" items="${users}">
                                    <c:forEach var="information" items="${userInformation}">
                                        <c:if test="${user.id == order.userId && userOrder.id == order.userOrderId &&
                                        information.id == user.userInformationId && informationNumberFlag == 0}">
                                            <p><c:out value="${information.surname}"/>
                                                <c:out value="${information.name}"/>
                                                <c:out value="${information.patronymic}"/>
                                            </p>
                                            <c:set scope="request" var="informationNumberFlag" value="1"/>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </c:forEach>
                        </td>
                        <td class="text-primary">
                            <c:set scope="request" var="informationNumberFlag" value="0"/>
                            <c:forEach var="order" items="${orders}">
                                <c:forEach var="user" items="${users}">
                                    <c:forEach var="information" items="${userInformation}">
                                        <c:if test="${user.id == order.userId && userOrder.id == order.userOrderId &&
                                        information.id == user.userInformationId && informationNumberFlag == 0}">
                                            <p>+<c:out value="${information.phone}"/></p>
                                            <c:set scope="request" var="informationNumberFlag" value="1"/>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="order" items="${orders}">
                                <c:forEach var="product" items="${products}">
                                    <c:if test="${product.id == order.productId && userOrder.id == order.userOrderId}">
                                        <p><c:out value="${product.name}"/></p>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="order" items="${orders}">
                                <c:if test="${userOrder.id == order.userOrderId}">
                                    <p><c:out value="${order.number}"/></p>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td><c:out value="${userOrder.address}"/></td>
                        <td><c:out value="${userOrder.orderDate}"/></td>
                        <td><c:out value="${userOrder.deliveryDate}"/></td>
                        <td class="text-active"><c:out value="${userOrder.status}"/></td>
                        <td>
                            <button type="button" class="btn btn-outline-success">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-check2" viewBox="0 0 16 16">
                                    <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
                                </svg>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</c:if>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>
