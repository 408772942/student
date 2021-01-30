package com.lin.controller;

import com.lin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    //添加教务
    @RequestMapping(value = "/admin/center")
    public ModelAndView student(){
        return new ModelAndView("center_add.html");
    }
    @RequestMapping(value = "/admin/centerAdd")
    public String centerAdd(HttpServletRequest request){
        return adminService.centerAdd(request);
    }
    //删除教务
    @RequestMapping(value = "/admin/centerDel/{userid}")
    public String studentDel(@PathVariable Integer userid){
        return adminService.centerDel(userid);
    }
    //修改密码
    @RequestMapping(value = "/admin/passwd/{password}")
    public String passwd(HttpServletRequest request,@PathVariable String password){
        return adminService.passwd(request,password);
    }
    @RequestMapping(value = "/admin/selectPw/{userid}")
    public String selectPasswd(Model model, @PathVariable Integer userid){
        return adminService.selectPassword(model,userid);
    }
}
