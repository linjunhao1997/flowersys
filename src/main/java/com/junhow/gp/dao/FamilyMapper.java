package com.junhow.gp.dao;

import com.junhow.gp.pojo.Family;
import com.junhow.gp.pojo.Phylum;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface FamilyMapper extends Mapper<Family> {
    List<Family> selectByTypeName(String name);
}