<%@ page language="java" %>
<html>
<head><title>User Input</title></head>
<body>
    <form action="user" method="post">
        Username: <input type="text" name="username"><br>
        Action: <input type="text" name="action"><br>
        File to read: <input type="text" name="file"><br>
        Count: <input type="text" name="count" value="5"><br>
        <input type="submit" value="Submit">
    </form>

    <%
         
        if (request.getParameter("msg") != null) {
            out.println("<div>Message: " + request.getParameter("msg") + "</div>");
        }
    %>
</body>
</html>