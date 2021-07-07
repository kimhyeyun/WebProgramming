function next(type_id) {
    var info = type_id.split("#");
    id = info[0];
    type = info[1];
    
    // client와 server의 비동기 통신(Ajax)를 위해 XMLHttpRequest 객체를 생성
    var oReq = new XMLHttpRequest();

    
    // XMLHttpRequest의 이벤트 리스너에 콜백 함수를 구현하여 스택에 있는 함수들이 모두 실행된 후
    // 가장 마지막에 실행하도록 함
    oReq.addEventListener("load", function() {
		//request가 끝나고 response가 준비된 상태일 때 콜백 함수를 실행시키기 위해 조건문을 추가
		if(oReq.readyState === 4){
	
		    //status property는 서버의 문서 상태를 나타냄
		    // status가 200이면 서버에 문서가 존재함을 나타냄
		    if(oReq.status === 200){
				var targetButton = document.getElementById(type_id);
				var target = targetButton.parentElement.parentElement;
				var targetParent = target.parentElement;
				
				targetParent.removeChild(target);
				
				// TodoTypeServlet에서 변경된 할 일을 받음
				var json = this.responseText;
				console.log(json);
				json = JSON.parse(json);
				
				
				// 변경된 데이터(json)로 HTML을 업로드 함
				var newUl = null;
				var msg = "";
				
				for(value in json){
					console.log(value);
				    var todo = json[value];
				    var type = todo['type'];

					console.log(type);

					newUl = document.getElementById(type);
				    newUl.innerHTML = "<li class='list_title'>"+type+"</li>";
				    if(type === "DOING"){
						
						var y = todo['regdate'].substring(0, 4);
						var m = todo['regdate'].substring(5, 7);
						var d = todo['regdate'].substring(8, 10);
				    	
						msg += "<li class='list_content'><h3>" + todo['title'] + "</h3>" +
							"<p>등록날짜:" + y + "." + m + "." + d + ", " + todo['name'] + ", 우선순위" + todo['sequence'] + 
							"<button id=" + "'" + todo['id'] + "#" + todo['type'] + "'"+ "class='next_btn' onclick='next(id)'>-></button></p></li>";
				    }
				    else{
						
						var y = todo['regdate'].substring(0, 4);
						var m = todo['regdate'].substring(5, 7);
						var d = todo['regdate'].substring(8, 10);
				    	
						msg += "<li class='list_content'><h3>" + todo['title'] + "</h3>" +
							"<p>등록날짜:" + y + "." + m + "." + d + ", " + todo['name'] + ", 우선순위" + todo['sequence'] + "</p></li>";
				    }
				}		  
				
				newUl.innerHTML += msg;
				console.log("success");
				
		    }
		    else{
				console.log(oReq.status);
				console.log("fail");
		    } 
		} 
	
    });
    
    //서버와 클라이언트를 POST 방식으로 연결
    oReq.open("POST", "http://localhost:8080/Todo/TodoTypeServlet?type="+type+"&id="+id, true);

	oReq.send(null);
   
}
