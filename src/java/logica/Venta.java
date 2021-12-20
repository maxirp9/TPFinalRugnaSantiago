package logica;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long numero;
    @Basic
    private String medioPago;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private boolean activo;
    @ManyToOne
    private Cliente unCliente;
    @ManyToOne
    private Empleado unEmpleado;
    @ManyToOne
    private Servicio unServicio;
    @ManyToOne
    private Paquete unPaquete;

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public Empleado getUnEmpleado() {
        return unEmpleado;
    }

    public void setUnEmpleado(Empleado unEmpleado) {
        this.unEmpleado = unEmpleado;
    }

    public Servicio getUnServicio() {
        return unServicio;
    }

    public void setUnServicio(Servicio unServicio) {
        this.unServicio = unServicio;
    }

    public Paquete getUnPaquete() {
        return unPaquete;
    }

    public void setUnPaquete(Paquete unPaquete) {
        this.unPaquete = unPaquete;
    }
    

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Venta() {
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }
    

    public Date getFecha() {
        return fecha;
    }
    
    public String getFechaString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	String fechaComoCadena = sdf.format(this.fecha);
        return fechaComoCadena;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
