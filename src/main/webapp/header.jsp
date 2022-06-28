<div class="shadow">
    <div class="pt-3 px-10">
        <div class="flex justify-between">
            <!-- left side -->
            <div class="flex space-x-6">
                <div class="bg-purple-600 text-white font-semibold rounded-md h-8 flex items-center px-4 text-lg"><span class="font-bold">FPT</span>QnA Portal</div>
                <div class="flex">
                    <form action="Search" method="post">
                        <div class="relative">
                            <input type="text" name="txtdisplayname" value="" class="text-sm h-8 w-60 rounded px-3 shadow" placeholder="Search...">
                            <span class="absolute inset-y-0 right-0 flex items-center pr-2">
                                <button type="submit" class="p-1  bg-gray-200 rounded">
                                  <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" class="w-3.5 h-3.5"><path d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>
                                </button>
                            </span>
                        </div>
                    </form>
                </div>
            </div>
            <!-- right-side  -->
            <div class="flex space-x-6 ">
                <div>
                    <button class="text-sm bg-purple-600 text-white font-semibold rounded-md h-8 flex items-center px-4 pb-0.5 space-x-2">
                        <div>
                            <svg class="w-4 h-4 fill-white" id="Layer_1"  viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" data-name="Layer 1"><path d="m12 0a12 12 0 1 0 12 12 12.013 12.013 0 0 0 -12-12zm4 13h-3v3a1 1 0 0 1 -2 0v-3h-3a1 1 0 0 1 0-2h3v-3a1 1 0 0 1 2 0v3h3a1 1 0 0 1 0 2z"/></svg>
                        </div>
                        <div>Ask Question</div>
                    </button>
                </div>
                <div>
                    <div class="relative flex items-center shadow px-2 rounded w-8 h-8">
                        <svg class="w-4 h-4 text-gray-700 fill-gray-700" xmlns="http://www.w3.org/2000/svg" id="Layer_1" data-name="Layer 1" viewBox="0 0 24 24" ><path d="M4.068,18H19.724a3,3,0,0,0,2.821-4.021L19.693,6.094A8.323,8.323,0,0,0,11.675,0h0A8.321,8.321,0,0,0,3.552,6.516l-2.35,7.6A3,3,0,0,0,4.068,18Z"/><path d="M7.1,20a5,5,0,0,0,9.8,0Z"/></svg>
                        <span class="absolute top-2 right-2.5 inline-block w-1.5 h-1.5 transform translate-x-1/2 -translate-y-1/2 bg-red-600 rounded-full"></span>
                    </div>
                </div>

                <div>
                    <a href="#">
                        <label class="flex space-x-2 cursor-pointer">
                            <img class="rounded-full h-9 w-9" src="https://inkythuatso.com/uploads/thumbnails/800/2022/03/avatar-mac-dinh-nu-co-mau-30-10-31-43.jpg">
                            <div class="flex flex-col">
                                <div class="text-sm font-semibold">${sessionScope.USER.name}</div>
                                <div class="text-xs font-semibold text-gray-600"> ${sessionScope.USER.email}</div>
                            </div>
                        </label>
                    </a>
                </div>
                <div>
                    <!-- Dropdown toggle button -->
                    <div class=" relative inline-block text-left dropdown">
                        <button class="py-2" type="button" aria-haspopup="true" aria-expanded="true" aria-controls="headlessui-menu-items-117">
                            <svg class="w-5 h-5 ml-2 -mr-1" viewBox="0 0 20 20" fill="currentColor"><path fill-rule="evenodd" d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                        </button>
                        <div class="opacity-0 invisible dropdown-menu transition-all duration-300 transform origin-top-right -translate-y-2 scale-95">
                            <div class="absolute right-0 w-56 mt-2 origin-top-right bg-white border border-gray-200 divide-y divide-gray-100 rounded-md shadow-lg outline-none" aria-labelledby="headlessui-menu-button-1" id="headlessui-menu-items-117" role="menu">
                                <div class="px-4 py-3">
                                    <p class="text-sm leading-5">Signed in as</p>
                                    <p class="text-sm font-medium leading-5 text-gray-900 truncate">${sessionScope.USER.email}</p>
                                </div>
                                <div class="py-1">
<%--                                    <a href="" class="text-gray-700 flex justify-between w-full px-4 py-2 text-sm leading-5 text-left"  role="menuitem" >Profile</a>--%>
                                    <a href="" class="text-gray-700 flex justify-between w-full px-4 py-2 text-sm leading-5 text-left" role="menuitem" >Profile</a></div>
                                <div class="py-1">
                                    <a href="/Logout" class="text-gray-700 flex justify-between w-full px-4 py-2 text-sm leading-5 text-left"  role="menuitem" >Sign out</a></div>
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
        opacity:1;
        transform: translate(0) scale(1);
        visibility: visible;
    }
</style>