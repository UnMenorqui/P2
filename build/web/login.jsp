<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="post">
            <div>
                <label for="name"> Name: </label>
                <input type="text" name="name" required/>                
            </div>
            
            <div>
                <label for="password"> Password </label>
                <input type="password" name="password" required/>
            </div>
            
            <div>
                <input type="submit" value="Submit">
            </div>
                
        </form>
    </body>
</html>
