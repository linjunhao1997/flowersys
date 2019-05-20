package com.junhow.gp.dao;

import com.junhow.gp.pojo.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RoleMapper extends Mapper<Role> {
    List<Role> getRolesByUserName(String username);

    List<Role> getRolesByUserId(Integer id);
}