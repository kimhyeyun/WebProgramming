//이벤트 등록
var el = document.querySelector(".outside");
el.addEventListener("click",function(){
    //do something
}, false);

//이벤트 객체
var el = document.getElementById("outside");
el.addEventListener("click",function(evt){
    console.log(evt.target);
    console.log(evt.target.nodeName);
},false);