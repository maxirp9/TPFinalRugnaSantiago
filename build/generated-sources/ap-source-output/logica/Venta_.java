package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Cliente;
import logica.Empleado;
import logica.Paquete;
import logica.Servicio;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2021-12-20T14:16:13")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, Long> numero;
    public static volatile SingularAttribute<Venta, Empleado> unEmpleado;
    public static volatile SingularAttribute<Venta, Paquete> unPaquete;
    public static volatile SingularAttribute<Venta, Servicio> unServicio;
    public static volatile SingularAttribute<Venta, String> medioPago;
    public static volatile SingularAttribute<Venta, Cliente> unCliente;
    public static volatile SingularAttribute<Venta, Boolean> activo;

}