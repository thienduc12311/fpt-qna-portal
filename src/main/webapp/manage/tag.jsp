<%@ page import="swp391.fptqna.dto.TagDTO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: tnahuy
  Date: 6/26/2022
  Time: 5:18 PM
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
        <th>Name</th>
        <th>Description</th>
        <th>Created date</th>
        <th>No.of questions</th>
        <th>State</th>
        <th> </th>
    </tr>

    <%
        try {
            ArrayList<TagDTO> list = (ArrayList<TagDTO>) request.getAttribute("listTag");
            for (TagDTO tag : list) {
    %>
    <tr>
        <a href="#">
            <td><%=tag.getId()%>
            </td>
            <td><%=tag.getTagName()%>
            </td>
            <td><%=(100 > tag.getDescription().length()) ? tag.getDescription() : tag.getDescription().substring(100) + "..."%>
            </td>
            <td><%=tag.getCreationDate()%>
            </td>
            <td><%=tag.getQuestionCount()%>
            </td>
            <td><%=tag.getState() == 1 ? "Available" : "Unavailable"%></td>
        </a>
        <td>
            <button>Edit</button>
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
