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
            <input type="text" name="sn" lay-verify="title" autocomplete="off" placeholder="请输入编码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">名称</label>
        <div class="layui-input-block">
            <input type="text" name="iname" placeholder="请输入名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">字典类型</label>
        <div class="layui-input-block">
            <input type="text" name="dicTypeSn" placeholder="请输入名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">字典类型</label>
        <div class="layui-input-block">
            <select id="dicTypeSn" name="interest" lay-filter="dicTypeSn">
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">数据状态</label>
        <div class="layui-input-block">
            <input type="text" name="state" placeholder="请输入名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">开关</label>
        <div class="layui-input-block">
            <input type="checkbox" name="switch" lay-skin="switch">
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
        component.initSelect('dicTypeSn', {
            method:'post',
            url:'/systemdictionarytype/list',
            param:{state:'state_001'},
            layer:layui
        },
        function success(msg) {
            layer.msg(msg);
            form.render('select');
        },
        function error(msg) {
            layer.alert(msg);
        });
    });
</script>
</html>
