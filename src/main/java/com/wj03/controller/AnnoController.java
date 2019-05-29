package com.wj03.controller;

import com.wj02.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 常用注解：
 *      RequestParam：把请求中指定名称的参数给控制器中的形参赋值
 *          属性：
 *              value：请求参数的名称
 *              required：请求参数中是否必须提供此参数，默认值：true，表示必须提供，如果不提供报错
 *      RequestBody: 用于获取请求体内容，直接得到的是key==value&key=value...结构的数据
 *          属性：
 *              required：是否必须有请求体，默认值：true。get请求会报错，取值为false，get请求得到的为null
 *      PathVaribale:
 *          用于绑定URL中的占位符，例如：请求URL中 /delete/{id} 这个{id}就是URL占位符。
 *          URL支持占位符是spring3.0之后加入的，是springmvcz支持rest风格URL的一个重要标志
 *          属性：
 *              value：用于指定URL中占位符名称
 *              required：是否必须提供占位符
 *      REST风格URL
 *          目前主流的三种web服务交互方案中，REST相比于SOAP以及XML-RPC更加简单明了，无论是对URL的处理还是对Payload的编码，REST更倾向
 *          用更加简单轻量的方法设计和实现，值得注意的是，REST并没有一个明确的标准，而更像一种设计的风格。
 *          特点：
 *              结构清晰，符合标准，易于理解，扩展方便。
 *          restful风格：
 *              资源
 *              表现层
 *              状态转化
 *                  HTTP协议中，GET，POST，PUT，DELETE
 *        RequestHeader:
 *              获取请求头
 *        CookieValue:
 *              属性：
 *                  value
 *                  required
 *        ModelAttribute
 *              该注解是springmvc4.3以后加入的，可以用于修饰方法和参数
 *              出现在方法上，表示当前方法会在控制器的方法执行之前先执行，可以修饰没有返回值的方法，也可以修饰有具体返回值的方法
 *              出现在参数上，获取指定的数据给参数赋值
 *              属性：
 *                  value：用户获取数据的key。key可以是POJO的属性名称，也可以是map结构的key
 *              应用场景：
 *                  当表单提交的不是完整的实体数据式，保证没有提交的数据字段使用数据库对象原来的数据
 *
 *        SessionAttributes: 只能作用在类上面
 *              用于多次执行控制器方法间的参数共享
 *              属性：
 *                  value：指定存入的属性的的名称
 *                  type：指定存入的数据类型
 *
 *
 */
@Controller
@RequestMapping("anno")
@SessionAttributes(value = {"msg"}) //把msg = 美美 存入session域对象中
public class AnnoController {


    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam("name") String username) {
        System.out.println(username);
        return "success";
    }

    @RequestMapping("testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    @RequestMapping("testPathVaribale/{id}")
    public String testPathVaribale(@PathVariable(name="id") String id) {
        System.out.println(id);
        return "success";
    }

    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println(header);
        return "success";

    }

    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println(cookieValue);
        return "success";

    }

    @RequestMapping("testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute 执行了");
        System.out.println(user);
        return "success";
    }

    @RequestMapping("testSessionAttribute")
    public String testSessionAttribute(Model model) {
        model.addAttribute("msg","美美");
        return "success";
    }

    /**
     * 获取值
     * @param model
     * @return
     */
    @RequestMapping("getSessionAttribute")
    public String getSessionAttribute(ModelMap model) {
        System.out.println(model.get("msg"));
        return "success";
    }


    /**
     * 有返回值的
     */
    /**
     * 改方法先执行
     */
   /* @ModelAttribute
    public User showUser(String id) {
        System.out.println("showUser 执行了 " + id);
        *//*通过id查询user，模拟数据库*//*
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setDate(new Date());
        user.setName("test");
        return user;
    }*/


    /**
     * 无返回值的
     * @param id
     * @return
     */
    /*@ModelAttribute
    public void showUser(String id, Map<String,User> map) {
        System.out.println("showUser 执行了 " + id);
        *//*通过id查询user，模拟数据库*//*
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setDate(new Date());
        user.setName("test");
        map.put("abc",user);
    }*/
}
