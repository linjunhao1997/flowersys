package com.junhow.gp.dao;

import com.junhow.gp.pojo.Family;
import com.junhow.gp.pojo.Genus;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface GenusMapper extends Mapper<Genus> {
    List<Genus> selectByTypeName(String name);
}