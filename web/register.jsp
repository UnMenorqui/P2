<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" media="screen" href="register.css">
    </head>
    <body>
        <form action="register" method="post">
            <div class="container">
                <label for="name"> Username </label>
                <input type="text" name="name" required/>                

                <label for="password"> Password: </label>
                <input type="password" name="password" required/>

                <label for="password"> Repeat Password: </label>
                <input type="password" name="password1" required/>
 
           
                <div class="clearfix">
                   <button type="submit" class="signupbtn">Sign Up</button> 
                </div>
            </div>    
        </form>
    </body>
</html>
