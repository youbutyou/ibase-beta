<!DOCTYPE HTML>
<html lang="zh_CN" xmlns:th="http://www.springframework.org/schema/jdbc">
<head>
    <title></title>
    <meta content="text/html;charset=UTF-8" http-equiv="content-type">
    <link href="/resources/common/commonCss.css" hreflang="zh_CN" rel="stylesheet" type="text/css">
</head>
<body>
<div id="home1" class="layui-layout-body">
    <div style="display: none;">
        <input id="modulesn" name="modulesn" value="${modulesn}">
    </div>
    <table id="list_data" lay-filter="list_table"></table>
</div>
</body>
<script src="/resources/common/commonJs.js"></script>
<script type="text/javascript" th:inline="none">
    layui.use(['layer', 'form','table'], function(){
        // 获取模块编号
        var modulesn = $("#modulesn").val();
        // 获取工具栏
        toolbar_table_getToolbar(modulesn,layui);
        // 数据初始化
        var table = layui.table;
        // 加载table
        table.render({
            elem: '#list_data',
            method:'POST',
            url: '/systemmodule/list',
            where:{state:"state_001"}
            ,height: $('#home1').height()
            ,title: '用户表'
            ,page: true //开启分页
            ,limits:[10,20,30,50,100]
            ,initSort:'orderNumber'
            ,loading:true
            ,toolbar: '#tool_bar' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            // ,totalRow: true //开启合计行
            ,cols: [[
                {checkbox: true}
                ,{type: 'numbers', title: '序号'}
                ,{field: 'id', title: 'ID',hide:true}
                ,{field: 'sn', title: '编码'}
                ,{field: 'iname', title: '名称'}
                ,{field: 'psn', title: '父节点'}
                ,{field: 'url', title: '地址'}
                ,{field: 'icon', title: '图标'}
                ,{field: 'dicSn', title: '模块类型'}
                ,{field: 'fileType', title: '文件类型'}
                ,{field: 'state', title: '数据状态'}
                ,{fixed: 'right', align:'center', toolbar: '#row_bar'}
            ]],
            parseData: function(res) { //res 即为原始返回的数据
                return toolbar_parseTableData(res);
            },
            done: function(res, curr, count){
                // 数据渲染结束
            }
        });
        //监听工具栏事件
        toolbar_table_toolbarOn('list_table', layui);
    });
</script>
</html>
