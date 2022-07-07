<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tw-elements/dist/css/index.min.css"/>
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.4.7/dist/flowbite.min.css"/>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">

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

        .heading-icon {
            font-size: 24px;
            transform: translateY(2px);
        }

        .information-icon {
            font-size: 24px;
        }

        .btn-icon {
            font-size: 20px;
        }

        .ql-toolbar {
            border-radius: 10px !important;
        }
    </style>
    <title>Create Question</title>
</head>
<body class="relative h-full w-full m-0 text-gray-800 bg-gray-50">
<jsp:include page="header.jsp"></jsp:include>

<div class="container w-full h-[100vh] mx-auto pt-32">
    <div class="header w-full flex gap-x-10 mb-5">
			<span>
				<ion-icon name="chatbox-ellipses" class="heading-icon"></ion-icon>
			</span>
        <p class="text-xl font-semibold">Ask a new question</p>
    </div>
    <div class="w-full flex flex-col lg:flex-row gap-x-5 gap-y-5">
        <div class="left w-full lg:w-9/12">
            <form action="/CreateQuestion" method="POST">
                <div
                        class="bg-white relative w-full p-[40px] grid content-start gap-y-4 rounded-xl shadow-[0px_2px_4px_rgba(0,0,0,0.06),0px_4px_6px_rgba(0,0,0,0.1)]">
                    <div class="w-full relative">
                        <label for="title" class="block mb-1 text-lg font-semibold text-gray-900">Question title</label>
                        <label for="title" class="block mb-3 text-sm font-medium text-gray-500">What is your question?
                            Be
                            specific</label>
                        <input type="text" id="title" name="questionTitle"
                               class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-[#7E3AF2] focus:border-[#7E3AF2] block w-full p-2.5"
                               placeholder="Put your title here..." required>
                    </div>
                    <div class="mb-5">
                        <label for="editor" class="block mb-1 text-lg font-semibold text-gray-900">Question body</label>
                        <label for="editor" class="block mb-3 text-sm font-medium text-gray-500">Include all the
                            information
                            someone
                            would need to answer your question.</label>
                        <div id="editor"
                             class="block p-2.5 w-full h-50 text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-[#7E3AF2] focus:border-[#7E3AF2]"
                             placeholder="Your question here..."></div>
                        <input id="questionContent" name="questionContent" style="display: none">
                        <input name="action" value="createQuestion" style="display: none">
                    </div>
                    <div class="mt-20">
                        <label for="tags" class="block mb-1 text-lg font-semibold text-gray-900">Tag</label>
                        <label for="tags" class="block mb-3 text-sm font-medium text-gray-500">Put at least one
                            tag</label>
                        <div id="tags"
                             class="p-2 w-full text-sm text-gray-400 bg-gray-50 rounded-lg border border-gray-300 flex items-center justify-between">
                            <span id="tagsPlaceholder" class="flex gap-x-2"></span>

                            <!-- Modal toggle -->
                            <button
                                    class="px-3 py-2 text-xs font-medium text-center text-white bg-[#7E3AF2] rounded-lg hover:bg-[#442083] focus:ring-4 focus:outline-none focus:ring-[#7E3AF220]"
                                    type="button" data-modal-toggle="tagsModal">
                                Choose tags
                            </button>
                        </div>
                    </div>
                    <div class="flex mt-2">
                        <a href="#"
                           type="button"
                           class="text-white bg-slate-500 hover:bg-slate-800 cursor-pointer focus:ring-4 focus:outline-none focus:ring-[#7E3AF220] font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center gap-x-2 mr-2">
                            <ion-icon name="close-circle" class="btn-icon"></ion-icon>
                            Cancel
                        </a>
                        <button type="submit"
                                class="text-white bg-[#7E3AF2] hover:bg-[#442083] cursor-pointer focus:ring-4 focus:outline-none focus:ring-[#7E3AF220] font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center gap-x-2 mr-2">
                            <ion-icon name="chatbubbles" class="btn-icon"></ion-icon>
                            Post Question
                        </button>
                    </div>
                </div>

                <!-- Main modal -->
                <div id="tagsModal" tabindex="-1" aria-hidden="true"
                     class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
                    <div class="relative p-4 w-full max-w-2xl h-full md:h-auto">
                        <!-- Modal content -->
                        <div class="relative bg-white rounded-lg shadow">
                            <!-- Modal header -->
                            <div class="flex justify-between items-start p-4 rounded-t border-b">
                                Tags
                                </h3>
                                <button type="button"
                                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center"
                                        data-modal-toggle="tagsModal">
                                    <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
                                         xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                                              clip-rule="evenodd"></path>
                                    </svg>
                                </button>
                            </div>
                            <!-- Modal body -->
                            <div class="modal-content p-6 grid grid-cols-5 gap-4">
                                <c:forEach items="${requestScope.tags}" var="tag">
                                    <div class="flex items-center">
                                        <input id="${tag.tagName}" type="checkbox" name="questionTag" value="${tag.id}"
                                               class="w-4 h-4 text-blue-600 bg-gray-100 rounded border-gray-800 focus:ring-blue-500 focus:ring-2">
                                        <label for="${tag.tagName}"
                                               class="ml-2 text-sm font-medium text-gray-900">${tag.tagName}</label>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- Modal footer -->
                            <div class="flex items-center p-6 space-x-2 rounded-b border-t border-gray-200">
                                <button id="confirmBtn" data-modal-toggle="tagsModal" type="button"
                                        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">
                                    Confirm
                                </button>
                                <button data-modal-toggle="tagsModal" type="button"
                                        class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">
                                    Cancel
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <span class="text-green-800">${requestScope.SUCCESS}</span>
            <span class="text-red-800">${requestScope.ERROR}</span>
        </div>
        <div class="right lg:w-3/12 w-full">
            <div
                    class="mb-5 bg-white p-[40px] grid content-start gap-y-4 rounded-xl shadow-[0px_2px_4px_rgba(0,0,0,0.06),0px_4px_6px_rgba(0,0,0,0.1)]">
                <div class="header w-full flex gap-x-2 mb-2">
						<span>
							<ion-icon name="information-circle" class="information-icon"></ion-icon>
						</span>
                    <p class="text-xl font-semibold">How to ask a new question</p>
                </div>
                <span class="text-sm">The community is here to help you with specific programming or learning problems.</span>
                <div class="text-lg font-semibold"><span class="text-[#7E3AF2] text-5xl font-bold mr-4">1</span>
                    Summarize the problem
                </div>
                <div class="text-lg font-semibold"><span class="text-[#7E3AF2] text-5xl font-bold mr-4">2</span>
                    Describe what you’ve tried
                </div>
                <div class="text-lg font-semibold"><span class="text-[#7E3AF2] text-5xl font-bold mr-4">3</span> Choose
                    tags for your problem
                </div>
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
    <script src="https://unpkg.com/flowbite@1.4.7/dist/flowbite.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
    <script>
        var quill = new Quill('#editor', {
            theme: 'snow',
            modules: {
                toolbar: true
            }
        });
        quill.on('text-change', function (delta, oldDelta, source) {
            $('#questionContent').val(quill.container.firstChild.innerHTML);
        });
        const tags = document.querySelectorAll('.modal-content input[type="checkbox"]:checked')
        const confirmButton = document.querySelector('#confirmBtn')
        const tagsPlaceholder = document.querySelector('#tagsPlaceholder')

        if (tags.length === 0) {
            tagsPlaceholder.textContent = 'Chosen tags will go here'
        }

        confirmButton.addEventListener('click', () => {
            const checkedTags = [...document.querySelectorAll('.modal-content input[type="checkbox"]:checked')]
            if (checkedTags.length === 0) {
                tagsPlaceholder.textContent = 'Chosen tags will go here'
                return
            }
            const tagsElement = checkedTags.map(e => {
                const htmlElement = document.createElement('span')
                htmlElement.className = 'px-4 py-1 mr-4 border border-solid border-[#B9C1CC] text-[#000000] rounded-md text-xs text-justify hover:backdrop-brightness-95 duration-50'
                htmlElement.textContent = e.id
                return htmlElement
            })
            tagsPlaceholder.replaceChildren(...tagsElement)
        })
    </script>

</body>
</html>