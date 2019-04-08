package com.junhow.gp.dao;


import com.junhow.gp.pojo.Order;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface OrderMapper extends Mapper<Order> {
    List<Order> selectByTypeName(String name);
}