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
                    <td style="text-align: right;">编号&nbsp</td>
                    <td><input name="sn" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">名称&nbsp</td>
                    <td><input name="iname" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">父节点&nbsp</td>
                    <td><input name="pid" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">url&nbsp</td>
                    <td><input name="url" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">图标&nbsp</td>
                    <td><input name="icon" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">字典编码&nbsp</td>
                    <td><input name="dicSn" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">排序号&nbsp</td>
                    <td><input name="orderNumber" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">数据状态&nbsp</td>
                    <td><input name="state" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
                </tr>
                <tr>
                    <td style="text-align: right;">备注&nbsp</td>
                    <td><input name="remark" class="ccrfid-readonly" style="height: 25px; width: 200px;"></td>
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
