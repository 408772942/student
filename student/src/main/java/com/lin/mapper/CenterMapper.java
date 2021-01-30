package com.lin.mapper;

import com.lin.model.Student;
import com.lin.model.Subject;
import com.lin.model.Teacher;
import com.lin.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CenterMapper {
    Integer subjectAdd(Integer subjectid,String subjectname,Integer teacherid);
    Integer subjectSelect(Integer subjectid);
    Integer subjectDel(Integer subjectid);
    List<Subject>subjectAll();
    Student student(Integer stuid);
    Subject subjectFind(Integer subjectid);
    List<Student>studentAll();
    List<Student>studentClass(String classname);
    Teacher teacherSelect(Integer teacherid);
    List<Teacher>teacherAll();
    Integer teacherFind(Integer teacherid);
    Integer teacherAdd(Integer teacherid,String name,String sex,String birthday,String addr,Integer phone);
    Integer teacherDel(Integer teacherid);
    Integer studentFind(Integer stuid);
    Integer studentAdd(Integer stuid,String name,String classname,Integer num,String sex,String birthday,Integer phone,String addr);
    Integer studentDel(Integer stuid);
    void teacherUserAdd(Integer teacherid);
    void teacherUserDel(Integer teacherid);
    void studentUserAdd(Integer stuid);
    void studentUserDel(Integer stuid);
    Integer passwd(Integer userid,String password);
    User selectPasswd(Integer userid);
    List<Subject>stuId(Integer subjectid);
    Integer count(Integer userid);

}
