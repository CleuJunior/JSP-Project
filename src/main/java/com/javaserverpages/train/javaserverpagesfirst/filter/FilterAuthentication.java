package com.javaserverpages.train.javaserverpagesfirst.filter;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/main/main.jsp"})
public class FilterAuthentication implements Filter { /* Intecepta todas as requisoçoes que vierem do projeto ou mapemento */

    public FilterAuthentication() { }


    /* Inicia os processos ou recursos quando um servidor sobe o projeto
    *
    * Iniciar a conexao com o banco
    * */

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }


    /* Intercepta as requisicoes e as respostas no sistema
     *
     * Tudo que fizer no sistema passa por ele
     *
     * Validacao de autenticacao
     *
     * Dar commit ou rolback de transacoes no banco
     *
     * Valirdar e fazer redirecionamento de paginas
     * */

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        String userLoggedIn = (String) session.getAttribute("user");

        String urlToAuthentication = req.getServletPath(); // Url que está sendo acessada


        /* Validar se está logado senao redireciona para a tela de login */

        if(userLoggedIn == null && !urlToAuthentication.equalsIgnoreCase("/main/ServletLogin")) {

            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/index.jsp?url=" + urlToAuthentication);
            servletRequest.setAttribute("msg", "Please make logging correctly");
            requestDispatcher.forward(servletRequest, servletResponse);

            return; /* Para a excucao e redireciona para o login */

        } else {
            filterChain.doFilter(servletRequest, servletResponse);

        }


    }

    /* Encerra os processos quando o servidor é parado
    *
    *  Mataria os processos de conexao com o banco
    * */

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
