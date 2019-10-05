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
        <input id="modulesn" name="modulesn" th:value="${modulesn}">
    </div>
    <table id="list_data" lay-filter="list_table"></table>
</div>
</body>
<script src="/resources/common/commonJs.js"></script>
<script type="text/javascript" th:inline="none">
    var tableRender;
    layui.use(['layer', 'form','table'], function(){
        // 获取模块编号
        var modulesn = $("#modulesn").val();
        // 获取工具栏
        toolbar_table_getToolbar(modulesn,layui);
        // 数据初始化
        var table = layui.table;
        // 加载table
        tableRender = function(){
            table.render({
                elem: '#list_data',
                method:'POST',
                url: '/systemuser/list',
                height: $('#home1').height(),
                title: '用户表',
                page: true,
                limit:10,
                limits:[10,20,30,50,100],
                initSort:'orderNumber',
                loading:true,
                toolbar: '#tool_bar',
                // ,totalRow: true //开启合计行
                cols: [[
                    {checkbox: true}
                    ,{type: 'numbers', title: '序号'}
                    ,{field: 'id', title: 'ID',hide:true}
                    ,{field: 'orgSnName', title: '组织'}
                    ,{field: 'roleSnName', title: '角色'}
                    ,{field: 'iname', title: '姓名'}
                    ,{field: 'sn', title: '账号'}
                    ,{field: 'phone', title: '手机号码'}
                    ,{field: 'state', title: '数据状态', templet: '#stateTpl'}
                    ,{fixed: 'right', align:'center', toolbar: '#row_bar'}
                ]],
                parseData: function(res) {
                    return toolbar_parseTableData(res);
                },done: function(res, curr, count){
                    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度、curr为当前页码
                }
            });
        };
        tableRender();
        //监听工具栏事件
        toolbar_table_toolbarOn('list_table', layui);
    });
</script>
</html>
