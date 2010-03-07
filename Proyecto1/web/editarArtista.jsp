<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />

<%
    if (!usuario.isAdmin()){ %>
        <jsp:forward page="buscaArtista.jsp"><jsp:param name="error" value="noAuto" /></jsp:forward>
   <% }
    String ariNon = blagtunez.stringFixer.toUTF8(request.getParameter("ariNon"));
    String ariGen = blagtunez.stringFixer.toUTF8(request.getParameter("ariGen"));

    if (request.getParameter("nombre")==null||request.getParameter("nacionalidad")==null||request.getParameter("imagen")==null||request.getParameter("genero")==null){
        %><jsp:forward page="buscaArtista.jsp"><jsp:param name="nombre" value="<%= ariNon %>" /><jsp:param name="genero" value="<%= ariGen %>" /><jsp:param name="error" value="si" /></jsp:forward><%
    }

    String arNon = blagtunez.stringFixer.toUTF8(request.getParameter("nombre"));
    String geNon = blagtunez.stringFixer.toUTF8(request.getParameter("genero"));
    String naNon = blagtunez.stringFixer.toUTF8(request.getParameter("nacionalidad"));
    String imNon =  blagtunez.stringFixer.toUTF8(request.getParameter("imagen"));

    blagtunez.artista arti = new blagtunez.artista(arNon,geNon,naNon,imNon);

    if (arti.getNombre()==null||arti.getGenero()==null){
       %><jsp:forward page="buscaArtista.jsp"><jsp:param name="nombre" value="<%= ariNon %>" /><jsp:param name="genero" value="<%= ariGen %>" /><jsp:param name="error" value="si" /></jsp:forward><%
    }
    if (arti.getNombre().equals("")||arti.getGenero().equals("")){
       %><jsp:forward page="buscaArtista.jsp"><jsp:param name="nombre" value="<%= ariNon %>" /><jsp:param name="genero" value="<%= ariGen %>" /><jsp:param name="error" value="si" /></jsp:forward><%
    }
    blagtunez.artista deArimasu = matri.buscarArtista(new blagtunez.artista(ariNon,ariGen),true);
    if (deArimasu == null){ %>
        <jsp:forward page="buscaArtista.jsp"><jsp:param name="nombre" value="<%= ariNon %>" /><jsp:param name="genero" value="<%= ariGen %>" /><jsp:param name="error" value="si" /></jsp:forward>
    <% }

    matri.reemplazarArtista(deArimasu,arti,true);

    //boolean furcio = matri.borrarArtista(deArimasu);
    //boolean funcio = matri.agregarArtista(arti);
    //arti.setLisCan(deArimasu.getLisCan());
    %>
    <jsp:forward page="reporteArtistas.jsp"></jsp:forward>