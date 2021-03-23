function a(){
    console.log(arguments)
}

a(1,2,3);

//arguments 속성을 사용해서, 1~무한대까지 인자를 받아 합을 구하는 함수
function sum(){
    var total = 0;
    for(var i in arguments){
        total += arguments[i];
    }
    return total;
}

console.log(sum());

//arrrow 함수
// function getName(name){
//     return "Kim " +name;
// }
//위의 함수는 아래 arrow 함수와 같음
var getName = (name)=>"Kim "+name;

console.log(getName("Hyeyun"));