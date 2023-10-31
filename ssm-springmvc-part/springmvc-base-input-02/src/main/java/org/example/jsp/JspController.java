package org.example.jsp;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;

@Controller
@RequestMapping("jsp")
public class JspController {

    // TODO:快速查找视图,返回值先经过视图渲染再响应给客户端
    //      1.方法返回值是字符串
    //      2.不能添加@ResponseBody（它使得直接返回字符串给浏览器，不走视图解析器）
    //      3.返回值对应中间的视图名称即可。如视图前后缀是"/WEB-INF/views/", ".jsp"，返回值index拼接在中间没问题
    @GetMapping("index")
    public String index(HttpServletRequest request){
        request.setAttribute("data","hello jsp");
        return "index";
    }

    /**
     * 转发：只能转发给项目下的资源（如完整项目路径是http://localhost/springmvc，前面这部分不用返回）
     *   1.方法的返回值写成字符串
     *   2.不能添加responseBody注解
     *   3.返回的字符串前 forward: /转发地址
     */

    //转发
    @GetMapping("forward")
    public String forward(){
        System.out.println("JspController.forward");
        return "forward:/jsp/index";
    }

    /**
     * 重定向：可重定向到项目下资源 或 项目外资源
     *   1.方法返回值写成字符串类型
     *   2.不能添加responseBody注解
     *   3.返回字符串前面 redirect: /重定向的地址
     */
    /**
     *  路径细节：【不使用springmvc request response】。如完整项目路径是http://localhost/springmvc
     *     转发   项目下的资源跳转。路径： 项目下的地址  /jsp/index 忽略 applicationContext
     *     重定向 项目下的资源可以是项目外的地址  重定向属于二次请求  路径： 项目下的地址，需要全地址 /springmvc/jsp/index  不忽略 applicationContext
     *  重定向若定向到项目内资源，优化：
     *     不必写完项目路径，即资源的地址不需要写项目的根路径/springmvc！ 直接 /jsp/index
     *     这样转发和重定向的地址都一样了！  /jsp/index
     */

    //重定向
    @GetMapping("redirect")
    public String redirect(){
        System.out.println("JspController.redirect");
        return "redirect:/jsp/index";
        // return "redirect:http://www.baidu.com";  重定向到项目外资源百度
    }


}
