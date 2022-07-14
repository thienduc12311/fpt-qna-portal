<%--
  Created by IntelliJ IDEA.
  User: thienduc
  Date: 31/05/2022
  Time: 07:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="text-gray-800 h-full w-full bg-[#F2F2F2]">
<jsp:include page="header.jsp"></jsp:include>
<div class="pt-14">
    <div class="pt-10 pb-3 px-1 xl:px-40 md:px-24 sm:px-10 inline-flex space-x-8 ml-20 font-semibold">
        <a href="#" class="text-sm hover:opacity-60 duration-150">Newest</a>
        <a href="#" class="text-sm hover:opacity-60 duration-150">Most liked</a>
        <a href="#" class="text-sm hover:opacity-60 duration-150">Most answered</a>
    </div>
    <div class="flex justify-center h-screen px-2 xl:px-40 lg:px-24 md:px-18 sm:px-8 h-full space-x-4">

        <!-- left column -->
        <div class="w-10/12">

            <!-- a post -->
            <c:forEach items="${sessionScope.questions}" var="question">
                <div class="flex gap-x-2 mb-4">
                    <div class="w-1/12 grid content-start pt-6 place-items-center font-semibold">
                        <a href="" class="hover:opacity-60 duration-150">
                            <ion-icon name="caret-up"></ion-icon>
                        </a>

                        <p>${question.score}</p>
                        <a href="" class="hover:opacity-60 duration-150">
                            <ion-icon name="caret-down"></ion-icon>
                        </a>
                    </div>

                    <div class="w-11/12 bg-white p-8 grid content-start gap-y-3 rounded shadow-md">
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
                               class="font-semibold hover:opacity-60 duration-150">${question.title}</a>
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

            <div class="pagination p-3 inline-flex space-x-3 sm:ml-20 ml-12">
                <a href="${pageContext.request.contextPath}/home?page=<%=previousPage%>"
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
        </div>
        <div class="hidden lg:block w-4/12">
            <div class=" bg-white p-6 grid content-start gap-y-3 mb-4 rounded shadow-md divide-y">
                <div class="font-semibold flex items-center space-x-2">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M17.707 9.293a1 1 0 010 1.414l-7 7a1 1 0 01-1.414 0l-7-7A.997.997 0 012 10V5a3 3 0 013-3h5c.256 0 .512.098.707.293l7 7zM5 6a1 1 0 100-2 1 1 0 000 2z" clip-rule="evenodd" />
                    </svg>
                    <span class="text-sm">Trending Tags</span>
                </div>
                <div class="flex flex-wrap text-xs gap-x-1 gap-y-1 pt-3">
                    <a href="#">
                        <div class="text-xs border rounded border-gray-400 text-gray-400 px-4 py-1 text-justify hover:backdrop-brightness-95 duration-50">Java</div>
                    </a>
                </div>
            </div>
            <div class="bg-white p-6 grid content-start gap-y-3 mb-4 rounded shadow-md divide-y">
                <div class="font-semibold flex items-center space-x-2">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" viewBox="0 0 20 20" fill="currentColor">
                        <path d="M9 6a3 3 0 11-6 0 3 3 0 016 0zM17 6a3 3 0 11-6 0 3 3 0 016 0zM12.93 17c.046-.327.07-.66.07-1a6.97 6.97 0 00-1.5-4.33A5 5 0 0119 16v1h-6.07zM6 11a5 5 0 015 5v1H1v-1a5 5 0 015-5z" />
                    </svg>
                    <span class="text-sm">Top Users</span>
                </div>
                <div class="divide-y">
                    <a href="#">
                        <div class="flex flex-wrap space-x-3 items-center p-2 hover:opacity-60 duration-150">
                            <p><img class="rounded h-9 w-9" src="https://inkythuatso.com/uploads/thumbnails/800/2022/03/avatar-mac-dinh-nu-co-mau-30-10-31-43.jpg"></p>
                            <div>
                                <p class="font-semibold text-xs">Jane Dove</p>
                                <p class="text-xs">100 points</p>
                            </div>
                        </div>
                    </a>
                </div>
            </div>

            <div class="bg-white p-6 grid content-start gap-y-3 mb-4 rounded shadow-md divide-y">
                <div class="font-semibold flex items-center space-x-2">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M12.395 2.553a1 1 0 00-1.45-.385c-.345.23-.614.558-.822.88-.214.33-.403.713-.57 1.116-.334.804-.614 1.768-.84 2.734a31.365 31.365 0 00-.613 3.58 2.64 2.64 0 01-.945-1.067c-.328-.68-.398-1.534-.398-2.654A1 1 0 005.05 6.05 6.981 6.981 0 003 11a7 7 0 1011.95-4.95c-.592-.591-.98-.985-1.348-1.467-.363-.476-.724-1.063-1.207-2.03zM12.12 15.12A3 3 0 017 13s.879.5 2.5.5c0-1 .5-4 1.25-4.5.5 1 .786 1.293 1.371 1.879A2.99 2.99 0 0113 13a2.99 2.99 0 01-.879 2.121z" clip-rule="evenodd" />
                    </svg>
                    <span class="text-sm">New Users</span>
                </div>
                <div class="divide-y">
                    <a href="#">
                        <div class="flex flex-wrap space-x-3 items-center p-2 hover:opacity-60 duration-150">
                            <p><img class="rounded h-9 w-9" src="https://inkythuatso.com/uploads/thumbnails/800/2022/03/avatar-mac-dinh-nu-co-mau-30-10-31-43.jpg"></p>
                            <div>
                                <p class="font-semibold text-xs">Jane Dove</p>
                                <p class="text-xs">100 points</p>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>