/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package blagtunez;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author tian
 */
public class mailer extends HttpServlet {

    public static String sendMail(String email,String content,String subject){
        try {
        Properties props = new Properties();

        String sendPass = "blag";
        String sendUsername = "blagtunez@sebastianoliva.com";

        String server = "box544.bluehost.com";
        String secure =  "false";
        int port = 26;

        props.setProperty("mail.smtp.host", server);
        props.setProperty("mail.smtp.starttls.enable",secure);
        props.setProperty("mail.smtp.port", port+"");

        props.setProperty("mail.smtp.user", sendUsername);
        props.setProperty("mail.smtp.auth", "true");


        Session chechon = Session.getDefaultInstance(props);


        MimeMessage message = new MimeMessage(chechon);

        message.setFrom(new InternetAddress(sendUsername));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

        message.setSubject(subject);
        message.setText(content,"UTF-8","html");



        Transport t = chechon.getTransport("smtp");

        t.connect(server, port, sendUsername,sendPass);

        t.sendMessage(message,message.getAllRecipients());

        t.close();

        return ("<div class='success'>El envio fue exitoso</div>");

        }
        catch (Exception e) {
        return ("<div class='error'>Algo salio mal, intentalo de nuevo</a>");
        }
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
            String email = request.getParameter("email");
            String content = request.getParameter("cont");
            String subject = request.getParameter("subj");

            if (email != null && content!=null && subject !=null){
                content = stringFixer.toUTF8(content);
            }




            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mailer</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mailer at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        }
        catch (Exception e) {
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
