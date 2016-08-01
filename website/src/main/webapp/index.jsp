<%--
  Created by IntelliJ IDEA.
  User: Mitul Kapoor
  Date: 7/30/2016
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>

    <%--<script src="https://apis.google.com/js/platform.js" async defer></script>
    <script>
      function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        var value = 'ID: ' + profile.getId() + 'Name: ' + profile.getName() + 'Image URL: ' + profile.getImageUrl() + 'Email: ' + profile.getEmail();
        alert(value);
        /*
        console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail());*/
      }

      function signOut() {
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
          console.log('User signed out.');
        });
      }


    </script>
--%>
    <title>$Title$</title>
  </head>
  <body>

  <%--
  <div class="g-signin2" data-onsuccess="onSignIn"></div>

  <a href="#" onclick="signOut();">Sign out</a>

<div style="background-color: #00aba9">
  <span id="googleSignIn">
    <span id="signInButton">
    </span>
</span>
</div>
--%>
  <form action="/login">
    <input type="submit" value="Click to continue">
  </form>

  </body>
</html>
