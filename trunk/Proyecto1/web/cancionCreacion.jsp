<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />


    <%
    if (request.getParameter("nomSon")==null||request.getParameter("anio")==null||request.getParameter("nomArt")==null||request.getParameter("genArt")==null){
                     %><jsp:forward page="homeScreen.jsp"><jsp:param name="error" value="si" /></jsp:forward><%
    }
    String nomS,a�o,nomArt,genArt;
    nomS = request.getParameter("nomSon");
    a�o = request.getParameter("anio");
    nomArt = request.getParameter("nomArt");
    genArt = request.getParameter("genArt");

    boolean funcio = matri.agregarCancion(nomS, a�o, nomArt, genArt);

    if (funcio) {
                                     %><jsp:forward page="buscaArtista.jsp"><jsp:param name="nombre" value="<%= nomArt %>" /><jsp:param name="genero" value="<%= genArt %>" /></jsp:forward><%
        }
    else { %><jsp:forward page="buscaArtista.jsp"><jsp:param name="error" value="si" /></jsp:forward><%}
    %>
    
