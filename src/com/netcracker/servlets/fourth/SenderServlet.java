package com.netcracker.servlets.fourth;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.*;


public class SenderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Parametrs parametrs = new Parametrs(req);
        User user = new User();
        PrintWriter out = resp.getWriter();
        if (parametrs.isValidEmail()) {

            try {
                MimeMessage message = new MimeMessage(user.getSession());
                message.setFrom(new InternetAddress(user.getUsername()));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(parametrs.getTo()));
                if (parametrs.isCc()) {
                    message.addRecipient(Message.RecipientType.CC, new InternetAddress(parametrs.getCc()));
                }
                message.setSubject(parametrs.getSubject());
                message.setText(parametrs.getText());
                Transport.send(message);
                out.print("<h1>Email successfully sent</h1>");
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        } else {
            out.print("<h1>An error has occurred! Repeat input</h1>");
        }
    }
}

