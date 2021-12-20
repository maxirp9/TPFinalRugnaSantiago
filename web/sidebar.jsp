<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
                  <h5 class="centered">
                      <%=usu      
                      %>
                  </h5>
              	  	
                  <li class="mt">
                      <a class="active" href="index.jsp">
                          <i class="fa fa-dashboard"></i>
                          <span>Dashboard</span>
                      </a>
                  </li>
                  
                  <li class="mt">                      
                      <a class="active" href="ventas_alta.jsp">
                          <i class="fa fa-tasks"></i>
                          <span>Cargar venta</span>
                      </a>
                  </li>
                  
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>ABM</span>
                      </a>
                      <ul class="sub">
                          <form id="listaClientes" action="SvCliente" method="POST">                              
                              <li><a  href="clientes_alta.jsp">Clientes</a></li>
                          </form>
                          <form id="listaEmpleados" action="SvEmpleado" method="GET">
                              <li><a  href="SvEmpleado" onclick="document.getElementById('listaEmpleados').submit()">Empleados</a></li>
                          </form>
                          <form id="listaServicios" action="SvServicio" method="POST">
                              <li><a  href="servicios_alta.jsp">Servicios</a></li>
                          </form>
                          <form id="listaPaquetes" action="SvServicio" method="GET">                              
                              <li><a  href="paquetes_lista.jsp">Paquetes</a></li>
                          </form>
                          <form id="listaVentas" action="SvVenta" method="GET">                              
                              <li><a  href="ventas_lista.jsp">Ventas</a></li>
                          </form>
                      </ul>
                  </li>          

              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
