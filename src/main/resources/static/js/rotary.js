

// 砸蛋抽奖
function  zadan(obj) { 
	$(obj).children("span").hide(); 
	eggClick($(obj)); 
  }; 



// dansui1=1;
var flag1=$("#flag1").val();
var flag=$("#flag").val();
function eggClick(obj) {

	var $raotary_looper = $(".rotary_box");
	var $egg=$(".egg");
	var $rotary_wrap = $(".rotary_wrap");
	// console.log(flag+ " --------------");
	// console.log(flag=="0")
	if(flag=="0"){
		$("#flag").val("1");
	}else{
		$("#flag1").val("1");
		alert("请不要点击太快！")
		$("#flag").val("0");
		return false;
	}
	var phone= document.getElementById("phone").value;
	var name= document.getElementById("name").value;
	var xuehao=document.getElementById("xuehao").value;

	if(phone==""){
		alert("无数据");
		return;
	}
	if(name==""){
		alert("无数据");
		return;
	}
	if(xuehao==""){
		alert("无数据");
		return;
	}

	console.log(dansui1)
	if(dansui1<1){
	
	alert("抽奖结束！");
        flag=0;
        flag1=0;
	// location.reload();
	return;
	}
	
	var _this = obj; 

	
	
	$("#hammer").stop(true);
	
		//clearInterval(dingshi);
		  
			//$(".hammer").css({"top":"150px","left":"420px"});
			setTimeout(function(){

				if(flag1=="1"){
					$("#flag1").val("0");
					return false;
				}
				
				window.dansui1=0;
				 _this.addClass("curr"); //蛋碎效果 
				   // _this.find("sup").show(); //金花四溅 
					$(".hammer").hide();//隐藏锤子 
					//var data={"code":200,"msg":"中奖名单","t":null,"tList":null,"obj":[{"id":"2019710222","user":"李四","phoneId":"123456"},{"id":"2019710235","user":"钟洪强","phoneId":"17628641423"},{"id":"2019710202","user":"赵六","phoneId":"123456"}],"url":null}
					
					
					$.ajax({
						url:"../../customerController/getData",    //请求的url地址
						dataType:"json",   //返回格式为json
						async:true,//请求是否异步，默认为异步，这也是ajax重要特性
						data:null,    //参数值
						type:"GET",   //请求方式
						
						//请求成功时处理
						success:function(req){
							if(req['code']=="200"){
								for(i=0;i<req["obj"].length;i++){
									if(req["obj"][i]["id"]==localStorage.getItem("id",xuehao)){
										alert(req["obj"][i]["user"]+"恭喜您，中奖啦！");
										return;
									}
								}
								alert("非常遗憾，未中奖。");
							}
						},
						// complete:function(){
						// 	//请求完成的处理
						// },
						error:function(){
							alert("Error！");
							return false;
							//请求出错处理
						}
					});
				
					  $("#flag").val("0")
			  },300)

			  console.log(dansui1)
				
	  
	}

//抽奖
function choujiang(){
	$("li").removeClass("curr");
    $(".hammer").show()
	window.dansui1 = 1;
	var $raotary_looper = $(".rotary_box");
	var $egg=$(".egg");
	var $rotary_wrap = $(".rotary_wrap");
	$egg.fadeIn(200);
	$raotary_looper.fadeIn(200);
	$rotary_wrap.fadeIn(200);
	var $looper_close = $('.looper_close');
	$looper_close.click(function(){
		$egg.fadeOut(200);
		$rotary_wrap.fadeOut(200);
		$raotary_looper.fadeOut(200);
	});
}


//数据录入+蒙版弹出层
function rotary() {

	var $rotaryArrow = $('#rotaryArrow');
	var $close = $(".close");
	
	var $raotary_looper = $(".rotary_box");

	var $rotary_wrap = $(".rotary_wrap");
	var $result = $('.result');

	var $rotary_fuzhu = $(".rotary_fuzhu");
	
	//var $resultTxt = $('#resultTxt');
	//var $resultTxt1 = $('#resultTxt1');
	var $resultBtn = $('#resultBtn');
	//var $rotaryNot = $('#rotaryNot');
	var $submit = $('.submit');
	var $looper_close = $('.looper_close');
	if($.cookie('rotary_time_hzh')==null){
		setTimeout(function(){
			$raotary_looper.fadeIn(200);
			$rotary_wrap.fadeIn(200);
		},2000);
	}else{
		if($.cookie('rotary_text_hzh')!=null){
			if($.cookie("rotary_result_hzh")==null){
				setTimeout(function(){
					$raotary_looper.fadeIn(200);
					$rotary_wrap.fadeIn(200);
					$resultTxt.val($.cookie('rotary_text_hzh'));
					$resultTxt1.val($.cookie('rotary_text_hzh'));
					$result.fadeIn(200);
				},2000);
			}		
		}
	}
	$result.fadeIn(200);
	//设置关闭按钮
	$close.click(function(){
		$raotary_looper.fadeOut(200);
		$rotary_wrap.fadeOut(200);
	});
	//抽奖开始
	$rotaryArrow.click();
	//用户信息操作
	$("form").submit(function(){
        var phone= document.getElementById("phone").value;
		var name= document.getElementById("name").value;
		var xuehao=document.getElementById("xuehao").value;
		
		$("#username").val(name);
		$(".layui-btn").trigger("click");

        var $time = new Date();
        if(phone=="" || name==""){
            alert('属性不能为空');
            return false;
        }else if (phone.search(/^(((1[2354789]{1}[0-9]{1})|(15[0-9]{1}))+\d{8})$/)== -1){ 
                alert("手机号码有误，请重新输入");  
                return false; 
            } else if(name.search(/^([\u4e00-\u9fa5]{2,6})$/)== -1){
            	alert("姓名有格式不对，请重新输入");  
                return false; 
			}

			localStorage.setItem("id",xuehao);
			//接口请求
			$.ajax({
				url:"../../customerController/getFrom",    //请求的url地址
				dataType:"json",   //返回格式为json
				async:true,//请求是否异步，默认为异步，这也是ajax重要特性
				data:{"id":xuehao,
					  "phoneId":phone,
					  "user":name},    //参数值
				type:"GET",   //请求方式
				// beforeSend:function(){
				// 	//请求前的处理
				// },
				
				success:function(req){
					if(req['code']=="200"){
						alert(req.msg);
					$result.fadeOut(200);
					$rotary_wrap.fadeOut(200);
					$raotary_looper.fadeOut(200);}
					//$egg.fadeIn(200);
					//请求成功时处理
				},
				// complete:function(){
				// 	//请求完成的处理
				// },
				error:function(){
					$result.fadeOut(200);
					$rotary_wrap.fadeOut(200);
					$raotary_looper.fadeOut(200);
					alert("提交失败！");
					
					//请求出错处理
				}
			});
        //判断是否提交,生成提交cookie
        
		});
	//回调函数
	var rotateFunc = function(awards,angle,text){
		$rotaryArrow.stopRotate();
		$rotaryArrow.rotate({
			angle:0,
			duration:5000,
			animateTo:angle+1800,
			callback:function(){
				//完成时生成text-cookie
				var $_COOKIE = $.cookie('rotary_text_hzh',text,{ expires:24 , path: "/"});
				$resultTxt.val(text);
				$resultTxt1.val(text);
				$result.fadeIn(350);
			}
		})
	};
	$looper_close.click(function(){
		$rotary_fuzhu.show(200);
		$rotary_wrap.hide();
	});

	$rotary_fuzhu.click(function(){
		$raotary_looper.css({"background-color":'#000','opacity':"0.6",'background-image':'none'});
		$raotary_looper.animate({
			'width':"100%",
			'height':"100%"
		},10);
		$(this).hide();
		$rotary_wrap.fadeIn(100);
	})
	
	//关闭按钮
	$resultBtn.click(function(){
		$result.fadeOut(300);
	});



}