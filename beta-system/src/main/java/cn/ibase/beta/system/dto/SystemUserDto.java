package cn.ibase.beta.system.dto;

import cn.ibase.beta.system.entity.SystemUser;

/**
 *  Dto
 * Created by Generator on 2019-09-11 12:26:20.
 */
public class SystemUserDto extends SystemUser{

    /**
     * 角色类型编码
     */
    private String roleTypeSn;

    public String getRoleTypeSn() {
        return roleTypeSn;
    }

    public void setRoleTypeSn(String roleTypeSn) {
        this.roleTypeSn = roleTypeSn;
    }
}
