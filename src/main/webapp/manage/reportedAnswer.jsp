<%@ page import="swp391.fptqna.dto.ReportedAnswerDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: tnahuy
  Date: 6/19/2022
  Time: 5:26 PM
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
            ArrayList<ReportedAnswerDTO> list = (ArrayList<ReportedAnswerDTO>) request.getAttribute("listReportedAnswer");
            HashMap<Integer, ReportedAnswerDTO> listFlagType = (HashMap<Integer, ReportedAnswerDTO>) request.getAttribute("listFlagType");
            for (ReportedAnswerDTO reportedAnswer : list) {
    %>
    <tr>
        <a href="#">
            <td><%=reportedAnswer.getId()%></td>
            <td><%= (100 > reportedAnswer.getDescription().length()) ? reportedAnswer.getDescription() : reportedAnswer.getDescription().substring(100) + "..."%></td>
        </a>
        <td><a href="#"><%=reportedAnswer.getOwnerUserId()%></a></td>
        <td><%=reportedAnswer.getCreationDate()%></td>
        <td><%=listFlagType.get(reportedAnswer.getFlagTypeId())%></td>
    </tr>
    <%
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    %>

</table>
</body>
</html>
