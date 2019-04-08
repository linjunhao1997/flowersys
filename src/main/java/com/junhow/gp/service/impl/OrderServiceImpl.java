package com.junhow.gp.service.impl;

import com.junhow.gp.common.impl.BaseServiceImpl;
import com.junhow.gp.pojo.Order;
import com.junhow.gp.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OrderServiceImpl
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl extends BaseServiceImpl<Order> implements IOrderService {
}
