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

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.FileUpload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.util.*;
import org.apache.commons.fileupload.ParameterParser.*;
import org.apache.commons.io.*;


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
            
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);

            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Parse the request

            java.util.List<FileItem> items = upload.parseRequest(request);

            items.get(0).getOutputStream();

            //FileInputStream fis = new FileInputStream("/home/tian/ArchivoXML.xml");

            SAXBuilder builder = new SAXBuilder();
            Document doc = null;

            doc = builder.build(items.get(0).getInputStream());

            java.util.List<Element> rootitu = doc.getContent();

            for (Element x : rootitu) {
                java.util.List<Element> artiList = x.getChildren();
                out.println("<div class='noList'>");
                for (Element arti : artiList) {

                    artista interpre = new artista();
                    interpre.setNombre(arti.getChildTextNormalize("artista-nombre"));
                    interpre.setGenero(arti.getChildTextNormalize("genero-musical"));
                    interpre.setNacionalidad(arti.getChildTextNormalize("artista-nacionalidad"));
                    interpre.setImagen(arti.getChildTextNormalize("artista-imagen"));
                    matricial.agregarArtista(interpre, true);
                    out.println("<div class='artDisplay padEm'><h2>"+interpre.getNombre()+"</h2><ul>");

                    java.util.List<Element> songList = arti.getChild("canciones").getChildren();
                    for (Element sogo : songList) {
                        cancion songi = new cancion(sogo.getChildText("nombre"),  Integer.parseInt(sogo.getChildText("anio")), interpre); //si, le añadi inteprete por gusto
                        matricial.agregarCancion(songi, interpre, true);
                        out.println("\t<li>"+songi+"</li>");
                        //System.out.println("\t" + sogo.getChildText("nombre"));
                    }
                    out.println("</ul></div>");
                }
                out.println("</div>");
            }
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
