package swp391.fptqna.controllers;

import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@WebServlet(name = "SendMail", value = "/SendMail")
public class SendMail extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recipient's email ID needs to be mentioned.
        String to =(String) request.getAttribute("emailTo");

        String content = (String) request.getAttribute("reason");

        // Sender's email ID needs to be mentioned
        String from = "ducnttse150079@fpt.edu.vn";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.user", "ducnttse150079@fpt.edu.vn");
        properties.setProperty("mail.password","ducsinhvienfpt123@");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

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
            message.setSubject("This is the Subject Line!");

            // Send the actual HTML message, as big as you like
            message.setContent("<h1>" + content + "</h1>", "text/html" );

            // Send message
            Transport.send(message);
            String title = "Send Email";
            String res = "Sent message successfully....";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor = \"#f0f0f0\">\n" +
                    "<h1 align = \"center\">" + title + "</h1>\n" +
                    "<p align = \"center\">" + res + "</p>\n" +
                    "</body></html>"
         );
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
