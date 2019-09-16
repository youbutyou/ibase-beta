package cn.ibase.beta.system.util;

import cn.ibase.beta.common.dto.NavData;
import cn.ibase.beta.system.dto.SystemModuleDto;

/**
 * 对象转换工具类
 * @Author: song
 * @Date: 2019/9/15
 */
public class InfoUtil {

    /**
     * 模块转导航栏数据
     * @param moduleDto
     * @return
     */
    public static NavData moduleToNav(SystemModuleDto moduleDto){
        if(null == moduleDto){
            return null;
        }
        NavData navData = new NavData();
        navData.setTitle(moduleDto.getIname());
        navData.setIcon(moduleDto.getIcon());
        navData.setHref("#");
        navData.setSpread(false);
        navData.setSn(moduleDto.getSn());
        navData.setUrl(moduleDto.getUrl());
        navData.setType(moduleDto.getFileType());
        return navData;
    }
}
