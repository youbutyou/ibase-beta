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
        <label class="layui-form-label">字典类型</label>
        <div class="layui-input-block">
            <select id="dicTypeSn" name="interest" lay-verify="required" lay-filter="dicTypeSn"></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">数据状态</label>
        <div class="layui-input-block">
            <input id="state" type="checkbox" name="state" lay-skin="switch" lay-text="启用|停用">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入备注" class="layui-textarea" name="remark"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
<script src="/resources/common/commonJs.js"></script>
<script type="text/javascript">
    layui.use(['form','jquery'], function(){
        var form = layui.form;
        // 初始化字典类型
        component.initSelect('dicTypeSn', {
            method:'post',
            url:'/systemdictionarytype/list',
            param:{
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
                form.render('checkbox');
            },
            function error(msg) {
                layer.alert(msg);
            });
    });
</script>
</html>
