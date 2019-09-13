package cn.ibase.beta.common.service.impl;

import cn.ibase.beta.common.dto.LoginUser;
import cn.ibase.beta.common.service.CommonQueryService;
import org.springframework.stereotype.Service;

/**
 * @Author: song
 * @Date: 2019/9/11
 */
@Service("commonQueryService")
public class CommonQueryServiceImpl implements CommonQueryService {

    @Override
    public LoginUser getCurrentUser(){
        LoginUser user = new LoginUser();
        return user;
    }
}
