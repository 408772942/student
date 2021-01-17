package com.lin.service;

import com.lin.mapper.UserMapper;
import com.lin.model.Score;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            //返回学生.html
            return "success";
        }else{
            //登入失败提示
            return "error";
        }
    }
    public String loginTest(Integer userid, String password) {
        return userMapper.logintest(userid,password);
    }
    public void sign(HttpServletRequest request,Integer classid){
        Integer userid=(Integer) request.getSession().getAttribute("userid");
        userMapper.sign(userid,classid);

    }
    public Score score(HttpServletRequest request){
        Integer userid=(Integer) request.getSession().getAttribute("userid");
        return userMapper.score(userid);
    }
}
