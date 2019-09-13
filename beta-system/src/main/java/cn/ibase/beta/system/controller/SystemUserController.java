package cn.ibase.beta.system.controller;

import cn.ibase.beta.common.controller.BaseController;
import cn.ibase.beta.common.dto.DataPage;
import cn.ibase.beta.common.dto.FormResult;
import cn.ibase.beta.common.util.ResultUtil;
import cn.ibase.beta.system.dto.SystemUserDto;
import cn.ibase.beta.system.service.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *  Controller
 * Created by Generator on 2019-09-11 12:26:20.
 */
@Api(" 相关接口")
@Controller
@RequestMapping("/systemuser")
public class SystemUserController extends BaseController {

    @Autowired
    private SystemUserService systemUserService;


    @ApiOperation(value = "主界面")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("modulesn", request.getParameter("modulesn"));
        return "system/systemuser-show";
    }

    @ApiOperation(value = "查询列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<SystemUserDto> showPageData(@ModelAttribute SystemUserDto systemUserDto) {
        return systemUserService.showPageData(systemUserDto);
    }

    @ApiOperation(value = "查询一条记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @ResponseBody
    public FormResult<SystemUserDto> load(Integer id) {
        if (null != id && 0 <= id) {
            return ResultUtil.createRightFormResult(systemUserService.load(id));
        }
        return null;
    }
    
    @ApiOperation(value = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public FormResult<Object> save(@ModelAttribute @Validated SystemUserDto systemUserDto) {
        systemUserService.save(systemUserDto);
        return ResultUtil.createRightFormResult(systemUserDto);
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids", value = "选中记录ID-in()", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public FormResult<String> delete(String ids) {
        Integer count = systemUserService.delete(ids);
        return ResultUtil.createRightFormResult(String.valueOf(count));
    }

}
