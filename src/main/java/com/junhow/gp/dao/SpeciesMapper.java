package com.junhow.gp.dao;

import com.junhow.gp.pojo.Genus;
import com.junhow.gp.pojo.Species;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SpeciesMapper extends Mapper<Species> {
    List<Species> selectByTypeName(String name);

}