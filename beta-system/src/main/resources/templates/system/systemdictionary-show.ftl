<!DOCTYPE HTML>
<html lang="zh_CN" xmlns:th="http://www.springframework.org/schema/jdbc">
<head>
    <title></title>
    <meta content="text/html;charset=UTF-8" http-equiv="content-type">
</head>
<body>
<div class="layui-layout-body" style="overflow: hidden;">
    <table id="list_data" class="layui-table" lay-fiflter="list_data"></table>
</div>
</body>
<script type="text/javascript" charset="UTF-8" src="/resources/css/layui/layui.js"></script>
<script type="text/javascript" charset="UTF-8" src="/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" th:inline="none">
    layui.use(['layer', 'form','table'], function(){
        var table = layui.table;
        table.render({
            elem: '#list_data',
            method:'POST',
            height: 312,
            url: '/systemdictionary/list',
            where:{state:"state_001"},
            toolbar: true,
            totalRow:true,
            page:true,
            limit:10,
            limits:[10,20,30,40,50,60,70,80,90],
            defaultToolbar: ['filter', 'print', 'exports', {
                title: '提示' //标题
                ,layEvent: 'LAYTABLE_TIPS' //事件名，用于 toolbar 事件中使用
                ,icon: 'layui-icon-tips' //图标类名
            }],
            skin: 'line' //行边框风格
            ,even: true //开启隔行背景
            ,cols: [[
                {checkbox: true}
                ,{field: 'id', title: 'ID',hide:true}
                ,{field: 'sn', title: '编码'}
                ,{field: 'iname', title: '名称'}
            ]],
            parseData: function(res) { //res 即为原始返回的数据
                if(res.success){
                    return {
                        "code": 0, //解析接口状态
                        "msg": res.message, //解析提示文本
                        "count": res.total, //解析数据长度
                        "data": res.rows //解析数据列表
                    };
                }
                return {
                    "code": res.state, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count": res.total, //解析数据长度
                    "data": res.rows //解析数据列表
                };
             }
            ,done:function (res, curr, count) {
                // console.log(res);
                // console.log(curr);
                // console.log(count);
            }
        });
        // table.reload('list_data', {page: {
        //         curr: 1 //重新从第 1 页开始
        //     }
        // });
    });
</script>
</html>
