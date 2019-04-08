package com.junhow.gp.dao;

import com.junhow.gp.pojo.Family;
import com.junhow.gp.pojo.Grade;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface GradeMapper extends Mapper<Grade> {
    List<Grade> selectByTypeName(String name);
}