// 模拟后台接口
function getData(params) {
	var result = {};
	$.ajaxSettings.async = false;
	$.post("/customer/pageList",
		//发送给后端的数据
		{
			"pageNum":params.current,
			"pageSize":params.size,
			"name":$("#name").val()
		},
		//回调函数
		function(data){
			if(data.responseCode == "00"){
				var resp = data.content.dataList;
				result =  {
					total: data.content.total,
					list: resp
				}
			}
			else {
				alert("登录过期");
				window.location.href="./../index.html";
			}
		}
	)
	$.ajaxSettings.async = true;
	return result;
}

// 设置tbody的html
function setTbody (arr) {
	var html = '';
	for (var i = 0; i < arr.length; i++) {
		var item = arr[i];
		html += '<tr><td>' + item.id + '</td><td>' + item.name + '</td><td>' + item.age + '</td><td>'+ item.sex + '</td><td>'
				+ item.phoneNum + '</td><td>'+ item.address + '</td><td>'+item.remark + '</td><td>'+ '<button data-toggle="modal" data-target="#myModal" onclick="detail(this.id)" id='+item.id+'>修改</button>'
				+ ' &nbsp; &nbsp; <button onclick="deleteById(this.id)" id='+item.id+'>删除</button>'+ '</td></tr>';
	}
	$('.tbody').html(html);
}

function detail(id) {
	$.ajaxSettings.async = false;
	$.get("/customer/queryCustomerById/"+id,
		//发送给后端的数据
		{},
		//回调函数
		function(data){
			if(data.responseCode == "00"){
				$('#modal_id').val(data.content.id);
				$('#modal_name').val(data.content.name);
				$('#modal_sex').val(data.content.sex);
				$('#modal_age').val(data.content.age);
				$('#modal_phone').val(data.content.phoneNum);
				$('#modal_address').val(data.content.address);
				$('#modal_remark').val(data.content.remark);
			} else {
				alert("登录过期");
				window.location.href="./../index.html";
			}
		}
	)
	$.ajaxSettings.async = true;
}

function deleteById(id) {
	$.ajaxSettings.async = false;
	$.get("/customer/deleteById/"+id,
		//发送给后端的数据
		{},
		//回调函数
		function(data){
			if(data.responseCode == "00"){
				search();
			} else if(data.responseCode == "02"){
				alert(data.content);
			}else {
				alert("登录过期");
				window.location.href="./../index.html";
			}
		}
	)
	$.ajaxSettings.async = true;
}

function search(){
	$('.box2').MyPaging({
		size: 10,
		total: 0,
		current: 1,
		prevHtml: '上一页',
		nextHtml: '下一页',
		layout: 'total, totalPage, prev, pager, next, jumper',
		jump: function () {
			var _this = this;
			// ajax获取数据
			setTimeout(function () {
				var res = getData({
					size: _this.size,
					current: _this.current
				});
				setTbody(res.list);
				// 必须调用
				_this.setTotal(res.total);
			}, 100);
		}
	});
}

function updateCustomer(){
	$.ajaxSettings.async = false;
	$.post("/customer/updateCustomer",
		//发送给后端的数据
		{
			"id":$("#modal_id").val(),
			"name":$("#modal_name").val(),
			"sex":$("#modal_sex").val(),
			"age":$("#modal_age").val(),
			"phoneNum":$("#modal_phone").val(),
			"address":$("#modal_address").val(),
			"remark":$("#modal_remark").val(),
		},
		//回调函数
		function(data){
			if(data.responseCode == "00"){
				search();
			} else if(data.responseCode == "02"){
				alert(data.content);
			}else {
				alert("登录过期");
				window.location.href="./../index.html";
			}
		}
	)
	$.ajaxSettings.async = true;
	$('#myModal').modal('hide');
}

function addCustomer(){
	$.ajaxSettings.async = false;
	$.post("/customer/addCustomer",
		//发送给后端的数据
		{
			"name":$("#add_modal_name").val(),
			"sex":$("#add_modal_sex").val(),
			"age":$("#add_modal_age").val(),
			"phoneNum":$("#add_modal_phone").val(),
			"address":$("#add_modal_address").val(),
			"remark":$("#add_modal_remark").val(),
		},
		//回调函数
		function(data){
			if(data.responseCode == "00"){
				search();
			} else {
				alert("登录过期");
				window.location.href="./../index.html";
			}
		}
	)
	$.ajaxSettings.async = true;
	$('#addModal').modal('hide');
}

// 初始化分页
$('.box2').MyPaging({
	size: 10,
	total: 0,
	current: 1,
	prevHtml: '上一页',
	nextHtml: '下一页',
	layout: 'total, totalPage, prev, pager, next, jumper',
	jump: function () {
		var _this = this;

		// ajax获取数据
		setTimeout(function () {
			var res = getData({
				size: _this.size,
				current: _this.current
			});
			setTbody(res.list);
			// 必须调用
			_this.setTotal(res.total);
		}, 100);
	}
});