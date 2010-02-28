<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />

  <div class="span-15" id="main">
      <h1 class="greet">Bienvenido a Blagtunes</h1>
      <div>
          <%
          if (request.getParameter("error")!=null){
          if (request.getParameter("error").equalsIgnoreCase("si")) { %>
          <div class="error">Hubo un error al ingresar tu data</div>
          <% }} %>
      </div>
      <div>
          <form id="agregaArtista" action="artistaCreacion.jsp" method="POST">
              <fieldset>
              <label class="formCap">Nombre: </label><input type="text" class="text" name="nombre" id="nombre" value="" size="20" /><br/>
              <label class="formCap">Nacionalidad: </label><input type="text" class="text" name="nacionalidad" id="nacionalidad" value="" size="20" /><br />
              <label class="formCap">Genero: </label><input type="text" class="text" name="genero" id="genero" value="" size="20" /><br />
              <label class="formcap formOpcional">Imagen: </label><input type="text" class="text" name="imagen" id="imagen" value="" size="20" /><br />
              <input type="submit" value="Agregar Artista" /><br />
              <label>Los campos en <span class="formOpcional">rojo, son opcionales</span></label>
              </fieldset>
          </form>
      </div>
  </div>
  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <p>
        Hola: <jsp:getProperty name="usuario" property="username" />
        Hola <% out.print(usuario.getNombre()); %>

        </p>
    </div>
  </div>

<%@ include file="standardFooter.xhtml" %>