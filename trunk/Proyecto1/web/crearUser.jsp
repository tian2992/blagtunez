<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="page"/>
<jsp:setProperty name="usuario" property="*"/>

<%
if (usuario != null){
boolean isUser = blagtunez.UserManager.a�adirUser(usuario);
if (isUser){ %>
<jsp:forward page="login.jsp" />
<% }
}

%>