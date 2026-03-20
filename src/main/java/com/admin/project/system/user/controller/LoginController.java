package com.admin.project.system.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.admin.framework.web.controller.BaseController;


/**
 * 登录验证
 * 
 * @author ruoyi
 */
@Controller
public class LoginController extends BaseController
{

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap mmap)
    {
        return "login";
    }
}
