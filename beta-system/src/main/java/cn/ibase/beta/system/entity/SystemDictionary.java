package cn.ibase.beta.system.entity;


import cn.ibase.beta.common.entity.BaseEntity;

/**
 *  Entity
 * Created by Generator on 2019-09-14 12:17:21.
 */
public class SystemDictionary extends BaseEntity {
    /**
     * 编号
     */
    private String sn;

    /**
     * 名称
     */
    private String iname;

    private String psn;

    /**
     * 排序号
     */
    private Integer orderNumber;

    /**
     * 数据状态
     */
    private String state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 类型编码
     */
    private byte[] dicTypeSn;

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
     * @return psn
     */
    public String getpsn() {
        return psn;
    }

    /**
     * @param psn
     */
    public void setpsn(String psn) {
        this.psn = psn;
    }

    /**
     * 获取排序号
     *
     * @return order_number - 排序号
     */
    public Integer getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置排序号
     *
     * @param orderNumber 排序号
     */
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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

    /**
     * 获取类型编码
     *
     * @return dic_type_sn - 类型编码
     */
    public byte[] getDicTypeSn() {
        return dicTypeSn;
    }

    /**
     * 设置类型编码
     *
     * @param dicTypeSn 类型编码
     */
    public void setDicTypeSn(byte[] dicTypeSn) {
        this.dicTypeSn = dicTypeSn;
    }
}