<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/6/2022
  Time: 7:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register account</title>
    <script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
    <div class="bg-gray-50 grid place-items-center h-screen">
        <div class="bg-white rounded-xl shadow-lg p-9 h-96 w-10/12 sm:w-8/12 md:w-6/12">
            <div class="h-full">
                <div class="h-full w-full lg:grid lg:grid-cols-2 lg:divide-x">
                    <div class="grid place-items-center lg:pr-6">
                        <img src="https://cutewallpaper.org/23/minimalist-landscape-wallpaper/1099126829.jpg"
                             alt="A cartoon pic" class="object-cover overflow-hidden h-full">
                    </div>
                    <div class="grid lg:pl-10 lg:pr-2 font-semibold text-sm text-gray-700 space-y-3">
                        <p class=" text-2xl">Create Account</p>
                        <form action="Register" method="POST" class="grid space-y-2.5">
<%--                            note: action should be MainController if MVC2 is used. this is MVC1. - Ngan Ha--%>
                            <div>
                                <p>Display name</p>
                                <p><input type="text" name="txtdisplayname" value="" class="w-full border border-gray-300 h-8 rounded px-3"></p>
                            </div>
                            <div>
                                <p>Password</p>
                                <p><input type="password" name="txtpassword" value="" class="w-full border border-gray-300 h-8 rounded px-3"></p>
                            </div>
                            <div>
                                <p>Confirm password</p>
                                <p><input type="password" name="txtpasswordconfirm" value="" class="w-full border border-gray-300 h-8 rounded px-3"></p>

                            </div>
                            <div class="text-red-500 text-sm">
                                <%
                                    String error = (String)request.getAttribute("ERROR");
                                    if (error != null && error.equals("Password do not match.")){
                                %>
                                    <p>Password do not match.</p>
                                <%
                                    } else if (error != null && error.equals("Do not leave form empty.")){
                                %>
                                    <p>Do not leave form empty.</p>
                                <%
                                    }
                                %>
                            </div>
                            <p><input type="submit" name="action" value="Register" class="bg-purple-600 hover:bg-purple-800 text-white font-bold rounded w-full h-8"> </p>

                        </form>


                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
