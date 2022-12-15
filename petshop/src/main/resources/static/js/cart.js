$(document).ready(function() {
	$(".deleteBtn").click(function(){
		let cartID = $(this).parent().parent().children()[0].innerText;
		let cartName = $(this).parent().parent().children()[2].innerText;
		$("#deleteProductID").val(cartID);
		$("#productDeleteName").html("Bạn thực xự muốn xóa "+ cartName +" ra khỏi giỏ hàng");
		$("#deleteModal").modal({
                backdrop: "static",
                keyboard: false
            });
	});
});