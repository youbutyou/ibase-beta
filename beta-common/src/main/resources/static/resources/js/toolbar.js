/**
 * toolbar
 * 工具栏
 */

// table表格
// table 数据格式转换
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
// 获取工具栏
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
            if(res && res.success){
                for(var i = 0; i < res.data.length; i ++){
                    var item = res.data[i];
                    if(item.dicSn === "toolbar_001"){
                        // 头工具栏
                        toolbar_setToolbar(item);
                    }else if (item.dicSn === "toolbar_002"){
                        // 行工具栏
                        toolbar_setRowbar(item);
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
function toolbar_setToolbar(data) {
    var toolbar = document.getElementById("tool_bar");
    var iconHtml = '';
    if(data.icon && data.icon != ''){
        iconHtml = '<i class="layui-icon ' + data.icon + '"></i>\n';
    }
    var html = '';
    if(iconHtml === ''){
        html = '<div id="tb_' + data.sn +
                    '" data-url="' + data.url +
                    '" data-iname="' + data.iname +
                    '" data-zindex="' + data.zindex +
                    '" class="layui-btn layui-btn-xs" lay-event="' + data.sn + '">' +
                    data.iname +
                '</div>\n';
    }else{
        html = '<div id="tb_' + data.sn +
                    '" data-url="' + data.url +
                    '" data-iname="' + data.iname +
                    '" data-zindex="' + data.zindex +
                    '" class="layui-inline" lay-event="' + data.sn + '">\n' +
                    (iconHtml === '' ? data.iname : iconHtml) +
                '</div>';
    }
    toolbar.append(html);
}
// 组装行工具栏
function toolbar_setRowbar(data) {
    var toolbar = document.getElementById("row_bar");
    var classHtml = '';
    if(data.icon && data.icon != ''){
        classHtml = data.icon;
    }
    var html = '<div id="rb_' + data.sn +
                    '" data-url="' + data.url +
                    '" data-iname="' + data.iname +
                    '" data-zindex="' + data.zindex +
                    '" class="layui-btn layui-btn-xs ' + classHtml +
                    '" lay-event="' + data.sn + '">' +
                    data.iname +
                '</div>\n';
    toolbar.append(html);
}
// 增删改等方法的封装用于页面的重写
// 新增
function toolbar_add(event, iname, url, object, zindex, w, h) {
    toolbar_event_impl(event, iname, url, object, zindex, w, h);
}
// 编辑
function toolbar_edit(event, iname, url, object, zindex, w, h) {
    toolbar_event_impl(event, iname, url, object, zindex, w, h);
}
// 详情
function toolbar_detail(event, iname, url, object, zindex, w, h) {
    toolbar_event_impl(event, iname, url, object, zindex, w, h);
}
// 删除
function toolbar_del(event, iname, url, object, zindex, w, h) {
    var array = [];
    if(Array.isArray(object)){
        for(var i = 0; i < object.length; i ++){
            array.push(object[i].id);
        }
    }else{
        array.push(object.id);
    }
    var ids =array.join(",");
    // 删除前检测，用于页面重写
    if(!toolbar_beforeDel(iname, url, ids, object)){
        return;
    }
    $.ajax({
        method: "POST",
        url: url,
        async: true,
        dataType: "JSON",
        data: {"ids": ids},
        success: function (data) {
            toolbar_delSuccess(ids, data);
        },
        error: function (XMLHttpRequest, textStatus) {
            layer.alert("请求异常，错误码：" + textStatus);
        }
    });
}
// 扩展头工具栏
function toolbar_event_extend(event, iname, url, data, zindex) {
    layer.msg("点击" + iname);
}
// 扩展行工具栏
function rowbar_event_extend(event, iname, url, data, zindex) {
    layer.msg("点击" + iname);
}
// 删除前
function toolbar_beforeDel(iname, url, ids, object) {
    return true;
}
// 加载前
function toolbar_beforeLoad(data) {
    console.log('toolbar_beforeLoad');
    return true;
}
// 提交前
function toolbar_beforeSubmit(object) {
    console.log("toolbar_beforeSubmit");
    return true;
}
// 页面打开后
function toolbar_openSuccess(object) {
    console.log('toolbar_openSuccess');
}
// 删除后
function toolbar_delSuccess(ids, data) {
    console.log("toolbar_delSuccess");
    if(data && data.success){
        layer.msg(data.message);
        tableRender();
        return;
    }
    layer.alert(data.message);
}
// 加载后
function toolbar_loadSuccess(object) {
    console.log("toolbar_loadSuccess");
}
// 保存后
function toolbar_saveSuccess(res) {
    console.log("toolbar_saveSuccess");
    if(res && res.success){
        // 关闭当前页面
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        // 刷新父页面table数据
        parent.tableRender();
        return;
    }
    parent.layer.alert(res.message);
}
// 设置弹出层按钮，可设置无限个按钮,当前最多5个，配合按钮回调
function toolbar_setFootButton() {
    var btn = [];
    //btn = ['btn1','btn2','btn3'];
    return btn;
}
// 弹出层按钮1
function toolbar_footButton1_callback(index, layero) {
}
// 弹出层按钮2
function toolbar_footButton2_callback(index, layero) {
    // 禁用点击该按钮关闭页面
    return false;
}
// 表格工具栏事件实现方法：新增、编辑、查看，打开弹出层表单
function toolbar_event_impl(event, iname, url, object, zindex, w, h) {
    // 检测url
    if(url === 'null' || url === ''){
        layer.msg("未配置url");
        return;
    }
    // 配置层级
    if(zindex === undefined || zindex === 'null' || zindex === ''){
        zindex = 0;
    }
    // 配置窗口大小
    w = (w && w !== '') ? w + 'px' : '800px';
    h = (h && h !== '') ? h + 'px' : '750px';
    // 配置按钮
    var btn = toolbar_setFootButton();
    // 页面url
    var infoUrl = url.substring(0, url.lastIndexOf("/")) + '/add';
    // 提交url
    var saveUrl = url.substring(0, url.lastIndexOf("/")) + '/save';
    // 弹出层
    var layerIndex = layer.open({
        type: 2,
        anim: 1,
        resize:true,
        maxmin: true,
        area: [w, h],
        title:iname,
        content: infoUrl,
        btn:btn,
        success: function(layero, index){
            // 层级置顶
            layer.setTop(layero); //重点2
            // 获取弹出窗口
            var iframeWin = window[layero.find('iframe')[0]['name']];
            // 传参子页面
            iframeWin.formParam = {
                readonly:'detail' === event ? true : false,        // 是否只读
                postData:'add' === event ? false : true,           // 是否获取表单数据
                url:url,                                           // 获取表单数据URL
                saveUrl:saveUrl,                                   // 表单提交保存URL
                data:object                                       // 当前对象
            };
            // 页面打开后
            iframeWin.toolbar_openSuccess(object);
        },
        yes:function (index,layero) {
            toolbar_footButton1_callback(index, layero);
        },
        btn2: function(index, layero){
            toolbar_footButton2_callback(index, layero);
        },
        cancel:function (index,layero) {
            // 右上角关闭回调
        }
    });
}
// 监听表格头工具栏事件
function toolbar_table_toolbarOn(layFilter,layui) {
    var table = layui.table;
    var layer = layui.layer;
    // 行单击事件 - 选中/取消改行
    $(document).on("click",".layui-table-body table.layui-table tbody tr", function () {
        var index = $(this).attr('data-index');
        var tableBox = $(this).parents('.layui-table-box');
        //存在固定列
        if (tableBox.find(".layui-table-fixed.layui-table-fixed-l").length>0) {
            tableDiv = tableBox.find(".layui-table-fixed.layui-table-fixed-l");
        } else {
            tableDiv = tableBox.find(".layui-table-body.layui-table-main");
        }
        var checkCell = tableDiv.find("tr[data-index=" + index + "]").find("td div.laytable-cell-checkbox div.layui-form-checkbox I");
        if (checkCell.length>0) {
            checkCell.click();
        }
    });
    $(document).on("click", "td div.laytable-cell-checkbox div.layui-form-checkbox", function (e) {
        e.stopPropagation();
    });
    // 监听头工具栏
    table.on('toolbar(' + layFilter + ')', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        // 获取工具栏url
        var eventElem = document.getElementById("tb_" + obj.event);
        var url = eventElem.dataset.url;
        var iname = eventElem.dataset.iname;
        var zindex = eventElem.dataset.zindex;
        switch(obj.event){
            case 'add':
                toolbar_add(obj.event,iname, url, data, zindex);
                break;
            case 'del':
                if(data.length === 0){
                    layer.msg('请选择要删除的记录');
                    return;
                }
                layer.confirm('确定删除吗？', function(index){
                    toolbar_del(obj.event,iname, url, data, zindex);
                });
                break;
            default:
                toolbar_event_extend(obj.event,iname, url, data, zindex);
                break;
        }
    });
    // 监听行工具栏
    table.on('tool(' + layFilter + ')', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        // 获取工具栏url
        var eventElem = document.getElementById("rb_" + obj.event);
        var url = eventElem.dataset.url;
        var iname = eventElem.dataset.iname;
        var zindex = eventElem.dataset.zindex;
        switch (layEvent) {
            case 'detail':
                toolbar_detail(obj.event,iname, url, data, zindex);
                break;
            case 'edit':
                toolbar_edit(obj.event,iname, url, data, zindex);
                break;
            case 'del':
                layer.confirm('确定删除吗？', function(index){
                    //向服务端发送删除指令
                    toolbar_del(obj.event,iname, url, data, zindex);
                });
                break;
            default:
                rowbar_event_extend(obj.event,iname, url, data, zindex);
                break;
        }
    });
}

// form 表单
// 表单取消按钮 - 关闭当前页面
function toolbar_form_cancel() {
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}
// 填充表单数据
function toolbar_form_fillData(id, data) {
    var formObj = $("#" + id);
    if (typeof data !== "object") {
        throw "data no object";
    }
    for (var key in data) {
        if (data.hasOwnProperty(key)) {
            var inputs = formObj.find('input[name = "' + key + '"]');
            if (inputs.length > 0) {
                var input = inputs[0];
                switch (input.type) {
                    case "text":
                        input.value = data[key];
                        break;
                    case "hidden":
                        input.value = data[key];
                        break;
                    case "radio":
                        formObj.find('input[type="radio"][name="' + key + '"][value="' + val + '"]').prop("checked", true);
                        break;
                    case "checkbox":
                        if (data[key] === 'state_001') {
                            formObj.find('input[type="checkbox"][name="' + key + '"]').prop("checked", true);
                        }else{
                            formObj.find('input[type="checkbox"][name="' + key + '"]').prop("checked", false);
                        }
                        break;
                }
            } else {
                var select = formObj.find('select[name="' + key + '"]');
                if (select.length > 0) {
                    formObj.find('select[name="' + key + '"]').val(data[key]);
                    formObj.find("dd[lay-value='" + data[key] + "']").trigger("click");
                }
            }
        }
    }
}
// 设置表单只读
function toolbar_form_readonly(id) {
    $("#" + id).find('select').attr('disabled',true);
    $("#" + id).find('input,textarea').attr('readonly',true);
    $("#" + id).find('input[type="checkbox"]').prop('disabled', true);
    $("#" + id).find('button[lay-submit]').remove();
}
// 表单打开后
function toolbar_form_openSuccess(form, formParam) {
    // switch 关闭时也向后台传值
    form.on('switch(state)', function(data) {
        $(data.elem).attr('type', 'hidden').val(this.checked ? 'state_001' : 'state_002');
    });
    // 监听提交按钮点击事件
    form.on('submit(submit)', function(data){
        var object = form.val('form');
        // 解决switch未选中状态下不能获取值
        object['state'] = $('#state').prop("checked") ? 'state_001' : 'state_002';
        if(toolbar_beforeSubmit(object)){
            // 提交表单数据
            $.ajax({
                method: "POST",
                url: formParam.saveUrl,
                data: object,
                async: true,
                dataType: "JSON",
                success: function (res) {
                    toolbar_saveSuccess(res);
                },
                error: function (XMLHttpRequest, textStatus) {
                    layer.alert("请求异常，错误码：" + textStatus);
                }
            });
        }
    });
    // 编辑/详情 表单数据初始化
    if(formParam.postData){
        // 获取表单数据
        component.postData(
            formParam.url,
            {id:formParam.data.id},
            function success(res) {
                if(toolbar_beforeLoad(res)){
                    // 填充表单数据
                    toolbar_form_fillData('form', res);
                    // 设置只读，隐藏提交按钮
                    if(formParam.readonly){
                        toolbar_form_readonly('form');
                    }
                    form.render();
                    toolbar_loadSuccess(res);
                }
            });
    }
}