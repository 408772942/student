package com.lin.controller;


import com.lin.service.StudentService;
import com.lin.service.TeacherService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;


@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    //查看所有课程
    @RequestMapping(value = "/teacher/sign")
    public String sign(HttpServletRequest request, Model model){
        return  teacherService.signPage(request,model);
    }
    //开启签到
    @RequestMapping(value = "/teacher/signOpen/{subjectid}")
    public String signOpen(HttpServletRequest request, @PathVariable Integer subjectid) {
        return teacherService.signOpen(request,subjectid);
    }
    @RequestMapping(value = "/teacher/signOff/{subjectid}")
    public String signOff(HttpServletRequest request, @PathVariable Integer subjectid) {
        return teacherService.signOff(request,subjectid);
    }
    @RequestMapping(value = "/teacher/signOpenAll")
    public String signOpenAll(HttpServletRequest request, Model model){
        return teacherService.signOpenAll(request,model);
    }
    @RequestMapping(value = "/teacher/signOffAll")
    public String signOffAll(HttpServletRequest request, Model model){
        return teacherService.signOffAll(request,model);
    }
    @RequestMapping(value = "/teacher/sign/{subjectid}")
    public String sign(HttpServletRequest request, @PathVariable Integer subjectid, Model model) {
        return teacherService.sign(request,subjectid,model);
    }
    @RequestMapping(value = "/teacher/signAll/{subjectid}")
    public String signAll(HttpServletRequest request,Model model,@PathVariable Integer subjectid){
        return teacherService.signAll(request,model,subjectid);
    }
    @RequestMapping(value = "/teacher/subjectAdd/{subjectid}/{stuid}")
    public String subjectAdd(HttpServletRequest request,@PathVariable Integer subjectid,@PathVariable Integer stuid){
        return teacherService.subjectAdd(request,subjectid,stuid);
    }
    @RequestMapping(value = "/teacher/subjectDel/{subjectid}/{stuid}")
    public String subjectDel(HttpServletRequest request,@PathVariable Integer subjectid,@PathVariable Integer stuid){
        return teacherService.subjectDel(request,subjectid,stuid);
    }
    @RequestMapping(value = "/teacher/studentAll/{subjectid}")
    public String studentAll(HttpServletRequest request,Model model,@PathVariable Integer subjectid){
        return teacherService.studentAll(request,model,subjectid);
    }
    @RequestMapping(value = "/teacher/select/{stuid}")
    public String selectStudent(HttpServletRequest request,Model model,@PathVariable Integer stuid){
        return teacherService.selectStudent(request,model,stuid);
    }
    @RequestMapping(value = "/teacher/scoreAll/{subjectid}")
    public String scoreAll(HttpServletRequest request,Model model,@PathVariable Integer subjectid){
        return teacherService.scoreAll(request,model,subjectid);
    }
    @RequestMapping(value = "/teacher/revise/{subjectid}/{stuid}/{score}")
    public String revise(HttpServletRequest request,@PathVariable Integer subjectid,@PathVariable Integer stuid,@PathVariable Integer score){
        return teacherService.revise(request,subjectid,stuid,score);
    }
    @RequestMapping(value = "/teacher/studentScore/{stuid}")
    public String studentScore(HttpServletRequest request,Model model,@PathVariable Integer stuid){
        return teacherService.studentScore(request,model,stuid);
    }
}
