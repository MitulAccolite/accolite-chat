<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lokesh K
  Date: 05 Aug 2016
  Time: 10:18 AM
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

    <title>Profile :: Accolite office chat</title>

    <link href="<c:url value="/resources/theme1/css/metro.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/metro-icons.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/metro-responsive.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/profile_edit.css" />" rel="stylesheet">
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
    <span class="pedit" title="edit your profile"><span class="mif-pencil"></span> Edit</span>
    <div class="tile dptile">
        <div class="tile-content zooming-out">
            <div class="slide">
                <image src="resources/theme1/img/placeholder.jpg" alt="profile image" width="width"/>
            </div>
        </div>
    </div>
    <div>
        <h1>${user.nickName}</h1>
        <h2><small>${user.firstName} ${user.middleName} ${user.lastName}</small></h2>
        <h3><small>${user.email}</small></h3>
        <h3><small>9898989898</small></h3>
    </div>
    <div class="groups">
        <h2>Groups</h2>
        <ul>

            <d:forEach items="${user.chatGroups}" var="groups">
                <li>
                    <a href="groupview.jsp">
                        <div class="panel">
                            <div class="heading">
                                <img class="icon" src="resources/theme1/img/placeholder.jpg">
                                <span class="title">${groups.name}</span>
                            </div>
                        </div>
                    </a>
                </li>
            </d:forEach>

        </ul>
    </div>
</section>
<input type="hidden" value=${user.id} id="userID">
<input type="hidden" value=${user.email} id="userEmail">
<script src="<c:url value="/resources/theme1/js/app_bar.js"/>"></script>
<script src="<c:url value="/resources/theme1/js/user_view.js"/>"></script>
</body>
</html>