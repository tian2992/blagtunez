<%@ include file="standardHeader.jsp" %>
<jsp:useBean id="userMan" class="blagtunez.UserManager" scope="page" />


<% if (!usuario.isAdmin()){ %>
    <jsp:forward page="noPermitido.jsp"><jsp:param name="error" value="noAuto" /></jsp:forward>
<% } %>

  <div class="span-15" id="main">
      <h1>Tareas Administrativas</h1>
      <script src="jquery-1.4.2.js" type="text/javascript"></script>
      <script src="importXML.js" type="text/javascript"></script>

      <h2>Importar XML</h2>
      <a id="importa" href="parseXML">Importar XML</a>
      <div class="contenidoso">
          
      </div>
      <h2>Gestor de Usuarios</h2>
      <ul>
      <!-- TODO: hacer el gestor de usuarios -->
      <%
        for (blagtunez.Usuario us: userMan.getUserList()){ %>
            <li><%= us.getNombre() %></li>

        <% }
      %>
      <!-- cambiar artista
      hacer prefijo de imagenes
      -->
      </ul>
      
  </div>

    <div class="span-9 last" id="sidebar">
        <div class="span-7 prepend-1 append-1 last">

        </div>
    </div>


<%@ include file="standardFooter.xhtml" %>