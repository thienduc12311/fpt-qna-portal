<%-- Created by IntelliJ IDEA. User: markhipz Date: 6/2/2022 Time: 2:57 PM To
change this template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>View Question</title>
    <link rel="icon" type="image/x-icon" href="" />
    <link href="/asset/style/style.css" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://unpkg.com/flowbite@1.4.7/dist/flowbite.min.css"
    />
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="h-auto pt-32 bg-[#F2F2F2]">
      <div class="container min-h-screen mx-auto pb-12 pl-14">
        <div class="text-[#505059] mb-8">
          <!-- this is for the link address -->

          <a href="" class="mr-1 cursor-pointer hover:opacity-75 duration-150"
            ><ion-icon name="home-sharp"></ion-icon
          ></a>
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
                          href="#"
                          class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600"
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

                <div class="flex items-center">
                  <div
                    class="bg-[#7E3AF2] text-[#fff] items-center flex px-5 py-2 rounded-md w-36 justify-center mr-6"
                  >
                    <ion-icon name="chatbox-ellipses"></ion-icon>
                    <!-- number of answers here -->
                    <div class="ml-2 text-xs">12 answers</div>
                  </div>
                  <div
                    class="bg-[#7E3AF2] text-[#fff] items-center flex px-5 py-2 rounded-md w-36 justify-center"
                  >
                    <ion-icon name="chatbubbles"></ion-icon>
                    <!-- number of answers here -->
                    <div class="ml-2 text-xs">24 comments</div>
                  </div>
                  <a
                    href=""
                    class="ml-auto text-[#B9C1CC] hover:opacity-60 duration-100"
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
                  ><ion-icon name="caret-up"></ion-icon
                ></a>

                <!-- number of votes -->

                <div class="font-bold">150</div>

                <!-- downvote button -->

                <a href="" class="hover:opacity-60 duration-150"
                  ><ion-icon name="caret-down"></ion-icon
                ></a>
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
                        <a
                          href="#"
                          class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600"
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
                  ><ion-icon name="caret-up"></ion-icon
                ></a>

                <!-- number of votes -->

                <div class="font-bold">150</div>

                <!-- downvote button -->

                <a href="" class="hover:opacity-60 duration-150"
                  ><ion-icon name="caret-down"></ion-icon
                ></a>
              </div>
            </div>

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
                  <span class="ml-2 text-lg font-semibold"
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
                  <span class="ml-2 text-lg font-semibold"
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
                  <span class="ml-2 text-lg font-semibold">Trending tags</span>
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
  </body>
</html>
