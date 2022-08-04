<%@ page import="java.util.ArrayList" %>
<%@ page import="swp391.fptqna.dto.QuestionDTO" %><%--
  Created by IntelliJ IDEA.
  User: tnahuy
  Date: 6/19/2022
  Time: 2:49 PM
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
        <th>Posted by</th>
        <th>Posted date</th>
    </tr>

    <%
        ArrayList<QuestionDTO> list = (ArrayList<QuestionDTO>) request.getAttribute("listPendingQuestion");
        for (QuestionDTO question : list) {
    %>
    <tr>
        <a href="#">
            <td><%=question.getId()%>
            </td>
            <td><%=(100 > question.getTitle().length()) ? question.getTitle() : question.getTitle().substring(100) + "..."%>
            </td>
        </a>
        <td><a href="#"><%=question.getOwnerUserId()%>
        </a></td>
        <td><%=question.getCreationDate()%>
        </td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>