$(function(){  
	//动态加载所属平台列表
	$.ajax({
		type:"GET",//请求类型
		url: hostPath + "/dev/appInfo/dataDictionary/APP_FLATFORM",//请求的url
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			data = data.data;
			let jquery = $("#flatformId");
			jquery.html("");
			let options = "<option value=\"\">--请选择--</option>";
			for(let i = 0; i < data.length; i++){
				options += "<option value=\""+data[i]["valueId"]+"\">"+data[i]["valueName"]+"</option>";
			}
			jquery.html(options);
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("加载平台列表失败！");
		}
	});  
	//动态加载一级分类列表
	$.ajax({
		type:"GET",//请求类型
		url: hostPath + "/dev/appInfo/levelList",//请求的url
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			data = data.data;
			let level1 = $("#categoryLevel1");
			level1.html("");
			let options = "<option value=\"\">--请选择--</option>";
			for(let i = 0; i < data.length; i++){
				options += "<option value=\""+data[i].id+"\">"+data[i]["categoryName"]+"</option>";
			}
			level1.html(options);
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("加载一级分类列表失败！");
		}
	});  
	//动态加载二级分类列表
	$("#categoryLevel1").change(function(){
		let categoryLevel1 = $("#categoryLevel1").val();
		let level2 = $("#categoryLevel2");
		if(categoryLevel1 !== '' && categoryLevel1 != null){
			$.ajax({
				type:"GET",//请求类型
				url: hostPath + "/dev/appInfo/levelList",//请求的url
				data:{"fatherId":categoryLevel1},//请求参数
				dataType:"json",//ajax接口（请求url）返回的数据类型
				success:function(data){//data：返回数据（json对象）
					data = data.data;
					level2.html("");
					let options = "<option value=\"\">--请选择--</option>";
					for(let i = 0; i < data.length; i++){
						options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
					}
					level2.html(options);
				},
				error:function(data){//当访问时候，404，500 等非200的错误状态码
					alert("加载二级分类失败！");
				}
			});
		}else{
			level2.html("");
			let options = "<option value=\"\">--请选择--</option>";
			level2.html(options);
		}
		let level3 = $("#categoryLevel3");
		level3.html("");
		let options = "<option value=\"\">--请选择--</option>";
		level3.html(options);
	});
	//动态加载三级分类列表
	$("#categoryLevel2").change(function(){
		let categoryLevel2 = $("#categoryLevel2").val();
		let level3 = $("#categoryLevel3");
		if(categoryLevel2 !== '' && categoryLevel2 != null){
			$.ajax({
				type:"GET",//请求类型
				url: hostPath + "/dev/appInfo/levelList",//请求的url
				data:{"fatherId":categoryLevel2},//请求参数
				dataType:"json",//ajax接口（请求url）返回的数据类型
				success:function(data){//data：返回数据（json对象）
					data = data.data;
					level3.html("");
					let options = "<option value=\"\">--请选择--</option>";
					for(let i = 0; i < data.length; i++){
						options += "<option value=\""+data[i].id+"\">"+data[i]["categoryName"]+"</option>";
					}
					level3.html(options);
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
	
	$("#back").on("click",function(){
		window.location.href = hostPath + "/dev/appInfo";
	});
	
	$("#APKName").bind("blur",function(){
		//ajax后台验证--APKName是否已存在
		$.ajax({
			type:"GET",//请求类型
			url: hostPath + "/dev/appInfo/apkName/exist",//请求的url
			data:{name:$("#APKName").val()},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.message === "empty"){//参数APKName为空，错误提示
					alert("APKName为不能为空！");
				}else if(data.message === "exist"){//账号不可用，错误提示
					alert("该APKName已存在，不能使用！");
				}else if(data.message === "noexist"){//账号可用，正确提示
					alert("该APKName可以使用！");
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("请求错误！");
			}
		});
	});
});
      
      
      