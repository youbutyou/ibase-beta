package cn.ibase.beta.common.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {

    int countBySql(T dto);

    List<T> queryBySql(T dto);

    T queryOneBySql(T dto);

    T queryUniqueBySql(T dto);

    T queryOneById(int id);

    Integer insert(T dto);

    void update(T dto);

    void delete(@Param("idArray") Integer[] idArray);

}
