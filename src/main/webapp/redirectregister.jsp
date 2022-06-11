<%@ page import="swp391.fptqna.utils.GoogleClient" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/6/2022
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Redirect register</title>
    <script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
<% GoogleClient client = new GoogleClient(); %>
<% String googleLoginLink = "https://accounts.google.com/o/oauth2/auth?scope=email https://www.googleapis.com/auth/userinfo.profile&redirect_uri="+client.getGoogleRedirectUri()+"&response_type=code &client_id="+client.getGoogleClientId()+"&approval_prompt=force&state=register";
%>
    <div class="bg-gray-50 grid place-items-center h-screen font-semibold">
        <div class="bg-white rounded-xl shadow-lg h-60 w-7/12 md:w-5/12 lg:w-3/12">
            <div class="p-6 md:p-10 h-full w-full text-center space-y-5 text-gray-700">
                <div class="text-2xl font-bold text-purple-600">Redirecting...</div>
                <div class="px-2">You must register with FPT account</div>
                <button class="border rounded border-gray-300 w-full h-8 flex justify-center content-center pt-1 mt-3">
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" class="h-9 w-9" viewBox="0 0 80 80"><defs><path id="a" d="M44.5 20H24v8.5h11.8C34.7 33.9 30.1 37 24 37c-7.2 0-13-5.8-13-13s5.8-13 13-13c3.1 0 5.9 1.1 8.1 2.9l6.4-6.4C34.6 4.1 29.6 2 24 2 11.8 2 2 11.8 2 24s9.8 22 22 22c11 0 21-8 21-22 0-1.3-.2-2.7-.5-4z"/></defs><clipPath id="b"><use xlink:href="#a" overflow="visible"/></clipPath><path clip-path="url(#b)" fill="#FBBC05" d="M0 37V11l17 13z"/><path clip-path="url(#b)" fill="#EA4335" d="M0 11l17 13 7-6.1L48 14V0H0z"/><path clip-path="url(#b)" fill="#34A853" d="M0 37l30-23 7.9 1L48 0v48H0z"/><path clip-path="url(#b)" fill="#4285F4" d="M48 48L17 24l-4-3 35-10z"/></svg>

                    <a href="<%=googleLoginLink%>"
                       class="font-semibold">
                        Register with Google</a>
                </button>
            </div>
        </div>
    </div>
</body>
</html>
