package com.skynet.action;

import com.skynet.user.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class RegisterAction extends HttpServlet {

    private UserAction userAction;
    private HttpSession session;
    private User user;

    private String username;
    private String password;

    private int age = 0;
    private String sex;
    private String phone;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        user = new User();
        Map<String,String[]> parameter = request.getParameterMap();
        try {
            BeanUtils.populate(user,parameter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        session = request.getSession();
        userAction = new UserAction(user);

        if (register()){
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }


    }

    private boolean register(){
        if (user.getUsername()!=null&&user.getPassword()!=null&&user.getAge()!=null&&user.getSex()!=null&&user.getPhone()!=null){
            return userAction.register();
        }
        return false;
    }

}
