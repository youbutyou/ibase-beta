package cn.ibase.beta.system.service.impl;

import cn.ibase.beta.common.service.impl.BaseServiceImpl;
import cn.ibase.beta.system.dao.SystemDictionaryDao;
import cn.ibase.beta.system.service.SystemDictionaryService;
import cn.ibase.beta.system.dto.SystemDictionaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  ServiceImpl
 * Created by Generator on 2019-09-14 12:17:19.
 */
@Service
public class SystemDictionaryServiceImpl extends BaseServiceImpl<SystemDictionaryDto> implements SystemDictionaryService {

    @Autowired
    private SystemDictionaryDao systemDictionaryDao;


}
