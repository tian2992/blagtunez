<%@ include file="standardHeader.jsp" %>

<%@ include file="auth.jspf" %>

  <div class="span-15" id="main">
    <div>
        <h1>Ingresa tu informacion para registrate</h1>
        <form charset="UTF-8" name="creation" action="#" method="POST" >
            <div class="formCaptions">
                <label class="formCapt">Nombre:</label><br /><input class="text" type="text" name="nombre" value="<%= usuario.getNombre() %>" size="20" /><br />
                <label class="formCapt">UserName:</label><br /><input class="text" type="text" name="username" value="<%= usuario.getUsername() %>" size="20" /><br />
                <label class="formCapt">E-Mail:</label><br /><input class="text" type="text" name="eMail" value="<%= usuario.getEMail() %>" size="20" /><br />
                <input  type="submit" value="Crear Cuenta" />
            </div>
        </form>
    </div>

  </div>
   <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <h2>¿Porque tienen tanta info de mi?</h2>
        <ul>
            <li>Necesitamos asecharte</li>
            <li>Además necesitamos tu mail para poder enviarte mucho SPAM</li>
            <li>Además te mantendremos informado de todo lo que necesites</li>
        </ul>
    </div>
  </div>

<%@include  file="standardFooter.xhtml"%>