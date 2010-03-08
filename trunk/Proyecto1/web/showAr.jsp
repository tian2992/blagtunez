<%@ include file="standardHeader.jsp" %>


  <%@ include file="auth.jspf" %>

  <%
    if (request.getParameter("artista")==null){
       %><jsp:forward page="homeScreen.jsp"></jsp:forward><%
    }
    blagtunez.artista a = matri.buscarArtista(request.getParameter("artista"));
    if (a==null){
       %><jsp:forward page="homeScreen.jsp"></jsp:forward><%
    }
  %>
  <jsp:forward page="buscaArtista.jsp"><jsp:param name="nombre" value="<%= a.getNombre() %>" /><jsp:param name="genero" value="<%= a.getGenero() %>" /></jsp:forward>