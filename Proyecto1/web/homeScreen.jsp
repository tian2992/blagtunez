<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="standardHeader.xhtml" %>
<jsp:useBean id="usuario" class="blagtunez.Usuario" scope="session"/>
<jsp:useBean id="matri" class="blagtunez.MatrixManager" scope="application" />

  <div class="span-15" id="main">
      <h1 class="greet">Bienvenido a Blagtunes</h1>
      <p><% out.print(matri.estadoDeMatriz()); %></p>
  </div>
  <div class="span-9 last" id="sidebar">
    <div class="span-7 prepend-1 append-1 last">
        <p class="saludo">
        Hola: <jsp:getProperty name="usuario" property="username" />
        Hola <% out.print(usuario.getNombre()); %>

        </p>
    </div>
  </div>
<%@ include file="standardFooter.xhtml" %>