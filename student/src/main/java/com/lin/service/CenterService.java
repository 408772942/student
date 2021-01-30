package com.lin.service;

import com.lin.mapper.CenterMapper;
import com.lin.mapper.TeacherMapper;
import com.lin.model.Student;
import com.lin.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class CenterService {
    @Autowired
    private CenterMapper centerMapper;
    private TeacherMapper teacherMapper;

    public String subjectAdd(HttpServletRequest request) {
        Integer subjectid = Integer.valueOf(request.getParameter("subjectid"));
        String subjectname = request.getParameter("subjectname");
        Integer teacherid = Integer.valueOf(request.getParameter("teacherid"));
        if (centerMapper.subjectSelect(subjectid) == null) {
            if (centerMapper.subjectAdd(subjectid, subjectname, teacherid) == 1) {
                return "student_add_success";
            } else
                return "student_add_error";
        } else {
            return "student_add_ready";
        }
    }

    public String subjectDel(Integer subjectid) {
        if (centerMapper.subjectDel(subjectid) == 1) {
            return "student_del_success";
        } else {
            return "student_del_error";
        }
    }

    public String subjectAll(Model model) {
        List<Subject> subjectAll = centerMapper.subjectAll();
        model.addAttribute("subject", subjectAll);
        return "subject_all_teacher";
    }

    public String subjectSelect(Model model, Integer subjectid) {
        model.addAttribute("subject", centerMapper.subjectFind(subjectid));
        return "subject_all_teacher";
    }

    public String studentAll(Model model) {
        model.addAttribute("student", centerMapper.studentAll());
        return "select_student";
    }

    public String studentSubject( Model model, Integer subjectid) {
        List<Subject> stu = centerMapper.stuId(subjectid);
        List<Student> studentAll = new ArrayList<>();
        for (Subject stuId : stu) {
            System.out.println(centerMapper.student(stuId.getStuid()));
            studentAll.add(centerMapper.student(stuId.getStuid()));
        }
        model.addAttribute("student", studentAll);
        return "student_subject";
    }
    public String studentSelect(Model model,Integer stuid){
        model.addAttribute("student",centerMapper.student(stuid));
        return "select_student";
    }
    public String studentClass(Model model, String classname) {
        model.addAttribute("student", centerMapper.studentClass(classname));
        return "select_student";
    }

    public String teacherSelect(Model model, Integer teacherid) {
        model.addAttribute("teacher", centerMapper.teacherSelect(teacherid));
        return "teacher_select";
    }

    public String teacherAll(Model model) {
        model.addAttribute("teacher", centerMapper.teacherAll());
        return "teacher_select";
    }

    public String teacherAdd(HttpServletRequest request) {
        Integer teacherid = Integer.valueOf(request.getParameter("teacherid"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String addr = request.getParameter("addr");
        Integer phone = Integer.valueOf(request.getParameter("phone"));
        if (centerMapper.teacherFind(teacherid) == 0) {
            if (centerMapper.teacherAdd(teacherid, name, sex, birthday, addr, phone) == 1) {
                centerMapper.teacherUserAdd(teacherid);
                return "student_add_success";
            } else {
                return "student_add_error";
            }
        } else {
            return "student_add_ready";
        }
    }

    public String teacherDel(Integer teacherid) {
        if (centerMapper.teacherDel(teacherid) == 1) {
            centerMapper.teacherUserDel(teacherid);
            return "student_del_success";
        } else {
            return "student_del_error";
        }
    }

    public String studentAdd(HttpServletRequest request) {
        Integer stuid = Integer.valueOf(request.getParameter("stuid"));
        String name = request.getParameter("name");
        String classname = request.getParameter("classname");
        Integer num = Integer.valueOf(request.getParameter("num"));
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        Integer phone = Integer.valueOf(request.getParameter("phone"));
        String addr = request.getParameter("addr");
        System.out.println(centerMapper.studentFind(stuid));
        if (centerMapper.studentFind(stuid) == null) {
            if (centerMapper.studentAdd(stuid, name, classname, num, sex, birthday, phone, addr) == 1) {
                centerMapper.studentUserAdd(stuid);
                return "student_add_success";
            } else {
                return "student_add_error";
            }
        } else {
            return "student_add_ready";
        }
    }

    public String studentDel(Integer stuid) {
        if (centerMapper.studentDel(stuid) == 1) {
            centerMapper.studentUserDel(stuid);
            return "student_del_success";
        } else {
            return "student_del_error";
        }
    }

    public String passwd(HttpServletRequest request, String password) {
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        if (centerMapper.passwd(userid, password) == 1) {
            if(centerMapper.count(userid)==2) {
                teacherMapper.passwd(userid, password);
            }
            return "student_add_success";
        } else {
            return "student_add_error";
        }
    }

    public String selectPassword(Model model, Integer userid) {
        if (centerMapper.selectPasswd(userid) == null) {
            return "student_add_error";
        } else {
            model.addAttribute("user", centerMapper.selectPasswd(userid));
            return "select_passwd";
        }
    }

}
