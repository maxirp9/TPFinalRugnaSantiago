<%@page import="logica.Paquete"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.Servicio"%>
<%@page import="logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Sistema de Turismo</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>    
  

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
       <%@include file="header.jsp" %>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <%@include file="sidebar.jsp" %>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">                
                
                <!-- BASIC FORM ELELEMNTS -->
          	<div class="row mt">
          	 <div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> Crear Venta</h4>
                      <form class="form-horizontal style-form" method="POST" action="SvVenta">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Medio de Pago:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="medioPago">
                              </div>
                          </div>     
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Fecha</label>
                              <div class="col-sm-10">
                                  <input type="date" class="form-control" name="fecha">
                              </div>
                          </div>
                  </div>
                 </div>
                </div>
                
                <!-- INLINE FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
                            <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> Selecciones un Cliente:</h4>
                          <select class="form-control" id="cliente" name="cliente">
                          <%
                            List <Cliente> listaClientes = (List) request.getSession().getAttribute("listaClientes");
                            for (Cliente cliente : listaClientes){
                                if(cliente.isActivo()==true){                                  
                                                                               
                            %>                               
                                                  
                            
                                <option value="<%=cliente.getId()%>"><%=cliente%></option>						  
						                    
                               <%}}%>	
                               
                               </select>  
          			</div><!-- /form-panel -->
          		</div><!-- /col-lg-12 -->
          	</div><!-- /row -->
                          
                         <!-- INPUT MESSAGES -->                     
          	                       
                        
                    <div class="row mt">
          		<div class="col-lg-12">
          			<div class="form-panel">
                                    <h4 class="mb"><i class="fa fa-angle-right"></i>Seleccionar un servicio o paquete:</h4>
                          
                                                <div class="radio">
						  <label>
						    <input onclick="habilitarServicio()" type="radio" name="optionsRadios" id="optionsRadios1" value="option1">
						    Cargar un Servicio
						  </label>
						</div>
						<div class="radio">
						  <label>
						    <input onclick="habilitarPaquete()" type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
						    Cargar un Paquete
						  </label>
						</div>
                                                
                        
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> Selecciones un Servicio:</h4>
                          <select disabled="true" class="form-control" id="servicio" name="servicio">
                          <%
                            List <Servicio> listaServicios = (List) request.getSession().getAttribute("listaServicios");
                            for (Servicio servicio : listaServicios){
                                if(servicio.isActivo()==true){                                  
                                                                               
                            %>                               
                                                  
                            
                                <option value="<%=servicio.getCodigo()%>"><%=servicio%></option>						  
						                    
                               <%}}%>	
                               
                               </select>  
          		                        
                        
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> Selecciones un Paquete:</h4>
                          <select disabled="true" class="form-control" id="paquete" name="paquete">
                          <%
                            List <Paquete> listaPaquetes = (List) request.getSession().getAttribute("listaPaquetes");
                            for (Paquete paquete : listaPaquetes){
                                if(paquete.isActivo()==true){                                  
                                                                               
                            %>                               
                                                  
                            
                                <option value="<%=paquete.getCodigo()%>"><%=paquete%></option>						  
						                    
                               <%}}%>	
                               
                               </select>  
          		                        
                               <hr>         	
                          <input type="hidden" name="accion" value="crear"> 
                          <button type="submit" class="btn btn-primary"> Enviar </button>
                          
                      </form>
                  </div>
          		</div><!-- col-lg-12-->      	
          	</div><!-- /row -->
              
          </section>
      </section>

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2021 - Rugna Santiago Maximiliano
              <a href="index.jsp#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/jquery-1.8.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="assets/js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="assets/js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="assets/js/sparkline-chart.js"></script>    
	<script src="assets/js/zabuto_calendar.js"></script>	
        
        <script>
                           function habilitarServicio()
                           {
                                   var variable = document.getElementById('servicio');
                                   variable.disabled = false;                                   
                                   var variable2 = document.getElementById('paquete');
                                   variable2.disabled = true;                                   
                           }
                           function habilitarPaquete()
                           {
                                   var variable = document.getElementById('paquete');
                                   variable.disabled = false;                                   
                                   var variable2 = document.getElementById('servicio');
                                   variable2.disabled = true;                                   
                           }
                           
        </script>
		
	
	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
  

  </body>
</html>