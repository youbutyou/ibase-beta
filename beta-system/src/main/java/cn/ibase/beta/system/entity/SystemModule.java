package cn.ibase.beta.system.entity;


import cn.ibase.beta.common.entity.BaseEntity;

/**
 *  Entity
 * Created by Generator on 2019-09-14 12:17:22.
 */
public class SystemModule extends BaseEntity {
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
     * url
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 字典编码
     */
    private String dicSn;

    /**
     * 排序号
     */
    private Integer orderNumber;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 数据状态
     */
    private String state;

    /**
     * 备注
     */
    private String remark;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

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
     * 获取url
     *
     * @return url - url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取字典编码
     *
     * @return dic_sn - 字典编码
     */
    public String getDicSn() {
        return dicSn;
    }

    /**
     * 设置字典编码
     *
     * @param dicSn 字典编码
     */
    public void setDicSn(String dicSn) {
        this.dicSn = dicSn;
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
}