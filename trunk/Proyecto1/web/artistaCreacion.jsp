<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />
<jsp:useBean id="arti" class="blagtunez.artista" scope="page" />
<jsp:setProperty name="arti" property="*"/>

<%  
    if (!usuario.isAdmin()){ %>
        <jsp:forward page="agregaArtista.jsp"><jsp:param name="error" value="noAuto" /></jsp:forward>
   <% }
    boolean funcio = matri.agregarArtista(arti); ///vamos a deshabilitar por el momento
    funcio = true; //TODO quitar cuando matri.agregarArtista funcione bien
    if (funcio){   %>
            <jsp:forward page="homeScreen.jsp" />
<%      } else { %>
            <jsp:forward page="agregarArtista.jsp"><jsp:param name="error" value="si" /></jsp:forward>
<%      }
     %>