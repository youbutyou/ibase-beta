<!DOCTYPE HTML>
<html lang="zh_CN">
<head>
    <title></title>
    <meta content="text/html;charset=UTF-8" http-equiv="content-type">
    <link href="/resources/common/commonCss.css" hreflang="zh_CN" rel="stylesheet" type="text/css">
<body>
<form id="form" class="layui-form layui-form-pane ibase-form" action="" lay-filter="form">
    <div style="display: none;">
        <input name="id">
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">父节点</label>
        <div class="layui-input-block">
            <select id="psn" name="psn" lay-verify="required" lay-filter="psn" ></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">编码</label>
        <div class="layui-input-block">
            <input type="text" name="sn" lay-verify="required" autocomplete="off" placeholder="请输入编码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">名称</label>
        <div class="layui-input-block">
            <input type="text" name="iname" lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">url地址</label>
        <div class="layui-input-block">
            <input type="text" name="url" placeholder="请输入url地址" utocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图标</label>
        <div class="layui-input-block">
            <input type="text" name="icon" placeholder="请输入图标" utocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">排序号</label>
        <div class="layui-input-block">
            <input type="number" name="orderNumber" placeholder="请输入排序号" utocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">模块类型</label>
            <div class="layui-input-block">
                <select id="dicSn" name="dicSn"  lay-verify="required" lay-filter="dicSn"></select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">文件类型</label>
            <div class="layui-input-block">
                <select id="fileType" name="fileType" lay-verify="required" lay-filter="fileType"></select>
            </div>
        </div>
    </div>
    <div class="layui-form-item" pane>
        <label class="layui-form-label">数据状态</label>
        <div class="layui-input-block">
            <input id="state" type="checkbox" name="state"   value="state_001" lay-filter="state" lay-skin="switch" lay-text="启用|停用">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入备注" class="layui-textarea " name="remark"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="submit">提交</button>
            <button class="layui-btn layui-btn-primary" type="button" onclick="toolbar_form_cancel()">取消</button>
        </div>
    </div>
</form>
</body>
<script src="/resources/common/commonJs.js"></script>
<script type="text/javascript">
    var formParam = {};
    layui.use(['form','jquery'], function(){
        var form = layui.form;
        // 初始化父节点
        component.initSelect('psn', {
                method:'post',
                url:'/systemmodule/list',
                param:{
                    dicSns:'module_001,module_002,system_001',
                    state:'state_001'
                }
            },
            function success() {
                form.render('select');
            },
            function error(msg) {
                layer.alert(msg);
            });
        // 初始化模块类型
        component.initSelect('dicSn', {
                method:'post',
                url:'/systemdictionary/list',
                param:{
                    psn:'001_system_module',
                    state:'state_001'
                }
            },
            function success() {
                form.render('select');
            },
            function error(msg) {
                layer.alert(msg);
            });
        // 初始化文件类型
        component.initSelect('fileType', {
                method:'post',
                url:'/systemdictionary/list',
                param:{
                    psn:'002_public_file',
                    state:'state_001'
                }
            },
            function success() {
                form.render('select');
            },
            function error(msg) {
                layer.alert(msg);
            });
        // 初始化数据状态
        component.initStateSwitch('state',
            function success() {
                // 表单数据初始化
                toolbar_form_openSuccess(form, formParam);
                form.render('checkbox');
                // 设置选中行为父节点
                if(formParam.data && formParam.data.length > 0){
                    layui.use(['form','jquery'], function() {
                        $('#psn').val(formParam.data[0].sn);
                        layui.form.render('select');
                    });
                }
            },
            function error(msg) {
                layer.alert(msg);
            });
    });

    function toolbar_loadSuccess(object) {
        // zero父节点不可编辑
        if(object && object.psn === 'zero'){
            var select = document.getElementById('psn');
            select.options.add(new Option('zero', 'zero',true, true));
            $('#psn').attr('disabled',true);
            layui.use(['form','jquery'], function(){
               layui.form.render();
            });
        }
    }
</script>
</html>
