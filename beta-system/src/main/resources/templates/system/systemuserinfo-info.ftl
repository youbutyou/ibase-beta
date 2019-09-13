<!DOCTYPE HTML>
<html lang="zh_CN">
<head>
    <title></title>
    <meta content="text/html;charset=UTF-8" http-equiv="content-type">
<body>
<div id="home5" class="home5" style="height: 410px; width: 320px;">
    <form method="POST" style="margin: 0;">
        <div style="padding: 10px; text-align: right;">
            <div style="display: none;">
                <input name="id">
            </div>
            <table style="border-collapse: separate; border-spacing: 0px 8px; font-size: 12px">
                            <tr>
                    <td style="text-align: right;">用户编码&nbsp</td>
                    <td><input name="userSn" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">性别（1-男，2-女）&nbsp</td>
                    <td><input name="gender" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">邮箱&nbsp</td>
                    <td><input name="email" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">个人签名&nbsp</td>
                    <td><input name="signature" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">编辑时间&nbsp</td>
                    <td><input name="editTime" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">编辑人编码&nbsp</td>
                    <td><input name="editUser" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
            <table>
        </div>
    </form>
</div>
</body>
<script type="text/javascript" charset="UTF-8" src="/js/common/tree-util.js"></script>
<script type="text/javascript" charset="UTF-8" src="/js/common/validatebox-util.js"></script>
<script type="text/javascript">

    /**
     * 打开成功时
     */
    function whenOpenSuccess(id) {

        //默认聚焦确定按钮
        $("#submit").focus();
        //优化校验机制：聚焦时停用校验，失焦时启用校验
        $(".validatebox-text").bind("focus", function () {
            $(this).validatebox("disableValidation");
        });
        $(".validatebox-text").bind("blur", function () {
            $(this).validatebox("enableValidation");
        });
    }

    function whenLoadSuccess(data, operation) {

    }

</script>
</html>
