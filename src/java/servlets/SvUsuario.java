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
import logica.Empleado;
import logica.Usuario;

@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession miSession = request.getSession(true);
            miSession.invalidate();
            response.sendRedirect("login.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        
        Controladora control = new Controladora();
        Usuario autorizado =  control.verificarUsuario(usuario, contrasenia);
        
        if(!(autorizado == null)){
            
            HttpSession miSession = request.getSession(true);
            miSession.setAttribute("usuario",usuario);
            miSession.setAttribute("contrasenia",contrasenia);
            Empleado e = control.traerEmpleado(autorizado);
            miSession.setAttribute("empleado", e);
            
            miSession.setAttribute("listaServicios", control.traerServicios());
            miSession.setAttribute("listaClientes", control.traerClientes());
            miSession.setAttribute("listaPaquetes", control.traerPaquetes());
            miSession.setAttribute("listaVentas", control.traerVentas());
            
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendRedirect("login.jsp");
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
