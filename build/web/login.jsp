<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" media="screen" href="login.css">
    </head>
    <body>
        <form action="login" method="post">
            
            <div class="imgcontainer">
                <img src="student_login.png" alt="Avatar" class="avatar">
            </div>
            
            <div class="container">
                    <label><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="name" required>

                    <label><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="password" required>

                    <button type="submit">Login</button>
            </div>           
        </form>
    </body>
</html>
