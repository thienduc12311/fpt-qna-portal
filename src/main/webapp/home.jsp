<%--
  Created by IntelliJ IDEA.
  User: thienduc
  Date: 31/05/2022
  Time: 07:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

</head>
<body>
<h1>Welcome ${sessionScope.USER.name}</h1>
<img src="${sessionScope.USER.avtUrl}">
<a href="/Logout">log out</a>
</body>
</html>
