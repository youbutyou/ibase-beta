package cn.ibase.beta.common.controller;

import cn.ibase.beta.common.service.CommonQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: song
 * @Date: 2019/9/11
 */
public class BaseController {

    public final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected CommonQueryService commonQueryService;

    /**
     * 获取模块ID
     * @return
     */
    protected String getModuleSn() {
        return request.getParameter("modulesn") == null ? null : (String) request.getParameter("modulesn");
    }
}
