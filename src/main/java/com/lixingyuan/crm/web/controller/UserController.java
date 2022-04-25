package com.lixingyuan.crm.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/settings/user/save.do")
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("用户进入控制器");
        String path = request.getServletPath();
        if("/settings/user/xxx.do".equals(path)){

        }else if("/settings/user/xx.do".equals(path)){

        }
    }
}
