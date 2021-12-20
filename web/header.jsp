<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
      HttpSession miSession = request.getSession();
      String usu = (String) miSession.getAttribute("usuario");
      System.out.println("---------------ESTOY EN HEADER----------------");
      if(usu == null){
          response.sendRedirect("login.jsp");
      }      
%>
<!--header start-->     
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="index.jsp" class="logo"><b>AGENCIA DE TURISMO</b></a>
            <!--logo end-->
            
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <form id="cerrarsesion" action="SvUsuario" method="GET">                        
                        <button type="submit" class="btn-primary btn" style="margin-top: 15px"> Cerrar Sesion </button>
                    </form>
            	</ul>
            </div>
        </header>
<!--header end-->