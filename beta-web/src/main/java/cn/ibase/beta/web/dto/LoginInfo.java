package cn.ibase.beta.web.dto;

import javax.validation.constraints.NotNull;

/**
 * @Author: song
 * @Date: 2019/9/13
 */
public class LoginInfo {

    /**
     * 账号
     */
    @NotNull(message = "用户名不能为空")
    private String userName;
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
