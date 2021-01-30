package com.lin.controller;

import com.lin.service.CenterService;
import com.lin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CenterController {
    @Autowired
    CenterService centerService;
    //进入添加课程
    @RequestMapping(value = "/center/subject")
    public ModelAndView subject(HttpServletRequest request){
        return  new ModelAndView("subject_add.html");
    }
    @RequestMapping(value = "/center/subjectAdd")
    public String subjectAdd(HttpServletRequest request){
        return centerService.subjectAdd(request);
    }
    //删除课程
    @RequestMapping(value = "/center/subjectDel/{subjectid}")
    public String subjectDel(@PathVariable Integer subjectid){
        return centerService.subjectDel(subjectid);
    }
    //查看所有课程
    @RequestMapping(value = "/center/subjectAll")
    public String subjectAll(Model model){
        return centerService.subjectAll(model);
    }
    //查看课程学生
    @RequestMapping(value = "/center/studentAll/{subjectid}")
    public String studentSubject(Model model,@PathVariable Integer subjectid){
        return centerService.studentSubject(model,subjectid);
    }
    //查找课程信息
    @RequestMapping(value = "/center/subjectSelect/{subjectid}")
    public String subjectSelect(Model model,@PathVariable Integer subjectid){
        return centerService.subjectSelect(model,subjectid);
    }
    //学号查找学生
    @RequestMapping(value = "/center/studentSelect/{stuid}")
    public String studentSelect(Model model,@PathVariable Integer stuid){
        return centerService.studentSelect(model,stuid);
    }
    //通过班级查找学生
    @RequestMapping(value = "/center/studentClass/{classname}")
    public String studentClass(Model model, @PathVariable String classname){
        return centerService.studentClass(model,classname);
    }
    //查看所有学生
    @RequestMapping(value = "/center/studentAll")
    public String StudentAll(Model model){
        return centerService.studentAll(model);
    }
    //通过工号查看教师
    @RequestMapping(value = "/center/teacherSelect/{teacherid}")
    public String teacherSelect(Model model,@PathVariable Integer teacherid){
        return centerService.teacherSelect(model,teacherid);
    }
    //查看所有教师
    @RequestMapping(value = "/center/teacherAll")
    public String teacherAll(Model model){
        return centerService.teacherAll(model);
    }
    //添加教师
    @RequestMapping(value = "/center/teacher")
    public ModelAndView  teacher(){
        return new ModelAndView("teacher_add.html");
    }
    @RequestMapping(value = "/center/teacherAdd")
    public String  teacherAdd(HttpServletRequest request){
        return centerService.teacherAdd(request);
    }
    //删除教师
    @RequestMapping(value = "/center/teacherDel/{teacherid}")
    public String  teacherDel(@PathVariable Integer teacherid){
        return centerService.teacherDel(teacherid);
    }
    //添加学生
    @RequestMapping(value = "/center/student")
    public ModelAndView  student(){
        return new ModelAndView("student_add.html");
    }
    @RequestMapping(value = "/center/studentAdd")
    public String studentAdd(HttpServletRequest request){
        return centerService.studentAdd(request);
    }
    //删除学生
    @RequestMapping(value = "/center/studentDel/{stuid}")
    public String  studentDel(@PathVariable Integer stuid){
        return centerService.studentDel(stuid);
    }
    //修改密码
    @RequestMapping(value = "/center/passwd/{password}")
    public String passwd(HttpServletRequest request,@PathVariable String password){
        return centerService.passwd(request,password);
    }
    //查看学生密码
    @RequestMapping(value = "/center/selectPw/{userid}")
    public String selectPasswd(Model model,@PathVariable Integer userid){
        return centerService.selectPassword(model,userid);
    }

}
