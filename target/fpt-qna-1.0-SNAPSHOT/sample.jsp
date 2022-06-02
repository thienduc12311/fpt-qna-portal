<%--
  Created by IntelliJ IDEA.
  User: markhipz
  Date: 6/2/2022
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="style.css" rel="stylesheet" title="Normal"/>
    <title>Sample</title>

    <%--    Add page icon here--%>
    <link rel="icon" type="image/x-icon" href="">

    <link href="/asset/style/global.css" rel="stylesheet">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<form class="flex items-center space-x-6">
    <div class="shrink-0">
        <img class="h-16 w-16 object-cover rounded-full"
             src="https://images.unsplash.com/photo-1580489944761-15a19d654956?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1361&q=80"
             alt="Current profile photo"/>
    </div>
    <label class="block">
        <span class="sr-only">Choose profile photo</span>
        <input type="file" class="block w-full text-sm text-slate-500
      file:mr-4 file:py-2 file:px-4
      file:rounded-full file:border-0
      file:text-sm file:font-semibold
      file:bg-violet-50 file:text-violet-700
      hover:file:bg-violet-100
    "/>
    </label>
</form>
</body>
</html>
