<%--
  Created by IntelliJ IDEA.
  User: thienduc
  Date: 31/05/2022
  Time: 08:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Notifications</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href='https://fonts.googleapis.com/css?family=Inter' rel='stylesheet'>
    <style>
        body {
            font-family: 'Inter';
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container w-1/2 h-[100vh] mx-auto flex gap-y-6 flex-col justify-start mt-28">
    <h3 class="text-2xl font-bold mb-5">All notifications</h3>
    <button type="button" data-modal-toggle="medium-modal">
        <div
                class="w-full bg-white rounded-lg border border-gray-200 shadow-md p-6 flex items-center gap-x-8 hover:bg-purple-50 text-left">
            <img src="https://avatar.tobi.sh/" alt="Avatar" class="rounded-full w-20 h-20 flex-shrink-0"/>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta vel, aut commodi maxime perspiciatis
                tempora
                deserunt veniam repudiandae molestias reprehenderit, sunt cupiditate debitis et suscipit nobis totam
                odit
                vitae quas!</p>
        </div>
    </button>
    <button type="button" data-modal-toggle="medium-modal">
        <div
                class="w-full bg-white rounded-lg border border-gray-200 shadow-md p-6 flex items-center gap-x-8 hover:bg-purple-50 text-left">
            <img src="https://avatar.tobi.sh/" alt="Avatar" class="rounded-full w-20 h-20 flex-shrink-0"/>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
        </div>
    </button>
    <button type="button" data-modal-toggle="medium-modal">
        <div
                class="w-full bg-white rounded-lg border border-gray-200 shadow-md p-6 flex items-center gap-x-8 hover:bg-purple-50 text-left">
            <img src="https://avatar.tobi.sh/" alt="Avatar" class="rounded-full w-20 h-20 flex-shrink-0"/>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta vel, aut commodi maxime perspiciatis
                tempora
                deserunt veniam repudiandae molestias reprehenderit, sunt cupiditate debitis et suscipit nobis totam
                odit
                vitae quas!</p>
        </div>
    </button>
    <button type="button" data-modal-toggle="medium-modal">
        <div
                class="w-full bg-white rounded-lg border border-gray-200 shadow-md p-6 flex items-center gap-x-8 hover:bg-purple-50 text-left">
            <img src="https://avatar.tobi.sh/" alt="Avatar" class="rounded-full w-20 h-20 flex-shrink-0"/>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta vel, aut commodi maxime perspiciatis
                tempora
                deserunt veniam repudiandae molestias reprehenderit, sunt cupiditate debitis et suscipit nobis totam
                odit
                vitae quas!</p>
        </div>
    </button>
    <button type="button" data-modal-toggle="medium-modal">
        <div
                class="w-full bg-white rounded-lg border border-gray-200 shadow-md p-6 flex items-center gap-x-8 hover:bg-purple-50 text-left">
            <img src="https://avatar.tobi.sh/" alt="Avatar" class="rounded-full w-20 h-20 flex-shrink-0"/>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta vel, aut commodi maxime perspiciatis
                tempora
                deserunt veniam repudiandae molestias reprehenderit, sunt cupiditate debitis et suscipit nobis totam
                odit
                vitae quas!</p>
        </div>
    </button>

    <div class="w-8/12 flex flex-col gap-4 justify-between sm:flex-row mt-5">
        <a href="#" class="text-[#B9C1CC] hover:text-[#9aa0a8] font-semibold">Back to home page...</a>
    </div>
    <div id="medium-modal" tabindex="-1"
         class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
        <div class="relative p-4 w-full max-w-lg h-full md:h-auto">
            <div class="relative bg-white rounded-lg shadow">
                <div class="flex justify-between items-center p-5 rounded-t border-b">
                    <h3 class="text-xl font-medium text-gray-900">
                        Notification Detail
                    </h3>
                    <button type="button"
                            class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center"
                            data-modal-toggle="medium-modal">
                        <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
                             xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                                  clip-rule="evenodd"></path>
                        </svg>
                        <span class="sr-only">Close modal</span>
                    </button>
                </div>
                <div class="p-6 flex gap-x-8">
                    <img src="https://avatar.tobi.sh/" alt="Avatar" class="rounded-full w-20 h-20 flex-shrink-0"/>
                    <p class="text-base text-gray-500">
                        With less than a month to go before the European Union enacts new consumer privacy laws for its
                        citizens, companies around the world are updating their terms of service agreements to comply.
                    </p>
                </div>
                <div class="flex items-center p-6 space-x-2 rounded-b border-t border-gray-200">
                    <button data-modal-toggle="medium-modal" type="button"
                            class="text-white bg-purple-700 hover:bg-purple-800 focus:ring-4 focus:outline-none focus:ring-purple-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">
                        Close
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
<script src="https://unpkg.com/flowbite@1.4.7/dist/flowbite.js"></script>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>
</html>
