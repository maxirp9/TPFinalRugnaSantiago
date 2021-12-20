package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long codigo;
    @Basic
    private String nombre;
    private String descripcion_breve;
    private String destino;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double costo;
    private boolean activo;
    @ManyToMany
    private List<Paquete> listaPaquetes;
    @OneToMany
    private List<Venta> listaVentas;

    public Servicio(long codigo, String nombre, String descripcion_breve, String destino, Date fecha, double costo, boolean activo, List<Paquete> listaPaquetes, List<Venta> listaVentas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion_breve = descripcion_breve;
        this.destino = destino;
        this.fecha = fecha;
        this.costo = costo;
        this.activo = activo;
        this.listaPaquetes = listaPaquetes;
        this.listaVentas = listaVentas;
    }
    
    
    public List<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<Paquete> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
    
    

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public Servicio() {
    }    

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion_breve() {
        return descripcion_breve;
    }

    public void setDescripcion_breve(String descripcion_breve) {
        this.descripcion_breve = descripcion_breve;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return nombre + " ($" + costo + ')';
    }

    
    
}
