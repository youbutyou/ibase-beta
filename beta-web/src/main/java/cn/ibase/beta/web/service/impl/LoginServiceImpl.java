package cn.ibase.beta.web.service.impl;

import cn.ibase.beta.common.dto.FormResult;
import cn.ibase.beta.common.dto.SessionInfo;
import cn.ibase.beta.common.info.ResultEnum;
import cn.ibase.beta.common.util.ResultUtil;
import cn.ibase.beta.system.dto.SystemModuleDto;
import cn.ibase.beta.system.dto.SystemUserDto;
import cn.ibase.beta.system.service.SystemModuleService;
import cn.ibase.beta.system.service.SystemUserService;
import cn.ibase.beta.web.dto.LoginInfo;
import cn.ibase.beta.web.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆类
 * @Author: song
 * @Date: 2019/9/13
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private SystemModuleService systemModuleService;

    @Override
    public FormResult login(LoginInfo loginInfo, HttpServletRequest request){
        if(null == loginInfo){
            return ResultUtil.createErrorFormResult(null, ResultEnum.SYS_LOGIN_ERROR);
        }
        SystemUserDto userDto = new SystemUserDto();
        userDto.setSn(loginInfo.getUserName());
        userDto = systemUserService.load(userDto);
        if(null == userDto){
            return ResultUtil.createErrorFormResult(loginInfo, ResultEnum.SYS_USER_NO_EXIST);
        }
        if(StringUtils.compare(loginInfo.getPassword(), userDto.getPassword()) != 0 ){
            return ResultUtil.createErrorFormResult(loginInfo, ResultEnum.SYS_LOGIN_ERROR);
        }
        request.getSession().setAttribute(SessionInfo.LOGIN_SESSION_USER, userDto);
        return ResultUtil.createFormResult(userDto, true, ResultEnum.SYS_LOGIN_SUCCESS);
    }

    @Override
    public SystemModuleDto getSystemInfo(){
        SystemModuleDto moduleDto = new SystemModuleDto();
        moduleDto.setDicSn("system_config_001");
        return systemModuleService.load(moduleDto);
    }

    @Override
    public SystemUserDto getLoginUserInfo(HttpServletRequest request){
        SystemUserDto systemUserDto = (SystemUserDto) request.getSession().getAttribute(SessionInfo.LOGIN_SESSION_USER);
        return systemUserDto;
    }
}
