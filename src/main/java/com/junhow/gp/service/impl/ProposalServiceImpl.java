package com.junhow.gp.service.impl;

import com.junhow.gp.common.impl.BaseServiceImpl;
import com.junhow.gp.pojo.Proposal;
import com.junhow.gp.service.IProposalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProposalServiceImpl
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProposalServiceImpl extends BaseServiceImpl<Proposal> implements IProposalService {
}
