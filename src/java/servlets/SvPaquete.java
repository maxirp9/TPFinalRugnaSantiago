package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Empleado;
import logica.Paquete;
import logica.Servicio;

@WebServlet(name = "SvPaquete", urlPatterns = {"/SvPaquete"})
public class SvPaquete extends HttpServlet {
    Controladora control = new Controladora();
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        actualizarLista(request);
        //response.sendRedirect("empleados_lista.jsp");
    }
    
    protected void actualizarLista(HttpServletRequest request){
        List <Paquete> listaPaquetes = control.traerPaquetes();
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaPaquetes", listaPaquetes);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        if(accion.equals("crear")){
            String [] servicios = request.getParameterValues("checkboxgroup");
            String nombre = request.getParameter("nombre");

            control.crearPaquete(nombre,servicios);
            actualizarLista(request);        
            response.sendRedirect("paquetes_lista.jsp");
        }
        
        if(accion.equals("borrar")){
            long id = Long.valueOf(request.getParameter("id"));
            control.borrarPaquete(id);
            
            actualizarLista(request);        
            response.sendRedirect("paquetes_lista.jsp");
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
