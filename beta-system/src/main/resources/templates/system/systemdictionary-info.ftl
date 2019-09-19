<!DOCTYPE HTML>
<html lang="zh_CN">
<head>
    <title></title>
    <meta content="text/html;charset=UTF-8" http-equiv="content-type">
    <link href="/resources/common/commonCss.css" hreflang="zh_CN" rel="stylesheet" type="text/css">
<body>
<form id="form" class="layui-form" action="" lay-filter="form">
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
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入备注" class="layui-textarea" name="remark"></textarea>
        </div>
    </div>
</form>
</body>
<script src="/resources/common/commonJs.js"></script>
<script type="text/javascript">
    function test(data) {
        var obj = JSON.stringify(data);
        console.log(obj);
        var params = {
            test: '2993',
            remark: data.remark,
            sn: data.sn,
            iname: data.iname
        };
        layui.use('form', function(){
            var form = layui.form;
            form.val('form', obj);
        });
    }
</script>
</html>
