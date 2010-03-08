package blagtunez;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class mail {

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

}
