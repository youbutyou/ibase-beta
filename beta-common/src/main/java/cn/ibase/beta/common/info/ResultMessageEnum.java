package cn.ibase.beta.common.info;

/**
 * 返回结果枚举信息
 * @author Binbin.Yang1
 * @date 2019-03-06
 */
public enum ResultMessageEnum {


    SYS_EXE_SUCCESS(200,"执行成功"),
    SYS_EXE_ERROR(500,"执行失败"),
    SYS_USER_NOT_LOGIN(505,"登陆用户失效，请重新登录"),
    SYS_LOGIN_ERROR(506,"用户名或密码错误，请重新登录"),
    SYS_PARAM_ERROR(507,"传入参数异常"),
    SYS_SEND_CODE_ERROR(508,"验证码发送失败"),
    SYS_SEND_CODE_SUCCESS(100,"验证码已发送"),
    SYS_SEND_CODE_HAS(509,"验证码已经发送，请稍后重试"),
    SYS_SEND_CODE_CHECK_ERROR(510,"验证码校验失败，请重试"),
    SYS_IMAGE_UPLOAD_ERROR(511,"图片上传失败"),
    SYS_IMAGE_UPLOAD_EMPTY(512,"上传文件为空"),
    SYS_IMAGE_UPLOAD_TOO_BIG(511,"上传文件大小过大"),
    SYS_POSITION_ELECTRIC_FENCE(512,"不在规定范围内，不可进行此操作"),
    SYS_USER_NO_EXIST(513,"用户不存在"),
    SYS_USER_STATUS_ERROR(514,"用户处于异常状态，请联系管理员"),
    SYS_USER_NO_PHONE(515,"用户没有关联手机，请联系管理员"),

    TM_BD_CARRIER_TO_ORG_ERROR(1000001,"承运商同步组织异常"),
    TM_BD_STATION_TO_ORG_ERROR(1000002,"服务站同步组织异常"),
    TM_BD_WAREHOUSE_TO_ORG_ERROR(1000003,"仓库同步组织异常"),
    TM_BD_STATION_SIGN_IN_CLOSED(1000004,"服务站未开启签收权限"),
    TM_BD_STATION_NOT_EXISTS(1000005,"服务站不存在"),
    TM_BD_WAREHOUSE_NOT_EXISTS(1000006,"仓库不存在"),
    TM_BD_CARRIER_NOT_EXISTS(1000007,"快递公司不存在"),
    TM_BD_ROUTE_NOT_EXISTS(1000008,"路径信息不存在"),
    TM_BD_WAREHOUSE_LNGLAT_NOT_EXISTS(1000009,"仓库经纬度不存在"),
    TM_BD_STATION_LNGLAT_NOT_EXISTS(10000010,"服务站经纬度不存在"),

    TM_BOX_IN_OTHER_BATCH(500003,"该箱存在其他批次，请检查"),
    TM_BOX_NOT_EXIST(500004,"箱号不存在或无权限"),
    TM_DELIVERY_NOT_EXIST(500005,"交货单不存在"),
    TM_TRANSPORT_NOT_EXIST(500006,"承运单不存在"),
    TM_BATCH_NOT_EXIST(500007,"批次不存在"),
    TM_FLOW_HAS_EXECUTOR(500008,"该流程已执行，不可重复执行"),
    TM_PRE_FLOW_NOT_EXECUTOR(500009,"前置流程未执行，不可执行此操作"),
    TM_BATCH_FLOW_ERROR(500010,"批次流程不存在，请联系管理员"),
    TM_BATCH_FLOW_DENY(500010,"批次当前流程不支持此操作"),
    TM_BATCH_MULTIPLE_ERROR(500011,"批次存在多个，请联系管理员"),
    TM_BATCH_BOX_IS_EXIST(500012,"箱号{0}已添加"),
    TM_BATCH_BOX_ADD_ERROR(500013,"请先执行批次装车重置"),
    TM_BATCH_BOX_ADD_FLOW_ERROR(500060,"只支持扫描待发运的箱"),
    TM_BATCH_BOX_SCAN(500014,"该箱已经扫描，无需重复操作"),
    TM_BATCH_BOX_SCAN_ERROR(500015,"批次扫码记录不存在"),
    TM_BATCH_BOX_SCAN_ERROR_1(500015,"批次存在未扫码数据"),
    TM_BATCH_BOX_NO_ITEM(500016,"该批次没有对应的箱信息"),
    TM_BATCH_BOX_STRATEGY_ERROR(500017,"批次执行策略出现异常"),
    TM_BATCH_BOX_NO_STRATEGY_ERROR(500018,"此流程没有对应的执行策略"),
    TM_BATCH_BOX_CREATE_ERROR(500019,"批次扫描记录创建出现异常"),
    TM_BATCH_BOX_CHECK_ERROR(500020,"存在未同步信息，请稍后操作"),
    TM_BATCH_CONFIRM_ERROR(500021,"确认失败！批次存在未校验箱号，请先执行校验"),
    TM_BATCH_ROLLBACK_ERROR(500024,"批次已经确定/完结或者部分箱已到店，不可进行重置操作"),
    TM_NEXT_FLOW_HAS_EXECUTOR(500023,"后续流程已执行，不可执行此操作"),
    TM_BATCH_SUPPLY_ERROR(500026,"批次信息补充出现异常"),
    TM_BATCH_SN_ERROR(500027,"批次车辆信息异常，请检查"),
    TM_BATCH_DRIVER_ERROR(500028,"批次司机信息异常，请检查"),
    TM_BATCH_EXPRESS_EXIST(500029,"此快递单已经绑定批次信息，不可重复绑定"),
    TM_BATCH_HAS_SYNC(500030,"批次已锁定！如需添加箱，请联系仓库工作人员进行装车重置"),
    TM_BATCH_HAS_OVER(500031,"批次已经完结，不可进行此操作"),
    TM_BATCH_CREATE_SCAN_ERROR(500032,"二维码生成失败，请重新操作"),
    TM_BATCH_SCAN_OVER(500033,"二维码已经失效"),
    TM_BATCH_HANDOVER_ERROR(500034,"握手交接出现异常"),
    TM_BATCH_HANDOVER_CACHE(500035,"握手交接执行结果通知异常"),
    TM_BATCH_BOX_LIST_ERROR(500036,"箱信息查询出现异常"),
    TM_BATCH_CONFIRM_NO_SURE(500039,"批次装运未确认"),
    TM_BATCH_ROUTE_NO_INFO(500040,"批次无对应的路径信息"),
    TM_BATCH_BOX_COUNT_ERROR(500041,"请补充箱托数信息"),
    TM_BATCH_DELETE_ERROR(500042,"在途批次不可删除"),
    TM_BATCH_SCAN_DETAIL_ERROR(500043,"批次未校验或异常"),
    TM_BATCH_TRANSPORT_STATION_MORE_ONE(500044,"没有或者包含多个目的地信息，不能进行此操作"),
    TM_BATCH_HAS_SCAN_MORE_STATION(500047,"此次扫描存在多个服务站数据"),
    TM_DELIVERY_NOT_EXIST_BY_BOX(500048,"箱号{0},对应的交货单不存在"),
    TM_DELIVERY_STATION_NOT_EQUAL_BY_BOX(500049,"箱号{0},对应的交货单服务站地址不同"),
    TM_BATCH_BOX_RECORD_STATION_NOT_EQUALS(500051,"存在不一致的代理服务站:{0}"),
    TM_BATCH_WAREHOUSE_NO_WMS(500052,"该仓库不支持一键装车"),
    TM_BATCH_BOX_WAREHOUSE_DIF_ERROR(500053,"添加箱的仓库不同，请检查"),
    TM_BATCH_WAREHOUSE_DIF_ERROR(500054,"箱与该批次的仓库不同，请检查"),
    TM_BATCH_VSTEL_DIF_ERROR(500055,"箱与该批次仓库的装运点不同，请检查"),
    TM_DELIVERY_VSTEL_NOT_EXISTS(500056,"箱对应的交货单的装运点不存在"),
    TM_BATCH_BOX_CARRIER_DIF_ERROR(500057,"添加箱的承运商不同，请检查"),
    TM_BATCH_CARRIER_DIF_ERROR(500058,"箱与该批次的承运商不同，请检查"),
    TM_BATCH_CARRIER_NO_EXIST(500059,"批次承运商不存在，请检查"),
    TM_BATCH_BOX_TRANSPORTMETHOD_DIF_ERROR(500057,"添加箱的运输方式不同，请检查"),
    TM_BATCH_TRANSPORTMETHOD_DIF_ERROR(500058,"箱与该批次的运输方式不同，请检查"),
    TM_BATCH_TRANSPORTMETHOD_NO_EXIST(500059,"批次运输方式不存在，请检查"),
    TM_DELIVERY_STATION_NOT_EXISTS(500056,"箱对应的交货单的服务站不存在"),
    TM_BATCH_CANT_PRINT(500057,"该批次无法打印,请确认状态"),
    TM_FLOW_BOX_HAS_EXECUTOR(500058,"已完成扫码操作，点击扫码提交即可"),
    TM_BATCH_BOX_NONE(500059, "批次装运记录查询为空"),
    TM_BATCH_BOX_AUTO_EXISTS(500060, "箱已添加批次，不可删除"),
    TM_BATCH_BOX_NO_PRINTER(500061,"该批次没找到对应的打印机，请添加打印机后操作"),

    TM_BATCH_BOX_RECORD_ROUTE_NOT_EQUALS(500061,"存在不一致的线路:{0}"),
    TM_BATCH_BOX_RECORD_SUCCESS_TRANSPORT_NOT_EXISTS(500062,"执行成功，提示：承运单未下发:{0}"),

    TM_LAYOUT_SN_ERROR(510000,"上报车辆信息异常，请检查"),
    TM_LAYOUT_DRIVER_ERROR(510001,"上报司机信息异常，请检查"),
    TM_LAYOUT_RESET_ERROR(510002,"审核已执行，无需重复操作"),
    TM_LAYOUT_PASS_ERROR(510003,"审核已通过，不允许执行当前操作"),
    TM_LAYOUT_PLATE_ERROR(510004,"车牌号不能为空"),
    TM_LAYOUT_NO_EXIST(510005,"车辆上报记录不存在"),

    TM_BATCH_IMPL_NO_EXIST(520000,"执行过程记录不存在"),
    TM_BATCH_IMPL_IS_REPEAT_EXECUTE(520001,"该执行过程已执行，无需重复操作"),

    TM_BATCH_TRANSFER_NO_EXIST(530000,"转运记录不存在"),
    TM_BATCH_TRANSFER_ALREADY_PASS(530001,"该记录已通过审核，无需重复操作"),
    TM_BATCH_TRANSFER_ERROR(530002,"在途批次不支持转运"),

    TM_BATCH_SCAN_NO_BOX(540000,"扫码提交前请先扫描箱"),
    TM_BATCH_SCAN_NO_BOX_LOAD(540001,"箱{0}未检测到装车记录"),
    TM_BATCH_SCAN_BOX_ERROR(540002,"只支持扫描当前批次的箱"),
    TM_BATCH_SCAN_STATION_BOX_ERROR(540003,"只支持扫描当前服务站的箱"),

    TM_BATCH_SIGNIN_NO_ARRIVE(550000,"箱{0}的前置条件未执行，不可执行此操作"),
    TM_BATCH_SIGNIN_DIFF_BATCH(550001,"不允许同时扫描多个批次的箱"),
    TM_BATCH_SIGNIN_BOX_REPEAT(550004,"箱{0}已签收，无需重复操作"),
    TM_BATCH_STATION_ERROR(550005,"该批次中没有找到对应的服务站"),
    TM_BATCH_SIGNIN_NO_MANUAL(550007,"签收不支持手动执行"),
    TM_BATCH_SIGNIN_DISABLE(550008,"签收权限未开启"),
    TM_BATCH_SIGNIN_NO_RECORD(550009,"未找到批次{0}签收记录"),
    TM_BATCH_SIGNIN_NO_TO_SIGN(550010,"未找到待签收批次"),

    TM_TRANSPORT_NO_EXIST(800002,"承运单不存在"),
    TM_TRANSPORT_FLOW_COUNT_ERROR(800001,"承运单状态计算出现异常"),


    TM_POSITION_ERROR(600001,"定位出现异常，请重试"),
    TM_AMAP_KEY_ERROR(600006,"高德key获取异常，请联系系统管理员"),
    TM_AMAP_LOCATION_ERROR(600007,"高德位置转换异常，请稍后重试"),
    TM_LOADING_IMAGE_ERROR(600002,"图片上传失败，请稍后重试"),
    TM_DOWNLOAD_FILE_ERROR(600003,"文件下载失败，请稍后重试"),
    TM_DATABASE_ERROR(600004,"数据操作异常"),
    TM_NO_POWER_EXECUTOR(600005,"没有权限进行次操作"),
    TM_POSITION_EXIST(600008,"位置已经上报，无需重复上报"),
    TM_MSG_ERROR(600009,"消息推送策略出现异常"),
    TM_POSITION_LATLON_ERROR(600010,"经纬度信息有误"),

    TM_CARGOLOSS_NO_INPUT_INFO(700001,"请至少填写一个货损货差信息"),
    TM_CARGOLOSS_BOX_HASADD(700002,"箱号货损货差信息已添加，请检查"),
    TM_CARGOLOSS_BOX_REPEAT(700003,"箱号信息重复，请检查"),
    TM_CARGOLOSS_HAS_AUDITOR(700004,"删除单据中有已审核单据，请检查"),
    TM_CARGOLOSS_CANT_AUDITOR(700005,"当前流程状态不能进行审核操作，请检查"),
    TM_CARGOLOSS_CANT_AUDITOR2(700006,"当前流程状态不能进行审核操作，请检查"),
    TM_CARGOLOSS_AUDITOR_TEXT_NULL(700007,"审核意见不能为空"),
    TM_CARGOLOSS_AUDITOR2_TEXT_NULL(700008,"审批意见不能为空"),
    TM_CARGOLOSS_HAS_DELETE(700009,"单据已删除，不能操作"),
    TM_CARGOLOSS_CANT_UPDATE(700010,"当前流程状态不能进行修改操作，请检查"),
    TM_CARGOLOSS_BOX_NOT_SCAN(700011,"上报批次中没有找到扫箱信息，请检查"),
    TM_CARGOLOSS_BOX_CANT_DELETE(700012,"该批次已审核，不能删除"),
    TM_CARGOLOSS_REVEIVE_NULL(700013,"虚拟交货单{0}对应收货记录为空"),

    TM_RECEIPT_EXIST(800001,"该批次{0}的服务站{1}已添加，不能重复添加"),
    TM_RECEIPT_IMG_NOT_UPLOAD(800002,"请至少上传一张照片"),
    TM_RECEIPT_CANT_UPDATE(800003,"此单据已确认不能操作"),
    TM_RECEIPT_BATCH_STATUS_ERROR(800004,"批次状态为到店的才可添加电子回单"),
    TM_RECEIPT_BATCH_NOT_ARRIVE(800005,"该批次状态不能添加电子回单"),

    TM_TRANSPORT_SN_REPEAT(800004,"承运单编号重复，请检查"),
    TM_TRANSPORT_VIRTUALSN_REPEAT(800004,"承运单虚拟交货单号重复，请检查"),
    TM_TRANSPORT_STATION_NO_EXIST(800005,"承运单无对应的服务站"),

    TM_TRANSPORT_SYNC_WAREHOUSE_NULL(900001, "运输计划点对应仓库为空"),

    TM_USER_NO_BIND_WECHAT(900003,"用户为绑定小程序"),
    TM_USER_WECHAT_TOKEN_ERROR(900004,"获取token出现异常"),
    TM_USER_WECHAT_BIND_ERROR(900004,"用户绑定失败"),
    TM_USER_WECHAT_HAS_BIND(900005,"账号已经绑定其他微信，请先解绑"),
    TM_WECHAT_USER_HAS_BING(900006,"微信已经绑定其他账号，请先解绑"),
    TM_USER_WECHAT_UNBIND_ERROR(900007,"用户解绑出现异常");


    private int state;

    private String msg;

    ResultMessageEnum(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }

    public static ResultMessageEnum stateOf(int index) {
        for (ResultMessageEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
