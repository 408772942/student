package com.lin.mapper;

import com.lin.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import sun.text.normalizer.UBiDiProps;

@Mapper
@Component
public interface AdminMapper {
    Integer centerFind(Integer userid);
    Integer centerAdd(Integer userid);
    Integer centerDel(Integer userid);
    Integer passwd(Integer userid,String password);
    User selectPasswd(Integer userid);
}
