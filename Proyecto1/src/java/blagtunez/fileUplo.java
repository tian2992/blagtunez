/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package blagtunez;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class fileUplo extends HttpServlet {
   
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

            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart){
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Parse the request

            java.util.List<FileItem> items = upload.parseRequest(request);


            java.util.Iterator iter = items.iterator();
            while (iter.hasNext()) {

                FileItem item = (FileItem) iter.next();

            if (!item.isFormField()) {
                out.print(item.getInputStream());
            }
            }
            //out.print(items.get(0).getOutputStream());

            }
            else {
                out.print("WTF!");
            }

            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet fileUplo</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet fileUplo at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        }
        catch (Exception e){
            out.print(e);
        }
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
