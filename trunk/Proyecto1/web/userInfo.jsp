<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />
<%@ include file="standardHeader.xhtml" %>

<%@ include file="auth.jspf" %>

<%@include  file="standardFooter.xhtml"%>