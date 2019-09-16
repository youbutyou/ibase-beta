package cn.ibase.beta.system.service.impl;

import cn.ibase.beta.common.service.impl.BaseServiceImpl;
import cn.ibase.beta.system.dao.SystemModuleDao;
import cn.ibase.beta.system.dto.SystemModuleDto;
import cn.ibase.beta.system.service.SystemModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  ServiceImpl
 * Created by Generator on 2019-09-14 12:17:19.
 */
@Service
public class SystemModuleServiceImpl extends BaseServiceImpl<SystemModuleDto> implements SystemModuleService {

    @Autowired
    private SystemModuleDao systemModuleDao;


}
