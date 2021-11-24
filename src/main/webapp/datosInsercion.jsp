<%-- 
    Document   : datosInsercion
    Created on : 09-nov-2021, 18:17:08
    Author     : DAW-A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="datosInsercion" action="ServletControlador?accion=guardarDep" method="POST">
            <label> Numero Depto: </label>
            <input type="number" name="depto" value="" size="4" /><br>
            <label> Nombre: </label>
            <input type="text" name="nombre" value="" size="4" /><br>
            <label> Localidad: </label>
            <input type="text" name="localidad" value="" size="40" /><br>
            <input type="submit" value="enviar" name="insertar" />
            <button type="submit" onclick="location.href = 'index.html'" class="bot2 boton">Volver</button>
        </form>
        
    </body>
</html>
