<%@ include file="standardHeader.jsp" %>


  <%@ include file="auth.jspf" %>
  <div class="span-15" id="main">
      <h1 class="greet">Bienvenido a <span class="rojo">Blag.fm</span></h1>
      <p><% out.print(matri.estadoDeMatriz()); %></p>


  </div>
  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <p class="saludo">
            <!-- aqui va la parte de arriba de la sidebar -->
        </p>
        <% if (!matri.esVacia()) {%>
        <div id="busCartista" class="buscador">
            <h2>Buscar Artistas</h2>
            <form charset="UTF-8" name="buscaArt" action="buscaArtista.jsp" method="POST">
                <label>Nombre del Artista: </label><input class="text" type="text" name="nombre" id="nombre" size="20" /><br />
                <label>Genero</label>
                <select name="genero" id="genero">
                    <%
                        java.util.List<String> genis = matri.listarGeneros();
                        if (genis!=null){
                            for (String geni : genis){
                               out.println("<option value=\""+geni+"\">"+geni+"</option>");
                            }
                        }
                        else{
                                out.println("<option disabled='true'>No Hay Generos</option>");
                            }
                    %>
                </select>
                <input type="submit" value="Buscar!" />
            </form>
        </div>
        <div>
            <h2>Listado de Artistas por Genero</h2>
                <form charset="UTF-8" name="buscaArt" action="reporteGenero.jsp" method="POST">
                <label>Genero</label>
                <select name="gen" id="gen">
                    <%
                        java.util.List<String> genois = matri.listarGeneros();
                        if (genois!=null){
                            for (String geni : genois){
                               out.println("<option value=\""+geni+"\">"+geni+"</option>");
                            }
                        }
                        else{
                                out.println("<option disabled='true'>No Hay Generos</option>");
                            }
                    %>
                </select>
                <input type="submit" value="Buscar!" />
            </form>
        </div>
        <div>
            <h2>Listado de Artistas por Genero</h2>
                <form charset="UTF-8" name="buscaArtistaConNombre" action="showAr.jsp" method="POST">
                <label>Nombre del Artista: </label><input class="text" type="text" name="artista" id="artista" size="20" /><br />
                <input type="submit" value="Buscar!" />
            </form>
        </div>
        <div>
            <h2>Buscar Canciones</h2>
                <form charset="UTF-8" name="buscaCancion" action="listarCanciones.jsp" method="POST">
                <label>Nombre del Artista: </label><input class="text" type="text" name="songi" id="songi" size="20" /><br />
                <input type="submit" value="Buscar!" />
            </form>
        </div>
        <% } %>
    </div>
  </div>
<%@ include file="standardFooter.xhtml" %>