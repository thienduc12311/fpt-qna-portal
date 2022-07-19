<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/6/2022
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Personal Profile</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<body class="h-full w-full flex justify-center bg-gray-50 text-gray-800">
<div class="flex flex-row justify-between h-full w-8/12 mt-20 relative">

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
                    <div class="font-semibold">0</div>
                    <div class="text-sm">Posts</div>
                </div>
                <div class="flex flex-col">
                    <div class="font-semibold">0</div>
                    <div class="text-sm">Answers</div>
                </div>

            </div>
            <div class="space-y-4">
                <div class="font-medium">Personal Profile</div>
                <div class="font-medium text-gray-400 hover:text-gray-500 duration-150"><a href="personalQuestion.jsp">Activity</a></div>
                <div class="font-medium text-gray-400 hover:text-gray-500 duration-150"><a href="editprofile.jsp">Edit Profile</a></div>
                <div class="font-medium text-gray-400 hover:text-gray-500 duration-150"><a href="changepassword.jsp">Change Password</a></div>
            </div>
        </div>
    </div>

    <!-- right side -->
    <div class="basis-8/12 h-full space-y-5 relative left-80">
        <!-- bio and badge  -->
        <div class="flex space-x-3">
            <div class="bg-white rounded p-10 w-1/2 shadow-md divide-y space-y-3">
                <div class="font-semibold">Bio</div>
                <div class="text-sm pt-3">${sessionScope.USER.bio}</div>
            </div>
            <div class="bg-white rounded p-10 w-1/2 shadow-md divide-y space-y-3">
                <div class="font-semibold">Badges</div>
                <div class="text-xs pt-3">
                    <div class="rounded py-0.5 px-3 text-red-700 bg-red-100  w-min">Newbie</div>
                </div>
            </div>
        </div>

        <div class="font-semibold pb-0.5">Recent questions</div>

        <!-- a question  -->
        <c:if test="${empty requestScope.emptyList}">

        <c:forEach items="${sessionScope.questions}" var="question">
            <div class="bg-white p-8 grid content-start gap-y-3 rounded shadow-md">
                <div class="flex gap-x-2 items-center">
                    <a href="#">
                        <img class="rounded-full h-8 w-8" src="${question.ownerAvt}">
                    </a>
                    <a href="#">
                        <p class="text-sm font-semibold pt-1">${question.ownerName}</p>
                    </a>
                </div>
                <div>
                    <a href="/ViewQuestion?questionId=${question.id}"
                       class="font-semibold text-gray-800 hover:opacity-60 duration-150">${question.title}</a>
                </div>
                <div>
                    <p class="text-gray-500 text-sm">${question.body}</p>
                </div>
                <div class="flex text-xs gap-x-1">
                    <c:forEach items="${question.tags}" var="tag">
                        <a href="/home?action=tag&tag=${tag.tagName}&page=1">
                            <div class="text-xs border rounded border-gray-400 text-gray-400 px-4 py-1 text-justify hover:backdrop-brightness-95 duration-50">${tag.tagName}</div>
                        </a>
                    </c:forEach>
                </div>
                <div class="border-t border-gray-300 pt-5 mt-2 flex items-center gap-x-3">
                    <div class="bg-[#7E3AF2] text-[#fff] items-center flex px-5 py-2 rounded-md w-full md:w-36 justify-center">
                        <ion-icon name="chatbox-ellipses"></ion-icon>
                        <div class="ml-2 text-xs">${question.answerCount} answers</div>
                    </div>
                    <div class="bg-[#7E3AF2] text-[#fff] items-center flex px-5 py-2 rounded-md w-full md:w-36 justify-center">
                        <ion-icon name="chatbubbles"></ion-icon>
                        <div class="ml-2 text-xs">${question.commentCount} comments</div>
                    </div>
                </div>
            </div>
        </c:forEach>

        <!-- end -->

        <%
            String currentPage = request.getParameter("page");
            String totalPage = request.getAttribute("numberOfPage").toString();
            Integer numberOfPage = Integer.parseInt(totalPage);
            Integer nextPage = Integer.parseInt(currentPage) + 1;
            Integer previousPage = Integer.parseInt(currentPage) - 1;
            if (previousPage < 1) previousPage = 1;
            if (nextPage > numberOfPage) nextPage = numberOfPage;
        %>

        <div class="pagination py-3 inline-flex space-x-3">
            <a href="${pageContext.request.contextPath}/PersonalProfile?page=<%=previousPage%>"
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
            <a href="${pageContext.request.contextPath}/home?page=<%=nextPage%>"
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
        </c:if>
        <c:if test="${not empty requestScope.emptyList}">
            <div class="font-semibold pb-0.5">${requestScope.emptyList}</div>
        </c:if>

        <!-- end a question  -->


    </div>
</div>

</body>
</html>
