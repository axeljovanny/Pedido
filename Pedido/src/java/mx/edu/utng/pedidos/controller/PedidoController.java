package mx.edu.utng.pedidos.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.pedidos.dao.PedidoDAOImp;
import mx.edu.utng.pedidos.model.Pedido;
import mx.edu.utng.pedidos.dao.PedidoDAO;
public class PedidoController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
   private static final String
           LISTA_PEDIDOS = "/lista_pedidos.jsp";
   private static final String 
           AGREGAR_O_CAMBIAR = "pedido.jsp";
   private PedidoDAO dao;
   
   public PedidoController(){
       dao = new PedidoDAOImp();
   }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_PEDIDOS;
            int idPedido = Integer.parseInt(
                request.getParameter("idPedido"));
            dao.borrarPedido(idPedido);
            request.setAttribute("pedidos",
                    dao.desplegarPedidos());
         }else if(action.equalsIgnoreCase("cambiar")){
             forward = AGREGAR_O_CAMBIAR;
             int idPedido = Integer.parseInt(
                request.getParameter("idPedido"));
             Pedido pedido = 
                     dao.elegirPedido(idPedido);
             request.setAttribute("pedido", pedido);
         } else if(action.equalsIgnoreCase("agregar")){
             forward = AGREGAR_O_CAMBIAR;
         } else{
             forward = LISTA_PEDIDOS;
             request.setAttribute("pedidos", 
                     dao.desplegarPedidos());
         }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pedido pedido = new Pedido();
        pedido.setFecha(request.getParameter("fecha"));
        pedido.setCliente(request.getParameter("cliente"));
        pedido.setObservacion(request.getParameter("observacion"));
        
        String idPedido = request.getParameter("idPedido");
        
        if(idPedido==null|| idPedido.isEmpty()||idPedido.trim().equals("")){
            dao.agregarPedido(pedido);
        }else{
            pedido.setIdPedido(
                    Integer.parseInt(idPedido));
            dao.cambiarPedido(pedido);
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_PEDIDOS);
        request.setAttribute("pedidos", 
                dao.desplegarPedidos());
        view.forward(request, response);
    }
}
