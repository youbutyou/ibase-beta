package cn.ibase.beta.web.service;

import cn.ibase.beta.web.dto.LoginInfo;

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
    String login(LoginInfo loginInfo);
}
