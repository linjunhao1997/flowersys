package com.junhow.gp.service.impl;

import com.junhow.gp.common.impl.BaseServiceImpl;
import com.junhow.gp.pojo.Role;
import com.junhow.gp.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RoleServiceImpl
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {
}
