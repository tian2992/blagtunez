<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />

  <%@ include file="auth.jspf" %>
  <div class="span-15" id="main">
      <h1 class="greet">Bienvenido a <span class="rojo">Blag.fm</span></h1>
      <p><% out.print(matri.estadoDeMatriz()); %></p>


  </div>
  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <p class="saludo">
        Hola: <jsp:getProperty name="usuario" property="username" />
        Hola <% out.print(usuario.getNombre()); %>
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
        <% } %>
    </div>
  </div>
<%@ include file="standardFooter.xhtml" %>