<%@ page import="com.mahdi.service.model.BookEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: mahdi
  Date: 04/08/2018
  Time: 09:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% BookEntity[] students = (BookEntity[]) request.getAttribute("books");

    for(BookEntity student : students)
    {
        out.print("Id: " + student.getId());
        out.print("<br/>");
        out.print("Name: " + student.getName());
        out.print("<br/>");
        out.print("Age: " + student.getIsbn());

        out.print("<br/>");
        out.print("<br/>");
    }

%>
</body>
</html>
