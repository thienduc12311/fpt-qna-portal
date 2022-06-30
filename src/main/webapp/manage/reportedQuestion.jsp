<%@ page import="java.util.ArrayList" %>
<%@ page import="swp391.fptqna.dto.ReportedQuestionDTO" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: tnahuy
  Date: 6/19/2022
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Page</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Reported by</th>
        <th>Reported date</th>
        <th>Reported type</th>
    </tr>

    <%
        try {
            ArrayList<ReportedQuestionDTO> list = (ArrayList<ReportedQuestionDTO>) request.getAttribute("listReportedQuestion");
            HashMap<Integer, ReportedQuestionDTO> listFlagType = (HashMap<Integer, ReportedQuestionDTO>) request.getAttribute("listFlagType");
            for (ReportedQuestionDTO reportedQuestion : list) {
    %>
    <tr>
        <a href="#">
            <td><%=reportedQuestion.getId()%>
            </td>
            <td><%= (100 > reportedQuestion.getDescription().length()) ? reportedQuestion.getDescription() : reportedQuestion.getDescription().substring(100) + "..."%>
            </td>
        </a>
        <td><a href="#"><%=reportedQuestion.getOwnerUserId()%>
        </a></td>
        <td><%=reportedQuestion.getCreationDate()%>
        </td>
        <td><%=listFlagType.get(reportedQuestion.getFlagTypeId())%>
        </td>
    </tr>
    <%
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

</table>
</body>
</html>
