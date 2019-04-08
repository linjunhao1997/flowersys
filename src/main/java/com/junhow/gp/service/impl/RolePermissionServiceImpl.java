package com.junhow.gp.service.impl;

import com.junhow.gp.common.impl.BaseServiceImpl;
import com.junhow.gp.pojo.RolePermission;
import com.junhow.gp.service.IRolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RolePermissionServiceImpl
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermission> implements IRolePermissionService {
}
