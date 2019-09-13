package cn.ibase.beta.arcsoft.service.impl;

import cn.ibase.beta.arcsoft.dao.ArcsoftFaceDao;
import cn.ibase.beta.arcsoft.dto.ArcsoftFaceDto;
import cn.ibase.beta.arcsoft.service.ArcsoftFaceService;
import cn.ibase.beta.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  ServiceImpl
 * Created by Generator on 2019-09-11 12:26:20.
 */
@Service("ArcsoftFaceService")
public class ArcsoftFaceServiceImpl extends BaseServiceImpl<ArcsoftFaceDto> implements ArcsoftFaceService {

    @Autowired
    private ArcsoftFaceDao arcsoftFaceDao;


}
