let btnPesquisar = document.getElementById('btnPesquisar');
let input = document.getElementById('pesquisa');

btnPesquisar.onclick = function() {
  valor = input.value;
  procuraPorNumero(valor);
}

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
    h1.appendChild(document.createTextNode(json.name));
    divPokemon.append(h1);

    let spanID = document.createElement('span')
    let id = (document.createTextNode(" Número: " + json.id));
    spanID.append(id);
    divPokemon.append(spanID);

    let img = document.createElement('img');
    img.src = json.sprites.front_default;
    divPokemon.append(img);

    let spanUl = document.createElement('span');
    spanUl.append(document.createTextNode('Tipos:'))
    let ul = document.createElement('ul');
    let tipos = json.types;
    tipos.forEach(function (e) {
      let li = document.createElement("li");
      li.appendChild(document.createTextNode(e['type'].name));
      ul.appendChild(li);
    });
    spanUl.append(ul)
    divPokemon.append(spanUl);

    procurarStatus(json.stats, divPokemon);
    div.append(divPokemon);
  })
}
