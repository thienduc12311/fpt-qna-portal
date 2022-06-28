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
        <div class="font-medium text-gray-400"><a href="">Activity</a> </div>
        <div class="font-medium">Edit Profile</div>
        <div class="font-medium text-gray-400"><a href="changepassword.jsp">Change Password</a></div>
      </div>
    </div>
  </div>

  <!-- right side -->

  <div class="basis-8/12 relative left-80">
    <div class=" bg-white items-center rounded-xl shadow-lg ">
    <form action="UpdateUser" method="POST">
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
<%--        <c:set var="error" value="${requestScope.ERROR}"></c:set>--%>
<%--        <c:if test="${not empty error}">--%>
<%--          <div class="font-bold text-red-500">--%>
<%--            <c:if test="${error eq 'Do not leave display name empty.'}">--%>
<%--              Do not leave display name empty.--%>
<%--            </c:if>--%>
<%--          </div>--%>
<%--        </c:if>--%>

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
          <div class="flex items-center bg-red-600 hover:bg-red-800 text-white rounded px-5 h-8"><a href="personalprofile.jsp">Cancel Change</a></div>
          <div><input type="submit" name="action" value="Save Change" class="bg-purple-600 hover:bg-purple-800 text-white rounded px-5 h-8"> </div>
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
