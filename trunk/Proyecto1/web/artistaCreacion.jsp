<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />
<jsp:useBean id="arti" class="blagtunez.artista" scope="page" />
<jsp:setProperty name="arti" property="*"/>

<%  //TODO: agregar solo si el usuario es administrador.
    boolean funcio = matri.agregarArtista(arti); ///vamos a deshabilitar por el momento
    funcio = true; //TODO quitar cuando matri.agregarArtista funcione bien
    if (funcio){   %>
            <jsp:forward page="homeScreen.jsp" />
<%      } else { %>
            <jsp:forward page="agregarArtista.jsp"><jsp:param name="error" value="si" /></jsp:forward>
<%      }
     %>