$(document).ready(function() {
	$(".deleteBtn").click(function(){
		let column =$(this).parent().parent().children();
		let cartID = column[0].innerText;
		let cartName = column[2].innerText;
		let cartBillId = column[6].innerText;
		$("#deleteProductID").val(cartID);
		$("#productDeleteName").html("Bạn thực xự muốn xóa "+ cartName +" ra khỏi giỏ hàng");
		$("#deleteModal").modal({
                backdrop: "static",
                keyboard: false
            });
	});
});