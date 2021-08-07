<%--
  Created by IntelliJ IDEA.
  User: Angelika
  Date: 06.06.2021
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>Home | Online-shop</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>
<fmt:setBundle basename="information" var="info"/>

<div class="container">
    <div class="my-sm-3">
        <h3 class="pb-3 my-sm-3"><fmt:message bundle="${info}" key="information.name"/>: <fmt:message bundle="${loc}"
                                                                                                      key="language.info"/>.</h3>
        <h3 class="pb-3 my-sm-3">
            <fmt:message bundle="${loc}" key="language.promotions"/>
        </h3>


<%--        <div class="bd-example">--%>
<%--            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">--%>
<%--                <ol class="carousel-indicators">--%>
<%--                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class=""></li>--%>
<%--                    <li data-target="#carouselExampleIndicators" data-slide-to="1" class="active"></li>--%>
<%--                    <li data-target="#carouselExampleIndicators" data-slide-to="2" class=""></li>--%>
<%--                </ol>--%>
<%--                <div class="carousel-inner">--%>
<%--                    <div class="carousel-item active">--%>
<%--                        <img class="d-block w-100"--%>
<%--                             data-src="holder.js/800x400?auto=yes&amp;bg=777&amp;fg=555&amp;text=Первый слайд"--%>
<%--                             alt="Первый слайд [800x400]"--%>
<%--                             src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22800%22%20height%3D%22400%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20800%20400%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_17b017ea3db%20text%20%7B%20fill%3A%23555%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A40pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_17b017ea3db%22%3E%3Crect%20width%3D%22800%22%20height%3D%22400%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22221.3671875%22%20y%3D%22217.7609375%22%3E%D0%9F%D0%B5%D1%80%D0%B2%D1%8B%D0%B9%20%D1%81%D0%BB%D0%B0%D0%B9%D0%B4%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"--%>
<%--                             data-holder-rendered="true">--%>
<%--                    </div>--%>
<%--                    <c:forEach var="promotion" items="${promotions}">--%>
<%--                        <div class="carousel-item">--%>
<%--                            <img class="d-block w-100"--%>
<%--                                 data-src="holder.js/800x400?auto=yes&amp;bg=777&amp;fg=555&amp;text=Первый слайд"--%>
<%--                                 alt="Первый слайд [800x400]"--%>
<%--                                 src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22800%22%20height%3D%22400%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20800%20400%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_17b017ea3db%20text%20%7B%20fill%3A%23555%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A40pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_17b017ea3db%22%3E%3Crect%20width%3D%22800%22%20height%3D%22400%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22221.3671875%22%20y%3D%22217.7609375%22%3E%D0%9F%D0%B5%D1%80%D0%B2%D1%8B%D0%B9%20%D1%81%D0%BB%D0%B0%D0%B9%D0%B4%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"--%>
<%--                                 data-holder-rendered="true">--%>
<%--                        </div>--%>
<%--                    </c:forEach>--%>
<%--                </div>--%>
<%--                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">--%>
<%--                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>--%>
<%--                    <span class="sr-only">Previous</span>--%>
<%--                </a>--%>
<%--                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">--%>
<%--                    <span class="carousel-control-next-icon" aria-hidden="true"></span>--%>
<%--                    <span class="sr-only">Next</span>--%>
<%--                </a>--%>
<%--            </div>--%>
        </div>


        <h3 class="pb-3 my-sm-3">
            <fmt:message bundle="${loc}" key="language.popularGoods"/>
        </h3>
        <h3 class="pb-3 my-sm-3">
            <fmt:message bundle="${loc}" key="language.ourAdvantages"/>
        </h3>
        <div class="row justify-content-center">
            <table class="table">
                <tr class="text-center">
                    <td width="15%">
                        <h4 class="text-primary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor"
                                 class="bi bi-truck" viewBox="0 0 16 16">
                                <path d="M0 3.5A1.5 1.5 0 0 1 1.5 2h9A1.5 1.5 0 0 1 12 3.5V5h1.02a1.5 1.5 0 0 1 1.17.563l1.481 1.85a1.5 1.5 0 0 1 .329.938V10.5a1.5 1.5 0 0 1-1.5 1.5H14a2 2 0 1 1-4 0H5a2 2 0 1 1-3.998-.085A1.5 1.5 0 0 1 0 10.5v-7zm1.294 7.456A1.999 1.999 0 0 1 4.732 11h5.536a2.01 2.01 0 0 1 .732-.732V3.5a.5.5 0 0 0-.5-.5h-9a.5.5 0 0 0-.5.5v7a.5.5 0 0 0 .294.456zM12 10a2 2 0 0 1 1.732 1h.768a.5.5 0 0 0 .5-.5V8.35a.5.5 0 0 0-.11-.312l-1.48-1.85A.5.5 0 0 0 13.02 6H12v4zm-9 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm9 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
                            </svg>
                        </h4>
                        <h5>
                            <fmt:message bundle="${loc}" key="language.freeDeliveryAllOverBelarus"/>
                        </h5>
                    </td>
                    <td width="15%">
                        <h4 class="text-primary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor"
                                 class="bi bi-shield-check" viewBox="0 0 16 16">
                                <path d="M5.338 1.59a61.44 61.44 0 0 0-2.837.856.481.481 0 0 0-.328.39c-.554 4.157.726 7.19 2.253 9.188a10.725 10.725 0 0 0 2.287 2.233c.346.244.652.42.893.533.12.057.218.095.293.118a.55.55 0 0 0 .101.025.615.615 0 0 0 .1-.025c.076-.023.174-.061.294-.118.24-.113.547-.29.893-.533a10.726 10.726 0 0 0 2.287-2.233c1.527-1.997 2.807-5.031 2.253-9.188a.48.48 0 0 0-.328-.39c-.651-.213-1.75-.56-2.837-.855C9.552 1.29 8.531 1.067 8 1.067c-.53 0-1.552.223-2.662.524zM5.072.56C6.157.265 7.31 0 8 0s1.843.265 2.928.56c1.11.3 2.229.655 2.887.87a1.54 1.54 0 0 1 1.044 1.262c.596 4.477-.787 7.795-2.465 9.99a11.775 11.775 0 0 1-2.517 2.453 7.159 7.159 0 0 1-1.048.625c-.28.132-.581.24-.829.24s-.548-.108-.829-.24a7.158 7.158 0 0 1-1.048-.625 11.777 11.777 0 0 1-2.517-2.453C1.928 10.487.545 7.169 1.141 2.692A1.54 1.54 0 0 1 2.185 1.43 62.456 62.456 0 0 1 5.072.56z"/>
                                <path d="M10.854 5.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
                            </svg>
                        </h4>
                        <h5>
                            <fmt:message bundle="${loc}" key="language.qualityAssurance"/>
                        </h5>
                    </td>
                    <td width="15%">
                        <h4 class="text-primary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor"
                                 class="bi bi-percent" viewBox="0 0 16 16">
                                <path d="M13.442 2.558a.625.625 0 0 1 0 .884l-10 10a.625.625 0 1 1-.884-.884l10-10a.625.625 0 0 1 .884 0zM4.5 6a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm0 1a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5zm7 6a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm0 1a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>
                            </svg>
                        </h4>
                        <h5>
                            <fmt:message bundle="${loc}" key="language.systemOfDiscounts"/>
                        </h5>
                    </td>
                    <td width="15%">
                        <h4 class="text-primary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor"
                                 class="bi bi-credit-card-2-back" viewBox="0 0 16 16">
                                <path d="M11 5.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1z"/>
                                <path d="M2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2zm13 2v5H1V4a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1zm-1 9H2a1 1 0 0 1-1-1v-1h14v1a1 1 0 0 1-1 1z"/>
                            </svg>
                        </h4>
                        <h5>
                            <fmt:message bundle="${loc}" key="language.paymentForGoodsByCreditCard"/>
                        </h5>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="script.js"></script>
</body>
</html>
