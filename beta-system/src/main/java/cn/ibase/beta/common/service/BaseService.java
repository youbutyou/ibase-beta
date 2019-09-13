package cn.ibase.beta.common.service;


import cn.ibase.beta.common.dto.DataPage;

import java.util.List;

public interface BaseService<T> {

    DataPage<T> showPageData(T dto);

    List<T> loadList(T dto);

    T load(Integer id);

    T load(T dto);

    T load(Class<T> clazz, String attr, Object val);

    Integer save(T dto);

    /**
     * 保存或更新数据，保持数据唯一性
     * @param clazz
     * @param dto
     * @param Attributes 唯一性属性检查
     * @return
     */
    Integer saveRemoveRepeat(Class<T> clazz, T dto, String[] Attributes);

    /**
     * 唯一性检查
     * @param clazz
     * @param dto
     * @param attributes
     * @return
     */
    boolean checkUniqueness(Class<T> clazz, T dto, String[] attributes);

    int delete(String ids);

    T saveUserAndTime(T dto);

}
