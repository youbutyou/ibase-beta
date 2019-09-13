package cn.ibase.beta.web.service.impl;

import cn.ibase.beta.system.dto.SystemUserDto;
import cn.ibase.beta.system.service.SystemUserService;
import cn.ibase.beta.web.dto.LoginInfo;
import cn.ibase.beta.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: song
 * @Date: 2019/9/13
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SystemUserService systemUserService;

    @Override
    public String login(LoginInfo loginInfo){
        if(null == loginInfo){
            return "main/login";
        }
        SystemUserDto userDto = new SystemUserDto();
        userDto.setSn(loginInfo.getUserName());
        userDto.setPassword(loginInfo.getPassword());
        userDto = systemUserService.load(userDto);
        if(null != userDto){
            return "main/main";
        }
        return "main/login";

    }
}
