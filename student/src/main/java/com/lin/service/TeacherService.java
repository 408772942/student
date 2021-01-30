package com.lin.service;

import com.lin.mapper.TeacherMapper;
import com.lin.mapper.UserMapper;
import com.lin.model.Score;
import com.lin.model.Sign;
import com.lin.model.Student;
import com.lin.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public String signPage(HttpServletRequest request, Model model) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        List<Subject> subject = teacherMapper.subjectTeacher(userid);
        model.addAttribute("subject", subject);
        return "object_sign_teacher";
    }

    public String signOpen(HttpServletRequest request, Integer subjectid) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        teacherMapper.signOpen(userid, subjectid);
        return "sign_open_success";
    }

    public String signOff(HttpServletRequest request, Integer subjectid) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        teacherMapper.signOff(userid, subjectid);
        return "sign_off_success";
    }

    public String signOpenAll(HttpServletRequest request, Model model) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        List<Subject> signOpenAll = teacherMapper.signOpenAll(userid);
        model.addAttribute("subject", signOpenAll);
        return "sign_open_all";
    }

    public String signOffAll(HttpServletRequest request, Model model) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        List<Subject> signOffAll = teacherMapper.signOffAll(userid);
        model.addAttribute("subject", signOffAll);
        return "sign_off_all";
    }

    public String sign(HttpServletRequest request, Integer subjectid, Model model) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        Integer state = teacherMapper.signState(userid, subjectid);
        if (state == 1) {
            teacherMapper.signOff(userid, subjectid);
            return signAll(request, model, subjectid);
        } else if (state == 2) {
            teacherMapper.cleanSign(subjectid);
            teacherMapper.signOpen(userid, subjectid);
            return "sign_open_success";
        } else {
            return "404.html";
        }
    }

    public String signAll(HttpServletRequest request, Model model, Integer subjectid) {
        List<Sign> signAll = teacherMapper.signAll(subjectid);
        List<String> stuName = new ArrayList<>();
        for (Sign sign : signAll) {
            stuName.add(teacherMapper.stuName(sign.getUserid()));
        }
        model.addAttribute("sign", signAll);
        model.addAttribute("student", stuName);
        return "sign_all_teacher";
    }

    public String subjectAdd(HttpServletRequest request, Integer subjectid, Integer stuid) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        String subjectName = teacherMapper.subjectName(subjectid, userid);
        Integer subjectState = teacherMapper.subjectState(subjectid, userid);
        if (teacherMapper.studentAddReady(stuid, subjectid) == null){
            if (teacherMapper.subjectAdd(subjectid, subjectName, stuid, userid, subjectState) == 1) {
                return "student_add_success";
            } else {
                return "student_add_error";
            }
        }else{
            return "student_add_ready";
        }
    }

    public String subjectDel(HttpServletRequest request, Integer subjectid, Integer stuid) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        if (teacherMapper.subjectDel(subjectid, userid, stuid) == 1) {
            return "student_del_success";
        }
        return "student_del_error";
    }

    public String studentAll(HttpServletRequest request, Model model, Integer subjectid) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        List<Subject> stu = teacherMapper.stuId(subjectid, userid);
        List<Student> studentAll = new ArrayList<>();
        ;
        for (Subject stuId : stu) {
            studentAll.add(teacherMapper.studentAll(stuId.getStuid()));
        }
        model.addAttribute("student", studentAll);
        return "subject_studentAll_teacher";
    }
    public String selectStudent(HttpServletRequest request,Model model,Integer stuid){
        model.addAttribute("student",teacherMapper.selectStudent(stuid));
        return "select_student";
    }
    public String scoreAll(HttpServletRequest request, Model model, Integer subjectid) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        List<Subject> stu = teacherMapper.stuId(subjectid, userid);
        List<Student> studentAll = new ArrayList<>();
        List<Score> scoreAll=new ArrayList<>();
        for (Subject stuId : stu) {
            studentAll.add(teacherMapper.studentAll(stuId.getStuid()));
            System.out.println(teacherMapper.scoreAll(stuId.getStuid(), subjectid));
            scoreAll.add(teacherMapper.scoreAll(stuId.getStuid(), subjectid));
        }
        model.addAttribute("student", studentAll);
        model.addAttribute("Score",scoreAll);
        return "scoreAll_teacher";
    }
    public String revise(HttpServletRequest request,Integer subjectid,Integer stuid,Integer score){
        teacherMapper.revise(subjectid,stuid,score);
        return "revise_success";
    }
    public String studentScore(HttpServletRequest request,Model model,Integer stuid){
        List<Score>studentScore=teacherMapper.studentScore(stuid);
        model.addAttribute("score",studentScore);
        return "student_score_teacher";
    }
}
