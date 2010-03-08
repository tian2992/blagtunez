<%@ include file="standardHeader.jsp" %>


  <div class="span-15" id="main">
      <h1>Reporte de Artistas</h1>
      <p class="explica">
          Este despliega los artistas que se encuentran almacenados.
      </p>
      <div>
          <%
          java.util.List<blagtunez.artista> arList = matri.listarArtistas();
        if (arList != null) {
            if (!arList.isEmpty()) {
                out.println("<ul class='noList'>");
                String s = "<ul>";
                for (blagtunez.artista ar : arList) {
                    out.println("<li class='artDisplay'>");
                    if (ar.isImagen()) {
                        out.println("<img src='" + ar.getImagen() + "' alt='' /> ");
                    }
                    out.println("<div class='articon'><h2 class=\"artiNom\"><a href='buscaArtista.jsp?nombre=" + ar.getNombre() + "&genero=" + ar.getGenero() + "'>" + ar.getNombre() + "</a></h2>");
                    out.println("<h3><a href='reporteGenero.jsp?gen=" + ar.getGenero() + "'>" + ar.getGenero() + "</a></h3>");
                    out.println("<p>" + ar.getNacionalidad() + "</p></div>");
                    out.println("</li>");
                    s += "<li>"+ ar.getNombre() + "</li>\n";
                }
                out.println("</ul>");
                s+="</ul>";


                if (request.getParameter("mail") == null) {
                    out.println("<a href='reporteArtistas.jsp?mail=true'>Enviar Mail</a>");
                } else {
                    out.println(blagtunez.mail.sendMail(usuario.getEMail(), s, "Reporte de Artistas"));
                }
            } else { //o sea si esta vacia
                out.println("<div class='notice'><img src=\"PICS/emblem-important.png\" alt='alerta' />No hay Artistas, debes añadir artistas</a>");
            }
            }
          %>
      </div>
  </div>
  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
    </div>
    <div class="span-7 prepend-1 append-1 last">

    </div>
  </div>
<%@ include file="standardFooter.xhtml" %>
