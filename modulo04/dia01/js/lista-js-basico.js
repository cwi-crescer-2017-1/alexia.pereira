// Exercicio 01
function daisyGame (numero) {
  var res = (numero%2===0)
  ? "Love me not"
  : "Love me"
  return res;
}
console.log(daisyGame(4));

// Exercicio 02
function maiorTexto (strings) {
  var max = strings[0].length;
  for (var i=0; i<strings.length; i++) {
    max = (max.length > strings[i].length) ? max : strings[i];
  }
  return max;
}
console.log(maiorTexto(['a maior', 'menor', 'min']));

// Exercicio 03
function imprime (strings, funcao) {
  if (typeof funcao === "function") {
    for (var i = 0; i < strings.length; i++) {
      funcao(strings[i])
    }
  }
}
function instrutor (instrutor) {
  console.log('olá querido instrutor:', instrutor);
}
imprime([ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ], instrutor);

// Exercicio 04
function somar(a){
  return function(b){
    return a + b;
  };
};
console.log(somar(3)(4));

// Exercicio 05
function fiboSum (num) {
  var anterior = 0, atual = 1;
  var soma = 0;
  var cont = 1
  while(cont <= num) {
    soma += atual;
    var proxima = atual + anterior;
    anterior = atual;
    atual = proxima;
    cont++;
  }
  return soma;
}
console.log(fiboSum(7));

// Exercicio 06
function queroCafe (mascada, precos) {
  var x = 0;
  var precosMenoresQueMascada = [];
  for (var i = 0; i < precos.length; i++) {
    if (precos[i] < mascada) {
      precosMenoresQueMascada[x] = precos[i];
      x++;
    }
  }
  precosMenoresQueMascada.sort(function(a, b){return a-b});
  return precosMenoresQueMascada.join();
}
console.log(queroCafe(3.14, [5.16, 2.12, 1.15, 3.11, 17.5]));
