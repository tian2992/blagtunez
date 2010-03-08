<%@ include file="standardHeader.jsp" %>

  <div class="span-15" id="main">
      <h1>Reporte de Artistas por Genero</h1>
      <p class="explica">
          Este despliega los artistas que se encuentran almacenados.
      </p>
      <div>
          <%
        String geni = "";
        if (request.getParameter("gen") == null) {
        } else {
            geni = blagtunez.stringFixer.toUTF8(request.getParameter("gen"));
            out.println("Reporte de genero: " + geni);
            java.util.List<blagtunez.artista> arList = matri.listarArtistas(geni);
            if (arList != null) {
                if (!arList.isEmpty()) {

                    out.println("<ul class='noList'>");
                    for (blagtunez.artista ar : arList) {
                        out.println("<li class='artDisplay'>");
                        if (ar.isImagen()) {
                            out.println("<img src='" + ar.getImagen() + "' alt='' /> ");
                        }
                        out.println("<div class='articon'><h2 class=\"artiNom\"><a href='buscaArtista.jsp?nombre=" + ar.getNombre() + "&genero=" + ar.getGenero() + "'>" + ar.getNombre() + "</a></h2>");
                        out.println("<h3><a href='reporteGenero.jsp?gen=" + ar.getGenero() + "'>" + ar.getGenero() + "</a></h3>");
                        out.println("<p>" + ar.getNacionalidad() + "</p></div>");
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
  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <%
            if (usuario.isAdmin()){ %>
                <a href='borraGenero.jsp?gen=<% out.print(geni); %>' onclick='alert("Esto no se puede deshacer")' >Borrar Genero?</a>
            <% }
        %>
    </div>
    <div class="span-7 prepend-1 append-1 last">

    </div>
  </div>
<%@ include file="standardFooter.xhtml" %>
