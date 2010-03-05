<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />

<%
    if (!usuario.isAdmin()){ %>
        <jsp:forward page="reporteGenero.jsp"><jsp:param name="error" value="noAuto" /></jsp:forward>
   <% }
    if (request.getParameter("gen")==null){
      %><jsp:forward page="borraArtista.jsp"><jsp:param name="error" value="si" /></jsp:forward><%
    }

    String genero = request.getParameter("gen");

    boolean funcio = matri.borrarGenero(genero);

    if (funcio){   %>
            <jsp:forward page="homeScreen.jsp" />
<%      } else { %>
            <jsp:forward page="reporteGenero.jsp"><jsp:param name="gen" value="<% genero %>" /></jsp:forward>
<%      }
     %>