package com.lin.mapper;

import com.lin.model.Subject;
import com.lin.model.Score;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface UserMapper {
    String logintest(Integer userid,String password);
    void sign(Integer userid,Integer subjectid);
    List<Score> score(Integer userid);
    List<Subject> subject(Integer userid);
}