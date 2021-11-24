<%-- 
    Document   : mostrarDeptos
    Created on : 04-nov-2021, 17:33:56
    Author     : DAW-A
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Departamentos</title>
    </head>
    <body>
        <h1>Mostrar Departamentos</h1>

        <!-- recogemos el listado de departamentos hay que hacer casting explicito como arrayList -->
        <%
            ArrayList<Departamento> listaDeptos = (ArrayList<Departamento>) request.getAttribute("laListaDeptos");

            //recorremos el Array
            for(Departamento d: listaDeptos){
                %>
                <table>
                    <tr>
                        <th><%= d.getNumD() %></th>
                        <th><%= d.getNombre() %></th>
                        <th><%= d.getLocalidad() %></th>  
                    </tr>
                </table>
                
                <%
            }
        %>
    <button type="submit" onclick="location.href = 'index.html'" class="bot2 boton">Volver</button>
    </body>
</html>
