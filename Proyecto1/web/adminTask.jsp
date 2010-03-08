<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />


<%
    if (!usuario.isAdmin()){ %>
        <jsp:forward page="adminConsole.jsp"><jsp:param name="error" value="noAuto" /></jsp:forward>
   <% }
    if (request.getParameter("us")!=null){
        blagtunez.Usuario usi = blagtunez.UserManager.getUsuario(request.getParameter("us"));

        if (usi == null){
            %><jsp:forward page="adminConsole.jsp"><jsp:param name="error" value="si" /></jsp:forward><%
        }
        if (usi.isAdmin()&& !usi.getUsername().equals("admin"))
            usi.setAdmin(false);
        else
            usi.setAdmin(true);
    }
    else if (request.getParameter("prefix")!=null) {

        blagtunez.artista.setImagenPrefix(request.getParameter("prefix"));

        }
    else {
        %><jsp:forward page="adminConsole.jsp"><jsp:param name="error" value="si" /></jsp:forward><%
    }


  %> <jsp:forward page="adminConsole.jsp"></jsp:forward>