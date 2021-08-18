<%--
  Created by IntelliJ IDEA.
  User: Angelika
  Date: 09.08.2021
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>Edit product | Online-shop</title>
</head>
<body class="d-flex flex-column h-100">
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

                <c:if test="${param.message == 'error'}">
                    <div class="alert alert-danger fade show " role="alert">
                        <fmt:message bundle="${loc}" key="language.productAddingError"/>
                    </div>
                </c:if>

                <form action="${pageContext.request.contextPath}/online-shop?command=confirmEditProduct"
                      method="post">
                    <h4><fmt:message bundle="${loc}" key="language.enterProductDetails"/></h4>

                    <div class="mb-3">
                        <label for="title" class="form-label"><fmt:message bundle="${loc}"
                                                                           key="language.nameOfProduct"/></label>
                        <input type="text" class="form-control" name="product-name" id="title"
                               placeholder="<fmt:message bundle="${loc}" key="language.nameOfProduct"/>" required
                        value="${product.name}">
                    </div>

                    <div class="row mb-3">
                        <div class="col-sm mb-3">
                            <label for="photo" class="form-label"><fmt:message bundle="${loc}"
                                                                               key="language.productPhoto"/></label>
                            <input type="text" id="photo" name="photo" class="form-control"
                                   placeholder="<fmt:message bundle="${loc}" key="language.productPhoto"/>" required
                                   value="${product.photo}">
                        </div>

                        <div class="col-sm">
                            <label for="price" class="form-label"><fmt:message bundle="${loc}"
                                                                               key="language.price"/></label>
                            <input type="text" id="price" name="price" class="form-control"
                                   placeholder="100.15" pattern="^\d+\.\d{0,2}$" required
                                   value="${product.price}">
                        </div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-sm mb-3">
                            <label for="category" class="form-label"><fmt:message bundle="${loc}" key="language.category"/></label>
                            <input type="text" name="category" id="category" class="form-control"
                                   placeholder="<fmt:message bundle="${loc}" key="language.category"/>" required
                                   value="${category.categoryName}">
                        </div>

                        <div class="col-sm mb-3">
                            <label for="promotion" class="form-label"><fmt:message bundle="${loc}" key="language.promotionId"/></label>
                            <input type="text" name="promotion" id="promotion" class="form-control" pattern="(?<![-.])\b[0-9]+\b(?!\.[0-9])"
                                   placeholder="<fmt:message bundle="${loc}" key="language.promotionId"/>" required
                                   value="${product.promotionId}">
                        </div>

                        <div class="col-sm">
                            <fieldset class="form-group">
                                <div class="form-check">
                                    <input type="checkbox" name="availability" class="form-check-input" id="exampleCheck1"
                                           <c:if test="${product.status == true}">
                                           checked
                                           </c:if>
                                    <label class="form-check-label" for="exampleCheck1"><fmt:message bundle="${loc}" key="language.availability"/></label>
                                </div>
                            </fieldset>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="description" class="form-label"><fmt:message bundle="${loc}"
                                                                                 key="language.description"/></label>
                        <textarea class="form-control" name="description" id="description"
                               placeholder="<fmt:message bundle="${loc}" key="language.description"/>" required><c:out value="${product.description}"/>
                        </textarea>
                    </div>

                    <input type="hidden" name="productId" value="${param.productId}">

                    <button class="btn btn-primary" type="submit"><fmt:message bundle="${loc}"
                                                                               key="language.confirm"/></button>
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
