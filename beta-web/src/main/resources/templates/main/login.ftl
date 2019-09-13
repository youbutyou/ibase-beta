<!DOCTYPE HTML>
<html lang="zh_CN">
<head>
	<title>登录</title>
	<meta content="text/html;charset=UTF-8" http-equiv="content-type">
	<link href="/resources/css/layui/css/layui.css" hreflang="zh_CN" rel="stylesheet" type="text/css">
	<link href="/resources/css/login.css" hreflang="zh_CN" rel="stylesheet" type="text/css">
</head>
<body>
<div id="login-container" class="layui-container">
	<form class="layui-form" action="">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-inline">
				<input type="text" name="title" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">登陆</button>
			</div>
		</div>
	</form>
</div>
</body>
<script type="text/javascript" charset="UTF-8" src="/resources/css/layui/layui.js"></script>
<script type="text/javascript">
	//一般直接写在一个js文件中
	layui.use(['layer', 'form'], function(){
		var layer = layui.layer
				,form = layui.form;

		layer.msg('Hello World');
	});
	layui.use('form', function(){
		var form = layui.form;
		//监听提交
		form.on('submit(formDemo)', function(data){
			$.ajax({
				type:"POST",
				url:"" + "/executelogin",
				data:JSON.stringify(data.field),
				dataType:"JSON",
				success:function(data){
					layer.msg(data.message);
				}
			});
			return false;
		});
	});
</script>
</html>