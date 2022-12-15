$(document).ready(function() {
	var money = 0;
	$("#totalPriceBill").html('Tổng tiền: 0 VNĐ');
	$.each($(".totalItemPrice"),function(index, value){
		let string = value.innerText;
		let i = string.slice(0,string.length);
		i =i.replaceAll(',','');
		money = money + parseInt(i);
		$("#billTotal").val(money);
		$("#totalPriceBill").html('Tổng tiền: '+Intl.NumberFormat().format(money)+' VNĐ');
	})
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
	
	$(".purchaseBtn").click(function(){
		let column =$(this).parent().parent().parent().children()[0].children[6];
		let cartBillId = column.innerText;
		$("#purchaseTotalMoney").html($("#totalPriceBill").text())
		$("#billId").val(cartBillId);
		$("#purchaseModal").modal({
                backdrop: "static",
                keyboard: false
            });
	});
});