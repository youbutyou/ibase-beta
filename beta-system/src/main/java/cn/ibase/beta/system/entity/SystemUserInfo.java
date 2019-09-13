package cn.ibase.beta.system.entity;

import cn.ibase.beta.common.entity.BaseEntity;

import java.util.Date;

/**
 *  Entity
 * Created by Generator on 2019-09-11 12:26:23.
 */
public class SystemUserInfo extends BaseEntity {
    /**
     * 用户编码
     */
    private String userSn;

    /**
     * 性别（1-男，2-女）
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 个人签名
     */
    private String signature;

    /**
     * 编辑时间
     */
    private Date editTime;

    /**
     * 编辑人编码
     */
    private String editUser;

    /**
     * 获取用户编码
     *
     * @return user_sn - 用户编码
     */
    public String getUserSn() {
        return userSn;
    }

    /**
     * 设置用户编码
     *
     * @param userSn 用户编码
     */
    public void setUserSn(String userSn) {
        this.userSn = userSn;
    }

    /**
     * 获取性别（1-男，2-女）
     *
     * @return gender - 性别（1-男，2-女）
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别（1-男，2-女）
     *
     * @param gender 性别（1-男，2-女）
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取个人签名
     *
     * @return signature - 个人签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置个人签名
     *
     * @param signature 个人签名
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 获取编辑时间
     *
     * @return edit_time - 编辑时间
     */
    public Date getEditTime() {
        return editTime;
    }

    /**
     * 设置编辑时间
     *
     * @param editTime 编辑时间
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    /**
     * 获取编辑人编码
     *
     * @return edit_user - 编辑人编码
     */
    public String getEditUser() {
        return editUser;
    }

    /**
     * 设置编辑人编码
     *
     * @param editUser 编辑人编码
     */
    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }
}