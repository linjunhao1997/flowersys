package com.junhow.gp.service.impl;

import com.junhow.gp.common.impl.BaseServiceImpl;
import com.junhow.gp.dao.FlowerImageMapper;
import com.junhow.gp.dao.FlowerMapper;
import com.junhow.gp.pojo.Flower;
import com.junhow.gp.pojo.FlowerImageDto;
import com.junhow.gp.service.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * FlowerServiceImpl
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FlowerServiceImpl extends BaseServiceImpl<Flower> implements IFlowerService {
    @Autowired
    private FlowerImageMapper flowerImageMapper;
    @Override
    public List<FlowerImageDto> getFlowerAndImg(String name) {
        return flowerImageMapper.selectByName(name);
    }
}
