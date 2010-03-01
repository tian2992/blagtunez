<jsp:useBean id="usu" class="blagtunez.Usuario" scope="page"/>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:setProperty name="usu" property="*"/>
<%
blagtunez.Usuario usi = blagtunez.UserManager.autenticar(usu.getUsername(), usu.getPass());
if (usi!=null){
    usuario.setNombre(usi.getNombre());
    usuario.setEMail(usi.getEMail());
    usuario.setPass(usi.getPass());
    usuario.setAdmin(usi.isAdmin());
    usuario.setUsername(usi.getUsername());
    %>
    
<jsp:forward page="homeScreen.jsp" />
<% } else { %>
<jsp:forward page="index.jsp" />
<% } %>