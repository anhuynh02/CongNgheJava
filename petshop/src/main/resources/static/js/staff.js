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