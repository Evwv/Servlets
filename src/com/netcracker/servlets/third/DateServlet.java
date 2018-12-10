package com.netcracker.servlets.third;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String timeStamp = new SimpleDateFormat("yyyy:MM:dd__HH:mm:ss").format(Calendar.getInstance().getTime());
        String userAgent = req.getHeader("User-Agent");
        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello my friend</h1>"+
                "<br><br>"+"<h2>" +
                "Your date and time : " +
                timeStamp + "</h2>" +
                "<br><br>"+"<h2>Name your browser</h2>" +
                userAgent);
    }
}
