console.log("Carregou!");
/*
alert("Bem vindo(a)!");
*/
if (typeof pi !== "undefined") {
  console.log(pi);
}

//ES 2015
// http://caniuse.com/#search=arrow%20functions
var somarArrowFunction = (a,b) => a+b;
console.log("somarArrowFunction", somarArrowFunction(1,2));
console.log("typeof somarArrowFunction", typeof somarArrowFunction);

console.log("tem somaSemReturn?", somaSemReturn);
function somaSemReturn(a, b, c) {
  c = c || 3;
  return a+b;
}
// console.log("somaSemReturn", somaSemReturn(1,2));
// console.log("typeof somaSemReturn", typeof somaSemReturn);

console.log("tem somar?", somar);
var somar = function(a, b, c=3) {
  return a+b;
}
console.log("somar(1,2,3)",somar(1,2,3));
// console.log("somar", somar(1,2));
// console.log("typeof somar", typeof somar);

console.log(Array(13).join(1-"-") + " Batman");
