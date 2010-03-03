<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />

<%
    usuario.setNombre(null);
    usuario.setUsername(null);
    usuario.setEMail(null);
    usuario.setPass(null);
    usuario.setAdmin(false);
%>

<jsp:forward page="index.jsp" />