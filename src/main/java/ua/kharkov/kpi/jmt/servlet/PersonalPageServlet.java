package ua.kharkov.kpi.jmt.servlet;

import ua.kharkov.kpi.jmt.model.User;
import ua.kharkov.kpi.jmt.util.HTMLPage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.websocket.Session;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonalPageServlet", value = "/personal_page")
public class PersonalPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        if(user == null) {
            request.getRequestDispatcher("personal_page").forward(request, response);
            return;
        }

        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append(HTMLPage.getDOCTYPE());
        outputBuilder.append(HTMLPage.getHeader("Personal page"));
        outputBuilder.append(HTMLPage.getBody1());

        outputBuilder.append("<h1>").append(user.getUsername()).append("'s personal page</h1><br>");
        outputBuilder.append("<img width='200px' alt=\"NoImg\" src=\"")
                .append("UserPhotoServlet")
                .append("\"><br><br>");

        outputBuilder.append("<a href='./play.jsp'>Play game</a><br>");
        outputBuilder.append("<a href='./logout.jsp'>Logout</a>");

        outputBuilder.append(HTMLPage.getBody2());
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(outputBuilder);
        out.close();
    }
}
