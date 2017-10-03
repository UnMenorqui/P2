
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="altavuelo" method="post">
            <div>
                <label for="numerovuelo"> Numero de vuelo: </label>
                <input type="text" name="numero" required/>                
            </div>
            
            <div>
                <label for="compañia"> Compañia: </label>
                <input type="text" name="compañia" required/>
            </div>
            
            <div>
                <label for="origen"> Origen: </label>
                <input type="text" name="origen" required/>
            </div>
            
            <div>
                <label for="password"> Hora de Salida: </label>
                <input type="time" name="horasalida" required/>
            </div>
            
            <div>
                <label for="password"> Destino: </label>
                <input type="text" name="destino" required/>
            </div>
            
            <div>
                <label for="horallegada"> Hora de llegada: </label>
                <input type="time" name="horallegada" required/>
            </div>
            
            <div>
                <input type="submit" value="Submit">
            </div>
                
        </form>
    </body>
</html>
