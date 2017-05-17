//$(function() {})
//$(document).ready(function() {})
//$.ready(function() {})

let btnPesquisar = document.getElementById('btnPesquisar');
const input = document.getElementById('pesquisa');

btnPesquisar.onclick = function() {
  valor = input.value;
  procuraPorNumero(valor);
}

// fetch('http://pokeapi.co/api/v2/stat/6/').then(response => response.json()).then(json => console.log(json));
// fetch("http://pokeapi.co/api/v2/pokemon/5/").then(response => response.json())
//   .then(json => {
//     console.log("JSON 1", json)
//     fetch("http://pokeapi.co/api/v2/pokemon/6/").then(response => response.json())
//       .then(json => {
//         console.log("JSON 2", json)
//         fetch("http://pokeapi.co/api/v2/pokemon/7/").then(response => response.json())
//           .then(json => {
//             console.log("JSON 3", json)
//           })
//       })
//   })

  function procurarStatus (obj, div) {
    var b =  obj.map(function (e) {
      let a = {name: e.stat.name, base_stat: e.base_stat};
      return a;
    });
  b.forEach(function(e) {
    let progress = document.createElement('progress');
    texto = document.createElement('h3').appendChild(document.createTextNode(e.name));
    progress.value = e.base_stat;
    progress.max = 100;
    div.append(texto);
    div.append(progress);
  });
}


function procuraPorNumero (input) {
  let url = "http://pokeapi.co/api/v2/pokemon/" + input;
  fetch(url)
  .then(response => response.json())
  .then(json => {
    console.log(json);
    let divPokemon = document.createElement('div');
    divPokemon.className = "pokemon";
    let div = document.getElementById('detalhesPokemon');
    let h1 = document.createElement('h1');
    h1.appendChild(document.createTextNode(json.name + " - " + json.id));
    divPokemon.append(h1);
    let img = document.createElement('img');
    img.src = json.sprites.front_default;
    divPokemon.append(img);
    let ul = document.createElement('ul');
    let tipos = json.types;
    tipos.forEach(function (e) {
      let li = document.createElement("li");
      li.appendChild(document.createTextNode(e['type'].name));
      ul.appendChild(li);
    });
    divPokemon.append(ul);
    procurarStatus(json.stats, divPokemon);
    div.append(divPokemon);
  })
}
