package cn.ibase.beta.system.entity;

import cn.ibase.beta.common.entity.BaseEntity;

import java.util.Date;

/**
 *  Entity
 * Created by Generator on 2019-09-11 12:26:22.
 */
public class SystemUser extends BaseEntity {
    /**
     * 编码
     */
    private String sn;

    /**
     * 姓名
     */
    private String iname;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 角色编码
     */
    private String roleSn;

    /**
     * 组织编码
     */
    private String orgSn;

    /**
     * 数据状态
     */
    private Integer state;

    /**
     * 添加/编辑时间
     */
    private Date editTime;

    /**
     * 添加/编辑人员
     */
    private String editUser;

    /**
     * 获取编码
     *
     * @return sn - 编码
     */
    public String getSn() {
        return sn;
    }

    /**
     * 设置编码
     *
     * @param sn 编码
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * 获取姓名
     *
     * @return iname - 姓名
     */
    public String getIname() {
        return iname;
    }

    /**
     * 设置姓名
     *
     * @param iname 姓名
     */
    public void setIname(String iname) {
        this.iname = iname;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoleSn() {
        return roleSn;
    }

    public void setRoleSn(String roleSn) {
        this.roleSn = roleSn;
    }

    /**
     * 获取组织编码
     *
     * @return org_sn - 组织编码
     */
    public String getOrgSn() {
        return orgSn;
    }

    /**
     * 设置组织编码
     *
     * @param orgSn 组织编码
     */
    public void setOrgSn(String orgSn) {
        this.orgSn = orgSn;
    }

    /**
     * 获取数据状态
     *
     * @return state - 数据状态
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置数据状态
     *
     * @param state 数据状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取添加/编辑时间
     *
     * @return edit_time - 添加/编辑时间
     */
    public Date getEditTime() {
        return editTime;
    }

    /**
     * 设置添加/编辑时间
     *
     * @param editTime 添加/编辑时间
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    /**
     * 获取添加/编辑人员
     *
     * @return edit_user - 添加/编辑人员
     */
    public String getEditUser() {
        return editUser;
    }

    /**
     * 设置添加/编辑人员
     *
     * @param editUser 添加/编辑人员
     */
    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }
}