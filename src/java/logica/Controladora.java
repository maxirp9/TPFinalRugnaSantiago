package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public Usuario verificarUsuario(String usuario, String contrasenia){
        System.out.println("Verificooooo");
        List <Usuario> listaUsuarios = controlPersis.traerUsuarios();
        
        if(listaUsuarios != null){
           for(Usuario usu:listaUsuarios){
               if(usu.getNombre().equals(usuario) && usu.getContrasenia().equals(contrasenia)){
                   return usu;
               }
           }
        }
        
        return null;
    }   
    
    
    public void borrarEmpleado(long id){
        controlPersis.borrarEmpleado(id);
    }

    public List<Empleado> traerEmpleados() {
        return controlPersis.traerEmpleados();
    }

    public Empleado traerEmpleado(long id) {
        return controlPersis.traerEmpleado(id);
    }
    
    public Servicio traerServicio(long id) {
        return controlPersis.traerServicio(id);
    } 

    public void editarEmpleado(Long id, String nombre, String apellido, int dni, String direccion, String nacionalidad, String celular, String email, String fechaNacimiento, String cargo, Double sueldo, String nombreUsu, String contrasenia) {
        
        Empleado emple = controlPersis.traerEmpleado(id);
        
        emple.setNombre(nombre);
        emple.setApellido(apellido);
        emple.setDni(dni);
        emple.setDireccion(direccion);
        emple.setNacionalidad(nacionalidad);
        emple.setCelular(celular);
        emple.setEmail(email);
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");  
        Date fecha;
        try {
            fecha = formato.parse(fechaNacimiento);
            emple.setFechaNacimiento(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        emple.setCargo(cargo);
        emple.setSueldo(sueldo);        
        
        emple.getUsuario().setNombre(nombreUsu);
        emple.getUsuario().setContrasenia(contrasenia);
        
        controlPersis.editarEmpleado(emple);
    }

    public void crearEmpleado(String nombre, String apellido, int dni, String direccion, String nacionalidad, String celular, String email, String fechaNacimiento, String cargo, Double sueldo, String nombreUsu, String contrasenia) {
        Empleado emple = new Empleado();
        Usuario usu = new Usuario();
        
        emple.setNombre(nombre);
        emple.setApellido(apellido);
        emple.setDni(dni);
        emple.setDireccion(direccion);
        emple.setNacionalidad(nacionalidad);
        emple.setCelular(celular);
        emple.setEmail(email);
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");  
        Date fecha;
        try {
            fecha = formato.parse(fechaNacimiento);
            emple.setFechaNacimiento(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        emple.setCargo(cargo);
        emple.setSueldo(sueldo);
        emple.setActivo(true);
        
        usu.setNombre(nombreUsu);
        usu.setContrasenia(contrasenia);
        usu.setActivo(true);
        
        emple.setUsuario(usu);
        
        controlPersis.crearEmpleado(emple,usu);        
        
    }
    
    public void crearCliente(String nombre, String apellido, int dni, String direccion, String nacionalidad, String celular, String email, String fechaNacimiento) {
        Cliente obj = new Cliente();        
        
        obj.setNombre(nombre);
        obj.setApellido(apellido);
        obj.setDni(dni);
        obj.setDireccion(direccion);
        obj.setNacionalidad(nacionalidad);
        obj.setCelular(celular);
        obj.setEmail(email);
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");  
        Date fecha;
        try {
            fecha = formato.parse(fechaNacimiento);
            obj.setFechaNacimiento(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        obj.setActivo(true);        
        
        controlPersis.crearCliente(obj);
    }

    public void crearServicio(String nombre, String descripcionBreve, String destino, String fecha, String costo) {
        Servicio obj = new Servicio();
        Usuario usu = new Usuario();
        
        obj.setNombre(nombre);
        obj.setDescripcion_breve(descripcionBreve);
        obj.setDestino(destino);
        obj.setCosto(Double.valueOf(costo));
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");  
        Date fechaFormat;
        try {
            fechaFormat = formato.parse(fecha);
            obj.setFecha(fechaFormat);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        obj.setActivo(true);                  
        
        controlPersis.crearServicio(obj);
    }

    public List<Servicio> traerServicios() {
        return controlPersis.traerServicios();
    }

    public List<Paquete> traerPaquetes() {
        return controlPersis.traerPaquetes();
    }
    
    public List<Cliente> traerClientes() {
        return controlPersis.traerClientes();
    }

    public void crearPaquete(String nombre, String[] servicios) {
        Paquete obj = new Paquete();
        
        obj.setNombre(nombre);
        obj.setActivo(true);
        
        double costo = 0;
        List <Servicio> listaServicios = new ArrayList<>();
        for(String servicioCodigo : servicios){
            Servicio s = this.traerServicio(Long.valueOf(servicioCodigo));
            listaServicios.add(s);
            costo = costo + s.getCosto()*0.9;
        }
        obj.setListaServicios(listaServicios);
        obj.setCosto(costo);
        
        controlPersis.crearPaquete(obj);
    }    

    public void crearVenta(long clienteId, long empleadoId, long servicioId, long paqueteId, String fecha, String medioPago) {
        
        Venta obj = new Venta();
        obj.setMedioPago(medioPago);
        obj.setActivo(true);
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");  
        Date fechaFormat;
        try {
            fechaFormat = formato.parse(fecha);
            obj.setFecha(fechaFormat);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Empleado empleado = this.traerEmpleado(empleadoId);
        Cliente cliente = this.traerCliente(clienteId);
        
        
        obj.setUnEmpleado(empleado);
        obj.setUnCliente(cliente);
        
        if(servicioId != 0){
            Servicio servicio = this.traerServicio(servicioId);
            obj.setUnServicio(servicio);
        }
        if(paqueteId != 0){
            Paquete paquete = this.traerPaquete(paqueteId);
            obj.setUnPaquete(paquete);
        }
        
        
        controlPersis.crearVenta(obj);
        
    }

    private Cliente traerCliente(long clienteId) {
        return controlPersis.traerCliente(clienteId);
    }

    private Paquete traerPaquete(long paqueteId) {
        return controlPersis.traerPaquete(paqueteId);
    }

    public Empleado traerEmpleado(Usuario autorizado) {
        List <Empleado> lista = this.traerEmpleados();
        for(Empleado emple : lista){
            if(autorizado.getId() == emple.getUsuario().getId()){
                return emple;
            }
                
        }
        
        return null;              
        
    }

    public List<Venta> traerVentas() {
        return controlPersis.traerVentas();
    }

    public void borrarVenta(long id) {
        controlPersis.borrarVenta(id);
    }

    public void borrarPaquete(long id) {
        controlPersis.borrarPaquete(id);
    }

    

    
}
