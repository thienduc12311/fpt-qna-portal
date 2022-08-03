<%@ page import="java.util.ArrayList" %>
<%@ page import="swp391.fptqna.controllers.manage.ReportedQuestion" %>
<%@ page import="swp391.fptqna.dto.*" %><%--
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
    <title>Reported Question | Question's Title</title>
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
<jsp:include page="../header.jsp"></jsp:include>
<div class="wrapper w-[100%] h-[100vh] flex justify-center items-center flex-col">

    <div class="wrapper w-[100%] h-[100vh] flex mt-[8%] items-center flex-col ">
        <%
            try{
                QuestionDTO question = (QuestionDTO) request.getAttribute("question");
                ReportedQuestionDTO reportedQuestion = (ReportedQuestionDTO) request.getAttribute("reportedQuestion");
                ArrayList<TagDTO> listTag = (ArrayList<TagDTO>) request.getAttribute("listTag");
                UserDTO ownerQuestionUser = (UserDTO) request.getAttribute("ownerQuestionUser");
        %>
        <!-- Card start -->
        <div
                class="mb-5 w-8/12 bg-white p-11 grid content-start gap-y-4 rounded-xl shadow-[0px_2px_4px_rgba(0,0,0,0.06),0px_4px_6px_rgba(0,0,0,0.1)]">
            <!-- Info start -->
            <div class="flex justify-start items-center gap-x-3">
                <a href="" class="cursor-pointer">
                    <img class="rounded-full h-8 w-8"
                         src="<%=ownerQuestionUser.getAvtUrl()%>">
                </a>
                <a href="" class="font-semibold"><%=ownerQuestionUser.getName()%></a>
                <span class="text-xs text-slate-400"><%=question.getCreationDate()%></span>
            </div>
            <!-- Info end -->

            <!-- Content start -->
            <div class="mb-2">
                <p class="font-semibold text-xl mb-2"><%= question.getTitle() %></p>
                <p class="text-gray-500"><%= question.getBody() %></p>
            </div>
            <!-- Content end -->

            <!-- Tags start -->
            <div class="flex text-xs gap-x-2 text-[#B9C1CC]">
                <% for (TagDTO tag : listTag ) { %>
                <a class="cursor-pointer border border-[#B9C1CC] rounded px-4 py-1 font-medium hover:backdrop-brightness-95 duration-50">
                    <%= tag.getTagName() %></a>
                <% } %>
            </div>
            <!-- Tags end -->

            <div class="border-b mt-4 mb-2"></div>
        </div>
        <!-- Card end -->

        <!-- Card footer start -->
        <div class="w-8/12 flex flex-col gap-4 justify-between sm:flex-row mb-5">
            <a onclick="history.back()" class="text-[#B9C1CC] hover:text-[#9aa0a8] font-semibold">Back to previous page...</a>
            <div class="w-[100%] sm:w-auto flex gap-2 flex-col sm:flex-row">
                <form action="MainController" method="post" class="m-0">
                    <input hidden name="action" value="ResolveReportedQuestion"/>
                    <input class="hidden" name="reportedQuestionId" value="<%=reportedQuestion.getId()%>"/>
                    <input class="hidden" name="emailTo" value="<%=ownerQuestionUser.getEmail()%>"/>
                    <input class="hidden" name="questionId" value="<%=question.getId()%>"/>
                    <input class="hidden" name="ownerUserId" value="<%=reportedQuestion.getOwnerUserId()%>"/>
                    <input class="hidden" name="ownerQuestionFlagUserId" value="<%=question.getOwnerUserId()%>"/>

                <button type="submit" name="state" value="REJECT"
                        class="px-10 py-2 text-sm font-medium text-center text-white bg-[#0694A2] rounded-lg hover:bg-[#057c87] focus:ring-2 focus:outline-none focus:ring-[#0694A230] hover:-translate-y-1 hover:shadow-md duration-200 ease-in-out">
                    Resolve with no violation
                </button>
                <button type="button" data-modal-toggle="deleteModal"
                        class="px-10 py-2 text-sm font-medium text-center text-white bg-[#FF5A1F] rounded-lg hover:bg-[#a53b15] focus:ring-2 focus:ring-[#FF5A1F30] hover:-translate-y-1 hover:shadow-md duration-200 ease-in-out">
                    Delete question
                </button>
                <button type="submit" name="state" value="DELETE_BAN"
                        class="px-10 py-2 text-sm font-medium text-center text-white bg-[#C81E1E] rounded-lg hover:bg-[#911717] focus:ring-2 focus:ring-[#C81E1E30] hover:-translate-y-1 hover:shadow-md duration-200 ease-in-out">
                    Delete question and ban user
                </button>
                </form>
            </div>
        </div>
        <!-- Card footer end -->

        <!-- Reason card start -->
        <div
                class="mb-5 w-8/12 bg-white p-11 grid content-start gap-y-4 rounded-xl shadow-[0px_2px_4px_rgba(0,0,0,0.06),0px_4px_6px_rgba(0,0,0,0.1)]">
            <!-- Info start -->
            <p class="text-xl font-semibold">Reported reason</p>
            <!-- Info end -->

            <!-- Content start -->
            <div class="mb-2">
                <p class="text-gray-500"><%=reportedQuestion.getDescription()%></p>
            </div>
            <!-- Content end -->

            <!-- Reason card end -->

        </div>
    </div>
</div>

<!-- Delete modal start -->
<div id="deleteModal" tabindex="-1" aria-hidden="true"
     class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
    <div class="relative p-4 w-full max-w-2xl h-full md:h-auto">
        <!-- Modal content -->
        <div class="relative bg-white rounded-lg shadow">
            <!-- Modal header -->
            <div class="flex justify-between items-start p-4 rounded-t border-b">
                <h3 class="text-xl font-semibold text-gray-900">
                    Reason to delete
                </h3>
                <button type="button"
                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center"
                        data-modal-toggle="deleteModal">
                    <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
                         xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd"
                              d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                              clip-rule="evenodd"></path>
                    </svg>
                </button>
            </div>
            <!-- Modal body -->
            <div class="p-6 space-y-6">
                <label for="message" class="block mb-2 text-sm font-medium text-gray-900">Reason</label>
                <textarea id="message" rows="4" name="reason"
                          class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500"
                          placeholder="Leave your reason here..."></textarea>
            </div>
            <!-- Modal footer -->
            <div class="flex items-center p-6 space-x-2 rounded-b border-t border-gray-200">
                <form action="MainController" method="post" class="m-0">
                    <input hidden name="action" value="ResolveReportedQuestion"/>
                    <input class="hidden" name="reportedQuestionId" value="<%=reportedQuestion.getId()%>"/>
                    <input class="hidden" name="questionId" value="<%=question.getId()%>"/>
                    <input class="hidden" name="ownerUserId" value="<%=reportedQuestion.getOwnerUserId()%>"/>
                    <input class="hidden" name="ownerQuestionFlagUserId" value="<%=question.getOwnerUserId()%>"/>
                    <input class="hidden" name="emailTo" value="<%=ownerQuestionUser.getEmail()%>"/>

                <button data-modal-toggle="deleteModal" type="submit" name="state" value="DELETE"
                        class="text-white bg-[#C81E1E] hover:bg-[#911717] focus:ring-4 focus:outline-none focus:ring-[#C81E1E30] font-medium rounded-lg text-sm px-5 py-2.5 text-center">
                    Reject
                </button>
                    </form>
                <button data-modal-toggle="deleteModal" type="button"
                        class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">
                    Cancel
                </button>
            </div>
        </div>
    </div>
</div>
<!-- Reject modal end -->
<%
    } catch (Exception e){
        e.printStackTrace();
    }
%>
<script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
<script src="https://unpkg.com/flowbite@1.4.7/dist/flowbite.js"></script>

</body>
</html>
