<%@page contentType="text/html" pageEncoding="UTF-8"%>         
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <%
        HttpSession sesion = request.getSession(false);
        String error = (String)sesion.getAttribute("error");
        if (error.equals("1")) {%>
            <h1>The user does not exist</h1>
            <a href="index.jsp"> Index </a>
        <%}
        else if (error.equals("2")) {%>
            <h1>The user already exists</h1>
            <a href="index.jsp"> Index </a>
        <%}
        else if (error.equals("3")) {%>
            <h1>The two passwords are not the same</h1>
            <a href="index.jsp"> Index </a>
        <%}
        else if (error.equals("4")) {%>
            <h1>There is no flight with these characteristics;</h1>
            <a href="menu.jsp"> Menu </a>
        <%}
        else if (error.equals("5")) {%>
            <h1>A flight with this number already exists</h1>
            <a href="menu.jsp"> Menu </a>
        <%}%>
    </body>
</html>
