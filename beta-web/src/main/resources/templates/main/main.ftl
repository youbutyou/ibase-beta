<!DOCTYPE HTML>
<html lang="zh_CN">
<head>
	<title>main</title>
	<meta content="text/html;charset=UTF-8" http-equiv="content-type">
	<link href="/resources/css/layui/css/layui.css" hreflang="zh_CN" rel="stylesheet" type="text/css">
</head>
<body>
<div id="loginContainer" class="login-container">
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
</script>
</html>