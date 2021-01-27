package com.lin.service;

import com.lin.model.Score;
import com.lin.model.Subject;
import com.lin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private UserMapper userMapper;
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String tempUserid=request.getParameter("userid");
        Integer userid=Integer.valueOf(tempUserid);
        String password=request.getParameter("password");
        String position=loginTest (userid,password);
        if(position!=null){
            session.setAttribute("userid",userid);
            session.setAttribute("password",password);
            session.setAttribute("position",position);
            return "success";
        }else{
            return "error";
        }
    }
    public String loginTest(Integer userid, String password) {
        return userMapper.logintest(userid,password);
    }
    public void sign(HttpServletRequest request,Integer subjectid){
        Integer userid=(Integer) request.getSession().getAttribute("userid");
        userMapper.sign(userid,subjectid);
    }
    public String score(HttpServletRequest request, Model model){
        Integer userid=(Integer) request.getSession().getAttribute("userid");
        List<Score>score=userMapper.score(userid);
        model.addAttribute("score",score);
        return "score_student" ;
    }
    public String subject(HttpServletRequest request, Model model){
        Integer userid=(Integer) request.getSession().getAttribute("userid");
        List<Subject> subject=userMapper.subject(userid);
        model.addAttribute("subject",subject);
        return "object_student";
    }
}
