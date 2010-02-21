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

/**
 *
 * @author tian
 */
public class testServlet extends HttpServlet {

    static matriz matrix;

    public void init(){

    }
   
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
            matrix = new matriz();
            matrix.agregarNodo(new nodoEl('c',"rock"));
            matrix.agregarNodo(new nodoEl('c',"pop"));
            matrix.agregarNodo(new nodoEl('d',"pop"));
            matrix.agregarNodo(new nodoEl('e',"rock"));

            nodo q = matrix.buscarPorFila('c',"pop");

            out.println("letra : "+q.getLetrina());
            out.println("genero : "+q.getGenero());
            /*
            out.println(songi.getNombre());
            out.println("blag");

            songi.setNombre("gluglumi");
             */
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet artServ</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet artServ at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
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
