//$(function() {})
//$(document).ready(function() {})
//$.ready(function() {})

let btnPesquisar = document.getElementById('btnPesquisar');
const input = document.getElementById('pesquisa');

btnPesquisar.onclick = function() {
  valor = input.value;
  procuraPorNumero(valor);
}



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
function procuraPorNumero (input) {
  let url = "http://pokeapi.co/api/v2/pokemon/" + input;
  fetch(url)
  .then(response => response.json())
  .then(json => {
    console.log(json);
    let div = document.getElementById('detalhesPokemon');
    let h1 = document.createElement('h1');
    h1.appendChild(document.createTextNode(json.name + " - " + json.id));
    div.append(h1);
    // div.appendChild(document.createTextNode(json.id))
    let img = document.createElement('img');
    img.src = json.sprites.front_default;
    div.append(img);
    let ul = document.createElement('ul');
    let tipos = json.types;
    tipos.forEach(function (e) {
      let li = document.createElement("li");
      li.appendChild(document.createTextNode(e['type'].name));
      ul.appendChild(li);
    });
    div.append(ul);
  })
}
