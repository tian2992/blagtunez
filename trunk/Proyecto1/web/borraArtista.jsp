<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />

  <%@ include file="auth.jspf" %>
  <div class="span-15" id="main">
      <h1 class="greet">Bienvenido a Blagtunes</h1>
      <div>
          <%
          if (request.getParameter("error")!=null){
            if (request.getParameter("error").equalsIgnoreCase("si")) { %>
            <div class="error">Hubo un error al ingresar tu data</div>
            <% }
            else if (request.getParameter("error").equalsIgnoreCase("noAuto")){ %>
            <div class="error">No tienes autorizacion de borrar artistas</div>
            <% }
          } %>
      </div>
      <div>
          <form charset="UTF-8" id="borraArtista" action="artistaBorrar.jsp" method="POST">
              <fieldset>
                <label>Selecciona el artista a Borrar</label>
                <select name="artista" id="artista">
                    <%
                        java.util.List<blagtunez.artista> artis = matri.listarArtistas();
                        if (artis!=null){
                            for (blagtunez.artista arti : artis){
                               out.println("<option value=\""+arti.getNombre()+"\">"+arti.getNombre()+"</option>");
                            }
                        }
                        else{
                                out.println("<option disabled='true'>No Hay Artistas a Borrar</option>");
                            }
                    %>
                </select>
                <input type="submit" value="Borrar!" />
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