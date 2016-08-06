<%@ page import="manager.ChatManager" %>
<%@ page import="com.accolite.chat.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Lokesh K
  Date: 02 Aug 2016
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="description"
          content="Accolite office chat, a sleek, intuitive, and powerful framework for faster and easier communication.">
    <meta name="keywords"
          content="Accolite, chat, office-chat, message, connect, team, communicate">
    <meta name="author" content="Lokesh, Sachin, Diksha and Mitul">

    <!-- <link rel='shortcut icon' type='image/x-icon' href='../favicon.ico' /> -->

    <title>Chat Room :: Accolite office chat</title>

    <link href="<c:url value="/resources/theme1/css/metro.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/metro-icons.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/metro-responsive.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/chat_room.css" />" rel="stylesheet">

    <script src="<c:url value="/resources/theme1/js/jquery-2.1.3.min.js"/>"></script>
    <script src="<c:url value="/resources/theme1/js/metro.js"/>"></script>
</head>
<body>
<header>
    <div class="app-bar" data-role="appbar">

        <a class="app-bar-element branding">Accolite Chat</a>

        <ul class="app-bar-menu">
            <li><a href="">Home</a></li>
            <li><a href="">Support</a></li>
            <li><a href="">Help</a></li>
        </ul>
    </div>
</header>


<section>
    <div class="tile dont-transform grouplist bg-white" data-role="tile">
        <h4>Groups</h4>
        <ul>
<d:forEach items="${user.chatGroups}" var="groups">
                    <%--<d:out value="${groups.name}"/>--%>
                <li>
                    <div class="gsettings">
                        <span></span>
                    </div>
                    <a href="${groups.name}">
                        <img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="20" height="20" alt="group name">
                        <span class="gname">${groups.name}</span>
                        <span class="gloader"></span>
                    </a>
                </li>
            </d:forEach>

        </ul>
    </div>
    <div class="chatarea">
        <div class="tile dont-transform chatbox bg-white" data-role="tile">
            <ul>
                <li class="day-divider">
                    <abbr>today</abbr>
                </li>
                <li class="msg-body">
                    <div class="dp-container">
                        <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                    </div>
                    <div class="msg-container">
                        <div class="msg-timestamp">
                            <abbr title="Today" >12:00pm</abbr>
                        </div>
                        <strong>
                            <a href="#">User NickName</a>
                        </strong>
                        <div class="message">
                            <p>Neruppuda! Nerunguda!</p>
                        </div>
                    </div>
                </li>
                <li class="msg-body">
                    <div class="dp-container">
                        <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                    </div>
                    <div class="msg-container">
                        <div class="msg-timestamp">
                            <abbr title="Today" >12:00pm</abbr>
                        </div>
                        <strong>
                            <a href="#">User NickName</a>
                        </strong>
                        <div class="message">
                            <p>Neruppuda! Nerunguda!</p>
                        </div>
                    </div>
                </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li><li class="msg-body">
                <div class="dp-container">
                    <a href="#"><img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="user nickname"></a>
                </div>
                <div class="msg-container">
                    <div class="msg-timestamp">
                        <abbr title="Today" >12:00pm</abbr>
                    </div>
                    <strong>
                        <a href="#">User NickName</a>
                    </strong>
                    <div class="message">
                        <p>Neruppuda! Nerunguda!</p>
                    </div>
                </div>
            </li>
            </ul>
        </div>
        <div class="tile dont-transform chatinput bg-white" data-role="tile">
            <div class="input-control textarea full-size">
                <textarea class="chattext" placeholder="Type a message ..."></textarea>
                <button class="sender" title="send"><span class="mif-pencil"></span></button>
            </div>
        </div>
    </div>
    <div class="tile dont-transform userlist bg-white" data-role="tile">
        <div class="userpan">

            <%
                Set<User> activeUsers = ChatManager.getActiveUsers();

    %>


<%--
            <a href="${groups.name}">
                <img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="20" height="20" alt="group name">
                <span class="gname">${groups.name}</span>
                <span class="gloader"></span>
            </a>
            --%>
            <%--<d:choose>
                <d:when test="${empty user}">
                    I see!  You don't have a name.. well.. Hello no name
                </d:when>
                <d:otherwise>
                    <%@ include file="response.jsp" %>
                </d:otherwise>
            </d:choose>--%>

            <ul>
                <% for(User user1 : activeUsers){%>
                <d:set var="userId" value="<%=user1.getId()%>"></d:set>
                    <d:if test="${user.id ne userId}">
                        <li>
                            <a href="profileView?user=<%=user1.getEmail()%>">
                                <img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="38" height="38" alt="nick name">
                                <span class="nickname"><%=user1.getNickName() %></span>
                                <span class="onlinestatus online"></span>
                            </a>
                        </li>
                </d:if>
                <% }%>
            </ul>
        </div>
        <div class="userquery">
            <input type="text" placeholder="search">
            <span class="mif-search"></span>
        </div>
    </div>
</section>
<input type="hidden" value="1" id="userID">
<input type="hidden" value="1" id="groupID">
    <script src="<c:url value="/resources/theme1/js/chat_room.js"/>"></script>
</body>
</html>