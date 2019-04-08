package com.junhow.gp.dao;

import com.junhow.gp.pojo.Permission;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface PermissionMapper extends Mapper<Permission> {
    List<Permission> getPermissionByUserName(String username);
}