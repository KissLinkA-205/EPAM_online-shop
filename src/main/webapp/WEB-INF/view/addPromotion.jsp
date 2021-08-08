<%--
  Created by IntelliJ IDEA.
  User: Angelika
  Date: 01.08.2021
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>Add promotion | Online-shop</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-6 my-sm-3">
            <c:if test="${sessionScope.role.name != 'admin'}">
                <div class="alert alert-danger fade show " role="alert">
                    <fmt:message bundle="${loc}" key="language.noRights"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.role.name == 'admin'}">
                <form action="${pageContext.request.contextPath}/online-shop?command=confirmAddingPromotion" method="post">
                <h4><fmt:message bundle="${loc}" key="language.enterProductDetails"/></h4>

                <div class="mb-3">
                    <label for="title" class="form-label"><fmt:message bundle="${loc}"
                                                                       key="language.title"/></label>
                    <input type="text" class="form-control" name="title" id="title"
                           placeholder="Name of product" required>
                </div>

                <div class="row mb-3">
                    <div class="col-sm mb-3">
                        <label for="beginning-date" class="form-label">Дата начала</label>
                        <div class="input-group w-100">
                            <input type="date" class="form-control" id="beginning-date" name="beginning-date"
                                   placeholder="date" required></div>
                    </div>

                    <div class="col-sm">
                        <label for="expiration-date" class="form-label">Дата начала</label>
                        <div class="input-group w-100">
                            <input type="date" class="form-control" id="expiration-date" name="expiration-date"
                                   placeholder="date" required></div>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-sm mb-3">
                        <label for="photo" class="form-label">Фото</label>
                        <input type="text" name="photo" id="photo" class="form-control"
                               placeholder="category" required>
                    </div>

                    <div class="col-sm mb-3">
                        <label for="price" class="form-label">Размер скидки</label>
                        <input type="text" name="price" id="price" class="form-control"
                               placeholder="1" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="description" class="form-label"><fmt:message bundle="${loc}"
                                                                             key="language.description"/></label>
                    <input type="text" class="form-control" name="description" id="description"
                           placeholder="Description" required>
                </div>

                <button class="btn btn-primary" type="submit"><fmt:message bundle="${loc}"
                                                                           key="language.add"/></button>
                </form>
                <hr class="dropdown-divider">
                <a href="/online-shop?command=main"><fmt:message bundle="${loc}" key="language.home"/></a>
            </c:if>
        </div>
    </div>
</div>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>