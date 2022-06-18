<%--
  Created by IntelliJ IDEA.
  User: thienduc
  Date: 31/05/2022
  Time: 07:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<html>
<head>
    <title>Home</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="text-gray-800 h-full w-full  bg-gray-50">
<%--<h1>Welcome ${sessionScope.USER.name}</h1>--%>
<%--<a href="/Logout">log out</a>--%>
<div class="">
    <div class="pt-10 pb-3 px-48 inline-flex space-x-8 ml-12 font-semibold">
        <a href="#">Newest</a>
        <a href="#">Most liked</a>
        <a href="#">Most answered</a>
    </div>
    <div class="flex h-screen px-48 h-full -space-x-8">

        <!-- left column -->
        <div class="w-10/12">

            <!-- a post -->
<%--            <c:forEach var = "i" begin = "1" end = "3">--%>
            <div class="flex gap-x-2 mb-4">
                <div class="w-1/12 bg-gray-50 grid content-start pt-6 place-items-center font-semibold">
                    <a href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M5 15l7-7 7 7" />
                        </svg>
                    </a>

                    <p>12</p>
                    <a href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M19 9l-7 7-7-7" />
                        </svg>
                    </a>
                </div>

                <div >
                    <div class="w-11/12 bg-white p-8 grid content-start gap-y-3 rounded-xl shadow-lg">
                        <div class="flex gap-x-2">
                            <p><img class="rounded-full h-8 w-8" src="https://inkythuatso.com/uploads/thumbnails/800/2022/03/avatar-mac-dinh-nu-co-mau-30-10-31-43.jpg"></p>
                            <p class="text-sm font-semibold pt-1">Jane Dove</p>

                        </div>
                        <div>
                            <p class="font-semibold ">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                        </div>
                        <div>
                            <p class="text-gray-500 text-sm">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                        </div>
                        <div class="flex text-xs gap-x-1 h-5">
                            <p class="border rounded border-gray-800 px-5">Java</p>
                        </div>
                        <div class="border-t border-gray-300 pt-4 mt-4 flex text-xs gap-x-1">
                            <p class="bg-purple-600 text-white rounded py-0.5 px-4 h-6 flex space-x-1 ">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                                    <path fill-rule="evenodd" d="M18 5v8a2 2 0 01-2 2h-5l-5 4v-4H4a2 2 0 01-2-2V5a2 2 0 012-2h12a2 2 0 012 2zM7 8H5v2h2V8zm2 0h2v2H9V8zm6 0h-2v2h2V8z" clip-rule="evenodd" />
                                </svg>
                                <span>12 answers</span>
                            </p>
                            <p class="bg-purple-600 text-white rounded py-0.5 px-4 h-6 flex space-x-1 ">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                                    <path d="M2 5a2 2 0 012-2h7a2 2 0 012 2v4a2 2 0 01-2 2H9l-3 3v-3H4a2 2 0 01-2-2V5z" />
                                    <path d="M15 7v2a4 4 0 01-4 4H9.828l-1.766 1.767c.28.149.599.233.938.233h2l3 3v-3h2a2 2 0 002-2V9a2 2 0 00-2-2h-1z" />
                                </svg>
                                <span>24 comments</span>
                            </p>
                        </div>
                    </div>

                </div>

            </div>
<%--            </c:forEach>--%>

            <!-- end -->



            <div class="pagination p-3 inline-flex space-x-3 ml-12">
                <a href="#" class="relative px-2 py-2 rounded-md border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                    <span class="sr-only">Previous</span>
                    <!-- Heroicon name: solid/chevron-left -->
                    <svg class="h-4 w-4 text-purple-600 " xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                        <path fill-rule="evenodd" d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z" clip-rule="evenodd" />
                    </svg>
                </a>
                <a href="#" class="relative px-2 py-2 rounded-md border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                    <span class="h-4 w-4 flex justify-center text-purple-600 text-xs">1</span>

                </a>
                <a href="#" class="relative px-2 py-2 rounded-md border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                    <span class="sr-only">Next</span>
                    <!-- Heroicon name: solid/chevron-right -->
                    <svg class="h-4 w-4 text-purple-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                        <path fill-rule="evenodd" d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z" clip-rule="evenodd" />
                    </svg>
                </a>
            </div>
        </div>
        <div class="w-4/12">
            <div class=" bg-white p-6 grid content-start gap-y-3 mb-4 rounded-xl shadow-lg divide-y">
                <div class="font-semibold flex items-center space-x-2">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M17.707 9.293a1 1 0 010 1.414l-7 7a1 1 0 01-1.414 0l-7-7A.997.997 0 012 10V5a3 3 0 013-3h5c.256 0 .512.098.707.293l7 7zM5 6a1 1 0 100-2 1 1 0 000 2z" clip-rule="evenodd" />
                    </svg>
                    <p>Trending Tags</p>
                </div>
                <div class="flex flex-wrap text-xs gap-x-1 gap-y-1 pt-3 h-8">
                    <p class="border rounded border-gray-800 px-5">Java</p>
                </div>
            </div>
            <div class="bg-white p-6 grid content-start gap-y-3 mb-4 rounded-xl shadow-lg divide-y">
                <div class="font-semibold flex items-center space-x-2">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" viewBox="0 0 20 20" fill="currentColor">
                        <path d="M9 6a3 3 0 11-6 0 3 3 0 016 0zM17 6a3 3 0 11-6 0 3 3 0 016 0zM12.93 17c.046-.327.07-.66.07-1a6.97 6.97 0 00-1.5-4.33A5 5 0 0119 16v1h-6.07zM6 11a5 5 0 015 5v1H1v-1a5 5 0 015-5z" />
                    </svg>
                    <p>Top Users</p>
                </div>
                <div class="divide-y">
<%--                    <c:forEach var = "i" begin = "1" end = "3">--%>
                        <div class="flex flex-wrap space-x-3 items-center p-2">
                            <p class="text-4xl font-semibold text-purple-600">1</p>
                            <p><img class="rounded-full h-9 w-9" src="https://inkythuatso.com/uploads/thumbnails/800/2022/03/avatar-mac-dinh-nu-co-mau-30-10-31-43.jpg"></p>
                            <div>
                                <p class="font-semibold">Jane Dove</p>
                                <p class="text-xs">100 points</p>
                            </div>
                        </div>
<%--                    </c:forEach>--%>


                </div>
            </div>

            <div class="bg-white p-6 grid content-start gap-y-3 mb-4 rounded-xl shadow-lg divide-y">
                <div class="font-semibold flex items-center space-x-2">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M12.395 2.553a1 1 0 00-1.45-.385c-.345.23-.614.558-.822.88-.214.33-.403.713-.57 1.116-.334.804-.614 1.768-.84 2.734a31.365 31.365 0 00-.613 3.58 2.64 2.64 0 01-.945-1.067c-.328-.68-.398-1.534-.398-2.654A1 1 0 005.05 6.05 6.981 6.981 0 003 11a7 7 0 1011.95-4.95c-.592-.591-.98-.985-1.348-1.467-.363-.476-.724-1.063-1.207-2.03zM12.12 15.12A3 3 0 017 13s.879.5 2.5.5c0-1 .5-4 1.25-4.5.5 1 .786 1.293 1.371 1.879A2.99 2.99 0 0113 13a2.99 2.99 0 01-.879 2.121z" clip-rule="evenodd" />
                    </svg>
                    <p>New Users</p>
                </div>
                <div class="divide-y">
<%--                    <c:forEach var = "i" begin = "1" end = "3">--%>

                        <div class="flex flex-wrap space-x-3 items-center p-2">
                            <p class="text-4xl font-semibold text-purple-600">1</p>
                            <p><img class="rounded-full h-9 w-9" src="https://inkythuatso.com/uploads/thumbnails/800/2022/03/avatar-mac-dinh-nu-co-mau-30-10-31-43.jpg"></p>
                            <div>
                                <p class="font-semibold">Jane Dove</p>
                                <p class="text-xs">100 points</p>
                            </div>
                        </div>
<%--                    </c:forEach>--%>


                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
