// function printName(firstName){
//     var myname = "yun";
//     return myname+" "+firstName;
// }

// console.log(printName("kim"));

//함수 표현식
function test(){
    var inner = function(){
        return "inner value";
    }

    console.log(inner);

    var result = inner();
    console.log("name is "+result);

    function inner(){
        return "inner value";
    }

    //이건 에러 -> 함수로 정의되지않음
    var inner = function(){
        return "inner value";
    }

}

test();