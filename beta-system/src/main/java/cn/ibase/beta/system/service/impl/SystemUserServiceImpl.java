package cn.ibase.beta.system.service.impl;

import cn.ibase.beta.common.service.impl.BaseServiceImpl;
import cn.ibase.beta.system.dao.SystemUserDao;
import cn.ibase.beta.system.dto.SystemUserDto;
import cn.ibase.beta.system.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  ServiceImpl
 * Created by Generator on 2019-09-11 12:26:20.
 */
@Service
public class SystemUserServiceImpl extends BaseServiceImpl<SystemUserDto> implements SystemUserService {

    @Autowired
    private SystemUserDao systemUserDao;


}
