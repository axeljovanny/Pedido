<%-- 
    Document   : pedido
    Created on : 23/09/2016, 10:44:09 AM
    Author     : ashle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
    </head>
    <body>
        <form action="PedidoController" method="post">
            <fieldset>
                <legend>Formulario de registro de pedido</legend>
                
                <div>
                <label for="idPedido">Id Pedido</label>
                <input type="text" name="idPedido"
                       value="${pedido.idPedido}"
                       readonly="readonly" 
                       placeholder="Id de pedido"/>
                </div>
                
                <div>
                <label for="fecha">Fecha:</label>
                <input type="text" name="fecha"
                       value="${pedido.fecha}"
                       placeholder="Fecha del pedido"/>
                </div>
                 
                <div>
                <label for="cliente">Cliente:</label>
                <input type="text" name="cliente"
                       value="${pedido.cliente}"
                       placeholder="Cliente del pedido"/>
                </div>
                
                <div>
                <label for="observacion">Observacion:</label>
                <input type="text" name="observacion"
                       value="${pedido.observacion}"
                       placeholder="Observacion"/>
                </div>
                       
                
                
                 <div>
                     <input type="submit" 
                       value="Guardar" />
                </div>
            </fieldset>
            
        </form>
    </body>
</html>

