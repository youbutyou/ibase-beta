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
    layui.config({
        base: '/resources/css/layui/'
    }).extend({
        treetable: 'treetable-lay/treetable'
    }).use(['layer', 'form','table','treetable'], function(){
        // 获取模块编号
        var modulesn = $("#modulesn").val();
        // 获取工具栏
        toolbar_table_getToolbar(modulesn,layui);
        // 数据初始化
        var table = layui.table;
        var treetable = layui.treetable;
        // 加载table
        tableRender = function(){
            treetable.render({
                elem: '#list_data',
                method:"post",
                url: '/systemdictionary/list',
                where:{
                    pagination:'false'
                },
                height: $('#home1').height(),
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
                    ,{field: 'fileType', title: '文件类型', templet:'#fileTypeTpl'}
                    ,{field: 'state', title: '数据状态', templet: '#stateTpl'}
                    ,{fixed: 'right', align:'center', toolbar: '#row_bar'}
                ]],
                parseData: function(res) { //res 即为原始返回的数据
                    return toolbar_parseTableData(res);
                },
                done: function(res, curr, count){
                    // 数据渲染结束
                }
            });
            // table.render({
            //     elem: '#list_data',
            //     method:'POST',
            //     url: '/systemdictionary/list',
            //     height: $('#home1').height(),
            //     title: '用户表',
            //     page: true,
            //     limit:10,
            //     limits:[10,20,30,50,100],
            //     initSort:'orderNumber',
            //     loading:true,
            //     toolbar: '#tool_bar',
            //     // ,totalRow: true //开启合计行
            //     cols: [[
            //         {checkbox: true}
            //         ,{type: 'numbers', title: '序号'}
            //         ,{field: 'id', title: 'ID',hide:true}
            //         ,{field: 'sn', title: '编码'}
            //         ,{field: 'iname', title: '名称'}
            //         ,{field: 'fileType', title: '文件类型', templet:'#fileTypeTpl'}
            //         ,{field: 'state', title: '数据状态', templet: '#stateTpl'}
            //         ,{fixed: 'right', align:'center', toolbar: '#row_bar'}
            //     ]],
            //     parseData: function(res) {
            //         return toolbar_parseTableData(res);
            //     },done: function(res, curr, count){
            //         //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度、curr为当前页码
            //     }
            // });
        };
        tableRender();
        //监听工具栏事件
        toolbar_table_toolbarOn('list_table', layui);
    });
</script>
</html>
