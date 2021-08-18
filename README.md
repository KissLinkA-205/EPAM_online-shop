<h2 align="center"> 🎓 Java Web Development<br/>EPAM Systems<br/>Minsk, Belarus (Минск, Беларусь)<br/>March 2021<br/>Final project: Online-shop</h2>

<h4> EN: All copyrights to the terms of the project provided below belong to the company 
<a href="https://www.epam.com/" rel="nofollow">EPAM</a></br>
RU: Все авторские права на предоставленные ниже условия проекта принадлежат компании 
<a href="https://www.epam.com/" rel="nofollow">EPAM</a></br>
</h4>
<hr align="center">

<h2> 
📑 Содержание
</h2>
<li><a href="#тема-проекта">Тема проекта</a></li>
<li><a href="#требования-к-БД">Требования к БД </a></li>
<li><a href="#базовые-требования-к-приложению">Базовые требования к приложению</a></li>
<li><a href="#минимальные-требования-к-функциональности-приложения">Минимальные требования к функциональности приложения</a></li>
<li><a href="#схема-БД">Схема БД</a></li>

<h2> 
<a id="user-content-тема-проекта" class="anchor" aria-hidden="true" href="#тема-проекта">
<svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true">
<path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path>
</svg></a>
🛒 Тема проекта 
</h2>
<p>
Система <strong>Интернет-магазин</strong>. Администратор осуществляет ведение каталога товаров и акций. Клиент делает и оплачивает заказ на товары. <br><br>
На сайте можно посмотреть контактные данные интернет-магазина, каталог товаров и акций. Пользователь может войти в аккаунт или зарегистрировать новый. Реализована смена языков (RU и EN).<br>
<strong>При авторизации</strong> можно просмотреть свой профиль, добавить товары (при их наличии) в корзину или удалить их из неё. 
Также пользователь может оформить заказ и просмотреть все свои заказы.<br>
<strong>Администратор</strong> может добавить или изменить новый продукт и акцию. Реализован просмотр администратором всех активных заказов пользователей с их личной информацией, 
есть возможность подтверждения получения заказа или отмена его.
</p>

<h2> 
<a id="user-content-требования-к-БД" class="anchor" aria-hidden="true" href="#требования-к-БД">
<svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true">
<path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path>
</svg></a>
📚 Требования к БД 
</h2>
<p>
• Информация о предметной области должна храниться в БД<br>
• Если данные в базе хранятся на кириллице, рекомендуется применять кодировку utf-8<br>
• Технология доступа к БД только JDBC<br>
• Для работы с БД в приложении должен быть реализован потокобезопасный пул соединений, использовать synchronized и volatile запрещено<br>
• При проектировании БД рекомендуется использовать не более 6-8 таблиц<br>
• Работу с данными в приложении осуществлять посредством шаблонов DAO или Specification<br>
• Реализовать защиту от sql injection<br>
</p>

<h2> 
<a id="user-content-базовые-требования-к-приложению" class="anchor" aria-hidden="true" href="#базовые-требования-к-приложению">
<svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true">
<path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path>
</svg></a>
🗿 Базовые требования к приложению 
</h2>
<p>
• Приложение реализовать применяя технологии Servlet и JSP<br>
• Архитектура приложения должна соответствовать шаблонам Layered architecture и MVC Controller может быть только двух видов: контроллер роли или контроллер приложения<br>
• Интерфейс приложения должен быть локализован; выбор из языков: EN|BE|DE etc<br>
• Приложение должно корректно обрабатывать возникающие исключительные ситуации, в том числе вести их логи. В качестве логгера использовать Log4J2/SLF4J<br>
• Классы и другие сущности приложения должны быть грамотно структурированы по пакетам и иметь отражающую их функциональность название<br>
• При реализации бизнес-логики приложения следует при необходимости использовать шаблоны проектирования (например, шаблоны GoF: Factory Method, Command, Builder,
Strategy, State, Observer, Singleton, Proxy etc)<br>
• Для хранения пользовательской информации между запросами использовать сессию<br>
• Для перехвата и корректировки объектов запроса (request) и ответа (response) применить фильтры<br>
• Разрешается использовать технологии AspectJ и Web-services<br>
• При реализации страниц JSP следует использовать теги библиотеки JSTL<br>
• Использовать скриплеты запрещено<br>
• При реализации пользовательского интерфейса разрешается использовать любые технологии front-end разработки (js, AJAX)<br>
• Реализовать защиту от cross site scripting (xss)<br>
• Реализовать защиту от повторного выполнения запроса нажатием F5<br>
• Реализовать собственные теги<br>
• Просмотр “длинных списков” желательно организовывать в постраничном режиме<br>
• Валидацию входных данных производить на клиенте и на сервере<br>
• Документацию к проекту необходимо оформить согласно требованиям javadoc<br>
• Оформление кода должно соответствовать Java Code Convention<br>
• При развертывании приложения разрешается использовать технологию Maven<br>
• Приложение должно содержать тесты TestNG, JUnit, Mockito или EasyMock.
</p>

<h2> 
<a id="user-content-минимальные-требования-к-функциональности-приложения" class="anchor" aria-hidden="true" href="#минимальные-требования-к-функциональности-приложения">
<svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true">
<path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path>
</svg></a>
⚙ Минимальные требования к функциональности приложения 
</h2>
<p>
• Авторизация (sign in) и выход (sign out) в/из системы<br>
• Регистрация пользователя и/или добавление артефакта предметной области системы<br>
• Просмотр информации (например: просмотр всех ставок тотализатора, статистики заказов, счетов и т.д.)<br>
• Удаление информации (например: отмена заказа, удаление сущности и т.д.)<br>
• Добавление и модификация информации (например: создать и отредактировать товар, создать и отредактировать заказ и т.д.)<br>
</p>

<h2> 
<a id="user-content-схема-БД" class="anchor" aria-hidden="true" href="#схема-БД">
<svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true">
<path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path>
</svg></a>
📊 Схема БД 
</h2>
<p align="center">
  <img src="https://github.com/KissLinkA-205/EPAM_online-shop/blob/master/database/onlineShop.png" width="1000" title="hover text">
</p>