<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />
<jsp:useBean id="arti" class="blagtunez.artista" scope="page" />
<jsp:setProperty name="arti" property="*"/>

  <div class="span-15" id="main">
      <h1>Resultados de la Busqueda</h1>
      <% blagtunez.artista artuditu = null;
         artuditu = matri.buscarArtista(arti);
         out.println("<div class='searchResults'>");
         if (artuditu != null){
            out.println("Listado para: "+artuditu.getNombre());
            java.util.List<blagtunez.cancion> lisCan = artuditu.getLisCan();
            if (!lisCan.isEmpty()){
                out.println("<ul class='liscan'>");
                    for (blagtunez.cancion songi : lisCan){
                        out.println("<li>"+songi.toString()+"</li>");
                    }
                out.println("</ul>");
            }
            else {
                out.println("<div class='success'>Este artista no tiene Canciones</div>");
            }

         }
         else{
             out.println("<div class='notice'>Tu busqueda fue fallida, intenta <a href='homeScreen.jsp'>buscar de nuevo</a></div> ");
             }
         out.println("</div>");

              %>


  </div>

<%@ include file="standardFooter.xhtml" %>