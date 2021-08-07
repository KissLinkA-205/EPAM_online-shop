<%--
  Created by IntelliJ IDEA.
  User: Angelika
  Date: 04.08.2021
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>Add order | Online-shop</title>
    <jsp:include page="fragments/headerLinks.jsp"/>
</head>
<body class="d-flex flex-column h-100">
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>
<fmt:setBundle basename="information" var="info"/>

<div class="container">
    <div class="row justify-content-center">
        <div class="col"></div>
        <div class="col-6 my-sm-3">
            <c:if test="${sessionScope.user == null}">
                <div class="alert alert-danger fade show " role="alert">
                    <fmt:message bundle="${loc}" key="language.noRights"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.user != null}">
            <c:if test="${errorMessage=='true'}">
                <div class="alert alert-danger fade show" role="alert">
                    <fmt:message bundle="${loc}" key="language.dataIsIncorrect"/>
                </div>
            </c:if>

                <h4 class="mt-5 fw-bold"><fmt:message bundle="${loc}" key="language.enterOrderDetails"/></h4>

                <form action="${pageContext.request.contextPath}/online-shop?command=confirmOrder" method="post">

                    <div class="mb-3">
                        <label for="address" class="form-label"><fmt:message bundle="${loc}"
                                                                           key="language.address"/></label>
                        <input type="text" class="form-control" name="address" id="address"
                               placeholder="City, Street **" required></div>

                    <div class="mb-3">
                        <label for="delivery-date" class="form-label"><fmt:message bundle="${loc}"
                                                                          key="language.deliveryDate"/></label>
                        <div class="input-group w-100">
                            <input type="date" class="form-control" id="delivery-date" name="delivery-date" placeholder="date" required></div>
                    </div>

                    <h3 class="text-primary"><fmt:message bundle="${loc}" key="language.toPay"/>:
                        <c:out value="${totalCost}"/> <fmt:message bundle="${info}"
                                                                   key="information.price"/></h3>
                    <div class="col-sm"></div>
                    <br><h4><fmt:message bundle="${loc}" key="language.enterCardDetails"/></h4>

                    <div class="row mb-3">
                        <div class="col-sm mb-3">
                            <label for="cardholder-name" class="form-label"><fmt:message bundle="${loc}" key="language.cardholderName"/></label>
                            <div class="input-group">
                                <input type="text" id="cardholder-name" name="cardholder-name" class="form-control"
                                       placeholder="Name Surname" required
                                       maxlength="45"
                                       pattern="\b[A-Z].*?\b"></div>
                        </div>

                        <div class="col-sm">
                            <label for="cvv" class="form-label">CVV</label>
                            <div class="input-group">
                                <input type="password" class="form-control" id="cvv" name="cvv"
                                       placeholder="000" pattern="^[0-9]{3}$" required></div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="card-number" class="form-label"><fmt:message bundle="${loc}" key="language.cardNumber"/></label>
                        <div class="input-group w-100">
                            <input type="text" class="form-control" id="card-number" name="card-number" placeholder="0000111122223333"
                                   pattern="^[0-9]{16}$" required></div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-sm mb-3">
                            <label for="month" class="form-label"><fmt:message bundle="${loc}" key="language.month"/></label>
                            <div class="input-group w-50">
                                <input type="text" class="form-control" id="month" name="month"
                                       placeholder="12" pattern="^([1-9]|1[012])$" required></div>
                        </div>

                        <div class="col-sm">
                            <label for="year" class="form-label"><fmt:message bundle="${loc}" key="language.year"/></label>
                            <div class="input-group w-50">
                                <input type="text" class="form-control" id="year" name="year"
                                       placeholder="2021" pattern="^[0-9]{4}$" required></div>
                        </div>
                    </div>

                    <button class="btn btn-primary" type="submit" name="command" value="confirmOrder"><fmt:message bundle="${loc}"
                                                                               key="language.confirm"/></button>

                </form>
                <hr class="dropdown-divider">
                <a href="/online-shop?command=main"><fmt:message bundle="${loc}" key="language.home"/></a>
        </div>
        </c:if>
        <div class="col-sm"></div>
    </div>
</div>
</body>
</html>
