<!DOCTYPE HTML>
<html lang="zh_CN">
<head>
    <title></title>
    <meta content="text/html;charset=UTF-8" http-equiv="content-type">
    <link href="/resources/common/commonCss.css" hreflang="zh_CN" rel="stylesheet" type="text/css">
<body>
<form id="form" class="layui-form ibase-form" action="" lay-filter="form">
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
            <input name="sn" type="text" lay-verify="required" autocomplete="off" placeholder="请输入编码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">名称</label>
        <div class="layui-input-block">
            <input type="text" name="iname" lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">文件类型</label>
        <div class="layui-input-block">
            <select id="fileType" name="fileType" lay-verify="required" lay-filter="fileType"></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">数据状态</label>
        <div class="layui-input-block">
            <input id="state" name="state" type="checkbox" lay-skin="switch" lay-text="启用|停用">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" placeholder="请输入备注" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn ibase-button" lay-submit lay-filter="submit">提交</button>
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
                url:'/systemdictionary/list',
                param:{
                    fileType:'file_002',
                    state:'state_001'
                }
            },
            function success() {
                form.render('select');
            },
            function error(msg) {
                layer.alert(msg);
            });
        // 初始化字典类型
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
            },
            function error(msg) {
                layer.alert(msg);
            });
    });
    function toolbar_loadSuccess(object) {
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
