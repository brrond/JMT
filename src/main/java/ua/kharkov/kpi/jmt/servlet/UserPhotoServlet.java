package ua.kharkov.kpi.jmt.servlet;

import ua.kharkov.kpi.jmt.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "UserPhotoServlet", value = "/UserPhotoServlet")
public class UserPhotoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String basePath = getServletContext().getInitParameter("upload.location");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        response.setContentType("image/jpeg");

        ServletOutputStream outStream = response.getOutputStream();
        FileInputStream fin;
        if(user.getPhotoPath() != null) fin = new FileInputStream(basePath + user.getPhotoPath());
        else fin = new FileInputStream(basePath + "0.png");

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(outStream);
        int ch;
        while((ch=bin.read())!=-1)
            bout.write(ch);

        bin.close();
        fin.close();
        bout.close();
        outStream.close();
    }
}
