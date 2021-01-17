package com.lin.controller;

import com.lin.model.Score;
import com.lin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;



@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/lgoin")
    public ModelAndView test(){
        return new ModelAndView("login.html");
    }
    @RequestMapping(value = "/loginTest")
    public String login(HttpServletRequest request){
        return studentService.login(request);
    }
    @RequestMapping(value = "/student/sign/{classid}")
    public String sign(HttpServletRequest request, @PathVariable Integer classid) {
        studentService.sign(request, classid);
        return "sign_sucess";
    }
    @RequestMapping(value = "/studnt/count")
    public Score count(HttpServletRequest request){
        return studentService.score(request);
    }




}
