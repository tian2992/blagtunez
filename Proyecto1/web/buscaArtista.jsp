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
                        out.println("<li>" +
                                "<div class='canDisplay'><h2>"+songi.toString()+"<a href='borrarCancion.jsp?artista="+artuditu.getNombre()+"&genero="+artuditu.getGenero()+"&cancion="+songi.getNombre()+"'><img src='PICS/user-trash.png' alt='borrar' /></a></h2>" +
                                ""+
                                "</div>" +
                                "</li>");
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

<%@ include file="standardFooter.xhtml" %>