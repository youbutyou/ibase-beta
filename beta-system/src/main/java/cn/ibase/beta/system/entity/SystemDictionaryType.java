package cn.ibase.beta.system.entity;


import cn.ibase.beta.common.entity.BaseEntity;

/**
 *  Entity
 * Created by Generator on 2019-09-14 12:17:21.
 */
public class SystemDictionaryType extends BaseEntity {
    /**
     * 编号
     */
    private String sn;

    /**
     * 名称
     */
    private String iname;

    /**
     * 父节点
     */
    private String psn;

    /**
     * 数据状态
     */
    private String state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取编号
     *
     * @return sn - 编号
     */
    public String getSn() {
        return sn;
    }

    /**
     * 设置编号
     *
     * @param sn 编号
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * 获取名称
     *
     * @return iname - 名称
     */
    public String getIname() {
        return iname;
    }

    /**
     * 设置名称
     *
     * @param iname 名称
     */
    public void setIname(String iname) {
        this.iname = iname;
    }

    /**
     * 获取父节点
     *
     * @return psn - 父节点
     */
    public String getpsn() {
        return psn;
    }

    /**
     * 设置父节点
     *
     * @param psn 父节点
     */
    public void setpsn(String psn) {
        this.psn = psn;
    }

    /**
     * 获取数据状态
     *
     * @return state - 数据状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置数据状态
     *
     * @param state 数据状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}