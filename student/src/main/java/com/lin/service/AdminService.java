package com.lin.service;

import com.lin.mapper.AdminMapper;
import com.lin.mapper.CenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public String centerAdd(HttpServletRequest request){
        Integer userid= Integer.valueOf(request.getParameter("teacherid"));

        if(adminMapper.centerFind(userid)==null){
            if(adminMapper.centerAdd(userid)==1){
                return "student_add_success";
            }else {
                return "student_add_error";
            }
        }else {
            return "student_add_ready";
        }
    }
    public String centerDel(Integer userid){
        if(adminMapper.centerDel(userid)==1){
            return "student_del_success";
        }else{
            return "student_del_error";
        }
    }
    public String passwd(HttpServletRequest request,String password){
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        if(adminMapper.passwd(userid,password)==1){
            return "student_add_success";
        }else{
            return "student_add_error";
        }
    }
    public String selectPassword(Model model, Integer userid) {
        if (adminMapper.selectPasswd(userid) == null) {
            return "student_add_error";
        } else {
            model.addAttribute("user", adminMapper.selectPasswd(userid));
            return "select_passwd";
        }
    }
}