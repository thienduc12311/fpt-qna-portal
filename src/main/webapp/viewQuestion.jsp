<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Question</title>
    <link rel="icon" type="image/x-icon" href=""/>
    <link href="/asset/style/style.css" rel="stylesheet"/>
    <link
            rel="stylesheet"
            href="https://unpkg.com/flowbite@1.4.7/dist/flowbite.min.css"
    />
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        html * {
            font-family: "Inter", sans-serif;
            font-size: 16px;
        }

        .drop ion-icon {
            font-size: 20px;
        }

        .vote ion-icon {
            font-size: 20px;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="h-auto pt-32 bg-[#F2F2F2]">
    <div class="container min-h-screen lg:mx-auto pb-12 pl-14">
        <div class="text-[#505059] mb-8">
            <!-- this is for the link address -->

            <a href="" class="mr-1 cursor-pointer hover:opacity-75 duration-150"
            >
                <ion-icon name="home-sharp"></ion-icon
                >
            </a>
            <a
                    href=""
                    class="font-bold cursor-pointer hover:opacity-75 duration-150"
            >Home</a
            >
            <span> / </span>
            <a
                    href=""
                    class="font-bold cursor-pointer hover:opacity-75 duration-150"
            >Question</a
            >
            <span> / </span>
            <a
                    href=""
                    class="font-bold cursor-pointer hover:opacity-75 duration-150 text-[#252530]"
            >Q14</a
            >
        </div>

        <div class="w-full flex">
            <!-- this section is for question info -->

            <div class="content w-full lg:w-9/12">
                <div class="question bg-white rounded-lg drop-shadow-md relative">
                    <div class="p-11">
                        <div class="flex items-center mb-6 mx-3">
                            <!-- put the link to profile here in href -->

                            <a href="" class="cursor-pointer">
                                <!-- put avatar link here -->

                                <img
                                        class="w-9 rounded-full"
                                        src="https://www.w3schools.com/howto/img_avatar.png"
                                        alt="avatar"
                                />
                            </a>
                            <!-- put the link to profile here in href-->

                            <a href="" class="font-semibold ml-3 text-[#505059]"
                            >Author
                                <!-- put the author name here -->
                            </a>

                            <!-- put date here -->
                            <span class="ml-4 text-xs text-[#B9C1CC]">March 3, 2022</span>

                            <button
                                    id="dropdownLeftStartButton"
                                    data-dropdown-toggle="dropdownLeftStart"
                                    data-dropdown-placement="left-start"
                                    class="drop ml-auto p-2 rounded-[100%] hover:backdrop-contrast-75 duration-200 text-[#B9C1CC]"
                                    type="button"
                            >
                                <ion-icon name="ellipsis-horizontal-sharp"></ion-icon>
                            </button>

                            <div
                                    id="dropdownLeftStart"
                                    class="z-20 hidden bg-white divide-y divide-gray-100 rounded shadow w-44"
                            >
                                <ul
                                        class="py-1 text-sm text-gray-700"
                                        aria-labelledby="dropdownLeftStartButton"
                                >
                                    <li>
                                        <a
                                                class="block px-4 py-2 hover:bg-gray-100 cursor-pointer"
                                                type="button"
                                                data-modal-toggle="reportModalQuestion"
                                        >Report</a
                                        >
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <!-- this to show question detail -->

                        <div class="content mr-16">
                            <h3 class="text-[#252530] font-semibold text-xl mb-3">
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                                do eiusmod tempor incididunt ut labore et dolore magna
                                aliqua.
                            </h3>
                            <p class="text-[#505059]">
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                                do eiusmod tempor incididunt ut labore et dolore magna
                                aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                                ullamco laboris nisi ut aliquip ex ea commodo consequat.
                                Duis aute irure dolor in reprehenderit in voluptate velit
                                esse cillum dolore eu fugiat nulla pariatur.
                            </p>
                        </div>

                        <!-- place a loop for tags here -->

                        <div class="flex mt-6">
                            <a
                                    href=""
                                    class="px-4 py-1 mr-4 border border-solid border-[#B9C1CC] text-[#B9C1CC] rounded text-xs text-justify hover:backdrop-brightness-95 duration-50"
                            >Lifestyle</a
                            ><a
                                href=""
                                class="px-4 py-1 mr-4 border border-solid border-[#B9C1CC] text-[#B9C1CC] rounded text-xs text-justify hover:backdrop-brightness-95 duration-50"
                        >Java </a
                        ><a
                                href=""
                                class="px-4 py-1 mr-4 border border-solid border-[#B9C1CC] text-[#B9C1CC] rounded text-xs text-justify hover:backdrop-brightness-95 duration-50"
                        >C#</a
                        >
                        </div>
                        <div class="border-b my-7"></div>

                        <!-- this is for number of answers and comments -->

                        <div class="flex items-center flex-col md:flex-row gap-y-3">
                            <div
                                    class="bg-[#7E3AF2] text-[#fff] items-center flex px-5 py-2 rounded-md w-full md:w-36 justify-center md:mr-6"
                            >
                                <ion-icon name="chatbox-ellipses"></ion-icon>
                                <!-- number of answers here -->
                                <div class="ml-2 text-xs">12 answers</div>
                            </div>
                            <div
                                    class="bg-[#7E3AF2] text-[#fff] items-center flex px-5 py-2 rounded-md w-full md:w-36 justify-center"
                            >
                                <ion-icon name="chatbubbles"></ion-icon>
                                <!-- number of answers here -->
                                <div class="ml-2 text-xs">24 comments</div>
                            </div>
                            <a
                                    href=""
                                    class="mx-auto md:ml-auto md:mr-0 text-[#B9C1CC] hover:opacity-60 duration-100"
                            >Follow this thread</a
                            >
                        </div>

                        <!-- comment form -->

                        <form action="" class="mt-8">
                            <div class="flex">
                                <input
                                        type="text"
                                        class="border-2 border-solid border-[#E2E8F0] bg-[#F9FAFB] w-8/12 rounded-md focus:ring-0 focus:outline-none placeholder:text-[#B9C1CC]"
                                        placeholder="Write a comment here..."
                                />
                                <button
                                        class="text-[#fff] bg-[#7E3AF2] p-3 rounded-[100%] ml-8 w-11 h-11 hover:opacity-90 duration-150"
                                        name=""
                                        value=""
                                >
                                    <ion-icon name="paper-plane"></ion-icon>
                                </button>
                            </div>
                        </form>

                        <!-- put comment here -->
                        <!-- open loop -->
                        <div class="comment my-8">
                            <div class="flex items-center mb-4 mx-3">
                                <!-- put the link to profile here in href -->

                                <a href="" class="cursor-pointer">
                                    <!-- put avatar link here -->

                                    <img
                                            class="w-9 rounded-full"
                                            src="https://www.w3schools.com/howto/img_avatar.png"
                                            alt="avatar"
                                    />
                                </a>
                                <!-- put the link to profile here in href-->

                                <a href="" class="font-semibold ml-3 text-[#505059]"
                                >Author
                                    <!-- put the author name here -->
                                </a>

                                <!-- put date here -->
                                <span class="ml-4 text-xs text-[#B9C1CC]"
                                >March 3, 2022</span
                                >
                            </div>
                            <div class="content mr-16 ml-14">
                                <p class="text-[#505059]">
                                    <!-- comment content here -->

                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                                    sed do eiusmod tempor incididunt ut labore et dolore magna
                                    aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                                    ullamco laboris nisi ut aliquip
                                </p>
                            </div>
                            <div class="border-b mt-7"></div>
                        </div>

                        <!--this button is for show more comment -->
                        <!--place a condition for show more comments -->
                        <!-- if there is no more comment, hide this button -->
                        <!-- best case is to show 2 comments -->
                        <a
                                href=""
                                class="text-[#7E3AF2] font-semibold hover:opacity-70 duration-150"
                        >See 22 more comments</a
                        >

                        <!-- close loop  -->
                    </div>

                    <!-- this is for vote -->

                    <div class="vote absolute flex-col text-center top-32 -left-12">
                        <!-- upvote button -->

                        <a href="" class="hover:opacity-60 duration-150"
                        >
                            <ion-icon name="caret-up"></ion-icon
                            >
                        </a>

                        <!-- number of votes -->

                        <div class="font-bold">150</div>

                        <!-- downvote button -->

                        <a href="" class="hover:opacity-60 duration-150"
                        >
                            <ion-icon name="caret-down"></ion-icon
                            >
                        </a>
                    </div>
                </div>

                <div
                        id="reportModalQuestion"
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
                                    Report Question
                                </h3>
                                <button
                                        type="button"
                                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center"
                                        data-modal-toggle="reportModalQuestion"
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
                                <form action="">
                                    <label
                                            for="question-flag"
                                            class="block mb-2 text-lg font-medium text-gray-90"
                                    >Select a flag</label
                                    >
                                    <select
                                            required
                                            onchange="questionFlagSelect(this)"
                                            id="question-flag"
                                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                    >
                                        <option selected value="">Choose a flag</option>
                                        <option value="flag-1">Flag 1</option>
                                        <option value="flag-2">Flag 2</option>
                                        <option value="flag-3">Flag 3</option>
                                    </select>

                                    <!-- description go here -->

                                    <div class="my-6 bg-[#F3F4F6] rounded-md">
                                        <p
                                                class="p-6 text-sm font-semibold"
                                                id="question-flag-0"
                                        >
                                            Please choose a flag
                                        </p>

                                        <p
                                                class="hidden p-6 text-sm font-semibold"
                                                id="question-flag-1"
                                        >
                                            des 1
                                        </p>

                                        <p
                                                class="hidden p-6 text-sm font-semibold"
                                                id="question-flag-2"
                                        >
                                            des 2
                                        </p>

                                        <p
                                                class="hidden p-6 text-sm font-semibold"
                                                id="question-flag-3"
                                        >
                                            des 3
                                        </p>
                                    </div>

                                    <label
                                            for="question-description"
                                            class="block mb-2 text-lg font-medium text-gray-90"
                                    >Description</label
                                    >
                                    <div class="relative w-full">
                                        <input
                                                type="text"
                                                id="question-description"
                                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                                placeholder="More detail"
                                                required
                                        />
                                    </div>
                                    <div
                                            class="flex items-center py-6 space-x-2 rounded-b border-gray-200"
                                    >
                                        <button
                                                data-modal-toggle="reportModalQuestion"
                                                type="button"
                                                class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center"
                                        >
                                            Report
                                        </button>
                                        <button
                                                data-modal-toggle="reportModalQuestion"
                                                type="button"
                                                class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10"
                                        >
                                            Cancel
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- number of answers here -->

                <div class="question bg-white rounded-lg drop-shadow-md my-6">
                    <div class="p-8">
                        <h1 class="font-semibold text-xl text-[#7E3AF2]">
                            ANSWERS (12)
                        </h1>
                    </div>
                </div>

                <!-- answers start her -->

                <div
                        class="answer bg-white rounded-lg drop-shadow-md relative border-l-4 border-[#7E3AF2] mb-6"
                >
                    <div class="p-11">
                        <div class="flex items-center mb-6 mx-3">
                            <!-- put the link to profile here in href -->

                            <a href="" class="cursor-pointer">
                                <!-- put avatar link here -->

                                <img
                                        class="w-9 rounded-full"
                                        src="https://www.w3schools.com/howto/img_avatar.png"
                                        alt="avatar"
                                />
                            </a>
                            <!-- put the link to profile here in href-->

                            <a href="" class="font-semibold ml-3 text-[#505059]"
                            >Author
                                <!-- put the author name here -->
                            </a>

                            <!-- put date here -->
                            <span class="ml-4 text-xs text-[#B9C1CC]">March 3, 2022</span>

                            <!-- this button is for report this answer loop the ans1 ans2 ans3 here -->

                            <button
                                    data-dropdown-toggle="dropdownLeftStartAns1"
                                    data-dropdown-placement="left-start"
                                    class="drop ml-auto p-2 rounded-[100%] hover:backdrop-contrast-75 duration-200 text-[#B9C1CC]"
                                    type="button"
                            >
                                <ion-icon name="ellipsis-horizontal-sharp"></ion-icon>
                            </button>

                            <!-- ans1 ans2 ans3 here too -->

                            <div
                                    id="dropdownLeftStartAns1"
                                    class="z-20 hidden bg-white divide-y divide-gray-100 rounded shadow w-44"
                            >
                                <ul
                                        class="py-1 text-sm text-gray-700"
                                        aria-labelledby="dropdownLeftStartButton"
                                >
                                    <li>
                                        <!-- put loop index here -->
                                        <a
                                                class="block px-4 py-2 hover:bg-gray-100 cursor-pointer"
                                                type="button"
                                                data-modal-toggle="reportModalAnswer-1"
                                        >Report</a
                                        >
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <!-- this to show answer detail -->

                        <div class="content mr-16">
                            <p class="text-[#505059]">
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                                do eiusmod tempor incididunt ut labore et dolore magna
                                aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                                ullamco laboris nisi ut aliquip ex ea commodo consequat.
                                Duis aute irure dolor in reprehenderit in voluptate velit
                                esse cillum dolore eu fugiat nulla pariatur.
                            </p>
                        </div>

                        <!-- comment form -->

                        <form action="" class="mt-8">
                            <div class="flex">
                                <input
                                        type="text"
                                        class="border-2 border-solid border-[#E2E8F0] bg-[#F9FAFB] w-8/12 rounded-md focus:ring-0 focus:outline-none placeholder:text-[#B9C1CC]"
                                        placeholder="Write a comment here..."
                                />
                                <button
                                        class="text-[#fff] bg-[#7E3AF2] p-3 rounded-[100%] ml-8 w-11 h-11 hover:opacity-90 duration-150"
                                >
                                    <ion-icon name="paper-plane"></ion-icon>
                                </button>
                            </div>
                        </form>

                        <!-- put comment here -->
                        <!-- open loop -->
                        <div class="comment my-8">
                            <div class="flex items-center mb-4 mx-3">
                                <!-- put the link to profile here in href -->

                                <a href="" class="cursor-pointer">
                                    <!-- put avatar link here -->

                                    <img
                                            class="w-9 rounded-full"
                                            src="https://www.w3schools.com/howto/img_avatar.png"
                                            alt="avatar"
                                    />
                                </a>
                                <!-- put the link to profile here in href-->

                                <a href="" class="font-semibold ml-3 text-[#505059]"
                                >Author
                                    <!-- put the author name here -->
                                </a>

                                <!-- put date here -->
                                <span class="ml-4 text-xs text-[#B9C1CC]"
                                >March 3, 2022</span
                                >
                            </div>
                            <div class="content mr-16 ml-14">
                                <p class="text-[#505059]">
                                    <!-- comment content here -->

                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                                    sed do eiusmod tempor incididunt ut labore et dolore magna
                                    aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                                    ullamco laboris nisi ut aliquip
                                </p>
                            </div>

                            <div class="border-b mt-7"></div>
                        </div>

                        <!-- close loop  -->
                    </div>

                    <!-- this is for vote -->

                    <div class="vote absolute flex-col text-center top-10 -left-12">
                        <!-- upvote button -->

                        <a href="" class="hover:opacity-60 duration-150"
                        >
                            <ion-icon name="caret-up"></ion-icon
                            >
                        </a>

                        <!-- number of votes -->

                        <div class="font-bold">150</div>

                        <!-- downvote button -->

                        <a href="" class="hover:opacity-60 duration-150"
                        >
                            <ion-icon name="caret-down"></ion-icon
                            >
                        </a>
                    </div>
                </div>

                <!-- place loop index here -->

                <div
                        id="reportModalAnswer-1"
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
                                    Report Answer
                                </h3>
                                <button
                                        type="button"
                                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center"
                                        data-modal-toggle="reportModalAnswer-1"
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
                                <form action="">
                                    <label
                                            for="answer-1-flag"
                                            class="block mb-2 text-lg font-medium text-gray-90"
                                    >Select a flag</label
                                    >
                                    <select
                                            required
                                            onchange="answerFlagSelect(1, this)"
                                            id="answer-1-flag"
                                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                    >
                                        <option selected value="">Choose a flag</option>
                                        <option value="flag-1">Flag 1</option>
                                        <option value="flag-2">Flag 2</option>
                                        <option value="flag-3">Flag 3</option>
                                    </select>

                                    <!-- description go here -->

                                    <div class="my-6 bg-[#F3F4F6] rounded-md">
                                        <p
                                                class="p-6 text-sm font-semibold"
                                                id="answer-1-flag-0"
                                        >
                                            Please choose a flag
                                        </p>

                                        <p
                                                class="hidden p-6 text-sm font-semibold"
                                                id="answer-1-flag-1"
                                        >
                                            des 1
                                        </p>

                                        <p
                                                class="hidden p-6 text-sm font-semibold"
                                                id="answer-1-flag-2"
                                        >
                                            des 2
                                        </p>

                                        <p
                                                class="hidden p-6 text-sm font-semibold"
                                                id="answer-1-flag-3"
                                        >
                                            des 3
                                        </p>
                                    </div>

                                    <label
                                            for="answer-1-description"
                                            class="block mb-2 text-lg font-medium text-gray-90"
                                    >Description</label
                                    >
                                    <div class="relative w-full">
                                        <input
                                                type="text"
                                                id="answer-1-description"
                                                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                                                placeholder="More detail"
                                                required
                                        />
                                    </div>
                                    <div
                                            class="flex items-center py-6 space-x-2 rounded-b border-gray-200"
                                    >
                                        <button
                                                data-modal-toggle="reportModalAnswer-1"
                                                type="button"
                                                class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center"
                                        >
                                            Report
                                        </button>
                                        <button
                                                data-modal-toggle="reportModalAnswer-1"
                                                type="button"
                                                class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10"
                                        >
                                            Cancel
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- answer end here -->

                <!-- answer form -->

                <div
                        class="answer bg-white rounded-lg drop-shadow-md relative border-l-4 border-[#7E3AF2] mb-8"
                >
                    <div class="p-11">
                        <h2 class="font-semibold text-xl text-[#7E3AF2]">
                            Your answer
                        </h2>
                        <div class="border-b my-7"></div>
                        <div class="flex items-center mb-6 mx-3">
                            <!-- put the link to profile here in href -->

                            <a href="" class="cursor-pointer">
                                <!-- put avatar link here -->

                                <img
                                        class="w-9 rounded-full"
                                        src="https://www.w3schools.com/howto/img_avatar.png"
                                        alt="avatar"
                                />
                            </a>

                            <!-- put the User name here -->
                            <!-- put the link to profile here in href-->

                            <a href="" class="font-semibold ml-3 text-[#505059]">User </a>
                        </div>

                        <!-- start answer form -->

                        <form action="" id="answer-form">
                  <textarea
                          rows="4"
                          name="answer"
                          class="block p-4 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500"
                          placeholder="Start typing..."
                  ></textarea>
                            <button
                                    class="text-[#fff] bg-[#7E3AF2] px-11 py-2 mt-6 hover:opacity-90 duration-150 rounded-md items-center justify-center flex"
                                    name=""
                                    value=""
                            >
                                <ion-icon name="paper-plane"></ion-icon>
                                <span class="ml-1 text-xs">Post</span>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="trending w-3/12 ml-7 hidden lg:block">
                <div class="bg-white rounded-lg drop-shadow-md mb-6">
                    <div class="p-9">
                        <div class="flex items-center text-[#505059]">
                            <ion-icon name="chatbox-ellipses"></ion-icon>
                            <span class="ml-2 text-md font-semibold"
                            >Popular Questions</span
                            >
                        </div>

                        <!-- put a loop for popular questions here -->

                        <div class="border-b my-4"></div>
                        <a href="" class="">
                            <div class="flex items-center mb-4">
                                <img
                                        class="w-9 rounded-full"
                                        src="https://www.w3schools.com/howto/img_avatar.png"
                                        alt="avatar"
                                />

                                <!-- put author name here -->

                                <span class="ml-3">Author</span>
                            </div>

                            <!-- put question here -->

                            <h4 class="font-semibold text-lg text-[#252530]">
                                Lorem ipsum dolor sit amet, consectetur adincid elit, sed do
                                eiusmod tempor
                            </h4>
                            <div class="flex items-center my-2">
                                <!-- put date here -->

                                <span class="mr-6 text-xs text-[#B9C1CC]"
                                >March 3, 2022</span
                                >

                                <!-- put number of answers and comments here -->

                                <div class="flex items-center text-[#7E3AF2]">
                                    <ion-icon name="chatbox-ellipses"></ion-icon>
                                    <span class="ml-1 mr-6">12</span>
                                    <ion-icon name="chatbubbles"></ion-icon>
                                    <span class="ml-1">12</span>
                                </div>
                            </div>
                        </a>

                        <!-- end loop here -->
                    </div>
                </div>

                <div class="bg-white rounded-lg drop-shadow-md mb-6">
                    <div class="p-9">
                        <div class="flex items-center text-[#505059]">
                            <ion-icon name="share-social-outline"></ion-icon>
                            <span class="ml-2 text-md font-semibold"
                            >Related questions</span
                            >
                        </div>

                        <!-- put a loop for related questions here -->

                        <div class="border-b my-4"></div>
                        <a href="" class="">
                            <div class="flex items-center mb-4">
                                <img
                                        class="w-9 rounded-full"
                                        src="https://www.w3schools.com/howto/img_avatar.png"
                                        alt="avatar"
                                />

                                <!-- put author name here -->

                                <span class="ml-3">Author</span>
                            </div>

                            <!-- put question here -->

                            <h4 class="font-semibold text-lg text-[#252530]">
                                Lorem ipsum dolor sit amet, consectetur adincid elit, sed do
                                eiusmod tempor
                            </h4>
                            <div class="flex items-center my-2">
                                <!-- put date here -->

                                <span class="mr-6 text-xs text-[#B9C1CC]"
                                >March 3, 2022</span
                                >

                                <!-- put number of answers and comments here -->

                                <div class="flex items-center text-[#7E3AF2]">
                                    <ion-icon name="chatbox-ellipses"></ion-icon>
                                    <span class="ml-1 mr-6">12</span>
                                    <ion-icon name="chatbubbles"></ion-icon>
                                    <span class="ml-1">12</span>
                                </div>
                            </div>
                        </a>

                        <!-- end loop here -->
                    </div>
                </div>

                <div class="bg-white rounded-lg drop-shadow-md mb-6">
                    <div class="p-9">
                        <div class="flex items-center text-[#505059]">
                            <ion-icon name="pricetag"></ion-icon>
                            <span class="ml-2 text-md font-semibold">Trending tags</span>
                        </div>
                        <div class="border-b my-4"></div>

                        <!-- place a loop for tags here -->

                        <div class="mt-6 flex flex-wrap gap-y-2 gap-x-1">
                            <a
                                    href=""
                                    class="leading-[1rem] px-4 py-1 border border-solid border-[#B9C1CC] text-[#B9C1CC] rounded text-xs text-justify hover:backdrop-brightness-95 duration-50"
                            >Java
                            </a>

                            <!-- delete the rest -->

                            <a
                                    href=""
                                    class="leading-[1rem] px-4 py-1 border border-solid border-[#B9C1CC] text-[#B9C1CC] rounded text-xs text-justify hover:backdrop-brightness-95 duration-50"
                            >Java </a
                            ><a
                                href=""
                                class="leading-[1rem] px-4 py-1 border border-solid border-[#B9C1CC] text-[#B9C1CC] rounded text-xs text-justify hover:backdrop-brightness-95 duration-50"
                        >Lifestyle
                        </a>
                            <a
                                    href=""
                                    class="leading-[1rem] px-4 py-1 border border-solid border-[#B9C1CC] text-[#B9C1CC] rounded text-xs text-justify hover:backdrop-brightness-95 duration-50"
                            >C# </a
                            ><a
                                href=""
                                class="leading-[1rem] px-4 py-1 border border-solid border-[#B9C1CC] text-[#B9C1CC] rounded text-xs text-justify hover:backdrop-brightness-95 duration-50"
                        >C++
                        </a>
                            <a
                                    href=""
                                    class="leading-[1rem] px-4 py-1 border border-solid border-[#B9C1CC] text-[#B9C1CC] rounded text-xs text-justify hover:backdrop-brightness-95 duration-50"
                            >Technology
                            </a>
                            <!-- end delete -->
                        </div>
                    </div>
                </div>
                <div class="font-semibold text-[#B9C1CC]">@ 2022 FPTQnA Portal</div>
            </div>
        </div>
    </div>
</div>

<script src="https://unpkg.com/flowbite@1.4.7/dist/flowbite.js"></script>
<script
        type="module"
        src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"
></script>
<script
        nomodule
        src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"
></script>

<script>
    const questionFlagSelect = (props) => {
        let value = props.value;
        if (value === "") {
            hideQuestionFlagDescription();
            document.getElementById("question-flag-0").classList.remove("hidden");
        } else if (value === "flag-1") {
            hideQuestionFlagDescription();
            document.getElementById("question-flag-1").classList.remove("hidden");
        } else if (value === "flag-2") {
            hideQuestionFlagDescription();
            document.getElementById("question-flag-2").classList.remove("hidden");
        } else if (value === "flag-3") {
            hideQuestionFlagDescription();
            document.getElementById("question-flag-3").classList.remove("hidden");
        }
    };

    const hideQuestionFlagDescription = () => {
        for (let i = 0; i <= 3; i++) {
            let current = document.getElementById("question-flag-" + i);
            if (!current.classList.contains("hidden")) {
                current.classList.add("hidden");
            }
        }
    };

    const answerFlagSelect = (idx, props) => {
        let value = props.value;
        if (value === "") {
            hideAnswerFlagDescription(idx);
            document
                .getElementById("answer-" + idx + "-flag-0")
                .classList.remove("hidden");
        } else if (value === "flag-1") {
            hideAnswerFlagDescription(idx);
            document
                .getElementById("answer-" + idx + "-flag-1")
                .classList.remove("hidden");
        } else if (value === "flag-2") {
            hideAnswerFlagDescription(idx);
            document
                .getElementById("answer-" + idx + "-flag-2")
                .classList.remove("hidden");
        } else if (value === "flag-3") {
            hideAnswerFlagDescription(idx);
            document
                .getElementById("answer-" + idx + "-flag-3")
                .classList.remove("hidden");
        }
    };

    const hideAnswerFlagDescription = (idx) => {
        for (let i = 0; i <= 3; i++) {
            let current = document.getElementById("answer-" + idx + "-flag-" + i);
            if (!current.classList.contains("hidden")) {
                current.classList.add("hidden");
            }
        }
    };
</script>
</body>
</html>
