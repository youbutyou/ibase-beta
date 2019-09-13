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
                        编码<input id="sn" name="sn" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        姓名<input id="iname" name="iname" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        密码<input id="password" name="password" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        手机号码<input id="phone" name="phone" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        组织编码<input id="orgSn" name="orgSn" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        数据状态<input id="state" name="state" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        添加/编辑时间<input id="editTime" name="editTime" style="width:120px;">
                    </li>
                    <li class="search-form-li">
                        添加/编辑人员<input id="editUser" name="editUser" style="width:120px;">
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
            url:"/systemuser/list",
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
                {field:'sn',title:'编码',width:100,align:"center"},
                {field:'iname',title:'姓名',width:100,align:"center"},
                {field:'password',title:'密码',width:100,align:"center"},
                {field:'phone',title:'手机号码',width:100,align:"center"},
                {field:'orgSn',title:'组织编码',width:100,align:"center"},
                {field:'state',title:'数据状态',width:100,align:"center"},
                {field:'editTime',title:'添加/编辑时间',width:100,align:"center"},
                {field:'editUser',title:'添加/编辑人员',width:100,align:"center"},
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
