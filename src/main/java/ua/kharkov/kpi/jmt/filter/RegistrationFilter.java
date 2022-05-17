package ua.kharkov.kpi.jmt.filter;

import ua.kharkov.kpi.jmt.model.User;
import ua.kharkov.kpi.jmt.repository.UserDAO;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

@WebFilter(filterName = "RegistrationFilter", servletNames = "RegistrationServlet")
public class RegistrationFilter extends HttpFilter {

    @Inject
    private UserDAO userDAO;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession(true); // obtain session

        if(session.getAttribute("user") != null) {
            req.getRequestDispatcher("personal_page").forward(req, res);
            return;
        }

        if(req.getParameter("email") != null) { // if it's new user
            session.setMaxInactiveInterval(7 * 24 * 60 * 60);
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            // TODO Check email & password

            Part photoPart = req.getPart("photo");
            // TODO Check photo cfg

            Date registrationDate = new Date(System.currentTimeMillis());
            String filePath = Math.abs(photoPart.getSubmittedFileName().hashCode() * registrationDate.hashCode() * System.currentTimeMillis()) + ".png";

            String basePath = getServletContext().getInitParameter("upload.location");

            User user;
            user = new User(email, username, password, registrationDate, null);
            if(!filePath.equals("0.png")) user.setPhotoPath(filePath);
            userDAO.save(user); // save new user in db
            if(!filePath.equals("0.png")) photoPart.write(basePath + filePath); // save img

            session.setAttribute("user", user);
        } else { // if we don't have user input
            res.sendRedirect("registration.html");
            return;
        }

        chain.doFilter(req, res);
    }
}
