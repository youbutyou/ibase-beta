package cn.ibase.beta.system.service.impl;

import cn.ibase.beta.common.service.impl.BaseServiceImpl;
import cn.ibase.beta.system.dao.SystemUserInfoDao;
import cn.ibase.beta.system.dto.SystemUserInfoDto;
import cn.ibase.beta.system.service.SystemUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  ServiceImpl
 * Created by Generator on 2019-09-11 12:26:20.
 */
@Service
public class SystemUserInfoServiceImpl extends BaseServiceImpl<SystemUserInfoDto> implements SystemUserInfoService {

    @Autowired
    private SystemUserInfoDao systemUserInfoDao;


}
