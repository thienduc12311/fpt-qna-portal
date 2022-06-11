<%@ page import="swp391.fptqna.utils.GoogleClient" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <% GoogleClient client = new GoogleClient(); %>
    <% String googleLoginLink = "https://accounts.google.com/o/oauth2/auth?scope=email https://www.googleapis.com/auth/userinfo.profile&redirect_uri="+client.getGoogleRedirectUri()+"&response_type=code &client_id="+client.getGoogleClientId()+"&approval_prompt=force";
    %>
    <title> Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
                            <p>
                                <input type="submit" name="action" value="Login" class="bg-purple-600 hover:bg-purple-800 text-white font-bold rounded w-full h-8">
                            </p>
                            <!-- submit? -->
                        </form>
                        <p class="text-purple-600 border-b border-gray-300 pb-3"><a href="#">Forgot password?</a> <span class="font-normal">or</span> <a
                                href="redirectregister.jsp">Register</a></p>
                        <button class="border rounded border-gray-300 w-full h-8 flex justify-center content-center pt-1.5 mt-3">
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
                            <a href="<%=googleLoginLink%>"
                               class="font-semibold">
                                Login with Google</a>
                        </button>
</body>
</html>