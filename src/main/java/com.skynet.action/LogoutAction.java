package com.skynet.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutAction extends HttpServlet {

    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();

        if (logout()){
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }

    }

    private boolean logout(){
        if (session.getAttribute("username")!=null){
            session.removeAttribute("username");
            session.invalidate();
            return true;
        }
        return false;
    }
}
