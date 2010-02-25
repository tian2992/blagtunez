<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:setProperty name="usuario" property="*"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>
  <div class="span-15" id="main">
        <%
        boolean user = blagtunez.UserManager.autenticar(usuario.getUsername(), usuario.getPass());
        if (user){
        session.setAttribute("login", true); %>
        <h1 class="greet">Inicio Exitoso</h1>
        <jsp:forward page="homeScreen.jsp" />


        <% } else { %>
        <h1 class="greet red">Inicio Fallido</h1>
        <jsp:forward page="homeScreen.jsp" />
        <% } %>
 </div>
 <%@ include file="standardFooter.xhtml" %>