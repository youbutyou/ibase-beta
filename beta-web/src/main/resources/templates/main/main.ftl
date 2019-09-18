<!DOCTYPE HTML>
<html lang="zh_CN">
<head>
	<meta charset="utf-8">
	<title>main</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="/resources/common/commonCss.css" hreflang="zh_CN" rel="stylesheet" type="text/css">
	<link href="/resources/css/main.css" hreflang="zh_CN" rel="stylesheet" type="text/css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">${systemname}</div>
			<ul id="nav-001" class="layui-nav layui-layout-left" lay-filter="nav-001">
				<#--				<li class="layui-nav-item"><a href="">最新活动</a></li>-->
				<#--				<li class="layui-nav-item layui-this">-->
				<#--					<a href="javascript:;">产品</a>-->
				<#--					<dl class="layui-nav-child">-->
				<#--						<dd><a href="">选项1</a></dd>-->
				<#--						<dd><a href="">选项2</a></dd>-->
				<#--						<dd><a href="">选项3</a></dd>-->
				<#--					</dl>-->
				<#--				</li>-->
				<#--				<li class="layui-nav-item"><a href="">大数据</a></li>-->
				<#--				<li class="layui-nav-item">-->
				<#--					<a href="javascript:;">解决方案</a>-->
				<#--					<dl class="layui-nav-child">-->
				<#--						<dd><a href="">移动模块</a></dd>-->
				<#--						<dd><a href="">后台模版</a></dd>-->
				<#--						<dd class="layui-this"><a href="">选中项</a></dd>-->
				<#--						<dd><a href="">电商平台</a></dd>-->
				<#--					</dl>-->
				<#--				</li>-->
				<#--				<li class="layui-nav-item"><a href="">社区</a></li>-->
			</ul>
			<ul id="nav-002" class="layui-nav layui-layout-right" lay-filter="nav-002">
				<li class="layui-nav-item" lay-unselect="">
					<a href="javascript:;">
						<img src="//t.cn/RCzsdCq" class="layui-nav-img">${username}
					</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;">修改信息</a></dd>
						<dd><a href="javascript:;">退出</a></dd>
					</dl>
				</li>
			</ul>
		</div>
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<ul id="nav-003" class="layui-nav layui-nav-tree layui-inline" style="margin-right: 10px;"></ul>
			</div>
		</div>
		<div class="layui-body" style="bottom: 0;border-left: solid 2px #1AA094;" id="admin-body">
			<div class="layui-tab admin-nav-card layui-tab-brief" lay-allowClose="true" lay-filter="tab-content" style="height: calc(100% - 20px)">
				<ul class="layui-tab-title"></ul>
				<div class="layui-tab-content" style="padding: 5px 0 0 0; height: calc(100% - 46px)"></div>
			</div>
		</div>
	</div>
</body>
<script src="/resources/common/commonJs.js"></script>
<script type="text/javascript">
	layui.config({
		base: '/resources/css/layui/lay/modules/'   //navbar组件js所在目录
	}).use(['layer', 'element','jquery','navbar'], function(){
		var element = layui.element;
		var layer = layui.layer;
		var navbar = layui.navbar();
		// 横向导航栏
		$("#nav-001").html(getNav001(element));
		// 侧边导航栏
		navbar.set({
			elem: "#nav-003",　　//存在组件的容器
			type: 'POST', 		//读取方式
			url: "/systemmodule/listwithchildren?dicSn=navigation_002&state=state_001",
			spreadOne: false,　　//设置是否只展开一个二级菜单
			cached: false　　	//是否启用缓存，如果设置为true，则将初始化数据的数据添加至缓存
		});
		navbar.render();
		//监听导航点击
		element.on('nav', function(elem){
			// layer.msg(elem.text());
			var fileType = $(this)[0].dataset.type;
			if("file_002" === fileType){
				// 目录类型不做处理
				return;
			}
			var title = elem.text();
			var url = $(this)[0].dataset.url;
			var sn = $(this)[0].dataset.sn;
			if(url === undefined || "" === url){
				layer.msg(title + "url未配置，请检查");
				return;
			}
			// 检测tab是否已打开
			var isTabOpen = false;
			$.each($(".layui-tab-title li[lay-id]"), function () {
				if ($(this).attr("lay-id") == sn){
					isTabOpen = true;
				}
			});
			if(!isTabOpen){
				// 添加新的tab
                url += "?modulesn="+ sn;
				element.tabAdd('tab-content', {
					title: title,
					content: '<iframe data-frameid="'+sn+'" scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>',
					id: sn
				});
			}
			// 切换tab
			element.tabChange('tab-content', sn);
		});
		// 监听TAB
		element.on('tab(tab-content)', function(elem){
			//layer.msg($(this).attr('lay-id'));
		});
	});

	/**
	 * 获取横向导航栏
	 */
	function getNav001(element) {
		$.ajax({
			method: "POST",
			url: "/systemmodule/listwithchildren",
			data:{dicSn:"navigation_001",state:"state_001"},
			dataType: "JSON",
			success: function (data, textStatus) {
				var html = "";
				$.each(data,function (index,da) {
					html += "<li class='layui-nav-item'>";
					html += "<a href='javascript:;' value=" + da.sn + ">" + da.title + "</a>";
					if(da.children){
						html += "<dl class='layui-nav-child'>";
						$.each(da.children,function (index,child) {
							html += "<dd><a href='' value=" + child.sn + ">" + child.title + "</a></dd>";
						});
						html += "</dl>";
					}
					html += "</li>";
				});
				$("#nav-001").append(html);
				// 所在导航重新渲染
				element.render('nav', 'nav-001');
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
				parent.layer.msg("请求失败");
			}
		});
	};

</script>
</html>