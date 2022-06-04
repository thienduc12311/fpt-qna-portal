<%--
  Created by IntelliJ IDEA.
  User: thienduc
  Date: 31/05/2022
  Time: 08:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Login error, ${sessionScope.ERROR}</h1>
<div class="text-center">
    <a class="btn btn-outline-dark" href="https://accounts.google.com/o/oauth2/auth?scope=email https://www.googleapis.com/auth/userinfo.profile&redirect_uri=http://localhost:8080/login-google&response_type=code
    &client_id=439318717683-v1og8jquc6kn82nua7sun6cbvkt2oprb.apps.googleusercontent.com&approval_prompt=force"> <img
            width="20px" style="margin-bottom:3px; margin-right:5px" alt="Google sign-in"
            src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png"/>
        Login
        With Google</a>
</div>
</body>
</html>
