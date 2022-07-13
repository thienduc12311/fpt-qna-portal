<%@ page import="swp391.fptqna.dto.ReportedAnswerDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="swp391.fptqna.dto.FlagTypeDTO" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/6/2022
  Time: 8:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reported Answer Management</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-full w-full m-0 text-gray-700 bg-gray-50">
<jsp:include page="../header.jsp"></jsp:include>
<div class="fixed h-screen">
    <jsp:include page="managementSidebar.jsp"></jsp:include>
</div>
<!-- container  -->
<div class=" ml-64 my-10 px-8 py-8">

    <!-- search bar  -->
    <div class="flex space-x-6">
        <div>
            <div class="text-2xl font-semibold">Reported answers</div>
        </div>
    </div>

    <!-- list wrap  -->
    <div class="bg-white rounded-md px-10 py-2 shadow-md mt-6">
        <table class="min-w-full text-sm">
            <thead>
            <tr>
                <th class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold ">
                    ID
                </th>
                <th class="px-5 py-3 border-b-2 w-96 border-gray-200 text-left font-semibold">
                    Description
                </th>
                <th class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    Reported by
                </th>
                <th
                        class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    Report date
                </th>
                <th
                        class="px-5 py-3 border-b-2 border-gray-200 text-center font-semibold">
                    Report type
                </th>
            </tr>
            </thead>
            <tbody>

            <%
                try {
                    ArrayList<ReportedAnswerDTO> list = (ArrayList<ReportedAnswerDTO>) request.getAttribute("listReportedAnswer");
                    HashMap<Integer, FlagTypeDTO> listFlagType = (HashMap<Integer, FlagTypeDTO>) request.getAttribute("listFlagType");
                    for (ReportedAnswerDTO reportedAnswer : list) {
                        String url = "/MainController?action=ViewReportedAnswer&reportedAnswerId="+reportedAnswer.getId();
            %>
            <tr onclick="window.location='<%=url%>';" class="cursor-pointer">
                <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                    <p class="text-gray-900 whitespace-no-wrap">
                        <%=reportedAnswer.getId()%>
                    </p>
                </td>
                <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-left">
                    <p class="text-gray-900 whitespace-no-wrap font-semibold">
                        <%= (70 > reportedAnswer.getDescription().length()) ? reportedAnswer.getDescription() : reportedAnswer.getDescription().substring(0,70) + "..."%>
                    </p>
                </td>
                <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                    <p class="text-gray-900 whitespace-no-wrap">
                        <%=reportedAnswer.getOwnerUserId()%>
                    </p>
                </td>
                <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                    <p class="text-gray-900 whitespace-no-wrap">
                        <%=reportedAnswer.getCreationDate()%>
                    </p>
                </td>
                <td class="px-5 py-2.5 border-b border-gray-200 bg-white text-sm text-center">
                    <p class="text-gray-900 whitespace-no-wrap">
                        <%=listFlagType.get((int) reportedAnswer.getFlagTypeId()).getName()%>
                    </p>
                </td>
            </tr>
            <!-- end record  -->
            <%
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            %>
            </tbody>
        </table>

        <!-- pagination  -->
        <%
            int currentPage = Integer.parseInt(request.getParameter("page"));
            int numberOfPage = Integer.parseInt(request.getAttribute("numberOfPage").toString());
            int nextPage = currentPage + 1;
            int previousPage = currentPage - 1 ;
            if (previousPage < 1) previousPage = 1;
            if (nextPage > numberOfPage) nextPage = numberOfPage;
        %>

        <div class="pagination p-3 inline-flex space-x-3 sm:ml-20 ml-12">
            <a href="MainController?action=ReportedAnswer&page=<%=previousPage%>" class="relative px-2 py-2 rounded border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span class="sr-only">Previous</span>
                <svg class="h-4 w-4 text-purple-600 " xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                    <path fill-rule="evenodd" d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z" clip-rule="evenodd" />
                </svg>
            </a>
            <a href="#" class="relative px-2 py-2 rounded border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span class="h-4 w-4 flex justify-center text-purple-600 text-xs"><%=currentPage%>/<%=numberOfPage%></span>
            </a>
            <a href="MainController?action=ReportedAnswer&page=<%=nextPage%>" class="relative px-2 py-2 rounded border border-purple-600 text-sm font-medium text-gray-500 hover:bg-gray-50">
                <span class="sr-only">Next</span>
                <svg class="h-4 w-4 text-purple-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                    <path fill-rule="evenodd" d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z" clip-rule="evenodd" />
                </svg>
            </a>
        </div>


    </div>
</div>
</body>

</html>