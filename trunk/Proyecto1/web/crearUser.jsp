<jsp:useBean id="addUss" class="blagtunez.Usuario" scope="page"/>
<jsp:setProperty name="addUss" property="*"/>

<%  // blagtunez.testServlet.blagg = blagtunez.testServlet.blagg+addUss;
    if (addUss!=null){
        if (blagtunez.UserManager.anadirUser(addUss)) { //si se pudo a�adir usuario %>
            <jsp:forward page="login.jsp" />
<%      } else { %>
            <jsp:forward page="crearCuenta.jsp"><jsp:param name="error" value="si" /></jsp:forward>
<%      }
    } %>