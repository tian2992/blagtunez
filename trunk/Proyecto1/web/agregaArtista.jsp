<%@ include file="standardHeader.jsp" %>

  <%@ include file="auth.jspf" %>
  <div class="span-15" id="main">
      <h1 class="greet">Bienvenido a Blagtunes</h1>
      <div>
          <%
          if (request.getParameter("error")!=null){
            if (request.getParameter("error").equalsIgnoreCase("si")) { %>
            <div class="error"><img src="PICS/emblem-error.png" alt="error"/>Hubo un error al ingresar tu data</div>
            <% }
            else if (request.getParameter("error").equalsIgnoreCase("noAuto")){ %>
            <div class="error"><img src="PICS/emblem-error.png" alt="error"/>No tienes autorizacion de ingresar artistas</div>
            <% }
          } %>
      </div>
      <div>
          <form charset="UTF-8"  id="agregaArtista" action="artistaCreacion.jsp" method="POST">
              <fieldset>
              <label class="formCap">Nombre: </label><input type="text" class="text" name="nombre" id="nombre" value="" size="20" /><br/>
              <label class="formCap">Nacionalidad: </label><input type="text" class="text" name="nacionalidad" id="nacionalidad" value="" size="20" /><br />
              <label class="formCap">Genero: </label><input type="text" class="text" name="genero" id="genero" value="" size="20" /><br />
              <label class="formcap formOpcional">Imagen: </label><input type="text" class="text" name="imagen" id="imagen" value="" size="20" /><br />
              <input type="submit" value="Agregar Artista" /><br />
              <label>Los campos en <span class="formOpcional">color, son opcionales</span></label>
              </fieldset>
          </form>
      </div>
  </div>
  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <p>
        </p>
    </div>
  </div>

<%@ include file="standardFooter.xhtml" %>