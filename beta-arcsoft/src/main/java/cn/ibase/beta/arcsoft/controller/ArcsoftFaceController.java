package cn.ibase.beta.arcsoft.controller;

import cn.ibase.beta.common.controller.BaseController;
import cn.ibase.beta.common.dto.DataPage;
import cn.ibase.beta.common.dto.FormResult;
import cn.ibase.beta.common.util.ResultUtil;
import cn.ibase.beta.arcsoft.dto.ArcsoftFaceDto;
import cn.ibase.beta.arcsoft.service.ArcsoftFaceService;
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

/**
 *  Controller
 * Created by Generator on 2019-09-11 12:26:20.
 */
@Api("相关接口")
@Controller
@RequestMapping("/arcsoftface")
public class ArcsoftFaceController extends BaseController {

    @Autowired
    private ArcsoftFaceService arcsoftFaceService;

    @ApiOperation(value = "主界面")
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("modulesn", request.getParameter("modulesn"));
        return "arcsoft/arcsoftface-show";
    }

    @ApiOperation(value = "查询列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<ArcsoftFaceDto> showPageData(@ModelAttribute ArcsoftFaceDto arcsoftFaceDto) {
        return arcsoftFaceService.showPageData(arcsoftFaceDto);
    }

    @ApiOperation(value = "查询一条记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @ResponseBody
    public FormResult<ArcsoftFaceDto> load(Integer id) {
        if (null != id && 0 <= id) {
            return ResultUtil.createRightFormResult(arcsoftFaceService.load(id));
        }
        return null;
    }
    
    @ApiOperation(value = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public FormResult<Object> save(@ModelAttribute @Validated ArcsoftFaceDto arcsoftFaceDto) {
        arcsoftFaceService.save(arcsoftFaceDto);
        return ResultUtil.createRightFormResult(arcsoftFaceDto);
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids", value = "选中记录ID-in()", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public FormResult<String> delete(String ids) {
        Integer count = arcsoftFaceService.delete(ids);
        return ResultUtil.createRightFormResult(String.valueOf(count));
    }

}
