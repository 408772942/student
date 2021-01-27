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
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest request){
        if(request.getSession().getAttribute("position")!=null){
            return  new ModelAndView("login_again.html");
        }else {
            return new ModelAndView("login.html");
        }
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        return studentService.login(request);
    }
    @RequestMapping(value = "/student/sign/{subjectid}")
    public String sign(HttpServletRequest request, @PathVariable Integer subjectid) {
        studentService.sign(request, subjectid);
        return "sign_success";
    }
    @RequestMapping(value = "/student/score")
    public String  score(HttpServletRequest request,Model model){
        return studentService.score(request,model);
    }
    @RequestMapping(value = "/student/subject")
    public String subject(HttpServletRequest request,Model model){
        return studentService.subject(request,model);
    }






}
