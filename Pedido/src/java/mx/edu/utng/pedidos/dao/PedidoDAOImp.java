/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.pedidos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.pedidos.model.Pedido;
import mx.edu.utng.pedidos.util.UtilDB;

/**
 *
 * @author tacho
 */
public class PedidoDAOImp implements PedidoDAO{

    private Connection connection;
    
    public PedidoDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarPedido(Pedido pedido) {
        try {
          String query = "INSERT INTO pedidos (fecha, cliente, "
                  + " observacion) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, pedido.getFecha());
            ps.setString(2, pedido.getCliente());
            ps.setString(3, pedido.getObservacion());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarPedido(int idPedido) {
        try {
             String query = "DELETE FROM pedidos WHERE id_pedido = ?";
             PreparedStatement ps = connection.prepareCall(query);
             ps.setInt(1, idPedido);
             ps.executeUpdate();
             ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarPedido(Pedido pedido) {
    try {
          String query = "UPDATE pedidos SET fecha = ?, "
                  + " cliente= ?, observacion=? WHERE "
                  + " id_pedido = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, pedido.getFecha());
            ps.setString(2, pedido.getCliente());
            ps.setString(3, pedido.getObservacion());
            ps.setInt(4, pedido.getIdPedido());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pedido> desplegarPedidos() {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM pedidos");
            while (resultSet.next()) {
              Pedido pedido = new Pedido(
              resultSet.getInt("id_pedido"),
              resultSet.getString("fecha"),
              resultSet.getString("cliente"),
              resultSet.getString("observacion"));
              pedidos.add(pedido);
            } 
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public Pedido elegirPedido(int idPedido) {
       Pedido pedido = new Pedido();
        try{
        PreparedStatement statement = 
                connection.prepareStatement(
                        "SELECT * FROM pedidos WHERE "
                                + " id_pedido = ?");
        statement.setInt(1, idPedido);
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
              pedido.setIdPedido(
                      resultSet.getInt("id_pedido"));
              pedido.setFecha(
                      resultSet.getString("fecha"));
              pedido.setCliente(
                      resultSet.getString("cliente"));
              pedido.setObservacion(
                      resultSet.getString("observacion"));
              
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pedido;
    }
    
    
}
