package com.junhow.gp.dao;

import com.junhow.gp.pojo.FlowerImageDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author linjunhao
 * @description
 * @createDate 2019/2/22 13:42
 */
@Repository
public interface FlowerImageMapper {
    List<FlowerImageDto> selectByName(String name);
}
