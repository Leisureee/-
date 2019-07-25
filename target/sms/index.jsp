<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<style>
 	body {margin: 0; }
	.head{background: #fff; width: 100%; height: 100px; }
	.content{width:  100%; height: 500px; background-image: url(image/loginbackgr.png); position: absolute; }
	.cont-txt{width: 600px; height: 200px; position: absolute; left: 250px; top: 0px; text-align: center; color: #fff; }
	.cont-img{width: 600px; height: 250px; position: absolute; left: 250px; top: 220px;  }
	.cont-form{width: 336px; height: 435px; padding: 0 30px; background: #fff; position: absolute; right: 180px; top: 30px; border-radius: 5px; box-sizing: border-box; }
	.bottom{width: 100%; height: 160px; background: #fff; position: absolute; bottom: 0; }
	h1{font-family: "微软雅黑"; font-size: 50px; }
	.title{font-size: 18px; height: 24px; margin: 40px 0 0 0; }
	ul li{list-style: none; height:  60px; width: 100%; }
	ul{padding: 0; }
	.input{border: 1px solid #32bf7b !important; box-shadow: 0 1px 1px 1px #eee; width: 100%; height: 40px; border-radius: 3px; padding: 0 50px; box-sizing: border-box;  }
	.Img{position: relative; top: -40px; height: 40px; }
	.btn1{background: #25ba5e; border-radius: 5px; width: 100%; height: 80%; border: 1px solid #32bf7b !important; color: #fff; text-align: center; }
	.btn2{background: #fff; border-radius: 5px; width: 100%; height: 80%; border: 1px solid #32bf7b !important; color: #32bf7b; margin: 10px 0; text-align: center; }
	.close{position: absolute; right: 20px; top: 10px; }
</style>
</head>
<body>
	<div class="head"></div>
	<div class="content">
		<div class="cont-txt"><h1>超市管理系统</h1></div>
		<div class="cont-img"><img src="image/new3loginbg_meitu_1.jpg" width="100%" height="100%"></div>
		<div class="cont-form" id="loginform">
			<div class="title">账号登录</div>
            <form action="UserController" id="l_form" method="post">
			<ul>
                <input type="hidden" name="action" value="login"/>
                <li><input type="text" placeholder="请输入您的账号" class="input" id="lcno" name="name"><img src="image/id.png" class="Img"></li>
				<li><input type="password" placeholder="请输入您的密码" class="input" id="lpassword" name="password"><img src="image/password.png" class="Img"></li>
				<li><input type="text" placeholder="验证码" name="vcode"><img id="vcode" src="index.jsp" onclick="changecode()" style="position: absolute;"></li>
				<li><button class="btn1" id="login" type="button">登录</button></li>
				<li><button class="btn2" id="reg" type="button">注册</button></li>
			</ul>
            </form>
			<br/><span style="color:red">${error }</span>
			<span><em>注意事项：必须是管理员登录</em></span>
		</div>
		<div class="cont-form" style="display: none" id="regform">
			<span class="close" id="close">X</span>
			<div class="title">账号注册</div>
            <form action="UserController" id="r_form" method="post">
            <ul>
                <input type="hidden" name="action" value="register"/>
                <li><input type="text" placeholder="请输入您的账号" class="input" id="cno" name="name"><img src="image/id.png" class="Img"></li>
				<li><input type="password" placeholder="请输入您的密码" class="input" id="password" name="password"><img src="image/password.png" class="Img"></li>
				<li><input type="password" placeholder="请再次输入您的密码" class="input" id="repassword"><img src="image/password.png" class="Img"></li>
				<li><input type="email" placeholder="请输入您的邮箱" class="input" name="email"><img src="image/email.png" class="Img"></li>
				<li><input type="text" placeholder="验证码" name="vcode"><img id="vcode" src="index.jsp" onclick="changecode()" style="position: absolute;"></li>
				<li><button class="btn2" id="regs" type="button">注册</button></li>
			</ul>
            </form>
			<br/><span style="color:red">${error }</span>
            <span><em>注意事项：必须是管理员注册</em></span>
		</div>
	</div>
	<div class="bottom"></div>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script>
  $('#reg').click(function(){
		$('#loginform').hide();
	    $('#regform').show();
	  	$('title').text('注册');
  })
	function showTips(txt,time,status)
	{
		var htmlCon = '';
		if(txt != ''){
			if(status != 0 && status != undefined){
				htmlCon = '<div class="tipsBox" style="width:220px;padding:10px;background-color:#4AAF33;border-radius:4px;-webkit-border-radius: 4px;-moz-border-radius: 4px;color:#fff;box-shadow:0 0 3px #ddd inset;-webkit-box-shadow: 0 0 3px #ddd inset;text-align:center;position:fixed;top:25%;left:50%;z-index:999999;margin-left:-120px;">'+txt+'</div>';
			}else{
				htmlCon = '<div class="tipsBox" style="width:220px;padding:10px;background-color:#D84C31;border-radius:4px;-webkit-border-radius: 4px;-moz-border-radius: 4px;color:#fff;box-shadow:0 0 3px #ddd inset;-webkit-box-shadow: 0 0 3px #ddd inset;text-align:center;position:fixed;top:25%;left:50%;z-index:999999;margin-left:-120px;">'+txt+'</div>';
			}
			$('body').prepend(htmlCon);
			if(time == '' || time == undefined){
				time = 1500;
			}
			setTimeout(function(){ $('.tipsBox').remove(); },time);
		}
	}
	$('#login').click(function(){
		var cno = $('#lcno').val();
		var password = $('#lpassword').val();
		if(cno == '') {
			showTips('账号不能为空')
	    } else if(password=='') {
			showTips('密码不能为空')
		} else {
			$('#l_form').submit();
		}
	})
	$('#regs').click(function(){
		var cno = $('#cno').val();
		var password = $('#password').val();
		var repassword = $('#repassword').val();
		if(cno == '') {
			showTips('账号不能为空')
	    } else if(password=='') {
			showTips('密码不能为空')
		} else if(repassword=='') {
			showTips('密码不能为空')
		} else if(password!=repassword) {
			showTips('两次密码不一致')
		} else {
			$('#r_form').submit();
		}
	})
	$('#close').click(function(){
		$('#regform').hide();
		$('#loginform').show();
		$('title').text('登录');
	})
	!function(){
		var status=<%=request.getParameter("status")%>
		if(status=='1'){
			showTips('用户名或密码错误！','',0);
		}else if(status=='2'){
			showTips('用户已存在！','',0);
			$('#close').click();
		}else if(status=='3'){
			showTips('注册成功！','',1);
		}else if(status=='4'){
			showTips('请先登录!')
		}
	}();
  //var i = 1;
  function changecode() {
<!--	  $("#vcode").attr("src", "UserController?action=changecode");-->
<!--	  $('#loginform').hide();-->
<!--	  $('#regform').show();-->
<!--	  $('title').text('注册');-->
	  document.getElementById('vcode').src="index.jsp?c="+Math.random();
  }
</script>
</html>
