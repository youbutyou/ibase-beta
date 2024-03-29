package cn.ibase.beta.system.controller;

import cn.ibase.beta.common.controller.BaseController;
import cn.ibase.beta.common.dto.DataPage;
import cn.ibase.beta.common.dto.FormResult;
import cn.ibase.beta.common.info.ResultEnum;
import cn.ibase.beta.common.util.ResultUtil;
import cn.ibase.beta.system.dto.SystemDictionaryDto;
import cn.ibase.beta.system.service.SystemDictionaryService;
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

/**
 *  Controller
 * Created by Generator on 2019-09-14 12:17:19.
 */
@Api(" 相关接口")
@Controller
@RequestMapping("/systemdictionary")
public class SystemDictionaryController extends BaseController {

    @Autowired
    private SystemDictionaryService systemDictionaryService;

    @ApiOperation(value = "主界面")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("modulesn", request.getParameter("modulesn"));
        return "system/systemdictionary-show";
    }

    @ApiOperation(value = "详情")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "system/systemdictionary-info";
    }

    @ApiOperation(value = "查询列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public DataPage<SystemDictionaryDto> showPageData(@ModelAttribute SystemDictionaryDto systemDictionaryDto) {
        return systemDictionaryService.showPageData(systemDictionaryDto);
    }

    @ApiOperation(value = "查询一条记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public FormResult load(@NotNull Integer id) {
        SystemDictionaryDto dictionaryDto = systemDictionaryService.load(id);
        if(null == dictionaryDto){
            return ResultUtil.createErrorFormResult(id, ResultEnum.SYS_FOND_ERROR);
        }
        return ResultUtil.createRightFormResult(dictionaryDto);
    }
    
    @ApiOperation(value = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public FormResult save(@ModelAttribute @Validated SystemDictionaryDto systemDictionaryDto) {
        systemDictionaryService.save(systemDictionaryDto);
        return ResultUtil.createRightFormResult(systemDictionaryDto);
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids", value = "选中记录ID-in()", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public FormResult<String> delete(String ids) {
        Integer count = systemDictionaryService.delete(ids);
        return ResultUtil.createRightFormResult(ids,ResultEnum.SYS_EXE_SUCCESS);
    }
}
