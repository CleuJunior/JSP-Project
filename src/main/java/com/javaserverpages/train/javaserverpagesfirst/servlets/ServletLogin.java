package com.javaserverpages.train.javaserverpagesfirst.servlets;

import com.javaserverpages.train.javaserverpagesfirst.dao.LoginRepositoryDAO;
import com.javaserverpages.train.javaserverpagesfirst.model.ModelLogin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
    Servlet sao Controllers -> ServletLoginController
 */
@WebServlet(urlPatterns = {"/ServletLogin", "/main/ServletLogin"}, name = "ServletLogin") /* Mapeamento de URL */
public class ServletLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final LoginRepositoryDAO loginDAO = new LoginRepositoryDAO();

    public ServletLogin() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String url = request.getParameter("url");


        try{

            if(login.isEmpty() || password.isEmpty())  {
                RequestDispatcher redirect = request.getRequestDispatcher("/index.jsp");

                request.setAttribute("msng", "Login and/or Password is empty!");
                redirect.forward(request, response);

            } else {

                ModelLogin modelLogin = null;
//                ModelLogin modelLogin = new ModelLogin(login, password);

                if(loginDAO.validateAuthentication(modelLogin)) {
                    request.getSession().setAttribute("user", modelLogin.getLogin());


                    if(url == null || url.equals("null")) {
                        url = "main/main.jsp";
                    }

                    RequestDispatcher redirect = request.getRequestDispatcher(url);
                    redirect.forward(request, response);


                } else{
                    RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");

                    request.setAttribute("msng", "Incorrect Login/Password");
                    redirect.forward(request, response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

            RequestDispatcher redirect = request.getRequestDispatcher("error.jsp");

            request.setAttribute("msng", e.getMessage());
            redirect.forward(request, response);
        }
    }
}
