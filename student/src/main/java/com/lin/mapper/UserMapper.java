package com.lin.mapper;

import com.lin.model.Score;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface UserMapper {
    String logintest(Integer userid,String password);
    void sign(Integer userid,Integer classid);
    Score score(Integer userid);
}