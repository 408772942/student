package com.lin.controller;



import com.lin.model.Score;
import com.lin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    //登陆界面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest request){
        if(request.getSession().getAttribute("position")!=null){
            return  new ModelAndView("login_again.html");
        }else {
            return new ModelAndView("login.html");
        }
    }
    //验证登陆
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        return studentService.login(request);
    }
    //查看签到科目
    @RequestMapping(value = "/student/sign")
    public String signPage(HttpServletRequest request, Model model){
        return studentService.signPage(request,model);
    }
    //进行签到
    @RequestMapping(value = "/student/sign/{subjectid}")
    public String sign(HttpServletRequest request, @PathVariable Integer subjectid) {
        return  studentService.sign(request, subjectid);
    }
    //查看成绩
    @RequestMapping(value = "/student/score")
    public String  score(HttpServletRequest request,Model model){
        return studentService.score(request,model);
    }
    //查看课程
    @RequestMapping(value = "/student/subject")
    public String subject(HttpServletRequest request,Model model){
        return studentService.subject(request,model);
    }
    //修改密码
    @RequestMapping(value = "/student/passwd/{password}")
    public String passwd(HttpServletRequest request,@PathVariable String password){
        return studentService.passwd(request,password);
    }

}
