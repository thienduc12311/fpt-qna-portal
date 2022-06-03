<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <div class="bg-gray-50 grid place-items-center h-screen ">
        <div class="bg-white rounded-xl shadow-lg p-9 h-98 w-10/12 sm:w-6/12">
            <div class="p-0.5 h-full">
                <div class="h-full w-full lg:grid lg:grid-cols-2 lg:divide-x">
                    <div class="grid place-items-center lg:pr-6">
                        <img src="https://cutewallpaper.org/23/minimalist-landscape-wallpaper/1099126829.jpg"
                             alt="A cartoon pic" class="object-cover overflow-hidden h-full">
                    </div>
                    <div class="grid lg:pl-10 lg:pr-2 py-3 font-semibold text-sm text-gray-700 gap-y-2">
                        <p class=" text-2xl">Welcome to <span class="text-purple-600">FPT<span
                                class="font-normal">QnA</span></span></p>
                        <form action="" method="post" class="grid gap-y-4">
                            <div>
                                <p class="pb-1">Email</p>
                                <p><input type="text" value="" class="w-full border border-gray-300 h-8 rounded"
                                          placeholder="   Username"></p>
                            </div>
                            <div>
                                <p class="pb-1">Password</p>
                                <p><input type="password" value="" class="w-full border border-gray-300 h-8 rounded"
                                          placeholder="   **************"></p>
                            </div>
                            <p>
                                <button type="submit" name="action" value="Log in"
                                        class="bg-purple-600 hover:bg-purple-800 text-white font-bold rounded w-full h-8">
                                    Submit
                                </button>
                            </p>
                            <!-- submit? -->
                        </form>
                        <p class="text-purple-600"><a href="#">Forgot password?</a> <span class="font-normal">or</span> <a
                                href="#">Register</a></p>
                        <hr/>
                        <button class="border rounded border-gray-300 w-full h-8 flex justify-center content-center pt-1 mt-1">
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                                 class="h-9 w-9" viewBox="0 0 80 80">
                                <defs>
                                    <path id="a"
                                          d="M44.5 20H24v8.5h11.8C34.7 33.9 30.1 37 24 37c-7.2 0-13-5.8-13-13s5.8-13 13-13c3.1 0 5.9 1.1 8.1 2.9l6.4-6.4C34.6 4.1 29.6 2 24 2 11.8 2 2 11.8 2 24s9.8 22 22 22c11 0 21-8 21-22 0-1.3-.2-2.7-.5-4z"/>
                                </defs>
                                <clipPath id="b">
                                    <use xlink:href="#a" overflow="visible"/>
                                </clipPath>
                                <path clip-path="url(#b)" fill="#FBBC05" d="M0 37V11l17 13z"/>
                                <path clip-path="url(#b)" fill="#EA4335" d="M0 11l17 13 7-6.1L48 14V0H0z"/>
                                <path clip-path="url(#b)" fill="#34A853" d="M0 37l30-23 7.9 1L48 0v48H0z"/>
                                <path clip-path="url(#b)" fill="#4285F4" d="M48 48L17 24l-4-3 35-10z"/>
                            </svg>
                            <a href="https://accounts.google.com/o/oauth2/auth?scope=email https://www.googleapis.com/auth/userinfo.profile&redirect_uri=http://localhost:8080/login-google&response_type=code
                                &client_id=439318717683-v1og8jquc6kn82nua7sun6cbvkt2oprb.apps.googleusercontent.com&approval_prompt=force"
                               class="font-semibold">
                                Sign in with FPT account</a>

                        </button>


                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<%--<!-- Include stylesheet -->--%>
<%--<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">--%>

<%--<!-- Create the editor container -->--%>
<%--<div id="editor">--%>
<%--    <p>Hello World!</p>--%>
<%--    <p>Some initial <strong>bold</strong> text</p>--%>
<%--    <p><br></p>--%>
<%--</div>--%>

<%--<!-- Include the Quill library -->--%>
<%--<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>--%>

<%--<!-- Initialize Quill editor -->--%>
<%--<script>--%>
<%--    var quill = new Quill('#editor', {--%>
<%--        theme: 'snow'--%>
<%--    });--%>
<%--</script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>--%>
</html>
r