<%@ include file="standardHeader.jsp" %>

  <div class="span-15" id="main">
      <h1>Reporte de Artistas por Genero</h1>
      <p class="explica">
          Este despliega los artistas que se encuentran almacenados.
      </p>
      <div>
          <%
        String songi = "";
        if (request.getParameter("songi") == null) {
        } else {
            songi = blagtunez.stringFixer.toUTF8(request.getParameter("songi"));
            out.println("Busqueda de Cancion: " + songi);
            java.util.List<blagtunez.cancion> canList = matri.buscarCancion(songi);
            if (canList != null) {
                if (!canList.isEmpty()) {

                    out.println("<ul class='noList'>");
                    for (blagtunez.cancion c : canList) {
                        out.println("<li class='artDisplay'>");

                        out.println("<div class='articon'><h2 class=\"artiNom\"><a href='buscaArtista.jsp?nombre=" + c.getInterprete().getNombre() + "&genero=" + c.getInterprete().getGenero() + "'>" + c.getInterprete().getNombre() + "</a></h2>");
                        out.println("<p>" + c.getNombre()+ "</p></div>");
                        out.println("</li>");
                    }
                    out.println("</ul>");

                } else { //o sea si esta vacia
                    out.println("<div class='notice'>No hay Artistas, debes añadir artistas</a>");
                }
            }
        }
            %>
      </div>
  </div>


<%@ include file="standardFooter.xhtml" %>