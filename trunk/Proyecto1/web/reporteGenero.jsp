<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />

  <div class="span-15" id="main">
      <h1>Reporte de Artistas por Genero</h1>
      <p class="explica">
          Este despliega los artistas que se encuentran almacenados.
      </p>
      <div>
          <%
            if (request.getParameter("gen")==null){
            } else {
                String geni = blagtunez.stringFixer.toUTF8(request.getParameter("gen"));
                out.println("Reporte de genero: "+geni);
            java.util.List<blagtunez.artista> arList = matri.listarArtistas(geni);
            if (arList!=null){
                if (!arList.isEmpty()){

                out.println("<ul class='noList'>");
                    for (blagtunez.artista ar :arList){
                        out.println("<li><div class='artDisplay'>");
                        if (ar.isImagen()){
                            out.println("<img src='"+ar.getImagen()+"' alt='' /> ");
                        }
                        out.println("<h2 class='artiNom'>"+ar.getNombre()+"</h2>");
                        out.println("<h3>"+ar.getGenero()+"</h3>");
                        out.println("<p>"+ar.getNacionalidad()+"</p>");
                        out.println("</div></li>");
                    }
                  out.println("</ul>");

                  } else { //o sea si esta vacia
                        out.println("<div class='notice'>No hay Artistas, debes añadir artistas</a>");
                  }
            }}%>
      </div>
  </div>
  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        
    </div>
    <div class="span-7 prepend-1 append-1 last">

    </div>
  </div>
<%@ include file="standardFooter.xhtml" %>
