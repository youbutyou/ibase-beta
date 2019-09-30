/**
 * 公用组件
 * @type {{}}
 */
var component = {

    /**
     * 空值判断
     * @param value
     */
    isEmpty : function(value){
        switch (value) {
            case undefined:
            case null:
            case "":
                return true;
        }
        return false;
    },


    /**
     * layui - select 初始化
     *
     * @param id        标签ID
     * @param conf      参数
     * @param success   成功回调
     * @param error     失败回调
     */
    initSelect : function (id, conf, success, error) {
        if(component.isEmpty(conf) || component.isEmpty(conf.url) || component.isEmpty(conf.method)){
            if(error){
                error("参数异常");
            }
            return;
        }
        $.ajax({
            type: conf.method,
            url: conf.url,
            data: conf.param || {},
            dataType: "JSON",
            success: function (res) {
                if(res && res.success){
                    if(res.rows.length > 0){
                        var select = document.getElementById(id);
                        $.each(res.rows, function (i, data) {
                            select.options.add(new Option(data.iname, data.sn));
                        });
                    }
                    if(success){
                        success(res.message);
                    }
                    return;
                }
                if(error){
                    error(res.message);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                if(error){
                    error("请求异常");
                }
            }
        });
    }
};