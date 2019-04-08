package com.junhow.gp.service;
import com.junhow.gp.pojo.Flower;
import com.junhow.gp.common.IBaseService;
import com.junhow.gp.pojo.FlowerImageDto;

import java.util.List;

/**
 * IFlowerService
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
public interface IFlowerService extends IBaseService<Flower> {
    List<FlowerImageDto> getFlowerAndImg(String name);
}
