<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />


<%
    if (!usuario.isAdmin()){ %>
        <jsp:forward page="borraArtista.jsp"><jsp:param name="error" value="noAuto" /></jsp:forward>
   <% }
   if (request.getParameter("artuditu")==null){
      %><jsp:forward page="borraArtista.jsp"><jsp:param name="error" value="si" /></jsp:forward><%
    }
    String[] reqData = request.getParameter("artuditu").split("---");

    if (reqData.length>2){
        %><jsp:forward page="borraArtista.jsp"><jsp:param name="error" value="si" /></jsp:forward><%
    }
    
    blagtunez.artista arti = matri.buscarArtista(new blagtunez.artista(reqData[0],reqData[1]));

    if (arti==null){
        %><jsp:forward page="borraArtista.jsp"><jsp:param name="error" value="si" /></jsp:forward><%
    }

    boolean funcio = matri.borrarArtista(arti);
    if (funcio){   %>
            <jsp:forward page="homeScreen.jsp" />
<%      } else { %>
            <jsp:forward page="borraArtista.jsp"><jsp:param name="error" value="si" /></jsp:forward>
<%      }
     %>