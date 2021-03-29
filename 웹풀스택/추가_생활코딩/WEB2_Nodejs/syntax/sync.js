var fs = require('fs');

/* 
//readFileSync
console.log('A');
var result = fs.readFileSync('WEB2_Nodejs/syntax/sample.txt','utf8');
console.log(result);
console.log('C');
*/


console.log('A');
var result = fs.readFile('syntax/sample.txt','utf8',function(err,result){
    console.log(result);
});
console.log('C');
