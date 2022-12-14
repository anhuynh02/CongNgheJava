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
        $("#addModal").modal({
            backdrop: "static",
            keyboard: false
        });
    });
    
    //Xóa nhân viên dialog
    $("#deleteStaffBtn").click(function(e) {
        $("#addModal").modal({
            backdrop: "static",
            keyboard: false
        });
    });
    
    // //Chỉnh sửa nhân viên
    // $(".btn-edit-staff").click(function(e) {
    // 	$("#editStaffModal").modal({
    //         backdrop: "static",
    //         keyboard: false
    //     });
    // 	$.get("admin/staff/edit/" + $(this).data("id"), function(staff) {
	// 		$("#editStaffPhone").val(staff.phone);
	// 		$("#editStaffName").val(staff.name);
	// 		$("#editStaffUsername").val(staff.username);
   	// 	});
    //     e.preventDefault();
    // });
    
    // //Xóa nhân viên
	// $(".btn-delete-staff").click(function(e) {
	// 	$("#deleteId").val($(this).data("id"));
    //     $("#deleteModal").modal({
    //         backdrop: "static",
    //         keyboard: false
    //     });
	// 	e.preventDefault();
    // });
    
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
				$("#editProPrice").val(product.price);
				$("#editProName").val(product.name);
				$("#editProDes").val(product.description);
				$("#editProId").val(product.id);
				console.log($("#editProId").val())
				
       		});
            e.preventDefault();
        });
     
    //Xóa sản phẩm
    $(".productDel").click(function(e) {
			console.log($(this).data("id"))
  			$("#delProId").val($(this).data("id"));
  			console.log($("#delProId").val())
            $("#deleteProduct").modal({
                backdrop: "static",
                keyboard: false
            });
  			e.preventDefault();
        });
})