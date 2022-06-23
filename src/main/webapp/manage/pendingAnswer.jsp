<%@ page import="swp391.fptqna.dto.AnswerDTO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: tnahuy
  Date: 6/19/2022
  Time: 4:34 PM
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
        <th>Content</th>
        <th>Posted by</th>
        <th>Posted date</th>
    </tr>

    <%
        ArrayList<AnswerDTO> list = (ArrayList<AnswerDTO>) request.getAttribute("listPendingAnswer");
        for (AnswerDTO answer : list) {
    %>
    <tr>
        <a href="#">
            <td><%=answer.getId()%></td>
            <td><%=(100 > answer.getBody().length()) ? answer.getBody() : answer.getBody().substring(100) + "..."%></td>
        </a>
        <td><a href="#"><%=answer.getOwnerUserId()%></a></td>
        <td><%=answer.getCreationDate()%></td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
