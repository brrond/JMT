package ua.kharkov.kpi.jmt.servlet;

import org.postgresql.util.PGInterval;
import org.postgresql.util.PGTimestamp;
import ua.kharkov.kpi.jmt.model.Session;
import ua.kharkov.kpi.jmt.model.User;
import ua.kharkov.kpi.jmt.repository.SessionDAO;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

@WebServlet(name = "SaveSessionServlet", value = "/save_session")
public class SaveSessionServlet extends HttpServlet {

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
        String time = request.getParameter("time");

        Session session2Save = new Session();
        session2Save.setDate(new Date(System.currentTimeMillis()));
        session2Save.setTime(new Time(System.currentTimeMillis()));
        session2Save.setSpeed(Double.valueOf(time));
        session2Save.setUserId(user.getUserId());
        sessionDAO.save(session2Save);

        response.sendRedirect("./play.jsp");
    }
}
