package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Servicio;
import logica.Venta;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2021-12-20T14:16:13")
@StaticMetamodel(Paquete.class)
public class Paquete_ { 

    public static volatile SingularAttribute<Paquete, Long> codigo;
    public static volatile SingularAttribute<Paquete, Double> costo;
    public static volatile ListAttribute<Paquete, Servicio> listaServicios;
    public static volatile ListAttribute<Paquete, Venta> listaVentas;
    public static volatile SingularAttribute<Paquete, String> nombre;
    public static volatile SingularAttribute<Paquete, Boolean> activo;

}