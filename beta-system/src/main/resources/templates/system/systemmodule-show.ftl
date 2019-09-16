<#include "./common/include.ftl" />
<#include "./common/toolbar.ftl" />
<!DOCTYPE HTML>
<html lang="zh_CN">
<head>
    <title></title>
    <meta content="text/html;charset=UTF-8" http-equiv="content-type">
</head>
<body>
<div id="home3" class="easyui-layout" data-options="fit:true">
    <div id="home3NorthBody" data-options="region:'north'">
        <form id="searchForm" style="margin:0;">
            <div style="display:none;">
                <input id="moduleid" name="moduleid">
            </div>
            <ul class="search-form">
                    <li class="search-form-li">
                        编号<input id="sn" name="sn" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        名称<input id="iname" name="iname" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        父节点<input id="pid" name="pid" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        url<input id="url" name="url" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        图标<input id="icon" name="icon" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        字典编码<input id="dicSn" name="dicSn" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        排序号<input id="orderNumber" name="orderNumber" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        数据状态<input id="state" name="state" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        备注<input id="remark" name="remark" style="width:120px;">
                    </li>
                <li class="search-form-li">
                    <a id="submitSearch" class="search-form-btn ccrfid-search" href="javascript:void(0)"></a>
                </li>
            </ul>
        </form>
    </div>
    <div id="home3CenterBody" data-options="region:'center'">
        <table id="list_data"></table>
    </div>
</div>
</body>
<script type="text/javascript" charset="UTF-8" src="/js/common/toolbar.js"></script>
<script type="text/javascript" charset="UTF-8" src="/js/common/tree-util.js"></script>
<script type="text/javascript">
    var queryParams={};
    $(function(){
        /**********工具条**********/
        contextPath="";
        getToolbar(contextPath,"${moduleid}");

        /**********数据网格**********/
        $("#list_data").datagrid({
            method:"GET",
            url:"/systemmodule/list",
            autoRowHeight:false,
            ctrlSelect:true,
            fit:true,
            idField:"id",
            pagination:true,
            resizeable:true,
            rownumbers:true,
            pageSize:20,
            singleSelect:false,
            striped:true,
            toolbar:"#ccms-toolbar",
            frozenColumns:[[
                {field:"ck",checkbox:true}
            ]],
            columns:[[
                {field:"id",hidden:true},
                {field:'sn',title:'编号',width:100,align:"center"},
                {field:'iname',title:'名称',width:100,align:"center"},
                {field:'pid',title:'父节点',width:100,align:"center"},
                {field:'url',title:'url',width:100,align:"center"},
                {field:'icon',title:'图标',width:100,align:"center"},
                {field:'dicSn',title:'字典编码',width:100,align:"center"},
                {field:'orderNumber',title:'排序号',width:100,align:"center"},
                {field:'state',title:'数据状态',width:100,align:"center"},
                {field:'remark',title:'备注',width:100,align:"center"},
                {field:"operate",title:"操作",width:150,align:"center",
                    formatter:function(value,rowData,rowIndex){
                        return rowTools(value,rowData,rowIndex);
                    }
                }
            ]],
            onLoadSuccess:function(data){
                loadRowBar(data);
                $("#list_data").datagrid("clearSelections");
            }
        });
    });
    /**
     * 保存成功时
     */
    function whenSaveSuccess(id,data,win){
        $.messager.progress("close");
        if(null!=data){
            if(data.code == "validation-fail"){
                $.messager.alert("提示",data.message +  JSON.stringify(data.data));
                return;
            }
            if(data.success){
                win.window("close");
                $("#list_data").datagrid("reload");
                showMessage(data.message);
                return;
            }else{
                $.messager.alert("提示", data.message);
                return;
            }
        }
        $.messager.alert("提示","操作失败！");
    }
    /**
     * 删除成功时
     */
    function whenDelSuccess(ids,data){
        if(null!=data){
            if(data.success){
                $("#list_data").datagrid("reload");
                showMessage(data.message);
                return;
            }
        }
        $("#list_data").datagrid("reload");
        $.messager.alert("提示", data.message);
    }
</script>
</html>
