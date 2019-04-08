package com.junhow.gp.dao;

import com.junhow.gp.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserMapper extends Mapper<User> {
}