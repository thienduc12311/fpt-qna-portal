package swp391.fptqna.controllers.manage;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet(name = "SendEmail", value = "/manage/SendEmail")
public class SendEmail extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recipient's email ID needs to be mentioned.
        String to =(String) request.getAttribute("emailTo");

        String content = (String) request.getAttribute("reason");

        // Sender's email ID needs to be mentioned
        String from = "ducnttse150079@fpt.edu.vn";

        // Assuming you are sending email from localhost
        String host = "localhost:8080";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
//        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
//        properties.setProperty("mail.user", "ducnttse150079@fpt.edu.vn");
//        properties.setProperty("mail.password","daaaa");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        // Get the default Session object.
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("huytnase150173@fpt.edu.vn", "abcd");
            }
        });

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("FPT Q&A Portal Notifications");

            // Send the actual HTML message, as big as you like
            String htmlContent = " <body style=\"font-family: Arial, Helvetica, sans-serif\">\n" +
                    "    <h1 style=\"color: #7e3af2\">\n" +
                    "      <span style=\"font-weight: bold\">FPT</span\n" +
                    "      ><span style=\"font-weight: normal\">QnA</span>\n" +
                    "    </h1>\n" +
                    "    \n" +
                    "    <!-- header for mail -->\n" +
                    "    <h3>"+ content +"</h3>\n" +
                    "\n" +
                    "    <!-- mail description -->\n" +
                    "    <p>If there was any mistake please reply this email</p>\n" +
                    "\n" +
                    "    <p style=\"font-size: 10px;\">Best regard,</p>\n" +
                    "    <p style=\"font-size: 10px;\">FPTQnA Portal team</p>\n" +
                    "  </body>\n" +
                    "</html>";
//            message.setContent("<h1>" + content + "</h1>", "text/html" );
            message.setContent(htmlContent, "text/html" );
            // Send message
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
