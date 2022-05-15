package ua.kharkov.kpi.jmt.servlet;

import ua.kharkov.kpi.jmt.XMathApiClient;
import ua.kharkov.kpi.jmt.model.User;
import ua.kharkov.kpi.jmt.repository.UserDAO;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "UserTestServlet", value = "/UserTestServlet")
public class UserTestServlet extends HttpServlet {

    @Inject
    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(XMathApiClient.getRandomExpression());

        StringBuilder outputBuilder = new StringBuilder();

        outputBuilder.append("<h2>Welcome to UserTestServlet</h2>");
        outputBuilder.append("<p>This servlet purpose is to show how User and User DAO works</p>");

        long userCount = userDAO.getUserCount();
        outputBuilder.append("<p>Total user count right now : ")
                .append(userCount)
                .append("</p>");

        // create new user and set some params
        User user = new User();
        user.setEmail("myMiLo.gmail");
        user.setUsername("__Coyote__");
        user.setPassword("MyMyMyPass");
        user.setDateOfRegistration(new Date(2022, 5, 15));
        //INSERT INTO public.account
        // (user_id, email, username, password, date_of_registration, photo)
        // VALUES (DEFAULT, 'bebra@gmai.com', 'fkejwkfjw', '1234203', '2022-05-15', null)

        userDAO.save(user); // save new user
        outputBuilder.append("<p>User : ").append(user).append(" added</p>");
        outputBuilder.append("<p>Total user count right now : ")
                .append(userCount)
                .append("</p>");

        // find user in db
        user = userDAO.findUserByUsername("__Coyote__");

        userDAO.remove(user); // remove newly created user
        outputBuilder.append("<p>User was remove</p>");
        outputBuilder.append("<p>Total user count right now : ")
                .append(userCount)
                .append("</p>");

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(outputBuilder);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

}
