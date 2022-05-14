package ua.kharkov.kpi.jmt.servlet;

import ua.kharkov.kpi.jmt.XMathApiClient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(XMathApiClient.getRandomExpression());

        StringBuilder outputBuilder = new StringBuilder();

        outputBuilder.append("<h2>Welcome</h2>");
        outputBuilder.append("<p>This is my servlet</p>");

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(outputBuilder);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
