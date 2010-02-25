<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>
  <div class="span-15" id="main">


 </div>
   <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <form  name = "creation" action = "crearUser.jsp" method = "POST" >
            <div class="formCaptions">
                <div><span class="formCapt">Nombre: </span><input type="text" name="nombre" value="" size="20" /></div>
                <div><span class="formCapt">UserName: </span><input type="text" name="username" value="" size="20" /></div>
                <div><span class="formCapt">Password: </span><input type="password" name="pass" value="" size="20" /></div>
                <div><span class="formCapt">E-Mail: </span><input type="text" name="eMail" value="" size="20" /></div>
                <input type="submit" value="Crear Cuenta" />
            </div>
        </form>
    </div>
  </div>
 <%@ include file="standardFooter.xhtml" %>