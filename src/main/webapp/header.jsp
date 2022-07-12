<div class="shadow bg-white fixed w-full top-0 z-10">
    <div class="py-2 px-5 lg:px-10">
        <div class="flex justify-between items-center space-x-6">
            <!-- left side -->
            <div class="flex space-x-6 items-center">
                <div>
                    <a href="home?page=1">
                        <div class="text-sm bg-purple-600 text-white font-semibold rounded-md py-1.5 flex items-center px-4 space-x-2 hover:bg-purple-800 transition ease-in-out duration-300">
                            <span class="font-bold">FPT</span>QnA Portal
                        </div>
                    </a>
                </div>
                <div class="hidden md:block ">
                    <form action="Search" method="post" class="p-0 m-0 inline">
                        <div class="relative">
                            <input type="text" name="txtdisplayname" value=""
                                   class="text-sm py-1.5 w-60 rounded px-3 shadow focus:outline-none focus:ring-1 focus:ring-purple-500"
                                   placeholder="Search...">
                            <span class="absolute inset-y-0 right-0 flex items-center pr-2">
                                    <button type="submit"
                                            class="p-1  bg-gray-200 rounded hover:bg-slate-100 transition ease-in-out duration-300">
                                      <svg fill="none" stroke="currentColor" stroke-linecap="round"
                                           stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24"
                                           class="w-3.5 h-3.5"><path
                                              d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>
                                    </button>
                                </span>
                        </div>
                    </form>
                </div>
            </div>
            <!-- right-side  -->
            <div class="flex space-x-6 items-center">
                <div>
                    <a href="/CreateQuestion"
                       class="text-sm bg-purple-600 text-white font-medium rounded-md py-1.5 flex items-center px-4 space-x-2 hover:bg-purple-800 transition ease-in-out duration-300">
                        <div>
                            <svg class="w-4 h-4 fill-white" id="Layer_1" viewBox="0 0 24 24"
                                 xmlns="http://www.w3.org/2000/svg" data-name="Layer 1">
                                <path d="m12 0a12 12 0 1 0 12 12 12.013 12.013 0 0 0 -12-12zm4 13h-3v3a1 1 0 0 1 -2 0v-3h-3a1 1 0 0 1 0-2h3v-3a1 1 0 0 1 2 0v3h3a1 1 0 0 1 0 2z"/>
                            </svg>
                        </div>
                        <div class="hidden sm:inline">Ask Question</div>
                    </a>
                </div>
                <div>
                    <!-- toggle drop down notification  -->

                    <div class="relative text-left dropdown font-semibold">
                        <a href="#">
                            <div class="relative flex items-center shadow px-2 rounded py-2 hover:bg-slate-100 transition ease-in-out duration-300">
                                <svg class="w-4 h-4 text-gray-700 fill-gray-700" xmlns="http://www.w3.org/2000/svg"
                                     id="Layer_1" data-name="Layer 1" viewBox="0 0 24 24">
                                    <path d="M4.068,18H19.724a3,3,0,0,0,2.821-4.021L19.693,6.094A8.323,8.323,0,0,0,11.675,0h0A8.321,8.321,0,0,0,3.552,6.516l-2.35,7.6A3,3,0,0,0,4.068,18Z"/>
                                    <path d="M7.1,20a5,5,0,0,0,9.8,0Z"/>
                                </svg>
                                <span class="absolute top-2 right-2.5 inline-block w-1.5 h-1.5 transform translate-x-1/2 -translate-y-1/2 bg-red-600 rounded-full"></span>
                            </div>
                        </a>
                        <div class="opacity-0 invisible dropdown-menu transition-all duration-300 transform origin-top-right -translate-y-2 scale-95">
                            <div class="absolute right-0 w-80 mt-2.5 origin-top-right bg-white border border-gray-200 divide-y divide-gray-100 rounded-md shadow-lg outline-none"
                                 aria-labelledby="headlessui-menu-button-1" id="headlessui-menu-items-117" role="menu">
                                <div class="px-6 pt-6 pb-2">
                                    <p class="text-lg leading-5 font-bold">Notifications</p>
                                </div>
                                <div class="py-1 px-6 hover:bg-slate-100">
                                    <a href="personalprofile.jsp"
                                       class="text-gray-700 flex w-full pt-4 py-2 text-xs leading-5 text-left space-x-2"
                                       role="menuitem">
                                        <img class="rounded-full h-9 w-9"
                                             src="https://inkythuatso.com/uploads/thumbnails/800/2022/03/avatar-mac-dinh-nu-co-mau-30-10-31-43.jpg">
                                        <div>
                                            <div class="text-xs">Jane Dove<span class="font-normal text-xs"> has recently answered your question </span>"Why
                                                do birds fly, they want to look down on us or ..."
                                            </div>
                                            <div class="text-slate-300 font-normal text-xs">March 3, 2022</div>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div>
                    <a href="personalprofile.jsp">
                        <label class="flex lg:space-x-2 cursor-pointer">
                            <img class="rounded-full h-9 w-9" src="${sessionScope.USER.avtUrl}">
                            <div class="hidden lg:flex lg:flex-col">
                                <div class="text-sm font-semibold">${sessionScope.USER.name}</div>
                                <div class="text-xs font-semibold text-gray-600"> ${sessionScope.USER.email}</div>
                            </div>
                        </label>
                    </a>
                </div>
                <div>
                    <!-- Dropdown toggle button -->
                    <div class="relative text-left dropdown font-semibold">
                        <button class="py-2" type="button" aria-haspopup="true" aria-expanded="true"
                                aria-controls="headlessui-menu-items-117">
                            <svg class="w-5 h-5" viewBox="0 0 20 20" fill="currentColor">
                                <path fill-rule="evenodd"
                                      d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z"
                                      clip-rule="evenodd"></path>
                            </svg>
                        </button>
                        <div class="opacity-0 invisible dropdown-menu transition-all duration-300 transform origin-top-right -translate-y-2 scale-95">
                            <div class="absolute right-0 w-56 mt-2 origin-top-right bg-white border border-gray-200 divide-y divide-gray-100 rounded-md shadow-lg outline-none"
                                 aria-labelledby="headlessui-menu-button-1" id="headlessui-menu-items-117" role="menu">
                                <div class="px-4 py-3">
                                    <p class="text-xs leading-5">Signed in as</p>
                                    <p class="text-xs font-medium leading-5 text-gray-900 truncate">${sessionScope.USER.email}</p>
                                </div>
                                <div class="py-1 px-4 hover:bg-slate-100">
                                    <a href="personalprofile.jsp"
                                       class="text-gray-700 flex items-center w-full px-4 py-2 text-sm leading-5 text-left"
                                       role="menuitem">
                                        <svg xmlns="http://www.w3.org/2000/svg" class="w-4 h-4 mr-3"
                                             viewBox="0 0 1000 1000">
                                            <path fill="currentColor"
                                                  d="M500,10C229.4,10,10,229.4,10,500c0,270.6,219.4,490,490,490c270.6,0,490-219.4,490-490C990,229.4,770.6,10,500,10z M500,156.5c89.5,0,162.1,72.6,162.1,162.1c0,89.5-72.6,162.1-162.1,162.1c-89.5,0-162.1-72.6-162.1-162.1C337.9,229.1,410.5,156.5,500,156.5z M499.9,861.9c-89.3,0-171.1-32.5-234.2-86.3c-15.4-13.1-24.2-32.3-24.2-52.5c0-90.8,73.5-163.4,164.3-163.4h188.6c90.8,0,164,72.6,164,163.4c0,20.2-8.8,39.4-24.2,52.5C671,829.3,589.2,861.9,499.9,861.9z"/>
                                        </svg>
                                        Profile
                                    </a></div>
                                <div class="py-1 px-4 hover:bg-slate-100">
                                    <a href="userManagement.jsp"
                                       class="text-gray-700 flex items-center w-full px-4 py-2 text-sm leading-5 text-left"
                                       role="menuitem">
                                        <svg class="w-4 h-4 mr-3" xmlns="http://www.w3.org/2000/svg" id="Layer_1"
                                             data-name="Layer 1" viewBox="0 0 24 24">
                                            <path fill="currentColor"
                                                  d="M19,12h5v7c0,2.757-2.243,5-5,5H5c-2.757,0-5-2.243-5-5v-7H5v1c0,.552,.447,1,1,1s1-.448,1-1v-1h10v1c0,.552,.447,1,1,1s1-.448,1-1v-1Zm5-3v1h-5v-1c0-.552-.447-1-1-1s-1,.448-1,1v1H7v-1c0-.552-.447-1-1-1s-1,.448-1,1v1H0v-1c0-2.757,2.243-5,5-5h1.101C6.566,1.721,8.586,0,11,0h2c2.414,0,4.434,1.721,4.899,4h1.101c2.757,0,5,2.243,5,5ZM8.184,4h7.631c-.414-1.161-1.514-2-2.816-2h-2c-1.302,0-2.402,.839-2.816,2Z"/>
                                        </svg>
                                        Manage
                                    </a></div>
                                <div class="py-1 px-4 hover:bg-slate-100">
                                    <a href="/Logout"
                                       class="text-gray-700 flex items-center w-full px-4 py-2 text-sm leading-5 text-left"
                                       role="menuitem">
                                        <svg class="w-4 h-4 mr-3" xmlns="http://www.w3.org/2000/svg" id="Layer_1"
                                             data-name="Layer 1" viewBox="0 0 24 24">
                                            <path fill="currentColor"
                                                  d="M11.5,16A1.5,1.5,0,0,0,10,17.5v.8A2.7,2.7,0,0,1,7.3,21H5.7A2.7,2.7,0,0,1,3,18.3V5.7A2.7,2.7,0,0,1,5.7,3H7.3A2.7,2.7,0,0,1,10,5.7v.8a1.5,1.5,0,0,0,3,0V5.7A5.706,5.706,0,0,0,7.3,0H5.7A5.706,5.706,0,0,0,0,5.7V18.3A5.706,5.706,0,0,0,5.7,24H7.3A5.706,5.706,0,0,0,13,18.3v-.8A1.5,1.5,0,0,0,11.5,16Z"/>
                                            <path d="M22.561,9.525,17.975,4.939a1.5,1.5,0,0,0-2.121,2.122l3.411,3.411L7,10.5a1.5,1.5,0,0,0,0,3H7l12.318-.028-3.467,3.467a1.5,1.5,0,0,0,2.121,2.122l4.586-4.586A3.505,3.505,0,0,0,22.561,9.525Z"/>
                                        </svg>
                                        Sign out
                                    </a></div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<style>
    .dropdown:focus-within .dropdown-menu {
        opacity: 1;
        transform: translate(0) scale(1);
        visibility: visible;
    }
</style>