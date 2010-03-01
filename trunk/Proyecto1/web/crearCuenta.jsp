<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>
  <div class="span-15" id="main">
    <div>
        <form charset="UTF-8" name="creation" action="crearUser.jsp" method="POST" >
            <div class="formCaptions">
                <label class="formCapt">Nombre:</label><br /><input class="text" type="text" name="nombre" value="" size="20" /><br />
                <label class="formCapt">UserName:</label><br /><input class="text" type="text" name="username" value="" size="20" /><br />
                <label class="formCapt">Password:</label><br /><input class="text" type="password" name="pass" value="" size="20" /><br />
                <label class="formCapt">E-Mail:</label><br /><input class="text" type="text" name="eMail" value="" size="20" /><br />
                <input type="submit" value="Crear Cuenta" />
            </div>
        </form>
    </div>

  </div>
   <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <h2>¿Porque necesitamos esta info de ti?</h2>
        <ul>
            <li>Necesitamos asecharte</li>
            <li>Además necesitamos tu mail para poder enviarte mucho SPAM</li>
            <li>Además te mantendremos informado de todo lo que necesites</li>
        </ul>
    </div>
  </div>
 <%@ include file="standardFooter.xhtml" %>