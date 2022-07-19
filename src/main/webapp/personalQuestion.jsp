<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/7/2022
  Time: 7:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-full w-full flex justify-center bg-gray-50 text-gray-800">
<div class="flex flex-row justify-between h-full w-8/12 mt-20 relative">

    <!-- left side -->
    <div class="basis-4/12 h-full fixed left-4/12">
        <div class="flex flex-col items-center space-y-6">
            <div><img  class="rounded-full w-48" src="https://inkythuatso.com/uploads/thumbnails/800/2022/03/avatar-mac-dinh-nu-co-mau-30-10-31-43.jpg" alt=""></div>
            <div class="flex flex-col items-center">
                <div class="font-semibold text-lg">${sessionScope.USER.name}</div>
                <div class="text-sm">${sessionScope.USER.email}</div>
            </div>
            <div class="flex space-x-6 border-t border-b border-gray-300 pt-3 pb-3">
                <div class="flex flex-col">
                    <div class="font-semibold">${sessionScope.USER.score}</div>
                    <div class="text-sm">Scores</div>
                </div>
                <div class="flex flex-col">
                    <div class="font-semibold">0</div>
                    <div class="text-sm">Posts</div>
                </div>
                <div class="flex flex-col">
                    <div class="font-semibold">0</div>
                    <div class="text-sm">Answers</div>
                </div>

            </div>
            <div class="space-y-4">
                <div class="font-medium text-gray-400"><a href="personalprofile.jsp">Personal Profile</a></div>
                <div class="font-medium">Activity</div>
                <div class="font-medium text-gray-400"><a href="editprofile.jsp">Edit Profile</a></div>
                <div class="font-medium text-gray-400"><a href="changepassword.jsp">Change Password</a></div>
            </div>
        </div>
    </div>

    <!-- right side -->

    <div class="basis-8/12 relative left-80">
        <div class=" bg-white items-center rounded-xl shadow-lg ">

        </div>

    </div>

</div>
</body>
</html>
