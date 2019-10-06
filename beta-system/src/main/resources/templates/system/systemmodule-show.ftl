<!DOCTYPE HTML>
<html lang="zh_CN" xmlns:th="http://www.springframework.org/schema/jdbc">
<head>
    <title></title>
    <meta content="text/html;charset=UTF-8" http-equiv="content-type">
    <link href="/resources/common/commonCss.css" hreflang="zh_CN" rel="stylesheet" type="text/css">
</head>
<body>
<div class="layui-layout-body">
    <div style="display: none;">
        <input id="modulesn" name="modulesn" th:value="${modulesn}">
    </div>
    <table id="list_data" class="layui-table" lay-filter="list_data"></table>
</div>
</body>
<script src="/resources/common/commonJs.js"></script>
<script type="text/javascript" th:inline="none">
    var tableRender;
    layui.config({
        base: '/resources/css/layui/'
    }).extend({
        treetable: 'treetable-lay/treetable'
    }).use(['layer', 'form','table','treetable'], function(){
        // 获取工具栏
        toolbar_table_getToolbar($("#modulesn").val(),layui);
        // 数据初始化
        var treetable = layui.treetable;
        // 渲染表格
        tableRender = function(){
            treetable.render({
                elem: '#list_data',
                method:"post",
                url: '/systemmodule/list',
                where:{
                    pagination:'false'
                },
                height: $('.layui-layout-body').height(),
                initSort:'orderNumber',
                loading:true,
                toolbar: '#tool_bar',
                treeColIndex: 3,            // 树形图标显示在第几列
                treeSpid: 'zero',           // 最上级的父级id
                treeIdName: 'sn',           // id字段的名称
                treePidName: 'psn',         // pid字段的名称，父级菜单id
                treeDefaultClose:false,      // 是否默认折叠
                treeLinkage: false,         // 父级展开时是否自动展开所有子级
                cols: [[
                    {checkbox: true}
                    ,{field: 'id', title: 'ID',hide:true}
                    ,{field: 'sn', title: '编码',hide:true}
                    ,{field: 'iname', title: '名称'}
                    ,{field: 'dicSnName', title: '模块类型'}
                    ,{field: 'fileType', title: '文件类型',templet:'#fileTypeTpl'}
                    ,{field: 'state', title: '数据状态',templet:'#stateTpl'}
                    ,{fixed: 'right',title: '操作', align:'center', toolbar: '#row_bar'}
                ]],
                parseData: function(res) { //res 即为原始返回的数据
                    return toolbar_parseTableData(res);
                },
                done: function(res, curr, count){
                    // 数据渲染结束
                }
            });
        };
        tableRender();
        //监听工具栏事件
        toolbar_table_toolbarOn('list_data', layui);
    });
</script>
</html>
