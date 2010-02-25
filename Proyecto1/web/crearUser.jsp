<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="page"/>
<jsp:setProperty name="usuario" property="*"/>

<%
if (usuario != null){
boolean isUser = blagtunez.UserManager.añadirUser(usuario);
if (isUser){ %>
<jsp:forward page="login.jsp" />
<% }
}

%>