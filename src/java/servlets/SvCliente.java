package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;

@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {

    Controladora control = new Controladora();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        if(accion.equals("crear")){
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            int dni = Integer.valueOf(request.getParameter("dni"));
            String direccion = request.getParameter("direccion");
            String nacionalidad = request.getParameter("nacionalidad");
            String celular = request.getParameter("celular");
            String email = request.getParameter("email");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            
            control.crearCliente(nombre,apellido,dni,direccion,nacionalidad,celular,email,fechaNacimiento);
            
            

            //actualizarListaClientes(request);
            response.sendRedirect("index.jsp");            
        }
        
        HttpSession miSession = request.getSession(true);
        miSession.setAttribute("listaServicios", control.traerServicios());
        miSession.setAttribute("listaClientes", control.traerClientes());
        miSession.setAttribute("listaPaquetes", control.traerPaquetes());
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
