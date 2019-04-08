package com.junhow.gp.service.impl;

import com.junhow.gp.common.impl.BaseServiceImpl;
import com.junhow.gp.pojo.Species;
import com.junhow.gp.service.ISpeciesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SpeciesServiceImpl
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SpeciesServiceImpl extends BaseServiceImpl<Species> implements ISpeciesService {
}
