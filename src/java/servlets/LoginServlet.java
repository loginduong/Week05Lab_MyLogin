package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 760483
 */
public class LoginServlet extends HttpServlet {
//if user session attribute exists go to home

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String logout = request.getParameter("logout");
        if (logout != null) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("logout", true);
        }

        User user = (User) session.getAttribute("user");
        if (user != null) {
            request.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                    .forward(request, response);
        }

        request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccountService as = new AccountService();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User newUser = as.login(username, password);

        //if empty username / password give invalid
        //if username / password do not match give invalid
        //if correct username / password make user attribute and go to home
        

            if (username == null || username.isEmpty() || password == null || password.isEmpty()
                    || newUser == null) {
                request.setAttribute("usernameInput", username);
                request.setAttribute("passwordInput", password);
                request.setAttribute("invalid", true);
                request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
                return;
            } else {
                session.setAttribute("user", newUser);
                response.sendRedirect("home");
                return;
            }
        
    }

}
