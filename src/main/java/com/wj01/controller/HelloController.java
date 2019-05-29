package com.wj01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器的类
 * RequestMapping注解：
 *      作用：用于建立请求URL和请求方法之间的对应关系，可以作用在方法和类上面
 *      属性：
 *          value 和 path 是一样的：用于指定请求路径
 *          method：用于指定请求的方式
 *          params: 里面写明参数后，要求前台必须要传递这个参数，否则不能被请求
 *                  用于限制请求参数的条件，支持简单的表达式，要求请求参数的key和value必须和配置的一样
 *                  例如：
 *                      params = {"accountName"} ,表示参数必须有accountName
 *                      params = {"money!100}  表示参数中money不能是100
 *          headers:用于指定限制请求消息头的条件
 *          注意：
 *              以上四个属性只要出现2个或以上时，他们的关系是与的关系
 */
@Controller
public class HelloController {


    @RequestMapping(path="/hello",params = {"username"})
    public String sayHello() {
        System.out.println("hello springmvc");
        return "success";
    }
}
