package com.junhow.gp.service.impl;

import com.junhow.gp.common.impl.BaseServiceImpl;
import com.junhow.gp.pojo.Class;
import com.junhow.gp.service.IClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassServiceImpl
 * @author CodeGenerator
 * @date 2019/03/16 16:24
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ClassServiceImpl extends BaseServiceImpl<Class> implements IClassService {
}
