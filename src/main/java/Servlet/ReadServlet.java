package Servlet;

import Service.UserService;
import User.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/read")
    public class ReadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        UserService userService = UserService.getInstance();
        List<User> col = userService.getAllUsers();
        for (User st : col) {

            long id = st.getId();
            req.setAttribute("id", id);

            String name = st.getName();
            req.setAttribute("name", name);

            String login = st.getLogin();
            req.setAttribute("login", login);

            String password = st.getPassword();
            req.setAttribute("password", password);
        }
        req.setAttribute("col", col);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/read.jsp");
        dispatcher.forward(req, resp);

    }
}
