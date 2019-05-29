package com.wj04.controller;

import com.wj04.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 响应数据和结果视图
 *      返回值分类：
 *          字符串
 *          void
 *          ModelAndView对象
 *
 *      使用关键字转发和重定向，使用了这个就不能使用视图了
 *
 */

@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping("testString")
    public String testString(Model model) {
        System.out.println("testString");
        User user = new User();
        user.setUsername("test1");
        user.setPassword("123");
        user.setAge(11);
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("testVoid")   //如果没有设置，默认寻找当前请求路径下面的testVoid.jsp页面 (可以使用原生Servlet的转发和重定向)
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid");
        //1.转发
       /* request.getRequestDispatcher("/success.jsp").forward(request,response); //手动转发，不会再去执行视图解析器中的内容，此处执行完毕，后续代码还会继续执行
        //可以使用return
        return;*/

        //2.重定向
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        //3.直接响应
        //设置中文乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("hello 中国");
    }


    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername("test2");
        user.setPassword("123456");
        user.setAge(12);
        modelAndView.addObject("user",user);
        //设置调整页面
        modelAndView.setViewName("success");
        return modelAndView;

    }

    /**
     * 使用关键字方法实现转发或重定向
     * @return
     */
    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect");
        //请求转发
//        return "forward:/success.jsp";

        //请求重定向
        return "redirect:/index.jsp";
    }

    /*
    * 使用@ResponseBody注解实现将controller方法返回对象转换为json响应给客户端
    * Springmvc默认的是使用MappingJacksonHttpMessageConverter，对json数据进行转换，需要加入jackson的包
    * */

    @RequestMapping("testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax");
        System.out.println(user);
        //响应
        user.setUsername("哈哈");
        user.setAge(40);
        return user;
    }

}
