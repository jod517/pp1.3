package Servlet;

import Service.UserService;
import User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("col", userService.getUserById(Long.parseLong(id)));
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        userService.updateUser(new User(id , name, login , password));

        response.sendRedirect("/preproject1_war_exploded/read");
    }
}
