package cn.ibase.beta.system.controller;

import cn.ibase.beta.common.controller.BaseController;
import cn.ibase.beta.common.dto.DataPage;
import cn.ibase.beta.common.dto.FormResult;
import cn.ibase.beta.common.info.ResultEnum;
import cn.ibase.beta.common.util.ResultUtil;
import cn.ibase.beta.system.dto.SystemDictionaryTypeDto;
import cn.ibase.beta.system.service.SystemDictionaryTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.text.MessageFormat;

/**
 *  Controller
 * Created by Generator on 2019-09-14 12:17:19.
 */
@Api(" 相关接口")
@Controller
@RequestMapping("/systemdictionarytype")
public class SystemDictionaryTypeController extends BaseController {

    @Autowired
    private SystemDictionaryTypeService systemDictionaryTypeService;

    @ApiOperation(value = "主界面")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("modulesn", request.getParameter("modulesn"));
        return "system/systemdictionarytype-show";
    }

    @ApiOperation(value = "查询列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public DataPage<SystemDictionaryTypeDto> showPageData(@ModelAttribute SystemDictionaryTypeDto systemDictionaryTypeDto) {
        return systemDictionaryTypeService.showPageData(systemDictionaryTypeDto);
    }

    @ApiOperation(value = "查询一条记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public FormResult load(@NotNull Integer id) {
        SystemDictionaryTypeDto typeDto = systemDictionaryTypeService.load(id);
        if(null == typeDto){
            return ResultUtil.createErrorFormResult(id, ResultEnum.SYS_FOND_ERROR);
        }
        return ResultUtil.createRightFormResult(typeDto);
    }
    
    @ApiOperation(value = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public FormResult<Object> save(@ModelAttribute @Validated SystemDictionaryTypeDto systemDictionaryTypeDto) {
        systemDictionaryTypeService.save(systemDictionaryTypeDto);
        return ResultUtil.createRightFormResult(systemDictionaryTypeDto);
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids", value = "选中记录ID-in()", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public FormResult<String> delete(String ids) {
        Integer count = systemDictionaryTypeService.delete(ids);
        return ResultUtil.createRightFormResult(ids, ResultEnum.SYS_EXE_SUCCESS);
    }

}
