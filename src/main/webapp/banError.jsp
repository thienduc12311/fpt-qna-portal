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
    <title>Ban Error</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href='https://fonts.googleapis.com/css?family=Inter' rel='stylesheet'>
    <style>
        body {
            font-family: 'Inter';
        }
    </style>
</head>
<body>

<%@include file="header.jsp" %>
<div class="container w-1/2 lg:w-1/3 h-[80vh] mx-auto flex gap-y-6 flex-col justify-center items-center mt-28">
    <!-- Card start -->
    <div
            class="w-8/12 lg:w-full h-auto bg-white p-11 flex flex-col items-center justify-center gap-y-4 rounded-xl shadow-[0px_2px_4px_rgba(0,0,0,0.06),0px_4px_6px_rgba(0,0,0,0.1)]">
        <div class="w-auto h-auto p-3 lg:p-11 bg-[#D5F5F6] rounded-full">
            <img
                    src="https://static.vecteezy.com/system/resources/previews/004/112/200/original/login-access-denied-illustration-system-refuses-password-error-and-entry-to-computer-device-showing-user-does-not-have-permission-for-website-or-mobile-development-vector.jpg"
                    alt="Ban Error"/>
        </div>
        <div class="mt-5 text-center mx-10">
            <h4 class="mb-2 lg:mb-5 text-red-500 text-4xl lg:text-[50px] font-bold">You're banned!</h4>
            <p class="text-lg font-medium">Your account is banned due to policy violation. A detail email has been sent
                to
                you. If there are any mistakes, please reply the email! Thank you.</p>
        </div>
        <a href="#"
           class="mt-5 px-6 py-3 text-sm lg:text-xl font-medium text-center text-white bg-[#7E3AF2] rounded-lg hover:bg-[#442083] focus:ring-4 focus:outline-none focus:ring-[#7E3AF220]"
           type="button">
            Back to login page
        </a>
    </div>
    <!-- Card end -->
</div>

<script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
<script src="https://unpkg.com/flowbite@1.4.7/dist/flowbite.js"></script>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>


</body>
</html>
