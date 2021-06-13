package com.example.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignInServlet", value = "/SignInServlet")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Process(request, response);
    }

    public void Process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String radio = request.getParameter("radios");
        PrintWriter writer = response.getWriter();
        String answer = "";

        if(radio.equals("1"))
            answer = "radio:1";
        else if(radio.equals("2"))
            answer ="radio:2";
        else if(radio.equals("3"))
            answer = "radio:3";

        writer.println(answer);
    }
}
