<%--
  Created by IntelliJ IDEA.
  User: Angelika
  Date: 07.06.2021
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/header.css"/>
</head>

<header>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="localization.language" var="loc"/>

    <form action=${pageContext.request.contextPath}/online-shop>
        <div class="header-panel">
            <img src="static/images/online_shop.png" align="left" width="100" height="60"/>
            <a class="header-text" href="${pageContext.request.contextPath}/online-shop?command=main">Online-shop</a>
            <a class="header-text">
                <fmt:message bundle="${loc}" key="language.catalog"/>
            </a>
            <a class="header-text">
                <fmt:message bundle="${loc}" key="language.promotions"/>
            </a>
            <a class="header-text" href="${pageContext.request.contextPath}/online-shop?command=contacts">
                <fmt:message bundle="${loc}" key="language.contacts"/>
            </a>

            <c:choose>
                <c:when test="${sessionScope.username == null}">
                    <button class="login-button" type="submit" name="command" value="login">
                        <fmt:message bundle="${loc}" key="language.logIn"/>
                    </button>
                </c:when>
            </c:choose>

            <c:choose>
                <c:when test="${sessionScope.language=='en'}">
                    <a href="${pageContext.request.contextPath}/online-shop?command=language&language=ru&path=${pageContext.request.servletPath}"
                       class="language-text" align="right" style="color: #a3a3a3">
                        RU
                    </a>
                    <img class="header-image" src="static/images/RU.png" align="right" width="30" height="20"/>
                    <a href="${pageContext.request.contextPath}/online-shop?command=language&language=en&path=${pageContext.request.servletPath}"
                       class="language-text" align="right">
                        EN
                    </a>
                    <img class="header-image" src="static/images/EN.png" align="right" width="30" height="20"/>
                </c:when>
            </c:choose>

            <c:choose>
                <c:when test="${sessionScope.language=='ru'}">
                    <a href="${pageContext.request.contextPath}/online-shop?command=language&language=ru&path=${pageContext.request.servletPath}"
                       class="language-text" align="right">
                        RU
                    </a>
                    <img class="header-image" src="static/images/RU.png" align="right" width="30" height="20"/>
                    <a href="${pageContext.request.contextPath}/online-shop?command=language&language=en&path=${pageContext.request.servletPath}"
                       class="language-text" align="right" style="color: #a3a3a3">
                        EN
                    </a>
                    <img class="header-image" src="static/images/EN.png" align="right" width="30" height="20"/>
                </c:when>
            </c:choose>
        </div>
    </form>
</header>