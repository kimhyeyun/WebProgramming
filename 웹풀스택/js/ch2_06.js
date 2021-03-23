function run(){
    //콜백함수
    //지연실행이 필요한 경우에 사용
    //setTimeout의 실행은 비동기(asynchronous)로 실행되어 동기적인 다른 실행이 
    //끝나야 실행됨
    setTimeout(function(){
        var msg = "hello codesquad";
        console.log(msg);
        console.log("run ----ing");
    },1000);
}

console.log("run start");
run();
console.log("run end");

//setInterval vs SetTimeout
//특정 동작을 반복적으로 수행하기 위해 쓰임 vs 특정 동작을 다른 동작이 끝난 후 처리하기위해 쓰임