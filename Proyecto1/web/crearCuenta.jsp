<%@ include file="standardHeader.jsp" %>
  <div class="span-15" id="main">
    <div>
        <h1>Ingresa tu informacion para registrate</h1>
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
        <h2>�Porque necesitamos esta info de ti?</h2>
        <ul>
            <li>Necesitamos asecharte</li>
            <li>Adem�s necesitamos tu mail para poder enviarte mucho SPAM</li>
            <li>Adem�s te mantendremos informado de todo lo que necesites</li>
        </ul>
    </div>
  </div>
 <%@ include file="standardFooter.xhtml" %>