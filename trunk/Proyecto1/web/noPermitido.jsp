<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<div class="span-24" id="main">
    <h1 class="greet">WTF tienes malo en la cabeza!</h1>
    <p class="large">No tienes permiso de estar aqui, si tanto quieres entrar, <a href="crearCuenta.jsp">Create una Cuenta</a></p>
</div>
<%@ include file="standardFooter.xhtml" %>