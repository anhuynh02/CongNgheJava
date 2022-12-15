let staffM = $("#staffManage");
let productM = $("#productManage");


$(document).ready(function() {
	//Phân trang
    $("#staff").click(function(){
        staffM.css("display","block");
        productM.css("display","none");
    })
    $("#product").click(function(){
        staffM.css("display","none");
        productM.css("display","block");
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
		$("#deleteId").val($(this).data("id"));
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
					$("#editcat").prop("checked",true);
				}else if(product.category.id == "2"){
					$("#editdog").prop("checked",true);
				}else if(product.category.id == "3"){
					$("#editfood").prop("checked",true);
				}else if(product.category.id == "4"){
					$("#edittoy").prop("checked",true);
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
})