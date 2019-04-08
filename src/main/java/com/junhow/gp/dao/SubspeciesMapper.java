package com.junhow.gp.dao;

import com.junhow.gp.pojo.Genus;
import com.junhow.gp.pojo.Subspecies;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SubspeciesMapper extends Mapper<Subspecies> {
    List<Subspecies> selectByTypeName(String name);
}