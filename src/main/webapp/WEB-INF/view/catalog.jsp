<%--
  Created by IntelliJ IDEA.
  User: Angelika
  Date: 22.07.2021
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>Catalog | Online-shop</title>
</head>
<body>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>
<fmt:setBundle basename="information" var="info"/>

<div class="container">
    <div class="p-3 p-md-4 border rounded-3 my-sm-3">
        <div class="col"></div>
        <div class="col-6">
            <h2><fmt:message bundle="${loc}" key="language.contactInformation"/></h2>
        </div>

    </div>

</div>

</body>
<jsp:include page="fragments/footer.jsp"/>
</html>