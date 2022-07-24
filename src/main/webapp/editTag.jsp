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
    <title>Edit Tag</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href='https://fonts.googleapis.com/css?family=Inter' rel='stylesheet'>
    <style>
        body {
            font-family: 'Inter';
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container w-50% p-5 md:p-0 h-[100vh] mx-auto flex flex-col justify-center">
    <h3 class="text-2xl font-bold mb-5">Edit tag</h3>
    <div class="w-full bg-white rounded-lg border border-gray-200 shadow-md p-8">
        <form>
            <div class="mb-6">
                <label for="title" class="block mb-2 text-sm font-medium text-gray-900">Title</label>
                <input type="title" id="title"
                       class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-purple-500 focus:border-purple-500 block w-full p-2.5"
                       placeholder="Tag's title here" value="" required>
            </div>
            <div class="mb-6">
                <label for="Description" class="block mb-2 text-sm font-medium text-gray-900">Description</label>
                <textarea id="description" rows="4"
                          class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-purple-500 focus:border-purple-500"
                          placeholder="Explain something about the tag..." value=""></textarea>
            </div>
            <button type="submit"
                    class="text-white bg-purple-700 hover:bg-purple-800 focus:ring-4 focus:outline-none focus:ring-purple-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center">Edit tag</button>
        </form>
    </div>
    <!-- Card footer start -->
    <div class="w-8/12 flex flex-col gap-4 justify-between sm:flex-row mt-5">
        <a href="#" class="text-[#B9C1CC] hover:text-[#9aa0a8] font-semibold">Back to previous page...</a>
    </div>
    <!-- Card footer end -->
</div>
</body>
</html>
