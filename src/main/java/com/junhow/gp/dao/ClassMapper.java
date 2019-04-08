package com.junhow.gp.dao;

import com.junhow.gp.pojo.Class;
import com.junhow.gp.pojo.Phylum;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ClassMapper extends Mapper<Class> {
    List<Class> selectByTypeName(String name);
}