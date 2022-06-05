<%@ page import="swp391.fptqna.utils.GoogleClient" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <% GoogleClient client = new GoogleClient(); %>
    <% String googleLoginLink = "https://accounts.google.com/o/oauth2/auth?scope=email https://www.googleapis.com/auth/userinfo.profile&redirect_uri="+client.getGoogleRedirectUri()+"&response_type=code &client_id="+client.getGoogleClientId()+"&approval_prompt=force";
    %>
    <title>JSP - Hello World %></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

</h1>
<br/>

<div class="text-center">
    <a class="btn btn-outline-dark" href="<%=googleLoginLink%>"> <img
            width="20px" style="margin-bottom:3px; margin-right:5px" alt="Google sign-in"
            src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png"/>
        Login
        With Google</a>
</div>

</body>
<%--<!-- Include stylesheet -->--%>
<%--<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">--%>

<%--<!-- Create the editor container -->--%>
<%--<div id="editor">--%>
<%--    <p>Hello World!</p>--%>
<%--    <p>Some initial <strong>bold</strong> text</p>--%>
<%--    <p><br></p>--%>
<%--</div>--%>

<%--<!-- Include the Quill library -->--%>
<%--<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>--%>

<%--<!-- Initialize Quill editor -->--%>
<%--<script>--%>
<%--    var quill = new Quill('#editor', {--%>
<%--        theme: 'snow'--%>
<%--    });--%>
<%--</script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>--%>
</html>