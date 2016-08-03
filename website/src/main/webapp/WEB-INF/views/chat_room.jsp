<%@ taglib prefix="commandName" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mitul Kapoor
  Date: 7/31/2016
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accolite Chat Room</title>
</head>
<body>
Chat Room Appears Here

Username : ${username}
Password : ${password}

Details :
Name : ${user.firstName}
LastName : ${user.lastName}
NickName : ${user.nickName}
Email : ${user.email}

<form action="/profileView">
    <input type="hidden" value="${user.email}" name="user">
    <input type="submit" value="View Profile"/>
</form>

</body>
</html>
