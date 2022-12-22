package com.example.testservlet;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HelloWorld", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private Jokes jokes;

    public void init() {

        jokes = new Jokes("/WEB-INF/classes/jokes.txt", this.getServletContext());

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>курсач</title>");
        out.println("<meta name=\"description\" content=\"курсач ок да\">");
        out.println("<meta name=\"keywords\" content=\"html tutorial template\">");
        out.println("</head>");

        out.println("<body>");

        out.println("<div>");
        out.println("<h2> Запросить анекдот: </h2>");
        out.println("<form action=\"\" method=\"POST\">");
        out.println("<input type=\"submit\" name=\"request\" value=\"Запросить!\" />");
        out.println("</form>");
        out.println("</div>");

        out.println("<div>");
        out.println("<textarea style=\"width: 584px; height: 115px;\">");
        out.println(jokes.getRandomJoke());
        out.println("</textarea>");
        out.println("</div>");


        out.println("</body>");

        out.println("</html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>курсач</title>");
        out.println("<meta name=\"description\" content=\"курсач ок да\">");
        out.println("<meta name=\"keywords\" content=\"html tutorial template\">");
        out.println("</head>");

        out.println("<body>");

        out.println("<div>");
        out.println("<h2> Запросить анекдот: </h2>");
        out.println("<form action=\"\" method=\"POST\">");
        out.println("<input type=\"submit\" name=\"request\" value=\"Запросить!\" />");
        out.println("</form>");
        out.println("</div>");

        out.println("<div>");
        out.println("<textarea style=\"width: 584px; height: 115px;\">");
        out.println(jokes.getRandomJoke());
        out.println("</textarea>");
        out.println("</div>");


        out.println("</body>");

        out.println("</html>");

    }

    public void destroy() {
    }
}