package cn.ibase.beta.system.service.impl;

import cn.ibase.beta.common.service.impl.BaseServiceImpl;
import cn.ibase.beta.system.dao.SystemDictionaryTypeDao;
import cn.ibase.beta.system.dto.SystemDictionaryTypeDto;
import cn.ibase.beta.system.service.SystemDictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  ServiceImpl
 * Created by Generator on 2019-09-14 12:17:19.
 */
@Service
public class SystemDictionaryTypeServiceImpl extends BaseServiceImpl<SystemDictionaryTypeDto> implements SystemDictionaryTypeService {

    @Autowired
    private SystemDictionaryTypeDao systemDictionaryTypeDao;


}
