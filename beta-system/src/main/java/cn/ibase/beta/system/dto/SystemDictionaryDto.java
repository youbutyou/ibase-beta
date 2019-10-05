package cn.ibase.beta.system.dto;

import cn.ibase.beta.system.entity.SystemDictionary;

/**
 *  Dto
 * Created by Generator on 2019-09-14 12:17:19.
 */
public class SystemDictionaryDto extends SystemDictionary{

    private String dicTypeSnName;

    public String getDicTypeSnName() {
        return dicTypeSnName;
    }

    public void setDicTypeSnName(String dicTypeSnName) {
        this.dicTypeSnName = dicTypeSnName;
    }

}
