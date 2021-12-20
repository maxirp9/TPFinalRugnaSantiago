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

@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        actualizarListaEmpleados(request);
        response.sendRedirect("empleados_lista.jsp");
    }
    
    protected void actualizarListaEmpleados(HttpServletRequest request){
        List <Empleado> listaEmpleados = control.traerEmpleados();
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaEmpleados", listaEmpleados);
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
            String cargo = request.getParameter("cargo");
            Double sueldo = Double.parseDouble(request.getParameter("sueldo"));
            String nombreUsu = request.getParameter("nombreUsu");
            String contrasenia = request.getParameter("contrasenia");

            control.crearEmpleado(nombre,apellido,dni,direccion,nacionalidad,celular,email,fechaNacimiento,cargo,sueldo,nombreUsu,contrasenia);

            actualizarListaEmpleados(request);
            response.sendRedirect("empleados_lista.jsp");            
        }
        
        if(accion.equals("borrar")){
            long id = Long.valueOf(request.getParameter("id"));
            control.borrarEmpleado(id);
            
            actualizarListaEmpleados(request);        
            response.sendRedirect("empleados_lista.jsp");
        }
        
        if(accion.equals("editar")){
            long id = Long.valueOf(request.getParameter("id"));            
            Empleado e = control.traerEmpleado(id);
            HttpSession miSession = request.getSession();
            miSession.setAttribute("empleado", e);
            
            response.sendRedirect("empleados_edicion.jsp");
        }
        
        if(accion.equals("editar_campos")){
            
            Long id = Long.valueOf(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            int dni = Integer.valueOf(request.getParameter("dni"));
            String direccion = request.getParameter("direccion");
            String nacionalidad = request.getParameter("nacionalidad");
            String celular = request.getParameter("celular");
            String email = request.getParameter("email");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            String cargo = request.getParameter("cargo");
            Double sueldo = Double.parseDouble(request.getParameter("sueldo"));
            String nombreUsu = request.getParameter("nombreUsu");
            String contrasenia = request.getParameter("contrasenia");

            control.editarEmpleado(id,nombre,apellido,dni,direccion,nacionalidad,celular,email,fechaNacimiento,cargo,sueldo,nombreUsu,contrasenia);

            actualizarListaEmpleados(request);
            response.sendRedirect("empleados_lista.jsp");            
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
