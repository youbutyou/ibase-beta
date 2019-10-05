package cn.ibase.beta.common.service.impl;

import cn.ibase.beta.common.dao.BaseDao;
import cn.ibase.beta.common.dto.DataPage;
import cn.ibase.beta.common.dto.LoginUser;
import cn.ibase.beta.common.entity.BaseEntity;
import cn.ibase.beta.common.service.BaseService;
import cn.ibase.beta.common.service.CommonQueryService;
import cn.ibase.beta.common.util.ReflectUtils;
import cn.ibase.beta.common.util.ResultUtil;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    private final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    private BaseDao<T> dao;

    @Autowired
    private CommonQueryService commonQueryService;

    @Override
    public DataPage<T> showPageData(T dto) {
        this.setCommonInfo(dto);
        List<T> list = dao.queryBySql(dto);
        int total = dao.countBySql(dto);
        return ResultUtil.createRightDataPage(list,total);
    }

    @Override
    public List<T> loadList(T dto) {
        return dao.queryBySql(dto);
    }

    @Override
    public T load(Integer id) {
        if (null != id && 0 < id) {
            return dao.queryOneById(id);
        }
        return null;
    }

    @Override
    public T load(T dto) {
        return dao.queryOneBySql(dto);
    }

    @Override
    public T load(Class<T> clazz, String attr, Object val) {
        T queryDto = null;
        try {
            queryDto = clazz.newInstance();
        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        }
        ReflectUtils.setFieldValue(queryDto, attr, val);
        return dao.queryOneBySql(queryDto);
    }

    @Override
    public Integer save(T dto) {
        Integer id = (Integer) ReflectUtils.getFieldValue(dto, "id");
        if(id == null){
            dao.insert(dto);
            return dto.getId();
        }
        dao.update(dto);
        return id;
    }

    @Override
    public Integer saveRemoveRepeat(Class<T> clazz, T dto, String[] attributes) {
        Integer id = null;
        T queryDto = null;
        if (attributes != null && attributes.length > 0) {
            try {
                queryDto = clazz.newInstance();
            } catch (InstantiationException e) {
                logger.error(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage(), e);
            }
            boolean mark = false;
            for (String attr : attributes) {
                Object attrValue = ReflectUtils.getFieldValue(dto, attr);
                if (attrValue != null) {
                    ReflectUtils.setFieldValue(queryDto, attr, attrValue);
                    if (!mark) {
                        mark = true;
                    }
                }
            }
            if (mark) {
                queryDto = dao.queryUniqueBySql(queryDto);
            } else {
                queryDto = null;
            }
        }
        if (queryDto != null) {
            if (ReflectUtils.getField(clazz, "editTime") != null) {
                Object editTime = ReflectUtils.getFieldValue(dto, "editTime");
                if (editTime == null) {
                    ReflectUtils.setFieldValue(dto, "editTime", new Date(System.currentTimeMillis()));
                }
            }
            ReflectUtils.setFieldValue(dto, "id", queryDto.getId());
            dao.update(dto);
            id = queryDto.getId();
        } else {
            if (ReflectUtils.getField(clazz, "addTime") != null) {
                Object addTime = ReflectUtils.getFieldValue(dto, "addTime");
                if (addTime == null) {
                    ReflectUtils.setFieldValue(dto, "addTime", new Date(System.currentTimeMillis()));
                }
            }
            dao.insert(dto);
            id = dto.getId();
        }
        return id;
    }

    @Override
    public boolean checkUniqueness(Class<T> clazz, T dto, String[] attributes){
        T queryDto = null;
        if (attributes != null && attributes.length > 0) {
            try {
                queryDto = clazz.newInstance();
            } catch (InstantiationException e) {
                logger.error(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage(), e);
            }
            boolean mark = false;
            for (String attr : attributes) {
                Object attrValue = ReflectUtils.getFieldValue(dto, attr);
                if (attrValue != null) {
                    ReflectUtils.setFieldValue(queryDto, attr, attrValue);
                    if (!mark) {
                        mark = true;
                    }
                }
            }
            if (mark) {
                queryDto = dao.queryUniqueBySql(queryDto);
            } else {
                queryDto = null;
            }
        }
        if (queryDto != null && !queryDto.getId().equals(dto.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int delete(String ids) {
        if (StringUtils.isBlank(ids)) {
            return 0;
        }
        Integer[] idArray = Iterables.toArray(Ints.stringConverter().convertAll(Splitter.on(",").omitEmptyStrings().trimResults().splitToList(ids)), Integer.class);
        dao.delete(idArray);
        return idArray.length;
    }

    @Override
    public T saveUserAndTime(T dto){
        if(null == dto){
            return dto;
        }
        LoginUser sysUser = commonQueryService.getCurrentUser();
        if(null == sysUser){
            return dto;
        }
        if(null != dto.getId()){
            if (ReflectUtils.getField(dto.getClass(), "editTime") != null) {
                ReflectUtils.setFieldValue(dto, "editTime", new Date(System.currentTimeMillis()));
            }
            if (ReflectUtils.getField(dto.getClass(), "editUser") != null) {
                ReflectUtils.setFieldValue(dto, "editUser", sysUser.getIname());
            }
            if (ReflectUtils.getField(dto.getClass(), "editUserId") != null) {
                ReflectUtils.setFieldValue(dto, "editUserId", sysUser.getId());
            }
        }else{
            if (ReflectUtils.getField(dto.getClass(), "addTime") != null) {
                ReflectUtils.setFieldValue(dto, "addTime", new Date(System.currentTimeMillis()));
            }
            if (ReflectUtils.getField(dto.getClass(), "addUser") != null) {
                ReflectUtils.setFieldValue(dto, "addUser", sysUser.getIname());
            }
            if (ReflectUtils.getField(dto.getClass(), "addUserId") != null) {
                ReflectUtils.setFieldValue(dto, "addUserId", sysUser.getId());
            }
        }
        return dto;
    }

    private String getRoleSnFromSession() {
        String roleSn = "";
        LoginUser user = commonQueryService.getCurrentUser();
        if (user == null) {
            return roleSn;
        } else {
            return "admin".equals(user.getSn()) ? roleSn : user.getRoleSn();
        }
    }

    public void setCommonInfo(BaseEntity baseEntity) {
        if (baseEntity.getPagination() == null || baseEntity.getPagination()) {
            String order = this.orderby(baseEntity.getSort(), baseEntity.getOrder(), true);
            if (order.contains(";") || order.contains("--") || order.contains("'")) {
                order = "";
            }

            int limit = baseEntity.getLimit() != null ? baseEntity.getLimit() : 20;
            int page = baseEntity.getPage() != null ? baseEntity.getPage() : 1;
            int offset = (page - 1) * limit;
            baseEntity.setOffset(offset);
            baseEntity.setLimit(limit);
            baseEntity.setOrder(order);
        }
        LoginUser user = commonQueryService.getCurrentUser();
        if (user != null && StringUtils.isNotEmpty(user.getSn())) {
            baseEntity.setUserRoleSn(StringUtils.isBlank(this.getRoleSnFromSession()) ? null : this.getRoleSnFromSession());
            baseEntity.setUserRoleTypeSn(StringUtils.isBlank(this.getRoleSnFromSession()) ? null : user.getRoleTypeSn());
            baseEntity.setUserSn(user.getSn());
            baseEntity.setUserOrgSn(user.getOrgSn());
        }
    }

    private String orderby(String sort, String order, Boolean multisort) {
        String partOfSql = "";
        if (null != sort && null != order) {
            if (!multisort) {
                partOfSql = " " + sort + " " + order;
            } else {
                String[] s = sort.split(",");
                String[] o = order.split(",");
                if (0 < s.length && s.length == o.length) {
                    partOfSql = " ";

                    for (int i = 0; i < s.length; ++i) {
                        partOfSql = partOfSql + s[i] + " " + o[i] + ",";
                    }

                    partOfSql = partOfSql.substring(0, partOfSql.length() - 1);
                }
            }
        }
        return partOfSql;
    }
}
