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
    <script src="https://cdn.tailwindcss.com"></script>
    <link href='https://fonts.googleapis.com/css?family=Inter' rel='stylesheet'>
    <style>
        body {
            font-family: 'Inter';
        }
    </style>
</head>
<body>
    <div class="bg-gray-50 grid place-items-center h-screen font-semibold">
        <div class="bg-white rounded-xl shadow-lg h-60 w-7/12 md:w-5/12 lg:w-3/12 grid place-items-center">
            <div class="p-6 md:p-10 h-full w-full text-center space-y-5 text-gray-700">
                <div class="text-2xl font-bold text-purple-600">Oops!!!</div>
                <div class="px-2">Your account is not authorized to access this page.</div>
                <button class="border rounded border-gray-300 w-full h-8 flex justify-center content-center pt-1 mt-3 font-semibold text-sm">
                    <a href="index.jsp">Back to login page</a>
                </button>
            </div>
        </div>
    </div>
</body>
</html>
