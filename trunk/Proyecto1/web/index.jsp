<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>

  <div class="span-15" id="main">
      <h1 class="greet">Bienvenido a <span class="rojo">Blag.fm</span></h1>
      <p class="explica">
          Blagtunez es una Aplicacion web diseñada para organizar tu música.
      </p>
      <ul class="explica">
          <li>Permite añadir y borrar Artistas</li>
          <li>Tiene Autenticación</li>
          <li>Puede recibir XML de entrada</li>
          <li>y mucho mas</li>
      </ul>
      <div class="creaCuenta">
          <a href="crearCuenta.jsp">Ingresa Aqui para crear tu Cuenta.</a>
      </div>
  </div>
  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <h2><span class="small">Si ya tienes cuenta</span> <br />Inicia Sesión</h2>
    </div>
    <div class="span-7 prepend-1 append-1 last">
        <form id="loginForm" name="loginForm" method="POST" action="login.jsp">
        Usuario: &nbsp;  <input type="text" name="username" size="20"><br/>
        Password: <input type="password" name="password" size="20"><br/>
        <input type="submit" value="Login">
        </form>
    </div>
  </div>
<%@ include file="standardFooter.xhtml" %>
