
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        
<%String error = request.getParameter("error");%>
            
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1><%=error%></h1>
        <a href="login.jsp"> Log In </a>
    </body>
</html>
