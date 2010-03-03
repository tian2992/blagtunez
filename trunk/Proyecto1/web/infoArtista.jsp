<%@ include file="standardHeader.jsp" %>

  <div class="span-15" id="main">
      <h1>Reporte de Artistas por Genero</h1>
      <p class="explica">
          Este despliega los artistas que se encuentran almacenados.
      </p>
      <div>
          <%
            if (request.getParameter("art")==null || request.getParameter("gen")==null){
            } else {
                String geni = blagtunez.stringFixer.toUTF8(request.getParameter("gen"));
                String arti = blagtunez.stringFixer.toUTF8(request.getParameter("art"));

                //String geni = request.getParameter("gen");
                //String arti = request.getParameter("art");

                out.println("Reporte de el artista "+arti);
                java.util.List<blagtunez.cancion> canList;
                blagtunez.artista artuditu = matri.buscarArtista(new blagtunez.artista(arti, geni));
            //java.util.List<blagtunez.cancion> canList = matri.getCancionesArtista(arti, geni);
                canList = artuditu.getLisCan();
            if (canList!=null){
                if (!canList.isEmpty()){

                out.println("<ul class='noList'>");
                    for (blagtunez.cancion can : canList){
                        out.println("<li><div class='artDisplay'>");
                        out.println("<h2 class='artiNom'>"+can.getNombre()+"</h2>");
                        out.println("<h3>"+can.getAño()+"</h3>");
                        out.println("</div></li>");
                    }
                  out.println("</ul>");

                  } else { //o sea si esta vacia
                        out.println("<div class='notice'>No hay canciones, debes añadir canciones</a>");
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
