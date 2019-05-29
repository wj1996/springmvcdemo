package com.wj02.controller;

import com.wj02.domain.Account;
import com.wj02.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 参数绑定
 */
@Controller
@RequestMapping("param")
public class ParamController {


    @RequestMapping("test")
    public String testParam(String username) {
        System.out.println("执行了 " + username);
        return "success";
    }

    @RequestMapping("save")
    public String saveAccount(Account account) {
        System.out.println(account.toString());
        return "success";
    }

    @RequestMapping("save2")
    public String saveAccount(User user) {
        System.out.println(user.toString());
        return "success";
    }

    /**
     * 原生的ServletAPI
     */
    @RequestMapping("getServlet")
    public void getServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        System.out.println(request.getParameter("id"));
        HttpSession session = request.getSession();
        ServletContext servletContext = session.getServletContext();
        System.out.println(session);
        System.out.println(servletContext);
        System.out.println(response);
    }

}
