<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>
  <div class="span-15" id="main">


 </div>
   <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <form  name = "creation" action = "crearUser.jsp" method = "POST" >
            <div class="formCaptions">
                <label class="formCapt">Nombre:</label><input class="text" type="text" name="nombre" value="" size="20" />
                <label class="formCapt">UserName:</label><input class="text" type="text" name="username" value="" size="20" />
                <label class="formCapt">Password:</label><input class="text" type="password" name="pass" value="" size="20" />
                <label class="formCapt">E-Mail:</label><input class="text" type="text" name="eMail" value="" size="20" />
                <input type="submit" value="Crear Cuenta" />
            </div>
        </form>
    </div>
  </div>
 <%@ include file="standardFooter.xhtml" %>