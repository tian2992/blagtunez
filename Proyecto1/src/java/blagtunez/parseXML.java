package blagtunez;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.*;
import org.jdom.input.*;
import java.io.*;


/**
 *
 * @author tian
 */
public class parseXML extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            MatrixManager matricial = new MatrixManager();

            FileInputStream fis = new FileInputStream("/home/tian/ArchivoXML.xml");

            SAXBuilder builder = new SAXBuilder();
            Document doc = null;

            doc = builder.build(fis);



            java.util.List<Element> rootitu = doc.getContent();

            //Element e = doc.getDocument().

            for (Element x : rootitu) {
                java.util.List<Element> artiList = x.getChildren();
                for (Element arti : artiList) {

                    artista interpre = new artista();
                    interpre.setNombre(arti.getChildTextNormalize("artista-nombre"));
                    interpre.setGenero(arti.getChildTextNormalize("genero-musical"));
                    interpre.setNacionalidad(arti.getChildTextNormalize("artista-nacionalidad"));
                    interpre.setImagen(arti.getChildTextNormalize("artista-imagen"));
                    matricial.agregarArtista(interpre, true);
                    out.println(interpre);
                    //System.out.println(arti.getChild("artista-nombre").getText());

                    java.util.List<Element> songList = arti.getChild("canciones").getChildren();
                    for (Element sogo : songList) {
                        cancion songi = new cancion(sogo.getChildText("nombre"),  Integer.parseInt(sogo.getChildText("anio")), interpre);
                        matricial.agregarCancion(songi, true);
                        out.println(songi);
                        //System.out.println("\t" + sogo.getChildText("nombre"));
                    }
                }
            }

            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet parseXML</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet parseXML at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        }
        catch (Exception e){}
        finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
