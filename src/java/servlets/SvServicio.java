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
import logica.Servicio;

@WebServlet(name = "SvServicio", urlPatterns = {"/SvServicio"})
public class SvServicio extends HttpServlet {
    
    Controladora control = new Controladora();
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        actualizarLista(request);
        //response.sendRedirect("empleados_lista.jsp");
    }
    
    protected void actualizarLista(HttpServletRequest request){
        List <Servicio> listaServicios = control.traerServicios();
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaServicios", listaServicios);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        //if(accion.equals("crear")){
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcionBreve");            
            String destino = request.getParameter("destino");            
            String fecha = request.getParameter("fecha");
            String costo = request.getParameter("costo");            

            control.crearServicio(nombre,descripcion,destino,fecha,costo);
            actualizarLista(request);
            response.sendRedirect("index.jsp");            
        //}
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
