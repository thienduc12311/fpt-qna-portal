<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/6/2022
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Question Management</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link
            rel="stylesheet"
            href="./asset/style/flowbite.min.css"
    />
</head>
<body class="relative h-full w-full m-0 text-gray-800 bg-gray-50">
<jsp:include page="header.jsp"></jsp:include>
<div class="fixed h-screen">
    <jsp:include page="myManageSideBar.jsp"></jsp:include>
</div>
<!-- container  -->
<%
    String currentPage = request.getParameter("page");
    String totalPage = request.getAttribute("numberOfPage").toString();
    int numberOfPage = Integer.parseInt(totalPage);
    int nextPage = Integer.parseInt(currentPage) + 1;
    int previousPage = Integer.parseInt(currentPage) - 1;
    if (previousPage < 1) previousPage = 1;
    if (nextPage > numberOfPage) nextPage = numberOfPage;
%>
<div class=" ml-64 my-10 px-8 py-8">

    <!-- search bar  -->
    <div class="flex space-x-6">
        <div>
            <div class="text-2xl font-semibold">Users</div>
        </div>
        <div class="flex">
            <form action="Search" method="post" class="p-0 m-0 inline">
                <div class="relative">
                    <input type="text" name="txtdisplayname" value=""
                           class="text-sm h-8 w-60 rounded px-3 shadow focus:outline-none focus:ring-1 focus:ring-purple-500"
                           placeholder="Search...">
                    <span class="absolute inset-y-0 right-0 flex items-center pr-2">
              <button type="submit"
                      class="p-1  bg-gray-200 rounded hover:bg-slate-100 transition ease-in-out duration-300">
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
                    Title
                </th>
                <th
                        class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    Score
                </th>
                <th
                        class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    Answer
                </th>
                <th
                        class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    State
                </th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${requestScope.questionList}" var="question">
                <tr>
                    <!-- form for ban button  -->
                    <form action="" method="post">
                        <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                            <p class="text-gray-900 whitespace-no-wrap">
                                    ${question.id}
                            </p>
                        </td>
                        <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                            <a href="/MainController?action=ViewPendingQuestion&questionId=${question.id}">
                                <p class="text-gray-900 whitespace-no-wrap font-bold">
                                        ${question.title}
                                </p>
                            </a>

                        </td>
                        <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                            <p class="text-gray-900 whitespace-no-wrap">
                                    ${question.score}
                            </p>
                        </td>
                        <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                            <p class="text-gray-900 whitespace-no-wrap">
                                    ${question.answerCount}
                            </p>
                        </td>
                        <c:if test="${question.deletionDate == null && question.approveUserId != 0}">
                            <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                                <span class="relative inline-block px-3 py-1 font-semibold text-green-900 leading-tight">
                                  <span aria-hidden class="absolute inset-0 bg-green-200 opacity-50 rounded-md"></span>
                                  <span class="relative">Approved</span>
                                </span>
                            </td>
                        </c:if>
                        <c:if test="${question.deletionDate != null && question.approveUserId == 0}">
                            <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                                <c:choose>
                                    <c:when test="${question.getReject().getReason() != null}">
                                        <a class="relative inline-block px-3 py-1 font-semibold text-green-900 leading-tight cursor-pointer"
                                           type="button"
                                           data-modal-toggle="reasonReject-${question.getId()}">
                                            <span aria-hidden
                                                  class="absolute inset-0 bg-red-200 opacity-50 rounded-md"></span>
                                            <span class="relative">Rejected</span>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="relative inline-block px-3 py-1 font-semibold text-green-900 leading-tight">
                                            <span aria-hidden
                                                  class="absolute inset-0 bg-red-200 opacity-50 rounded-md"></span>
                                            <span class="relative">Rejected</span>
                                        </span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </c:if>
                        <c:if test="${question.deletionDate == null && question.approveUserId == 0}">
                            <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                                <span class="relative inline-block px-3 py-1 font-semibold text-green-900 leading-tight">
                                  <span aria-hidden class="absolute inset-0 bg-orange-200 opacity-50 rounded-md"></span>
                                  <span class="relative">Pending</span>
                                </span>
                            </td>
                        </c:if>
                            <%--                        <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">--%>

                            <%--                            <input type="submit" name="action" value="Ban User"--%>
                            <%--                                   class="bg-purple-600 hover:bg-purple-800 text-white rounded px-5 py-1 font-semibold  transition duration-300 ease-in-out">--%>
                            <%--                        </td>--%>
                    </form>
                </tr>
                <c:if test="${question.getReject().getReason() != null}">
                    <div
                            id="reasonReject-${question.getId()}"
                            tabindex="-1"
                            aria-hidden="true"
                            class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full"
                    >
                        <div class="relative p-4 w-full max-w-2xl h-full md:h-auto">
                            <!-- Modal content -->
                            <div class="relative bg-white rounded-lg shadow">
                                <!-- Modal header -->
                                <div
                                        class="flex justify-between items-start p-4 rounded-t border-b"
                                >
                                    <h3 class="text-xl font-semibold text-gray-900">
                                        Reason Reject
                                    </h3>
                                    <button
                                            type="button"
                                            class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center"
                                            data-modal-toggle="reasonReject-${question.getId()}"
                                    >
                                        <svg
                                                class="w-5 h-5"
                                                fill="currentColor"
                                                viewBox="0 0 20 20"
                                                xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <path
                                                    fill-rule="evenodd"
                                                    d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                                                    clip-rule="evenodd"
                                            ></path>
                                        </svg>
                                    </button>
                                </div>
                                <div class="mx-8 pt-6">

                                    <div>
                                            ${question.getReject().reason}
                                    </div>
                                    <div
                                            class="flex items-center py-6 space-x-2 rounded-b border-gray-200"
                                    >
                                        <button
                                                data-modal-toggle="reasonReject-${question.getId()}"
                                                type="button"
                                                class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10"
                                        >
                                            Close
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
            <!-- one record  -->

            <!-- end record  -->

            </tbody>
        </table>

        <!-- pagination  -->
        <div class="pagination p-3 inline-flex space-x-3 sm:ml-20 ml-12">
            <a href="${pageContext.request.contextPath}/ManageMyQuestion?page=<%=previousPage%>"
               class="relative px-2 py-2 rounded-md border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span class="sr-only">Previous</span>
                <!-- Heroicon name: solid/chevron-left -->
                <svg class="h-4 w-4 text-purple-600 " xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
                     fill="currentColor" aria-hidden="true">
                    <path fill-rule="evenodd"
                          d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z"
                          clip-rule="evenodd"/>
                </svg>
            </a>
            <a href="#"
               class="relative px-2 py-2 rounded-md border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span class="h-4 w-4 flex justify-center text-purple-600 text-xs"><%=currentPage%>/${requestScope.numberOfPage}</span>
            </a>
            <a href="${pageContext.request.contextPath}/ManageMyQuestion?page=<%=nextPage%>"
               class="relative px-2 py-2 rounded-md border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span class="sr-only">Next</span>
                <!-- Heroicon name: solid/chevron-right -->
                <svg class="h-4 w-4 text-purple-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
                     fill="currentColor" aria-hidden="true">
                    <path fill-rule="evenodd"
                          d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
                          clip-rule="evenodd"/>
                </svg>
            </a>
        </div>
        <!-- end pagination -->

    </div>
</div>
<script src="./asset/js/flowbite.js"></script>
</body>
</html>