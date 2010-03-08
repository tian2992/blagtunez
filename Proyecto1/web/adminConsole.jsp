<%@ include file="standardHeader.jsp" %>
<jsp:useBean id="userMan" class="blagtunez.UserManager" scope="page" />


<% if (!usuario.isAdmin()){ %>
    <jsp:forward page="noPermitido.jsp"><jsp:param name="error" value="noAuto" /></jsp:forward>
<% } %>

  <div class="span-15" id="main">
      <h1>Tareas Administrativas</h1>

      <h2>Importar XML</h2>

      <script src="jquery-1.4.2.js" type="text/javascript"></script>
      <script src="importXML.js" type="text/javascript"></script>

      <form id="importa" action="parseXML" method="POST" target="iframeUpload" enctype="multipart/form-data">
          <input type="file" id="data" name="data" size="20" value="" />
          
          <input id="clicar" type="submit" value="CargarXML" />
      </form>
      <iframe id="iframeUpload" src="" style="display:none" >
      </iframe>
      
      <h2>Bitacora de Acciones</h2>

      <%
      String log = blagtunez.UserManager.getLog();
                if (request.getParameter("mail") == null) {
                    out.println("<a href='?mail=true'>Enviar Mail</a>");
                } else {
                    out.println(blagtunez.mail.sendMail(usuario.getEMail(), log, "Reporte de Acciones"));
                }
      %>
      <div id="divurcio">

<%= log %>
      </div>

      <h2>Gestor de Usuarios</h2>
      <ul>
      <%
        for (blagtunez.Usuario us: userMan.getUserList()){ %>
            <li <% if (us.isAdmin()){out.print("class='rojo'");} %>><%= us.getNombre() %> <a href="adminTask.jsp?us=<%= us.getUsername() %>">Cambiar Derechos</a> </li>
        <% }
      %>
      </ul>
      
      <h2>Prefijo de Imagenes</h2>
      <form action="adminTask.jsp" method="POST">
          <input class="text" type="text" id="prefix" name="prefix" size="20" value="<%= blagtunez.artista.getImagenPrefix() %>" />
          <input type="submit" value="Cambiar Prefijo" />
      </form>

  </div>

    <div class="span-9 last" id="sidebar">
        <div class="span-7 prepend-1 append-1 last">

        </div>
    </div>


<%@ include file="standardFooter.xhtml" %>