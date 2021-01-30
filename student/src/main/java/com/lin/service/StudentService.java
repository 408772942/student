package com.lin.service;

import com.lin.model.Score;
import com.lin.model.Student;
import com.lin.model.Subject;
import com.lin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private UserMapper userMapper;
    //登陆验证 记录session
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String tempUserid = request.getParameter("userid");
        Integer userid = Integer.valueOf(tempUserid);
        String password = request.getParameter("password");
        String position = userMapper.login(userid, password);
        if (position != null) {
            session.setAttribute("userid", userid);
            session.setAttribute("password", password);
            session.setAttribute("position", position);
            return "success";
        } else {
            return "error";
        }
    }

    //签到页面
    public String signPage(HttpServletRequest request, Model model) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        List<Subject> subject = userMapper.subjectSign(userid);
        model.addAttribute("subject", subject);
        return "sign_student";
    }
    //添加签到学生
    public String sign(HttpServletRequest request, Integer subjectid) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        if(userMapper.signReady(userid,subjectid)==null){
            userMapper.sign(userid, subjectid);
            return "sign_success";
        }else {
            return "sign_error";
        }
    }
    //成绩查询
    public String score(HttpServletRequest request, Model model) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        List<Score> score = userMapper.score(userid);
        model.addAttribute("score", score);
        return "score_student";
    }
    //课程查询
    public String subject(HttpServletRequest request, Model model) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        List<Subject> subject = userMapper.subject(userid);
        model.addAttribute("subject", subject);
        return "object_student";
    }
}
