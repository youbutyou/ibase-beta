package cn.ibase.beta.arcsoft.entity;


import cn.ibase.beta.common.entity.BaseEntity;

import java.util.Date;

/**
 *  Entity
 * Created by Generator on 2019-09-11 12:26:23.
 */
public class ArcsoftFace extends BaseEntity {
    /**
     * 用户编码
     */
    private String userSn;

    private String faceId;

    private Date editTime;

    private String editUser;

    /**
     * 数据状态
     */
    private Integer state;

    /**
     * 脸部特性数据
     */
    private byte[] faceFeature;

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
     * @return face_id
     */
    public String getFaceId() {
        return faceId;
    }

    /**
     * @param faceId
     */
    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    /**
     * @return edit_time
     */
    public Date getEditTime() {
        return editTime;
    }

    /**
     * @param editTime
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    /**
     * @return edit_user
     */
    public String getEditUser() {
        return editUser;
    }

    /**
     * @param editUser
     */
    public void setEditUser(String editUser) {
        this.editUser = editUser;
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
     * 获取脸部特性数据
     *
     * @return face_feature - 脸部特性数据
     */
    public byte[] getFaceFeature() {
        return faceFeature;
    }

    /**
     * 设置脸部特性数据
     *
     * @param faceFeature 脸部特性数据
     */
    public void setFaceFeature(byte[] faceFeature) {
        this.faceFeature = faceFeature;
    }
}