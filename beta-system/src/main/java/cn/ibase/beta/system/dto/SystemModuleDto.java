package cn.ibase.beta.system.dto;

import cn.ibase.beta.system.entity.SystemModule;

import java.util.List;

/**
 *  Dto
 * Created by Generator on 2019-09-14 12:17:19.
 */
public class SystemModuleDto extends SystemModule{

    /**
     * 字典类型
     */
    private List<String> dicSns;

    private List<SystemModuleDto> children;

    public List<String> getDicSns() {
        return dicSns;
    }

    public void setDicSns(List<String> dicSns) {
        this.dicSns = dicSns;
    }

    public List<SystemModuleDto> getChildren() {
        return children;
    }

    public void setChildren(List<SystemModuleDto> children) {
        this.children = children;
    }
}
