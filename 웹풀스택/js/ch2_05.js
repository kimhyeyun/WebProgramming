//함수의 호출
function printName(firstname){
    var myname="hyeyun";
    return myname+","+firstname;
}

function run(firstname){
    firstname= firstname||"Kim";
    var result = printName(firstname);
    console.log(result);
}

//호출관계 bar() -> foo()
function foo(b){
    var a = 5;
    return a*b+10;
}

function bar(x){
    var y = 3;
    return foo(x*y);
}

console.log(bar(6));