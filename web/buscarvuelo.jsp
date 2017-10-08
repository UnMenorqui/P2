<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="buscarvuelo" method="post">
            <div>
                <label for="numerovuelo"> Numero de vuelo: </label>
                <input type="text" name="numero"/>                
            </div>
            
            <div>
                <label for="compañia"> Compañia: </label>
                <input type="text" name="compañia"/>
            </div>
            
            <div>
                <label for="origen"> Origen: </label>
                <input type="text" name="origen"/>
            </div>
            
            <div>
                <label for="password"> Destino: </label>
                <input type="text" name="destino"/>
            </div>
            
            <div>
                <input type="submit" value="Search">
            </div>
                
        </form>
    </body>
</html>
