/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.pedidos.dao;

import java.util.List;
import mx.edu.utng.pedidos.model.Pedido;

/**
 *
 * @author axel
 */
public interface PedidoDAO {
    void agregarPedido(Pedido pedido);
    void borrarPedido(int idPedido);
    void cambiarPedido(Pedido pedido);
    List<Pedido> desplegarPedidos();
    Pedido elegirPedido(int idPedido);

}
