<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:setProperty name="usuario" property="*"/>
<%
boolean user = blagtunez.UserManager.autenticar(usuario.getUsername(), usuario.getPass());
if (user){ %>
<jsp:forward page="homeScreen.jsp" />
<% } else { %>
<jsp:forward page="index.jsp" />
<% } %>