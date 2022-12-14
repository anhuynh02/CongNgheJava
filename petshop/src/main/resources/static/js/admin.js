const staffM = $("#staffManage");
const productM = $("#productManage");
const statisticM = $("#statisticManage");


$(document).ready(function() {
	//Phân trang
    $("#staff").click(function(){
        staffM.css("display","block");
        productM.css("display","none");
        statisticM.css("display","none");
    })
    $("#product").click(function(){
        staffM.css("display","none");
        productM.css("display","block");
        statisticM.css("display","none");
    })
    $("#statistic").click(function(){
        staffM.css("display","none");
        productM.css("display","none");
        statisticM.css("display","block");
    })
    
//----------------------Quản lý nhân viên-------------------------
    
    //Thêm nhân viên dialog
    $("#addStaffBtn").click(function(e) {
        $("#addStaffModal").modal({
            backdrop: "static",
            keyboard: false
        });
    });
    
    //Xóa nhân viên dialog
    $(".btn-delete-staff").click(function(e) {
        $("#deleteStaffModal").modal({
            backdrop: "static",
            keyboard: false
        });
    });
    
    //Chỉnh sửa nhân viên
    $(".btn-edit-staff").click(function(e) {
    	$("#editStaffModal").modal({
            backdrop: "static",
            keyboard: false
        });
        let currId = $(this).data("id")
    	$.get("admin/staff/edit/" + currId, function(staff) {
			$("#editStaffId").val(staff.id);
			$("#editStaffPhone").val(staff.phone);
			$("#editStaffName").val(staff.name);
			$("#editStaffUsername").val(staff.username);
			//Đổi mật khẩu nhân viên
		    $("#editPassword").click(function() {
		    	window.location.href = "admin/staff/edit/password/" + currId;
		    });
   		});
        e.preventDefault();
    });
    
    //Xóa nhân viên
	$(".btn-delete-staff").click(function(e) {
		$("#deleteStaffId").val($(this).data("id"));
        $("#deleteModal").modal({
            backdrop: "static",
            keyboard: false
        });
		e.preventDefault();
    });
    
//----------------------Quản lý sản phẩm-------------------------
    
    //Thêm sản phẩm dialog
    $("#proAddBtn").click(function(e) {
        $("#addProduct").modal({
            backdrop: "static",
            keyboard: false
        });
    });
        
    //Chỉnh sửa sản phẩm
    $(".productEdit").click(function(e) {
		console.log($(this).data("id"));
    	$("#editProduct").modal({
            backdrop: "static",
            keyboard: false
        });
    	$.get("admin/product/edit/" + $(this).data("id"), function(product) {
			$("#editprice").val(product.price);
			$("#editname").val(product.name);
			$("#editdes").val(product.description);
			$("#editprice").val(product.price);
			$("#editProId").val(product.id);
			if(product.category.id == "1"){
				$("#editcat").prop("selected",true);
			}else if(product.category.id == "2"){
				$("#editdog").prop("selected",true);
			}else if(product.category.id == "3"){
				$("#editfood").prop("selected",true);
			}else if(product.category.id == "4"){
				$("#edittoy").prop("selected",true);
			}
   		});
        e.preventDefault();
    });
     
    //Xóa sản phẩm
    $(".productDel").click(function(e) {
		$("#delProId").val($(this).data("id"));
        $("#deleteProduct").modal({
            backdrop: "static",
            keyboard: false
        });
		e.preventDefault();
    });
    
//----------------------Thống kê-------------------------
	
	// Tạo màu ngẫu nhiên cho biểu đồ.
	function generateColor() {
		return "#" + Math.floor(Math.random()*16777215).toString(16);
	}
	
	// Tạo biểu đồ doanh thu theo tháng năm hiện tại.
	function statisticMonthChart(id, months=[], totals=[]) {
		let colors = [];
		for (let i = 0; i < months.length; i++) {
			colors.push(generateColor())
		}
		
		const data = {
			labels: months,
			datasets: [{
				label: "",
				data: totals,
				backgroundColor: colors,
				borderColor: colors,
				hoverOffset: 4
			}]
		};
		
		const config = {
			type: 'bar',
			data: data,
		};
		
		let ctx = document.getElementById(id).getContext("2d");
		
		new Chart(ctx, config);
	}
	
	// Lấy dữ liệu từ bảng html.
	let months=[], totals=[];
	
	$('tr.statistic').each(function (a, b) {
        months.push($('.statistic-month', b).text());
        totals.push($('.statistic-total', b).text());
    });
	
	statisticMonthChart("statisticMonthChart", months, totals);
})