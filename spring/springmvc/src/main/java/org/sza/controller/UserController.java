package org.sza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//定义Controller，使用@Controller定义Beans
@Controller
public class UserController {
    //设置当前访问路径，使用@RequestMapping
    @RequestMapping("/save")
    //设置当前对象的返回值类型
    @ResponseBody
    public String save() {
        System.out.println("save");
        return "{'module':'SpringMVC '}";
    }
}
