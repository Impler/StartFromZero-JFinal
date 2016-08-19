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
								<!-- action改为action/param?param_1=p1，urlPara将取不到 -->
								<form id="paraForm" action="action/param?param_1=p1">
									<label>param1:</label><input type="text" id="param-param1" name="param1"/> <br />
									<label>param2:</label><input type="text" id="param-param2" name="param2"/> <br />
									<label>param3(数字):</label><input type="number" id="param-param3" name="param3"/> <br />
									<input type="button" value="get" id="paraGetButton" class="paraButton"/>
									<input type="button" value="post" id="paraPostButton" class="paraButton"/>
								</form>
							</div>
						</li>
						<li>
							<h3>getModel 与 getBean 系列方法</h3>
							<p>getModel 用来接收页面表单域传递过来的 model(com.jfinal.plugin.activerecord.Model)
								对象，表单域名称以”modelName.attrName”方式命名。 除了 getModel 以外， 还提供了一个
								getBean 方法用于支持传统的 Java Bean。<br/></p>
							<div>
								<ul>
									<li>
										<h4>getBean</h4>
										<div>
											<form id="beanForm" action="action/bean">
												<label>书名book.name:</label><input type="text" name="book.name"/> <br />
												<label>作者book.author:</label><input type="text" name="book.author"/> <br />
												<label>书名bk.name:</label><input type="text" name="bk.name"/> <br />
												<label>作者bk.author:</label><input type="text" name="bk.author"/> <br />
												<input type="submit" value="test" />
											</form>
										</div>
									</li>
									<li>
										<h4>getModel</h4>
										<div>
											<form id="modelForm" action="action/model">
												<label>用户名user.username:</label><input type="text" name="user.username"/> <br />
												<label>邮箱user.email:</label><input type="text" name="user.email"/> <br />
												<label>用户名u.username:</label><input type="text" name="u.username"/> <br />
												<label>邮箱u.email:</label><input type="text" name="u.email"/> <br />
												<input type="submit" value="test" />
											</form>
										</div>
									</li>
								</ul>
							</div>
						</li>
						<li>
							<h3>setAttr方法</h3>
							<p>setAttr(String, Object)转调了
								HttpServletRequest.setAttribute(String, Object)，该方法可以将各种数据传递给
								View 并在 View 中显示出来。</p>
							<div>
								<form action="action/setAttr">
									<label>attr:</label><input type="text" name="attr"/> <br />
									<input type="submit" value="test" />
								</form>
							</div>
						</li>
						<li>
							<h3>session 操作方法</h3>
							<p>通过 setSessionAttr(key, value)可以向 session
								中存放数据，getSessionAttr(key)可以从 session 中读取数据。 还可以通过 getSession()得到
								session 对象从而使用全面的 session API。</p>
							<div>
								<form action="action/session">
									<label>attr:</label><input type="text" name="attr"/> <br />
									<input type="submit" value="test" />
								</form>
							</div>
						</li>
					</ol>
				</div>
			</li>
			<li>
				<h2>Interceptor</h2>
				<div>
					<p>
						实现com.jfinal.aop.Interceptor即可作为JFinal拦截器。从代码实现上拦截器之间没有太大不同，但从意义和作用上分为控制层拦截器和业务层拦截器，<br />
						作用于任意controller(继承com.jfinal.core.Controller)类的拦截器称为控制层拦截器；作用于任意service(任意java类)类的拦截器称为业务层控制器。<br />
						控制层拦截器的触发， 只需发起 action 请求即可。业务层拦截器的触发需要先使用 enhance方法对目标对象进行增强， 然后调用目标方法即可. 详见Duang、 Enhancer帮助类 <br />
						无论控制层还是业务层，按照拦截对象，拦截器又可以分为全局拦截器、类拦截器、方法拦截器、Inject拦截器。<br />
						全局控制器：作用于控制层或业务层的所有类的所有方法，在JFinalConfig中注册全局注册器<br />
						类拦截器：作用于控制层或业务层的所有方法 ，在具体类上通过@Before注解配置拦截器<br />
						方法拦截器：作用于指定的方法， 在具体方法上通过@Before注解配置拦截器<br />
						Inject拦截器：在使用 enhance 或 duang 方法增强时使用参数传入的拦截器。 Inject 可以对目标完全无侵入地应用 AOP。 即不需要使用@Before注解。Inject拦截器作用于被拦截类的所有方法，与类拦截器同级别，只不过先与类拦截器执行<br />
						拦截器各级别执行的次序依次为： Global、Inject、 Class、 Method，如果同级中有多个拦截器，那么同级中的执行次序是： 配置在前面的先执行
					</p>
					<ul>
						<li>
							<h3>控制层拦截器</h3>
							<div>
								<a href="interceptor">类拦截器</a> <a href="interceptor/other">方法拦截器</a> <a href="interceptor/clear">清除拦截器</a>
							</div>
						</li>
						<li>
							<h3>业务层拦截器</h3>
							<div>
								<a href="interceptor/service">业务层拦截器</a>
							</div>
						</li>
						<li>
							<h3>Inject拦截器</h3>
							<div>
								<a href="interceptor/inject">Inject拦截器</a>
							</div>
						</li>
					</ul>
				</div>
			</li>
			<li>
				<h2>ActiveRecord</h2>
				<div>
					<p>ActiveRecord 是 JFinal 最核心的组成部分之一，通过 ActiveRecord 来操作数据库， 将极大
						地减少代码量，极大地提升开发效率。 ActiveRecord 是作为 JFinal 的 Plugin 而存在的，所以使用时需要在
						JFinalConfig 中配置 ActiveRecordPlugin。
					</p>
					<ul>
						<li><h3>Model</h3>
							<div><a href="user">测试</a></div>
						</li>
						<li><h3>Model</h3></li>
					</ul>
				</div>
			</li>
		</ol>
	</div>
	<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".paraButton").click(function(){
				var urlParam = $('#param-param1').val() + "-" + $("#param-param2").val();
				var action = $("#paraForm").attr('action') + "/" + urlParam;
				$("#paraForm").attr("method", $(this).val());
				$("#paraForm").attr("action", action);
				$("#paraForm").submit();
			});
		});
	</script>
</body>
</html>