<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/6/2022
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
  <title>Edit Profile</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-full w-full flex justify-center bg-[#F2F2F2] text-gray-800 overflow-hidden">
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<jsp:include page="header.jsp"></jsp:include>
<div class="flex flex-row justify-between h-full w-8/12 pt-32 relative">

  <!-- left side -->
  <!-- left side -->
  <div class="basis-4/12 h-full fixed left-4/12">
    <div class="flex flex-col items-center space-y-6">
      <div><img  class="rounded-full w-48" src="${sessionScope.USER.avtUrl}" alt=""></div>
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
          <div class="font-semibold">${sessionScope.numberofQuestions}</div>
          <div class="text-sm">Questions</div>
        </div>
        <div class="flex flex-col">
          <div class="font-semibold">${sessionScope.numberofAnswers}</div>
          <div class="text-sm">Answers</div>
        </div>

      </div>
      <div class="space-y-4">
        <div class="font-medium text-gray-400 hover:text-gray-500 duration-150"><a href="/PersonalProfile?page=1">Personal Profile</a></div>
        <div class="font-medium text-gray-400 hover:text-gray-500 duration-150"><a href="personalQuestion.jsp">Activity</a></div>
        <div class="font-medium">Edit Profile</div>
        <div class="font-medium text-gray-400 hover:text-gray-500 duration-150"><a href="changepassword.jsp">Change Password</a></div>
      </div>
    </div>
  </div>

  <!-- right side -->

  <div class="basis-8/12 relative left-80">

    <div class=" bg-white items-center rounded shadow-md">

    <form action="/UpdateUser" method="POST">
      <div class="flex flex-col items-center p-20 space-y-6">
        <div class="font-bold text-xl">Edit Profile</div>
        <div><img class="rounded-full w-24" src="https://inkythuatso.com/uploads/thumbnails/800/2022/03/avatar-mac-dinh-nu-co-mau-30-10-31-43.jpg" alt=""></div>
        <div class="text-sm">${sessionScope.USER.email}</div>
        <div class="text-sm space-y-3">
          <div class="flex justify-between space-x-3 items-center">
            <p class="font-semibold">Display name</p>
            <p><input type="text" name="txtdisplayname" value="${sessionScope.USER.name}" class="w-72 border border-gray-300 h-8 rounded px-3" placeholder="Display name"></p>
          </div>
          <div class="flex justify-between space-x-3">
            <p class="font-semibold py-2">Biography</p>
            <p><textarea type="textarea" name="txtbio" value="${sessionScope.USER.bio}" class="w-72 border border-gray-300 h-24 rounded px-3 py-2" placeholder="Biography">${sessionScope.USER.bio}</textarea></p>
          </div>
        </div>
        <div class="font-bold text-red-500">
          <%
            String error = (String)request.getAttribute("ERROR");
            if (error != null && error.equals("Do not leave display name empty.")){
          %>
            <p>Do not leave display name empty.</p>
          <%
            }
          %>
        </div>

        <div class="flex space-x-3">
          <div class="cursor-pointer bg-[#7E3AF2] hover:bg-[#5828a9] text-[#fff] items-center flex px-5 py-2 rounded-md w-full md:w-36 justify-center">
            <ion-icon name="checkmark-outline"></ion-icon>
            <div><input type="submit" name="action" value="Save" class="ml-2 text-sm"> </div>
          </div>
          <div class="cursor-pointer bg-red-600 hover:bg-red-800 text-[#fff] items-center flex px-5 py-2 rounded-md w-full md:w-36 justify-center">
            <ion-icon name="close-outline"></ion-icon>
            <div class="ml-2 text-sm"><a href="/PersonalProfile?page=1">Cancel</a></div>
          </div>
        </div>
      </div>
        <input type="hidden" name="txtoldpassword" value="${sessionScope.USER.password}">
        <input type="hidden" name="id" value="${sessionScope.USER.id}">

    </form>
    </div>
  </div>

</div>
</body>
</html>
