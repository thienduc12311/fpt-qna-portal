<%@ page import="swp391.fptqna.dto.UserDTO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/6/2022
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="relative h-full w-full m-0 text-gray-800 bg-gray-50">
<jsp:include page="../../header.jsp"></jsp:include>
<div class="fixed h-screen">
    <jsp:include page="../managementSidebar.jsp"></jsp:include>
</div>
<!-- container  -->
<div class=" ml-64 my-10 px-8 py-8">

    <!-- search bar  -->
    <div class="flex space-x-6">
        <div>
            <div class="text-2xl font-semibold">Users</div>
        </div>
        <div class="flex">
            <form action="MainController?action=ManageUser&page=1" method="post">
                <div class="relative">
                    <input type="text" name="search" value="" class="text-sm h-8 w-60 rounded px-3 shadow"
                           placeholder="Search...">
                    <span class="absolute inset-y-0 right-0 flex items-center pr-2">
              <button type="submit" class="p-1  bg-gray-200 rounded">
                <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                     viewBox="0 0 24 24" class="w-3 h-3">
                  <path d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path>
                </svg>
              </button>
            </span>
                </div>
            </form>
        </div>
    </div>

    <!-- list wrap  -->
    <div class="bg-white rounded-md px-10 py-2 shadow-md mt-6">
        <table class="min-w-full text-sm">
            <thead>
            <tr>
                <th class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold ">
                    ID
                </th>
                <th class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    Name
                </th>
                <th class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    Email
                </th>
                <th
                        class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    Score
                </th>
                <th class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    Role
                </th>
                <th
                        class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    State
                </th>
                <th
                        class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    Action
                </th>
            </tr>
            </thead>
            <tbody>

            <%
                try{
                    UserDTO userR = (UserDTO) session.getAttribute("USER");
                    ArrayList<UserDTO> list = (ArrayList<UserDTO>) request.getAttribute("listUser");
                    for (UserDTO user : list) {
                        String url = "/MainController?action=SetRole&id=" + user.getId() + "&role=";
            %>
            <tr>
                <!-- form for ban button  -->
                <form action="MainController" method="post">
                    <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                        <p class="text-gray-900 whitespace-no-wrap">
                            <%=user.getId()%>
                        </p>
                    </td>
                    <td  class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center cursor-pointer" onclick="window.location='<%="/PersonalProfile?page=1&userid=" + user.getId()%>';">
                        <p class="text-gray-900 whitespace-no-wrap"><%=user.getName()%></p>
                    </td>
                    <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                        <p class="text-gray-900 whitespace-no-wrap">
                            <%=user.getEmail()%>
                        </p>
                    </td>
                    <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                        <p class="text-gray-900 whitespace-no-wrap">
                            <%=user.getScore()%>
                        </p>
                    </td>
                    <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                        <% if (user.getId() == userR.getId()) {%>
                            <span>Admin</span>
                        <%} else {%>
                        <select id="selectBox" onchange="window.location='<%=url%>' + value;" class="text-gray-900 whitespace-no-wrap">
                            <option value="0" <%= user.getRole() == 0 ? "selected" : "" %>>User</option>
                            <option value="1" <%= user.getRole() == 1 ? "selected" : "" %>>Moderator</option>
                            <option value="2" <%= user.getRole() == 2 ? "selected" : "" %>>Admin</option>
                        </select>
                        <%}%>
                    </td>
                    <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                <span class="relative inline-block w-full py-1 font-semibold text-green-900 leading-tight">
                    <% if (user.getState()) { %>
                        <span aria-hidden class="absolute inset-0 bg-green-200 opacity-50 rounded-md"></span>
                        <span class="relative">Active</span>
                    <% } else {%>
                        <span aria-hidden class="absolute inset-0 bg-red-200 opacity-50 rounded-md"></span>
                        <span class="relative">Suspended</span>
                    <%}%>
                </span>
                    </td>
                    <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                        <% if (user.getId() != userR.getId()) {%>
                            <input hidden name="action" value="BanOrUnBanUser"/>
                            <input class="hidden" name="userId" value="<%=user.getId()%>"/>
                            <input class="hidden" name="url" value="<%="MainController?action=ManageUser&page=" + request.getParameter("page")%>"/>
                            <input class="hidden" name="emailTo" value="<%=user.getEmail()%>"/>
                            <% if (user.getState()){%>
                            <input type="submit" name="state" value="Ban User" class="bg-purple-600 hover:bg-purple-800 text-white rounded w-full py-1 font-semibold  transition duration-300 ease-in-out">
                            <% } else { %>
                            <input type="submit" name="state" value="Unban User" class="bg-purple-600 hover:bg-purple-800 text-white rounded w-full py-1 font-semibold  transition duration-300 ease-in-out">
                            <% } %>
                        <%}%>
                    </td>
                </form>
            </tr>
            <%
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            %>

            </tbody>
        </table>

        <!-- pagination  -->
        <%
            int currentPage = Integer.parseInt(request.getParameter("page"));
            int numberOfPage = Integer.parseInt(request.getAttribute("numberOfPage").toString());
            int nextPage = currentPage + 1;
            int previousPage = currentPage - 1 ;
            if (previousPage < 1) previousPage = 1;
            if (nextPage > numberOfPage) nextPage = numberOfPage;
        %>

        <div class="pagination p-3 inline-flex space-x-3 sm:ml-20 ml-12">
            <a href="MainController?action=ManageUser&search=<%=request.getParameter("search") == null ? "" : request.getParameter("search")%>&page=<%=previousPage%>" class="relative px-2 py-2 rounded border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span class="sr-only">Previous</span>
                <svg class="h-4 w-4 text-purple-600 " xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                    <path fill-rule="evenodd" d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z" clip-rule="evenodd" />
                </svg>
            </a>
            <a href="#" class="relative px-2 py-2 rounded border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span class="h-4 w-4 flex justify-center text-purple-600 text-xs"><%=currentPage%>/<%=numberOfPage%></span>
            </a>
            <a href="MainController?action=ManageUser&search=<%=request.getParameter("search") == null ? "" : request.getParameter("search")%>&page=<%=nextPage%>" class="relative px-2 py-2 rounded border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span class="sr-only">Next</span>
                <svg class="h-4 w-4 text-purple-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                    <path fill-rule="evenodd" d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z" clip-rule="evenodd" />
                </svg>
            </a>
        </div>
        <!-- end pagination -->

    </div>
</div>
</body>
</html>
