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
    public static String blagg = "";

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
            /*
            MatrixManager matriz = new MatrixManager();
            if (matriz.agregarArtista("Daft Punk", "Electronica"))
                out.println("ya va uno");
            if (matriz.agregarArtista("Timmy", "Timmi!")){
                out.println("van dos :D");
            }



            out.println(matriz.estadoDeMatriz());
             *
             * */
            out.println(UserManager.lisUser);
            for (Usuario us: UserManager.lisUser){
                out.println(us);
            }

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
        }
        catch (Exception e){
            out.println(e.toString());
            out.close();
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
