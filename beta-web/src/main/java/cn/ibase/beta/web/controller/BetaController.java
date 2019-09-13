package cn.ibase.beta.web.controller;

import cn.ibase.beta.common.dto.FormResult;
import cn.ibase.beta.common.util.ResultUtil;
import cn.ibase.beta.system.dto.SystemUserDto;
import cn.ibase.beta.system.entity.SystemUserInfo;
import cn.ibase.beta.system.service.SystemUserService;
import cn.ibase.beta.web.dto.LoginInfo;
import cn.ibase.beta.web.service.LoginService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
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
public class BetaController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登陆界面")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        return "main/login";
    }
    @ApiOperation(value = "登陆界面")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login1() {
        return "main/login";
    }

    @ApiOperation(value = "主界面")
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "main/main";
    }

    @ApiOperation(value = "执行登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "userName", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "password", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/executelogin", method = RequestMethod.POST)
    public String executeLogin(@Validated LoginInfo loginInfo) {
        return loginService.login(loginInfo);
    }
}
