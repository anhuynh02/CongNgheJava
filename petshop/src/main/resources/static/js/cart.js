$(document).ready(function() {
	$("#dateOfBill").html("Thời gian lập đơn: "+$(".dateModify")[0].innerText);
	var money = 0;
	if($("#alertCart").length != 0){
		let a = $("#alertCart").children("a");
		setTimeout(function () {
            // Closing the alert
            $('#alertCart').alert('close');
        }, 2000);
	}
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
		if(column != null){
			let cartBillId = column.innerText;
		$("#purchaseTotalMoney").html($("#totalPriceBill").text())
		$("#billId").val(cartBillId);
		$("#purchaseModal").modal({
                backdrop: "static",
                keyboard: false
            });
		}else{
			alert("Giỏ hàng trống");
		}
		
	});
	
	$(".volumn").on("input", function(e) {
		e.preventDefault();
		if($(this).val() < 1){
			$(this).val("1");
		}
	   let volumnItem =$(this).val();
	   let row =$(this).parent().parent().children()[0];
	   let b =$("#billDetailId").val(row.innerText);
	   let a =$("#quantityItem").val(volumnItem);
	   if(b !=null){
			$("#updateForm").submit();
		}
	});
});