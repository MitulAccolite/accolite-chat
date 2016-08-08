<%@ page import="com.accolite.chat.dao.IUserDao" %>
<%@ page import="com.accolite.chat.dao.impl.UserDao" %>
<%@ page import="com.accolite.chat.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lokesh K
  Date: 02 Aug 2016
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>Group :: Accolite office chat</title>

    <link href="<c:url value="/resources/theme1/css/metro.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/metro-icons.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/metro-responsive.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/group.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/app_bar.css" />" rel="stylesheet">

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
            <li>
                <a href="userprofile?user=${user.email}" class="userhandle">
                    <img src="<c:url value="/resources/theme1/img/placeholder.jpg"/>" width="32" height="32" alt="nick name">
                    <span class="nickname">${user.nickName}</span>
                </a>
            </li>
            <li><a href="logout?user=${user.email}" class="logout">logout</a></li>
        </ul>
    </div>
</header>

<section class="bg-grayLighter">
    <span class="gedit" title="edit your group"><span class="mif-pencil"></span> Edit</span>
    <div class="tile dptile">
        <div class="tile-content zooming-out">
            <div class="slide">
                <image src="resources/theme1/img/placeholder.jpg" alt="group image" width="width"/>
            </div>
        </div>
    </div>
    <div>
        <h1>${group.name}</h1>
        <h2><small>Created: ${group.created.date}/${group.created.month}/${1900+group.created.year}</small></h2>
    </div>
    <div class="people">
        <h2>People</h2>
        <ul>

            <d:forEach items="${group.getUsers()}" var="user">
                <li>
                    <a href="profileView?user=${user.email}">
                        <div class="panel">
                            <div class="heading">
                                <span class="icon mif-user"></span>
                                <span class="title">${user.nickName}</span>
                                <span class="mif-user-minus leaveg"></span>
                                <input type="hidden" value=${user.id} class="userID">
                            </div>
                        </div>
                    </a>
                </li>
            </d:forEach>
        </ul>
    </div>
</section>
<input type="hidden" value=${user.id} id="UserID">
<input type="hidden" value="1" id="groupID">
<script src="<c:url value="/resources/theme1/js/app_bar.js"/>"></script>
<script src="<c:url value="/resources/theme1/js/group_view.js"/>"></script>
</body>
</html>
