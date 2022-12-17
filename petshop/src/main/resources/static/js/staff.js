const productM = $("#productManage");
const statisticM = $("#statisticManage");


$(document).ready(function() {
	productM.css("display","block");
	//Phân trang
    $("#product").click(function(){
        productM.css("display","block");
        statisticM.css("display","none");
    })
    $("#statistic").click(function(){
        productM.css("display","none");
        statisticM.css("display","block");
    })

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
    	$.get("staff/product/edit/" + $(this).data("id"), function(product) {
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
})