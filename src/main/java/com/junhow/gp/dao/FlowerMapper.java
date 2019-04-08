package com.junhow.gp.dao;

import com.junhow.gp.pojo.Flower;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface FlowerMapper extends Mapper<Flower> {
    List<Flower> selectByTypeName(String name);
}