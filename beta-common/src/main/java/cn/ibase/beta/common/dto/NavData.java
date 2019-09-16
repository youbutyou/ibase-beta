package cn.ibase.beta.common.dto;

import java.util.List;

/**
 * 导航栏数据（layui）
 * @Author: song
 * @Date: 2019/9/15
 */
public class NavData {

    private String title;
    private String icon;
    private String href;
    private boolean spread;
    private List<NavData> children;

    private String sn;      // 模块sn
    private String url;     // 模块ur
    private String type;    // 文件类型

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<NavData> getChildren() {
        return children;
    }

    public void setChildren(List<NavData> children) {
        this.children = children;
    }
}
