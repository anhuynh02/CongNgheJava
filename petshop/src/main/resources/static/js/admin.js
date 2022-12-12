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
    
    //Thêm nhân viên dialog
    $("#addBtn").click(function(e) {
            $("#addModal").modal({
                backdrop: "static",
                keyboard: false
            });
        });
})