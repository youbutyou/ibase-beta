package cn.ibase.beta.web.controller;

import cn.ibase.beta.common.controller.BaseController;
import cn.ibase.beta.common.dto.FormResult;
import cn.ibase.beta.system.dto.SystemModuleDto;
import cn.ibase.beta.system.dto.SystemUserDto;
import cn.ibase.beta.web.dto.LoginInfo;
import cn.ibase.beta.web.service.LoginService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: song
 * @Date: 2019/9/11
 */
@Controller
@RequestMapping("/")
public class BetaController extends BaseController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登陆界面")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        return "main/login";
    }

    @ApiOperation(value = "主界面")
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        SystemModuleDto moduleDto = loginService.getSystemInfo();
        SystemUserDto userDto = loginService.getLoginUserInfo(request);
        model.addAttribute("systemname", (null != moduleDto && StringUtils.isNotBlank(moduleDto.getIname())) ? moduleDto.getIname() : "youbutyou" );
        model.addAttribute("username", (null != userDto && StringUtils.isNotBlank(userDto.getIname())) ? userDto.getIname() : "我");
        return "main/main";
    }

    @ApiOperation(value = "执行登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "userName", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "password", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public FormResult login(@Validated LoginInfo loginInfo) {
        return loginService.login(loginInfo, request);
    }
}
