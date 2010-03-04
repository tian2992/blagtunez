<%@ include file="standardHeader.jsp" %>
<jsp:useBean id="arti" class="blagtunez.artista" scope="page" />
<jsp:setProperty name="arti" property="*"/>

  <div class="span-15" id="main">
      <h1>Resultados de la Busqueda</h1>
      
      <% blagtunez.artista artuditu = null;
         artuditu = matri.buscarArtista(arti);
         out.println("<div class='searchResults'>");
         if (artuditu != null){
            out.println("<p class='explica'>Listado para: <span class='rojo'>"+artuditu.getNombre()+"</span></p>");
            java.util.List<blagtunez.cancion> lisCan = artuditu.getLisCan();
            if (!lisCan.isEmpty()){
                out.println("<ul class='lisCan'>");
                    for (blagtunez.cancion songi : lisCan){
                        out.print("<li class='canDisplay'>" +
                                "<h2>"+songi.toString());
                        if (usuario.isAdmin()) {out.print("<a class='delus' href='borraRola.jsp?artista="+blagtunez.stringFixer.urlEncode(artuditu.getNombre())+"&amp;genero="+blagtunez.stringFixer.urlEncode(artuditu.getGenero())+"&amp;cancion="+blagtunez.stringFixer.urlEncode(songi.getNombre())+"'><img src='PICS/user-trash.png' alt='borrar' /></a>"); }
                        out.print("</h2></li>");
                    }
                out.println("</ul>");
            }
            else {
                out.println("<div class='success'>Este artista no tiene Canciones</div>");
            }

         }
         else{
             out.println("<div class='notice'><img src='PICS/emblem-important.png' alt='importante' />Tu busqueda fue fallida, intenta <a href='homeScreen.jsp'>buscar de nuevo</a></div> ");
             }
         out.println("</div>");
         %>
</div>

  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <% if (usuario.isAdmin()) { %>
        
        <h2>Agregar Cancion</h2><% if (artuditu!=null){ %>
          <form charset="UTF-8" id="agregaCancion" action="cancionCreacion.jsp" method="POST">
              <fieldset>
              <label class="formCap">Nombre: </label><input type="text" class="text" name="nomSon" id="nomSon" value="" size="20" /><br/>
              <label class="formCap">Año: </label><input type="text" class="text" name="anio" id="anio" value="" size="20" /><br />
              <input type="hidden" name="nomArt" id="nomArt" value="<% out.print(artuditu.getNombre()); %>" />
              <input type="hidden" name="genArt" id="genArt" value="<% out.print(artuditu.getGenero()); %>" />
              <input id="creRola" type="submit" value="Agregar Cancion" /><br />
              </fieldset>
          </form>
            <script src="jquery-1.4.2.js" type="text/javascript"></script>
            <script src="modRola.js" type="text/javascript"></script>
          <% } else { %>
          <p class="">El artista no fue encontrado, no puedes añadir Canciones</p>
          <% }

           }  %>
    </div>
  </div>


<%@ include file="standardFooter.xhtml" %>