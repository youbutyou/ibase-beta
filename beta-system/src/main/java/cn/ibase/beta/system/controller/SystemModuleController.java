package cn.ibase.beta.system.controller;

import cn.ibase.beta.common.controller.BaseController;
import cn.ibase.beta.common.dto.DataPage;
import cn.ibase.beta.common.dto.FormResult;
import cn.ibase.beta.common.dto.NavData;
import cn.ibase.beta.common.info.ResultEnum;
import cn.ibase.beta.common.util.ResultUtil;
import cn.ibase.beta.system.dto.SystemModuleDto;
import cn.ibase.beta.system.service.SystemModuleService;
import cn.ibase.beta.system.util.InfoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 *  Controller
 * Created by Generator on 2019-09-14 12:17:19.
 */
@Api(" 相关接口")
@Controller
@RequestMapping("/systemmodule")
public class SystemModuleController extends BaseController {
    @Autowired
    private SystemModuleService systemModuleService;


    @ApiOperation(value = "主界面")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("modulesn", request.getParameter("modulesn"));
        return "system/systemmodule-show";
    }

    @ApiOperation(value = "查询列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public DataPage<SystemModuleDto> showPageData(@ModelAttribute SystemModuleDto systemModuleDto) {
        return systemModuleService.showPageData(systemModuleDto);
    }



    @ApiOperation(value = "查询列表")
    @RequestMapping(value = "/listwithchildren", method = RequestMethod.POST)
    @ResponseBody
    public List<NavData> listWithChildren(@ModelAttribute SystemModuleDto systemModuleDto) {
        List<SystemModuleDto> list = systemModuleService.loadList(systemModuleDto);
        List<NavData> nav = new ArrayList<>(list.size());
        list.forEach(item->{
            if(StringUtils.isBlank(item.getpsn())){
                nav.add(InfoUtil.moduleToNav(item));
            }
        });
        for(NavData navData : nav){
            list.forEach(item->{
                if(navData.getSn().equals(item.getpsn())){
                    if(null == navData.getChildren()){
                        navData.setChildren(new ArrayList<>());
                    }
                    navData.getChildren().add(InfoUtil.moduleToNav(item));
                }
            });
        }
        return nav;
    }

    @ApiOperation(value = "查询一条记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public FormResult load(@NotNull Integer id) {
        SystemModuleDto moduleDto = systemModuleService.load(id);
        if(null == moduleDto){
            return ResultUtil.createErrorFormResult(id, ResultEnum.SYS_FOND_ERROR);
        }
        return ResultUtil.createRightFormResult(moduleDto);
    }

    @ApiOperation(value = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public FormResult<Object> save(@ModelAttribute @Validated SystemModuleDto systemModuleDto) {
        systemModuleService.save(systemModuleDto);
        return ResultUtil.createRightFormResult(systemModuleDto);
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids", value = "选中记录ID-in()", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public FormResult<String> delete(String ids) {
        Integer count = systemModuleService.delete(ids);
        return ResultUtil.createRightFormResult(ids, ResultEnum.SYS_EXE_SUCCESS);
    }

}
