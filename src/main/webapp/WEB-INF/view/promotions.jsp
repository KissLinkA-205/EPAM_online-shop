<%--
  Created by IntelliJ IDEA.
  User: Angelika
  Date: 22.07.2021
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/header.jsp"/>
<title>Promotions | Online-shop</title>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>
<div class="container">
    <c:forEach var="promotion" items="${promotions}">
        <div class="my-lg-4">
            <div class="col-6"></div>
            <div class="card text-center">
                <div class="card-header">
                    <h3><c:out value="${promotion.name}"/>
                        <small class="text-muted"> #<c:out value="${promotion.id}"/></small>
                    </h3>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-8">
                            <img src="static/images/<c:out value="${promotion.photo}"/>" class="img-fluid" width="600"
                                 height="800">
                        </div>
                        <div class="col-md-4">
                            <h3><fmt:message bundle="${loc}" key="language.discount"/>: <c:out
                                    value="${promotion.discount}"/>%</h3>
                            <p><fmt:message bundle="${loc}" key="language.description"/>: <c:out
                                    value="${promotion.description}"/></p>
                        </div>
                    </div>

                </div>
                <div class="card-footer text-muted">
                    <fmt:message bundle="${loc}" key="language.from"/> <c:out value="${promotion.beginningDate}"/>
                    <fmt:message bundle="${loc}" key="language.to"/> <c:out value="${promotion.expirationDate}"/>
                </div>
            </div>
        </div>
    </c:forEach>
    <p class="text-secondary">* <fmt:message bundle="${loc}" key="language.promotionsNote"/></p>
</div>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>