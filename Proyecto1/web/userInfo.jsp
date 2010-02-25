<%-- 
    Document   : userInfo
    Created on : 24-Feb-2010, 17:44:35
    Author     : tian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="userVisitor" scope="session" class="blagtunez.Usuario" />
<jsp:useBean id="userManager" scope="application" class="blagtunez.UserManager" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Informacion del Usuario</title>
<!-- Framework CSS -->
<link rel="stylesheet" href="css/screen.css" type="text/css" media="screen, projection"/>
<link rel="stylesheet" href="css/print.css" type="text/css" media="print"/>
<!--[if lt IE 8]><link rel="stylesheet" href="css/ie.css" type="text/css" media="screen, projection"/><![endif]-->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script> -->

</head>
<body>
<div class="container">
  <div class="span-15" id="main">
      <h1>Configuracion de Usuario</h1>
      <p>
          Nombre: <jsp:getProperty name="userVisitor" property="username" />
      </p>
  </div>
  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">

    </div>
  </div>
</div>
</body>
</html>