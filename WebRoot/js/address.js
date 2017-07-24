$(function(){
	var flag={"receiveName":false,"fullAddress":false,"postalCode":false,"phone":false,"mobile":false};

	$("#receiveName").blur(function(){
		var receiveName=$("#receiveName").val();
		if(receiveName.length==0){
			$("#nameValidMsg").html("<img src='images/wrong.gif'></img>");
			flag.receiveName=false;
		}else{
			$("#nameValidMsg").html("<img src='images/right.gif'></img>");
			flag.receiveName=true;
		}
	});
	
	$("#fullAddress").blur(function(){
		var fullAddress=$("#fullAddress").val();
		if(fullAddress.length==0){
			$("#addressValidMsg").html("<img src='images/wrong.gif'></img>");
			flag.fullAddress=false;
		}else{
			$("#addressValidMsg").html("<img src='images/right.gif'></img>");
			flag.fullAddress=true;
		}
	});
	
	$("#postalCode").blur(function(){
		var postalCode=$("#postalCode").val();
		if(postalCode.length==0){
			$("#codeValidMsg").html("<img src='images/wrong.gif'></img>");
			flag.postalCode=false;
		}else{
			var req=/^\d{6}$/;
			if(!req.test(postalCode)){
				$("#codeValidMsg").html("<img src='images/wrong.gif'></img>");
				flag.postalCode=false;
			}else{
				$("#codeValidMsg").html("<img src='images/right.gif'></img>");
				flag.postalCode=true;
			}
		}
	});
	
	$("#phone").blur(function(){
		var phone=$("#phone").val();
		if(phone.length!=0){
			var req=/^\d{4}-\d{7}$/;
			if(!req.test(phone)){
				$("#phoneValidMsg").html("<img src='images/wrong.gif'></img>");
				flag.phone=false;
			}else{
				$("#phoneValidMsg").html("<img src='images/right.gif'></img>");
				flag.phone=true;
			}
		}else{
			$("#phoneValidMsg").html("");
			flag.phone=true;
		}
	});
	
	$("#mobile").blur(function(){
		var mobile=$("#mobile").val();
		if(mobile.length==0){
			$("#mobileValidMsg").html("<img src='images/wrong.gif'></img>");
			flag.mobile=false;
		}else{
			var req=/^\d{11}$/;
			if(!req.test(mobile)){
				$("#mobileValidMsg").html("<img src='images/wrong.gif'></img>");
				flag.mobile=false;
			}else{
				$("#mobileValidMsg").html("<img src='images/right.gif'></img>");
				flag.mobile=true;
			}
		}
	});
	
	window.setInterval(function(){
		if(flag.receiveName&&flag.fullAddress&&flag.postalCode&&flag.phone&&flag.mobile){
			$("#next").attr("disabled","");
		}else{
			$("#next").attr("disabled","disabled");
		}
	},1000);
});