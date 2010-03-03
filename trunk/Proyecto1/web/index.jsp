<%@ include file="standardHeader.jsp" %>

  <div class="span-15" id="main">
      <h1 class="greet">Bienvenido a <span class="rojo">Blag.fm</span></h1>
      <p class="explica">
          Blagtunez es una Aplicacion web dise�ada para organizar tu m�sica.
      </p>
      <ul class="explica">
          <li>Permite a�adir y borrar Artistas</li>
          <li>Tiene Autenticaci�n</li>
          <li>Puede recibir XML de entrada</li>
          <li>y mucho mas</li>
      </ul>
      <div class="creaCuenta">
          <a href="crearCuenta.jsp">Ingresa Aqui para crear tu Cuenta.</a>
      </div>
  </div>
  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <h2><span class="small">Si ya tienes cuenta</span> <br />Inicia Sesi�n</h2>
    </div>
    <div class="span-7 prepend-1 append-1 last">
        <form charset="UTF-8" id="loginForm" name="loginForm" method="POST" action="login.jsp">
        <label for="username">Usuario:</label> <input class="text" type="text" name="username" size="20" /><br/>
        <label for="pass">Password:</label> <input class="text" type="password" name="pass" size="20" /><br/>
        <input type="submit" value="Login" />
        </form>
    </div>
  </div>
<%@ include file="standardFooter.xhtml" %>
