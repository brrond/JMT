package ua.kharkov.kpi.jmt.servlet;

import ua.kharkov.kpi.jmt.util.HTMLPage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistrationServlet", value = "/registration")
@MultipartConfig(maxFileSize = 1024 * 1024)
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String outputBuilder = HTMLPage.getDOCTYPE() +
                HTMLPage.getHeader("Welcome") +
                HTMLPage.getBody1() +
                "<h1>Welcome to our community!</h1>" +
                "<br><br>Some useful links:<br>" +
                "<a href='play'>Play</a><br>" +
                "<a href='personal_page'>Personal page</a>";

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(outputBuilder);
        out.close();
    }
}
