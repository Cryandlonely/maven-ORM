package com.cj.crm.web.controller;

import com.cj.crm.settings.domain.User;
import com.cj.crm.settings.service.Impl.UserServiceImpl;
import com.cj.crm.settings.service.UserService;
import com.cj.crm.utils.MD5Util;
import com.cj.crm.utils.PrintJson;
import com.cj.crm.utils.ServiceFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/settings/user/login.do")
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        String path = request.getServletPath();
        if("/settings/user/login.do".equals(path)){
            login(request,response);
        }else if("/settings/user/xx.do".equals(path)){

        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {

        String loginAct = request.getParameter("loginAct");
        String loginPwd = MD5Util.getMD5(request.getParameter("loginPwd"));
        String ip = request.getRemoteAddr();

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        try{

            User user = us.login(loginAct,loginPwd,ip);
            request.getSession().setAttribute("user",user);
            PrintJson.printJsonFlag(response,true);

        }catch (Exception e){

            e.printStackTrace();
            String msg = e.getMessage();
            Map<String,Object> map = new HashMap<>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);

        }
    }
}
