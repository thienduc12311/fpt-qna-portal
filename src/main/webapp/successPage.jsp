<%@ page import="swp391.fptqna.dto.AnswerDTO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: tnahuy
  Date: 6/19/2022
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%-- We can put question's title in the title --%>
    <title>Success Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tw-elements/dist/css/index.min.css"/>
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.4.7/dist/flowbite.min.css"/>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">
    <style>
        @tailwind base;

        @tailwind components;

        @tailwind utilities;

        *,
        *::before,
        *::after {
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        body {
            font-family: 'Inter', sans-serif;
            font-size: 16px;
        }
    </style>
</head>
<body class="bg-[#F2F2F2]">
<jsp:include page="header.jsp"></jsp:include>
<div class="wrapper w-[100%] h-[100vh] flex items-center justify-center flex-col ">

    <div
            class="w-8/12 lg:w-5/12 h-auto bg-white p-11 flex flex-col items-center justify-center gap-y-4 rounded-xl shadow-[0px_2px_4px_rgba(0,0,0,0.06),0px_4px_6px_rgba(0,0,0,0.1)]">
        <div class="w-auto h-auto p-3 lg:p-11 bg-[#D5F5F6] rounded-full">
            <ion-icon class="text-4xl lg:text-[100px] checkmark text-[#0694A2]" name="checkmark"></ion-icon>
        </div>
        <div class="mt-5 text-center mx-10">
            <h4 class="mb-2 lg:mb-5 text-4xl lg:text-[50px] font-bold">Successful!!!</h4>
            <p class="text-lg font-medium">Your action is being received. You can see it on the feed as soon as it is
                approved.</p>
        </div>
        <a href="<%=request.getAttribute("back") != null ? request.getAttribute("back") : "#" %>"
           class="mt-5 px-6 py-3 text-sm lg:text-xl font-medium text-center text-white bg-[#7E3AF2] rounded-lg hover:bg-[#442083] focus:ring-4 focus:outline-none focus:ring-[#7E3AF220]"
           type="button">
            Back to previous page...
        </a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
    <script src="https://unpkg.com/flowbite@1.4.7/dist/flowbite.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</div>
</body>
</html>
