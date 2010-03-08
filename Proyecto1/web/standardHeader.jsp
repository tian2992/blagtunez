<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Bienvenido a Blag.fm</title>
<link rel="stylesheet" href="css/screen.css" type="text/css" media="screen, projection"/>
<link rel="stylesheet" href="css/print.css" type="text/css" media="print"/>
<!--[if lt IE 8]><link rel="stylesheet" href="css/ie.css" type="text/css" media="screen, projection"/><![endif]-->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

</head>
<body>
<div class="userManager">Hola <% if(usuario!=null){ if (usuario.getNombre()!=null){ out.print(usuario.getNombre()); out.println("<br /><a href='logOut.jsp' >Cierra tu sesión</a>"); if(usuario.isAdmin()){out.println("<br /><a class='adCons' href='adminConsole.jsp'>Consola Administrativa</a>");} }else{out.println(" Extraño");} }else{out.println(" Extraño");}%></div>
<div class="container">