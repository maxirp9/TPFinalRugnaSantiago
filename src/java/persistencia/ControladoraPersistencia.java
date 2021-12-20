package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.Paquete;
import logica.Servicio;
import logica.Usuario;
import logica.Venta;


public class ControladoraPersistencia {
    
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    ServicioJpaController serviJPA = new ServicioJpaController();
    PaqueteJpaController paqueteJPA = new PaqueteJpaController();
    ClienteJpaController clienteJPA = new ClienteJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();
    
    
    public void crearServicio(Servicio obj){
        
        try {
            serviJPA.create(obj);            
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public void crearEmpleado(Empleado emple, Usuario usu){
        
        try {
            usuJPA.create(usu);
            empleJPA.create(emple);
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public void editarEmpleado(Empleado emple){
        try {
            empleJPA.edit(emple);
            usuJPA.edit(emple.getUsuario());
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> traerUsuarios() {
        return usuJPA.findUsuarioEntities();
    }
    
    public List<Empleado> traerEmpleados(){
        return empleJPA.findEmpleadoEntities();
    }

    public void borrarEmpleado(long id) {
        Empleado e = empleJPA.findEmpleado(id);
        e.setActivo(false);
        try {
            empleJPA.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    public Empleado traerEmpleado(long id) {
        return empleJPA.findEmpleado(id);
    }

    public List<Servicio> traerServicios() {
        return serviJPA.findServicioEntities();
    }

    public Servicio traerServicio(long id) {
        return serviJPA.findServicio(id);
    }

    public void crearPaquete(Paquete obj) {
        try {
            paqueteJPA.create(obj);        
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearCliente(Cliente obj) {
        try {
            clienteJPA.create(obj);        
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente traerCliente(long clienteId) {
        return clienteJPA.findCliente(clienteId);
    }

    public Paquete traerPaquete(long paqueteId) {
        return paqueteJPA.findPaquete(paqueteId);
    }

    public void crearVenta(Venta obj) {
        try {
            ventaJPA.create(obj);        
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Paquete> traerPaquetes() {
        return paqueteJPA.findPaqueteEntities();
    }

    public List<Cliente> traerClientes() {
        return clienteJPA.findClienteEntities();
    }

    public List<Venta> traerVentas() {
        return ventaJPA.findVentaEntities();
    }

    public void borrarVenta(long id) {
        Venta e = ventaJPA.findVenta(id);
        e.setActivo(false);
        try {
            ventaJPA.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarPaquete(long id) {
        Paquete e = paqueteJPA.findPaquete(id);
        e.setActivo(false);
        try {
            paqueteJPA.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarServicio(long id) {
        Servicio e = serviJPA.findServicio(id);
        e.setActivo(false);
        try {
            serviJPA.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
