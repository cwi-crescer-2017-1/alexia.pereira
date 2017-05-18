let btnCor = document.getElementById('inputCor');
btnCor.addEventListener("change", function() {
  let cor = btnCor.value;
  document.querySelector('h1').style.color = cor;
  let a = (hexToRGB(cor));
  mashup(a[0], a[1], a[2]);
  // let container = document.getElementById('container')
  // container.style.backgroundColor = cor;
  document.body.style.backgroundColor = cor;
}, false);


function hexToRGB(a) {
  var first = a[1] + a[2];
  var second = a[3] + a[4];
  var third = a[5] + a[6];
  var res = [first,second,third];
  for(var i = 0; i < res.length; i++){
    res[i] = parseInt(res[i],16);
  }
  return res;
}

function mashup (r, g, b) {
  procuraPorCor(r);
  procuraPorCor(g);
  procuraPorCor(b);
}

function procuraPorCor (input) {
  let url = "http://pokeapi.co/api/v2/pokemon/" + input;
  fetch(url)
  .then(response => response.json())
  .then(json => {
    let div = document.getElementById('pokemonMashup');
    let img = document.createElement('img');
    img.src = json.sprites.front_default;
    div.append(img);
  })
}
