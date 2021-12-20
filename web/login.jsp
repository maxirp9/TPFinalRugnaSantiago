<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:700,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="assets/css/style_login.css">
  </head>
  <body>
      
      <h1 class="titulo">Sistema de Turismo</h1>

<form id="myform" method="POST" action="SvUsuario">
<div class="box">
<h1>Ingresar al sistema</h1>

<input type="text" name="usuario" value="usuario" onFocus="field_focus(this, 'usuario');" onblur="field_blur(this, 'usuario');" class="email" />
  
<input type="password" name="contrasenia" value="email" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />
  
<a href="#" onclick="document.getElementById('myform').submit()" ><div class="btn">Entrar</div></a> <!-- End Btn -->

  
</div> <!-- End Box -->
  
</form>

  
<script>
    function field_focus(field, email)
  {
    if(field.value == email)
    {
      field.value = '';
    }
  }

  function field_blur(field, email)
  {
    if(field.value == '')
    {
      field.value = email;
    }
  }

//Fade in dashboard box
$(document).ready(function(){
    $('.box').hide().fadeIn(1000);
    });

//Stop click event
$('a').click(function(event){
    event.preventDefault(); 
	});
</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js" type="text/javascript"></script>

  </body>
</html>