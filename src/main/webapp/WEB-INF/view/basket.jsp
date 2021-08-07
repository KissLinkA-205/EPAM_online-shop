<%--
  Created by IntelliJ IDEA.
  User: Angelika
  Date: 01.08.2021
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>Basket | Online-shop</title>
    <jsp:include page="fragments/headerLinks.jsp"/>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>
<fmt:setBundle basename="information" var="info"/>

<form action=${pageContext.request.contextPath}/online-shop method="post">
    <div class="container">
        <div class="my-sm-3">
            <div class="row justify-content-center">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col"><fmt:message bundle="${loc}" key="language.title"/></th>
                        <th scope="col"><fmt:message bundle="${loc}" key="language.number"/></th>
                        <th scope="col"><fmt:message bundle="${loc}" key="language.price"/></th>
                        <th scope="col"><fmt:message bundle="${loc}" key="language.action"/></th>
                    </tr>
                    </thead>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>
                                <c:forEach var="product" items="${products}">
                                    <c:if test="${product.id == order.productId}">
                                        <img src="static/images/${product.photo}" class="img-thumbnail" width="80"
                                             height="80">
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach var="product" items="${products}">
                                    <c:if test="${product.id == order.productId}">
                                        <p><c:out value="${product.name}"/></p>
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:out value="${order.number}"/>
                            </td>
                            <td>
                                <c:forEach var="product" items="${products}">
                                    <c:if test="${product.id == order.productId}">
                                        <p><c:out value="${product.price}"/> <fmt:message bundle="${info}"
                                                                                          key="information.price"/></p>
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-outline-danger" name="orderId"
                                        value="${order.id}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                         fill="currentColor"
                                         class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>
                                        <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"></path>
                                    </svg>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="hidden" name="command" value="deleteOrder"/>
                <h4 class="text-primary"><fmt:message bundle="${loc}" key="language.toPay"/>:
                    <c:out value="${totalCost}"/> <fmt:message bundle="${info}"
                                                               key="information.price"/></h4>

            </div>
            <div class="row justify-content-center">
                <input type="button" class="btn btn-primary" value="<fmt:message bundle="${loc}"
                                                                               key="language.arrange"/>"
                       onClick='location.href="${pageContext.request.contextPath}/online-shop?command=addOrder"'>
        </div>
    </div>
    </div>
</form>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>
