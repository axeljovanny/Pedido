<%-- 
    Document   : lista_pedidos
    Created on : 23/09/2016, 10:49:28 AM
    Author     : ashle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Pedidos</title>
    </head>
    <body>
        <table>
            <thead>  
            <tr>
                <th>Id de Pedido</th>
                <th>Fecha</th>
                <th>Cliente</th>
                <th>Observacion</th>
               
            </tr>
            </thead>
            <tbody>
                <c:forEach var="pedido" 
                           items="${pedidos}">
                    <tr>
                        <td>${pedido.idPedido}</td>
                        <td>${pedido.fecha}</td>
                        <td>${pedido.cliente}</td>
                        <td>${pedido.observacion}</td>
                   
                        <td><a href="PedidoController?action=cambiar&idPedido=${pedido.idPedido}">Cambiar</a></td>
                        <td><a href="PedidoController?action=borrar&idPedido=${pedido.idPedido}">Borrar</a></td>
                     </tr>  
                </c:forEach> 
            </tbody>
        </table>
        <p>
            <a href="PedidoController?action=agregar">
                Agregar pedido
            </a>
        </p>
    </body>
</html>

