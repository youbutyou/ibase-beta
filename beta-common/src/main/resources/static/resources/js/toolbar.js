/**
 * toolbar
 * 工具栏
 */

// table 数据解析
function toolbar_parseTableData(res) {
    if(res && res.success){
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

/**
 * 获取工具栏
 * @param sn
 */
function toolbar_table_getToolbar(sn,layui) {
    $.ajax({
        type: "post",
        url: "/systemmodule/toolbar",
        data:{
            psn:sn,
            state:"state_001",
            dicSns:"toolbar_001,toolbar_002"
        },
        dataType: 'json',
        async: false,
        success: function (res) {
            console.log(res);
            if(res && res.success){
                for(var i = 0; i < res.data.length; i ++){
                    var item = res.data[i];
                    if(item.dicSn === "toolbar_001"){
                        // 头工具栏
                        setToolbar(item);
                    }else if (item.dicSn === "toolbar_002"){
                        // 行工具栏
                        setRowbar(item);
                    }
                }
                return;
            }
            layui.layer.msg(res.message);
        },
        error: function (err) {
            layui.layer.msg("请求异常");
        }
    });
}
// 组装头工具栏
function setToolbar(data) {
    var toolbar = document.getElementById("tool_bar");
    var html = '<div class="layui-inline" lay-event="add">\n' +
            '    <i class="layui-icon layui-icon-add-1"></i>\n' +
            '    </div>\n' +
            '    <div class="layui-inline" lay-event="del">\n' +
            '    <i class="layui-icon layui-icon-delete"></i>\n' +
            '    </div>';
    toolbar.append(html);
}
// 组装行工具栏
function setRowbar(data) {
    var toolbar = document.getElementById("row_bar");
    var html = '<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>\n' +
        '        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>\n' +
        '        <a class="layui-btn layui-btn-danger  layui-btn-xs" lay-event="delete">删除</a>';
    toolbar.append(html);
}

//监听头工具栏事件
function toolbar_table_toolbarOn(layFilter,layui) {
    var table = layui.table;
    var layer = layui.layer;
    table.on('toolbar(' + layFilter + ')', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                }
                break;
        };
    });
}

// 监听行工具栏事件
function toolbar_table_toolOn(layFilter,layui) {
    var table = layui.table;
    var layer = layui.layer;
    table.on('tool(' + layFilter + ')', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            layer.msg('查看操作');
        } else if(layEvent === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构
                layer.close(index);
                //向服务端发送删除指令
            });
        } else if(layEvent === 'edit'){
            layer.msg('编辑操作');
        }
    });

}