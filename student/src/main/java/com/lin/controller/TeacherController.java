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
    //关闭签到
    @RequestMapping(value = "/teacher/signOff/{subjectid}")
    public String signOff(HttpServletRequest request, @PathVariable Integer subjectid) {
        return teacherService.signOff(request,subjectid);
    }
    //查看所有关闭课程
    @RequestMapping(value = "/teacher/signOpenAll")
    public String signOpenAll(HttpServletRequest request, Model model){
        return teacherService.signOpenAll(request,model);
    }
    //查看所有开启课程
    @RequestMapping(value = "/teacher/signOffAll")
    public String signOffAll(HttpServletRequest request, Model model){
        return teacherService.signOffAll(request,model);
    }
    //打关签到
    @RequestMapping(value = "/teacher/sign/{subjectid}")
    public String sign(HttpServletRequest request, @PathVariable Integer subjectid, Model model) {
        return teacherService.sign(request,subjectid,model);
    }
    //查看签到人数
    @RequestMapping(value = "/teacher/signAll/{subjectid}")
    public String signAll(HttpServletRequest request,Model model,@PathVariable Integer subjectid){
        return teacherService.signAll(request,model,subjectid);
    }
    //课程添加学生
    @RequestMapping(value = "/teacher/subjectAdd/{subjectid}/{stuid}")
    public String subjectAdd(HttpServletRequest request,@PathVariable Integer subjectid,@PathVariable Integer stuid){
        return teacherService.studentAdd(request,subjectid,stuid);
    }
    //课程删除学生
    @RequestMapping(value = "/teacher/subjectDel/{subjectid}/{stuid}")
    public String subjectDel(HttpServletRequest request,@PathVariable Integer subjectid,@PathVariable Integer stuid){
        return teacherService.studentDel(request,subjectid,stuid);
    }
    //查看该门课程所有学生
    @RequestMapping(value = "/teacher/studentAll/{subjectid}")
    public String studentAll(HttpServletRequest request,Model model,@PathVariable Integer subjectid){
        return teacherService.studentAll(request,model,subjectid);
    }
    //查看学生通过学号
    @RequestMapping(value = "/teacher/select/{stuid}")
    public String selectStudent(Model model,@PathVariable Integer stuid){
        return teacherService.studentSelect(model,stuid);
    }
    //查看该门课程所有学生成绩
    @RequestMapping(value = "/teacher/scoreAll/{subjectid}")
    public String scoreAll(HttpServletRequest request,Model model,@PathVariable Integer subjectid){
        return teacherService.scoreAll(request,model,subjectid);
    }
    //修改学生成绩
    @RequestMapping(value = "/teacher/revise/{subjectid}/{stuid}/{score}")
    public String revise(HttpServletRequest request,@PathVariable Integer subjectid,@PathVariable Integer stuid,@PathVariable Integer score){
        return teacherService.revise(request,subjectid,stuid,score);
    }
    //查看学生成绩
    @RequestMapping(value = "/teacher/studentScore/{stuid}")
    public String studentScore(HttpServletRequest request,Model model,@PathVariable Integer stuid){
        return teacherService.studentScore(request,model,stuid);
    }
    //修改密码
    @RequestMapping(value = "/teacher/passwd/{password}")
    public String passwd(HttpServletRequest request,@PathVariable String password){
        return teacherService.passwd(request,password);
    }
}
