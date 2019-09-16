package cn.ibase.beta.web.service;

import cn.ibase.beta.common.dto.FormResult;
import cn.ibase.beta.system.dto.SystemModuleDto;
import cn.ibase.beta.system.dto.SystemUserDto;
import cn.ibase.beta.web.dto.LoginInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: song
 * @Date: 2019/9/13
 */
public interface LoginService{

    /**
     * 登陆
     * @param loginInfo
     * @return
     */
    FormResult login(LoginInfo loginInfo, HttpServletRequest request);

    /**
     * 获取系统信息
     * @return
     */
    SystemModuleDto getSystemInfo();

    /**
     * 获取用户信息
     * @return
     */
    SystemUserDto getLoginUserInfo(HttpServletRequest request);

}
