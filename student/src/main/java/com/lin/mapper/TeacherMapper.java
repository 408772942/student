package com.lin.mapper;

import com.lin.model.Score;
import com.lin.model.Sign;
import com.lin.model.Student;
import com.lin.model.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface TeacherMapper {
    List<Subject> subjectTeacher(Integer userid);
    void signOpen(Integer userid,Integer subjectid);
    void signOff(Integer userid,Integer subjectid);
    List<Subject> signOpenAll(Integer userid);
    List<Subject> signOffAll(Integer userid);
    Integer signState(Integer userid,Integer subjectid);
    void cleanSign(Integer subjectid);
    List<Student> student(Integer userid);
    List<Sign> signAll(Integer subjectid);
    String stuName(Integer userid);
    Integer subjectState(Integer subjectid,Integer userid);
    String subjectName(Integer subjectid,Integer userid);
    Integer subjectAdd(Integer subjectid,String subjectname,Integer stuid,Integer userid,Integer state);
    Integer subjectDel(Integer subjectid,Integer userid,Integer stuid);
    List<Subject>stuId(Integer subjectid,Integer userid);
    Student studentAll(Integer stuid);
    Integer studentAddReady(Integer stuid,Integer subjectid);
    Student selectStudent(Integer stuid);
    Score scoreAll(Integer stuid,Integer subjectid);
    void revise(Integer subjectid,Integer score,Integer stuid);
    List<Score>studentScore(Integer stuid);
    Integer passwd(Integer userid,String password);
}