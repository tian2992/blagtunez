<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />

    <%
    // este recibe rolas del tipo borrarRola.jsp?artista="+artuditu.getNombre()+"&genero="+artuditu.getGenero()+"&cancion="+songi.getNombre()+"

    if (request.getParameter("artista")==null||request.getParameter("genero")==null||request.getParameter("cancion")==null){
                      %><jsp:forward page="noPermitido.jsp"></jsp:forward><%
    }

    String art = request.getParameter("artista");
    String gen = request.getParameter("genero");
    String can = request.getParameter("cancion");

    boolean funcio = matri.borrarCancion(art, gen, can);

    if (funcio){ %>
        <jsp:forward page="homeScreen.jsp"></jsp:forward>
    <% }


    %>