<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/6/2022
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
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
                <div class="font-medium text-gray-400"><a href="">Activity</a></div>
                <div class="font-medium text-gray-400"><a href="editprofile.jsp">Edit Profile</a></div>
                <div class="font-medium text-gray-400"><a href="changepassword.jsp">Change Password</a></div>
            </div>
        </div>
    </div>

    <!-- right side -->
    <div class="basis-8/12 h-full space-y-5 relative left-80">
        <!-- bio and badge  -->
        <div class="flex space-x-3">
            <div class="bg-white rounded-md p-10 w-1/2 shadow-lg divide-y space-y-3">
                <div class="font-semibold">Bio</div>
                <div class="text-sm pt-3">${sessionScope.USER.bio}</div>
            </div>
            <div class="bg-white rounded-md p-10 w-1/2 shadow-lg divide-y space-y-3">
                <div class="font-semibold">Badges</div>
                <div class="text-xs pt-3">
                    <div class="rounded-md py-0.5 px-3 text-red-700 bg-red-100  w-min">Newbie</div>
                </div>
            </div>
        </div>

        <div class="font-semibold">Recent questions</div>

        <!-- a question  -->
        <div class="bg-white p-8 grid gap-y-3 rounded-lg shadow-lg">
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
        <!-- end a question  -->

        <!-- a question  -->
        <div class="bg-white p-8 grid gap-y-3 rounded-lg shadow-lg">
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
        <!-- end a question  -->



    </div>
</div>
</body>
</html>
