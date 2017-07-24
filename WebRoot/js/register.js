var p;
$(function(){
	var flagEmail=false;
	var flagName=false;
	var flagPwd=false;
	var flagRepPwd=false;
	var flagCode=false;
	
	$("#email").blur(function(){
		var email=$("#email").val();
		if(email.length==0){
			$("#emailInfo").text("用户名不可空").css("color","red");
			flagEmail=false;
		}else{
			var reg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			if(!reg.test(email)){
				$("#emailInfo").text("\u90ae\u7bb1\u683c\u5f0f\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01").css("color","red");
				flagEmail=false;
			}else{
				$.ajax({
					type:"get",
					url:"checkemail",
					data:{email:$(this).val()},
					success:function(msg){
						if(msg=='0'){
							$("#emailInfo").text("\u90ae\u7bb1\u53ef\u4ee5\u4f7f\u7528\u3002").css("color","green");
							flagEmail=true;
						}else{
							$("#emailInfo").text("\u8be5\u90ae\u7bb1\u5df2\u88ab\u6ce8\u518c\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\u3002").css("color","red");
							flagEmail=false;
						}
					}
				});
			}
		}
	});
	
	$("#txtNickName").blur(function(){
		var txtNickName=$("#txtNickName").val();
		if(txtNickName.length==0){
			$("#nameInfo").text("\u6635\u79f0\u4e0d\u80fd\u4e3a\u7a7a\uff01").css("color","red");
			flagName=false;
		}else{
			var reg=/^[a-z\d\u4e00-\u9fa5]{4,20}$/;
			if(!reg.test(txtNickName)){
				$("#nameInfo").text("\u60a8\u8f93\u5165\u7684\u6635\u79f0\u683c\u5f0f\u4e0d\u6b63\u786e\uff01").css("color","red");
				flagName=false;
			}else{
				$("#nameInfo").text("\u606d\u559c\uff0c\u6635\u79f0\u53ef\u7528\u3002").css("color","green");
				flagName=true;
		   }
		}
	});
	
	$("#txtPassword").blur(function(){
		var txtPassword=$("#txtPassword").val();
		p=txtPassword;
		if(txtPassword.length==0){
			$("#passwordInfo").text("\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a\uff01").css("color","red");
			flagPwd=false;
		}else{
			var req=/^[a-zA-Z\d]{6,20}$/;
			if(!req.test(txtPassword)){
				$("#passwordInfo").text("\u5bc6\u7801\u4e0d\u7b26\u5408\u8981\u6c42\uff01").css("color","red");
				flagPwd=false;
			}else{
				$("#passwordInfo").text("\u5bc6\u7801\u6b63\u786e\u3002").css("color","green");
				flagPwd=true;
		   }
		}
	});
	
	$("#txtRepeatPass").blur(function(){
		var txtRepeatPass=$("#txtRepeatPass").val();
		if(txtRepeatPass.length==0){
			$("#password1Info").text("\u91cd\u590d\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a\uff01").css("color","red");
			flagRepPwd=false;
		}else{
			if(p==txtRepeatPass){
				$("#password1Info").text("\u91cd\u590d\u5bc6\u7801\u53ef\u7528\u3002").css("color","green");
				flagRepPwd=true;
			}else{
				$("#password1Info").text("\u4e24\u6b21\u5bc6\u7801\u4e0d\u4e00\u81f4\uff01").css("color","red");
				flagRepPwd=false;
			}
		}
	});
	
	$("#validateCode").blur(function(){
		var validateCode=$("#validateCode").val();
		if(validateCode.length==0){
			$("#numberInfo").text("\u9a8c\u8bc1\u7801\u4e0d\u80fd\u4e3a\u7a7a\uff01").css("color","red");
			flagCode=false;
		}else{
			$.ajax({
				type:"get",
				url:"checkcode",
				data:{numberCode:$(this).val()},
				success:function(msg){
					if(msg=='1'){
						$("#numberInfo").text("\u9a8c\u8bc1\u7801\u53ef\u7528\u3002").css("color","green");
						flagCode=true;
					}else{
						$("#numberInfo").text("\u9a8c\u8bc1\u7801\u4e0d\u6b63\u786e\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\u3002").css("color","red");
						flagCode=false;
					}
				}
			});
		}
	});
	
	$("#f").submit(function(){
		return flagEmail&&flagName&&flagPwd&&flagRepPwd&&flagCode;
	});
});