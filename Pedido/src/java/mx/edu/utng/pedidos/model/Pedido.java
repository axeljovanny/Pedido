/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.pedidos.model;

/**
 *
 * @author tacho
 */
public class Pedido {
   private int idPedido;
   private String fecha;
   private String cliente;
   private String observacion;


   public Pedido() {
        this(0,"","","");
    }

    public Pedido(int idPedido, String fecha, String cliente, String observacion) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.cliente = cliente;
        this.observacion = observacion;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", fecha=" + fecha + ", cliente=" + cliente + ", observacion=" + observacion + '}';
    }
    
   

  
}
