package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Paquete;
import logica.Venta;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2021-12-20T14:16:13")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, Date> fecha;
    public static volatile SingularAttribute<Servicio, Long> codigo;
    public static volatile SingularAttribute<Servicio, Double> costo;
    public static volatile ListAttribute<Servicio, Paquete> listaPaquetes;
    public static volatile SingularAttribute<Servicio, String> destino;
    public static volatile ListAttribute<Servicio, Venta> listaVentas;
    public static volatile SingularAttribute<Servicio, String> nombre;
    public static volatile SingularAttribute<Servicio, String> descripcion_breve;
    public static volatile SingularAttribute<Servicio, Boolean> activo;

}