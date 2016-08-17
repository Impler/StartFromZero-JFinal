<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JFinal Study</title>
</head>
<body>
	<h1>JFinal Study</h1>
	<hr>
	<div class="content">
		<ol>
			<li>
				<h2>
					<a href="hello">Hello World</a>
				</h2>
			</li>
			<li>
				<h2>Controller</h2>
				<div>
					<p>Controller 是 JFinal 核心类之一， 该类作为 MVC 模式中的控制器。 基于 JFinal 的 Web
						应用的控制器需要继承该类。 Controller 是定义 Action 方法的地点，是组织 Action 的一种方式，一个
						Controller 可以包含多个 Action。 Controller 是<b>线程安全</b>的。</p>
					<ol>
						<li>
							<h3>Action</h3>
							<p>Controller 以及在其中定义的 public 无参方法称为一个 Action。 Action
								是请求的最小单位。Action 方法必须在 Controller 中声明，该方法必须是 public
								可见性且没有形参。其中index方法作为具体路由下的默认Action</p>
							<p>
								<a href="action">index Action</a>, 
								<a href="action/other">其他Action</a>
							</p>

						</li>
						<li>
							<h3>getPara 系列方法</h3>
							<p>Controller提供了 getPara系列方法用来从请求中获取参数。<br/>getPara系列方法分为两种类型。 第 一
								种 类 型 为 第 一 个 形 参 为 String 的 getPara 系 列 方 法 。 该 系 列 方 法 是 对
								HttpServletRequest.getParameter(String name) 的 封 装 ， 这 类 方 法 都 是
								转 调 了 HttpServletRequest.getParameter(String name)。<br/> 第二种类型为第一个形参为
								int 或无形参的 getPara 系列方法。 该系列方法是去获取 urlPara 中所带的参数值。 <br />getParaMap 与
								getParaNames 分别对应 HttpServletRequest 的 getParameterMap 与
								getParameterNames。</p>
							<div>
								<form id="paraForm" method="post">
									<label>param1:</label><input type="text" id="param-param1" name="param1"/> <br />
									<label>param2:</label><input type="text" id="param-param2" name="param2"/> <br />
									<label>param3(数字):</label><input type="number" id="param-param3" name="param3"/> <br />
									<input type="button" value="test" id="paraButton"/>
								</form>
							</div>
						</li>
						<li>
							<h3>getModel 与 getBean 系列方法</h3>
							<p>getModel 用来接收页面表单域传递过来的 model
								对象，表单域名称以”modelName.attrName”方式命名。 除了 getModel 以外， 还提供了一个
								getBean 方法用于支持传统的 Java Bean。<br/></p>
							<div>
								<form id="modelForm" method="post" action="action/model">
									<label>书名:</label><input type="text" name="book.name"/> <br />
									<label>作者:</label><input type="text" name="book.author"/> <br />
									<input type="submit" value="test" />
								</form>
							</div>
						</li>
					</ol>
				</div>
			</li>
		</ol>
	</div>
	<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#paraButton").click(function(){
				var urlParam = $('#param-param1').val() + "-" + $("#param-param2").val();
				$("#paraForm").attr("action", "action/param/" + urlParam);
				$("#paraForm").submit();
			});
		});
	</script>
</body>
</html>