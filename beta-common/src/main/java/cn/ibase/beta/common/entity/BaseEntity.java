package cn.ibase.beta.common.entity;

public class BaseEntity{

    /**
     * 数据库 id
     */
    protected Integer id;

    /**
     * 前端 第几页
     */
    protected Integer page = 1;

    /**
     * 前端 查几行
     */
    protected Integer rows = 20;

    /**
     * 前端 是否分页
     */
    protected Boolean pagination;

    /**
     * 前端、数据库 排序字段
     */
    protected String sort;

    /**
     * 前端、数据库 排序类型
     */
    protected String order;

    /**
     * 数据库 起始条目
     */
    protected Integer offset;

    /**
     * 数据库 偏移量
     */
    protected Integer limit;

    /**
     * 数据版本
     */
    private Integer dataVersion;

    /**
     * 用户编号
     */
    private String userSn;

    /**
     * 用户角色编号
     */
    private String userRoleSn;

    /**
     * 用户角色类型编号
     */
    private String userRoleTypeSn;

    /**
     * 用户组织编号
     */
    private String userOrgSn;

    public String getUserSn() {
        return userSn;
    }

    public void setUserSn(String userSn) {
        this.userSn = userSn;
    }

    public String getUserRoleSn() {
        return userRoleSn;
    }

    public void setUserRoleSn(String userRoleSn) {
        this.userRoleSn = userRoleSn;
    }

    public String getUserRoleTypeSn() {
        return userRoleTypeSn;
    }

    public void setUserRoleTypeSn(String userRoleTypeSn) {
        this.userRoleTypeSn = userRoleTypeSn;
    }

    public String getUserOrgSn() {
        return userOrgSn;
    }

    public void setUserOrgSn(String userOrgSn) {
        this.userOrgSn = userOrgSn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Boolean getPagination() {
        return pagination;
    }

    public void setPagination(Boolean pagination) {
        this.pagination = pagination;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Integer dataVersion) {
        this.dataVersion = dataVersion;
    }
}
