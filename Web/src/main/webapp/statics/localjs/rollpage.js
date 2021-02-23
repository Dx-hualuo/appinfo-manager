function page_nav(frm, num){
	//添加搜索参数
	for (let name in param) {
		if(param.hasOwnProperty(name)){
			frm[name] = param[name];
		}
	}
	frm["pageNo"].value = num;
	frm.submit();
}
