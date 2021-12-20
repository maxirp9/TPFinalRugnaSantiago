/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Empleado;
import logica.Venta;


/**
 *
 * @author maxi
 */
@WebServlet(name = "SvVenta", urlPatterns = {"/SvVenta"})
public class SvVenta extends HttpServlet {
   
    Controladora control = new Controladora();
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        actualizarListaVentas(request);
        response.sendRedirect("ventas_lista.jsp");
    }
    
    protected void actualizarListaVentas(HttpServletRequest request){
        List <Venta> listaVentas = control.traerVentas();
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaVentas", listaVentas);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession miSession = request.getSession(true);
        
        String accion = request.getParameter("accion");
        if(accion.equals("crear")){
            String medioPago = request.getParameter("medioPago");
            String fecha = request.getParameter("fecha");
            long clienteId = Long.valueOf(request.getParameter("cliente"));
            Empleado e = (Empleado) miSession.getAttribute("empleado");
            long empleadoId = e.getId();
            long servicioId = 0;
            if(request.getParameter("servicio")!= null){
                servicioId = Long.valueOf(request.getParameter("servicio"));
            }
            long paqueteId = 0;
            if(request.getParameter("paquete")!= null){
                paqueteId = Long.valueOf(request.getParameter("paquete"));
            }

                
            control.crearVenta(clienteId,empleadoId,servicioId,paqueteId,fecha,medioPago);
            actualizarListaVentas(request);

            response.sendRedirect("ventas_lista.jsp");
        }
        
        
        if(accion.equals("borrar")){
            long id = Long.valueOf(request.getParameter("id"));
            control.borrarVenta(id);
            
            actualizarListaVentas(request);        
            response.sendRedirect("ventas_lista.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
