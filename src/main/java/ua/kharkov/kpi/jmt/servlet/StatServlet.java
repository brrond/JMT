package ua.kharkov.kpi.jmt.servlet;

import ua.kharkov.kpi.jmt.model.Session;
import ua.kharkov.kpi.jmt.model.User;
import ua.kharkov.kpi.jmt.repository.SessionDAO;
import ua.kharkov.kpi.jmt.util.HTMLPage;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StatServlet", value = "/stat")
public class StatServlet extends HttpServlet {

    @Inject
    private SessionDAO sessionDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("personal_page");
            return;
        }

        List<Session> sessions = sessionDAO.findSessionsByUserId(user.getUserId());

        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append(HTMLPage.getDOCTYPE());
        outputBuilder.append(HTMLPage.getHeader("Personal page"));
        outputBuilder.append(HTMLPage.getBody1());

        outputBuilder.append("<h1>").append(user.getUsername()).append("'s statistic page</h1><br>");
        if(sessions.isEmpty()) {
           outputBuilder.append("<p>There are no sessions yet</p><br>");
        } else {
            outputBuilder.append("<table border='3'><tr>")
                    .append("<td>Date</td>")
                    .append("<td>Time</td>")
                    .append("<td>Speed</td>")
                    .append("</tr>");

            for (Session ses : sessions) {
                outputBuilder.append("<tr>")
                        .append("<td>").append(ses.getDate()).append("</td>")
                        .append("<td>").append(ses.getTime()).append("</td>")
                        .append("<td>").append(ses.getSpeed()).append("</td>")
                        .append("</tr>");
            }
            outputBuilder.append("</table><br>");
        }
        outputBuilder.append("<a href='personal_page'>Personal page</a>");

        outputBuilder.append(HTMLPage.getBody2());
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(outputBuilder);
        out.close();
    }
}
