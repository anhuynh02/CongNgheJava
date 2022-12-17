var index = 0;
showSlide(index);
function plusSlides(n){
    showSlide(index += n);
}

if($("#alertAddCart").length != 0){
		let a = $("#alertAddCart").children("a");
		setTimeout(function () {
            // Closing the alert
            $('#alertAddCart').alert('close');
        }, 2000);
	}
function showSlide(n){
    var i;
    var slides = document.getElementsByClassName("slide");
    var bestseller = document.getElementsByClassName("bestseller");
    var get = bestseller;
    if(n >= bestseller.length){
        index = 0;
    }
    if(n < 0){
        index = bestseller.length-1;
    }
    slides[0].innerHTML = get[index].innerHTML;
    if(index + 1 >= bestseller.length){
        slides[1].innerHTML = get[0].innerHTML;
    }else{
        slides[1].innerHTML = get[index+1].innerHTML;
    }
    
}

window.onload = function(){
		setInterval(plusSlides(1),150);
	}