<%--
  Created by IntelliJ IDEA.
  User: Lokesh K
  Date: 09 Aug 2016
  Time: 9:58 PM
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

    <title>Group Create:: Accolite office chat</title>

    <link href="<c:url value="/resources/theme1/css/metro.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/metro-icons.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/metro-responsive.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/theme1/css/group_create.css" />" rel="stylesheet">
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
    <div class="wizard2 groupCreationWizard" data-role="wizard2"
         data-button-labels='{"help": "?", "prev": "<span class=\"mif-arrow-left\"></span>", "next": "<span class=\"mif-arrow-right\"></span>", "finish": "<span class=\"mif-checkmark\"></span>"}'>

        <div class="step">
            <div class="step-content">
                <p class="text-small lowercase no-margin">Group Create</p>
                <h1 class="no-margin-top sub-leader">Name</h1>
                <div class="grid">
                    <div class="row">
                        <div class="cell">
                            <div class="input-control modern text iconic" data-role="input">
                                <input id="groupName" name="groupName" type="text" style="padding-right: 5px;">
                                <span class="label">Your Group Name</span>
                                <span class="informer">Please enter your group name</span>
                                <span class="placeholder" style="display: block;">Public</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="text-small padding20 bg-grayLighter">
                    Edit your Group Name.
                </div>
            </div>
        </div>

        <div class="step">
            <div class="step-content">
                <p class="text-small lowercase no-margin">Group Create</p>
                <h1 class="no-margin-top sub-leader">People</h1>
                <div class="input-control text peopleSearch">
                    <span class="mif-user prepend-icon"></span>
                    <input type="text" value="" placeholder="Enter to search a user">
                </div>
                <div class="peopleEdit">
                    <ul>
                        <d:forEach items="${pGroup}" var="user">
                            <li>
                                <a href="profileView?user=${user.email}">
                                    <div class="panel">
                                        <div class="heading">
                                            <span class="icon mif-user"></span>
                                            <span class="title">${user.nickName}</span>
                                            <span class="mif-user-plus gentry"></span>
                                            <input type="hidden" value=${user.id} class="userID">
                                        </div>
                                    </div>
                                </a>
                            </li>
                        </d:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<input type="hidden" value=${user.id} id="userID">
<input type="hidden" value=${user.email} id="userEmail">
<script src="<c:url value="/resources/theme1/js/app_bar.js"/>"></script>
<script src="<c:url value="/resources/theme1/js/group_create.js"/>"></script>
</body>
</html>
