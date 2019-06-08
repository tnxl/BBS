package com.skynet.action;

import com.skynet.action.UserAction;
import com.skynet.user.User;
import org.apache.catalina.mbeans.MBeanUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class LoginAction extends HttpServlet {

    private User user;
    private UserAction userAction;
    private HttpSession session;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        session = request.getSession();

        user = new User();
        Map<String,String[]> parameter = request.getParameterMap();
        //自动分装对象属性
        try {
            BeanUtils.populate(user,parameter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userAction = new UserAction(user);
        if (login()){
            request.getRequestDispatcher("welcom.jsp").forward(request,response);
        }
    }

    private boolean login(){
        if (user.getUsername()!=null&&user.getPassword()!=null){

            if (userAction.login()){
                session.setAttribute("username",user.getUsername());
                return true;
            }
        }
        return false;
    }






}
