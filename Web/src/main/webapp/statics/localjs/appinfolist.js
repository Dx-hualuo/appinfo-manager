/**
 * 	填充二级分类
 */
$("#queryCategoryLevel1").change(function(){
	//jQuery 123级分类
	let queryCategoryLevel1 = $("#queryCategoryLevel1").val();
	let lv2 = $("#queryCategoryLevel2");
	let lv3 = $("#queryCategoryLevel3");
	if(queryCategoryLevel1 !== "" && queryCategoryLevel1 != null){
		$.ajax({
			type:"GET",//请求类型
			url: hostPath + "/dev/appInfo/levelList",//请求的url
			data:{"fatherId":queryCategoryLevel1},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				lvlSuccess(data, lv2);
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("加载二级分类失败！");
			}
		});
	}else{
		lv2.html("");
		let options = "<option value=\"\">--请选择--</option>";
		lv2.html(options);
	}
	lv3.html("");
	let options = "<option value=\"\">--请选择--</option>";
	lv3.html(options);
});

/**
 * 	填充三级分类
 */
$("#queryCategoryLevel2").change(function(){
	let level3 = $("#queryCategoryLevel3");
	let queryCategoryLevel2 = $("#queryCategoryLevel2").val();
	if(queryCategoryLevel2 !== '' && queryCategoryLevel2 != null){
		$.ajax({
			type: "GET",//请求类型
			url: hostPath + "/dev/appInfo/levelList",//请求的url
			data: {fatherId:queryCategoryLevel2},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				lvlSuccess(data, level3);
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("加载三级分类失败！");
			}
		});
	}else{
		level3.html("");
		let options = "<option value=\"\">--请选择--</option>";
		level3.html(options);
	}
});

/**
 * 	分类代码抽取
 * @param data 后台数据
 * @param lvlDom 需要被填充的Dom对象
 */
function lvlSuccess(data, lvlDom){
	data = data.data;
	lvlDom.html("");
	let options = "<option value=\"\">--请选择--</option>";
	for(let i = 0; i < data.length; i++){
		//alert(data[i].id);
		//alert(data[i].categoryName);
		options += "<option value=\""+data[i].id+"\">"+data[i]["categoryName"]+"</option>";
	}
	lvlDom.html(options);
}

/**
 * 	添加版本
 */
$(".addVersion").on("click",function(){
	let obj = $(this);
	window.location.href=hostPath + "/dev/appInfo/version/add/"+ obj.attr("appinfoid");
});

/**
 * 	更改版本
 */
$(".modifyVersion").on("click",function(){
	let obj = $(this);
	let status = obj.attr("status");
	let versionid = obj.attr("versionid");
	let appinfoid = obj.attr("appinfoid");
	if(status === "1" || status === "3"){//待审核、审核未通过状态下才可以进行修改操作
		if(versionid == null || versionid === ""){
			alert("该APP应用无版本信息，请先增加版本信息！");
		}else{
			window.location.href= hostPath + "/dev/appInfo/version/modify?versionId="+ versionid + "&appId="+ appinfoid;
		}
	}else{
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能修改其版本信息，只可进行【新增版本】操作！");
	}
});

/**
 * 	更改APP信息
 */
$(".modifyAppInfo").on("click",function(){
	let obj = $(this);
	let status = obj.attr("status");
	if(status === "1" || status === "3"){//待审核、审核未通过状态下才可以进行修改操作
		window.location.href= hostPath + "/dev/appInfo/modify/"+ obj.attr("appinfoid");
	}else{
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能修改！");
	}
});

/**
 *	上下架事件绑定
 */
$(document).on("click",".saleSwichOpen,.saleSwichClose",function(){
	let obj = $(this);
	let appinfoid = obj.attr("appinfoid");
	let saleSwitch = obj.attr("saleSwitch");
	if("open" === saleSwitch){
		saleSwitchAjax(appinfoid, obj);
	}else if("close" === saleSwitch){
		if(confirm("你确定要下架您的APP应用【"+obj.attr("appsoftwarename")+"】吗？")){
			saleSwitchAjax(appinfoid, obj);
		}
	}
});

/**
 *	销售开关 AJAX
 * @param appId AppId
 * @param obj Object
 */
const saleSwitchAjax = function(appId, obj){
	$.ajax({
		type:"PUT",
		url: hostPath + "/dev/appInfo/saleStatusChange/" + appId,
		dataType:"json",
		success:function(data){
			let jquery = $("#appInfoStatus" + obj.attr("appinfoid"));
			/*
			 * resultMsg:success/failed
			 * errorCode:exception000001
			 * appId:appId
			 * errorCode:param000001
			 */
			if(data.errorCode === '0'){
				if(data.message === "success"){//操作成功
					if("open" === obj.attr("saleSwitch")){
						//alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作成功");
						jquery.html("已上架");
						obj.className="saleSwichClose";
						obj.html("下架");
						obj.attr("saleSwitch","close");
						jquery.css({
							'background':'green',
							'color':'#fff',
							'padding':'3px',
							'border-radius':'3px'
						});
						jquery.hide();
						jquery.slideDown(300);
						alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作成功");
					}else if("close" === obj.attr("saleSwitch")){
						//alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作成功");
						jquery.html("已下架");
						obj.className="saleSwichOpen";
						obj.html("上架");
						obj.attr("saleSwitch","open");
						jquery.css({
							'background':'red',
							'color':'#fff',
							'padding':'3px',
							'border-radius':'3px'
						});
						jquery.hide();
						jquery.slideDown(300);
						alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作成功");
					}
				}else if(data.message === "failed"){//删除失败
					if("open" === obj.attr("saleSwitch")){
						alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作失败");
					}else if("close" === obj.attr("saleSwitch")){
						alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作失败");
					}
				}
			}else{
				if(data.errorCode === 'exception000001'){
					alert("对不起，系统出现异常，请联系IT管理员");
				}else if(data.errorCode === 'param000001'){
					alert("对不起，参数出现错误，您可能在进行非法操作");
				}
			}
		},
		error:function(data){
			if("open" === obj.attr("saleSwitch")){
				alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作失败");
			}else if("close" === obj.attr("saleSwitch")){
				alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作失败");
			}
		}
	});
};

$(".viewApp").on("click",function(){
	let obj = $(this);
	window.location.href= hostPath + "/dev/appInfo/view/"+ obj.attr("appinfoid");
});

$(".deleteApp").on("click",function(){
	let obj = $(this);
	if(confirm("你确定要删除APP应用【"+obj.attr("appsoftwarename")+"】及其所有的版本吗？")){
		$.ajax({
			type:"GET",
			url: hostPath + "/dev/appInfo/delete/"+obj.attr("appinfoid"),
			dataType:"json",
			success:function(data){
				if(data.message === "true"){//删除成功：移除删除行
					alert("删除成功");
					obj.parents("tr").remove();
				}else if(data.message === "false"){//删除失败
					alert("对不起，删除AAP应用【"+obj.attr("appsoftwarename")+"】失败");
				}else if(data.message === "notexist"){
					alert("对不起，APP应用【"+obj.attr("appsoftwarename")+"】不存在");
				}
			},
			error:function(data){
				alert("对不起，删除失败");
			}
		});
	}
});
