console.log("series", series);

// Ex 01
// 1. criar funcao para verificar se série é inválida
// 2. aplicar criterio de verificação de série inválida para as séries originais
// 3. retornar string resultante de acordo com o formato esperado
function seriesInvalidas(series) {
  let invalidas = series.filter(serie => {
    // for (let campo in serie) { }
    let algumCampoInvalido = Object.values(serie).some(v => v === null || typeof v === 'undefined');
    let estreiaInvalida = serie.anoEstreia > new Date().getFullYear();
    return estreiaInvalida || algumCampoInvalido;
  });
  return `Séries Inválidas: ${ invalidas.map(s => s.titulo).join(" - ") }`;
}

// retorna um array com todas as séries com
// ano de estreia igual ou maior que 2017.
function filtrarSeriesPorAno(series, ano) {
  return series.filter(s => s.anoEstreia >= ano)
}

// numeroEpisodios
// 34.1
function mediaDeEpisodios(series) {
  // return series
  //   .map(function(s) { return s.numeroEpisodios })
  //   .reduce(function(acc, numeroEpisodios) { return acc + numeroEpisodios }, 0) / series.length;
  return series
    .map(s => s.numeroEpisodios)
    .reduce((acc, numeroEpisodios) => acc + numeroEpisodios) / series.length;
}

function procurarPorNome(series, nome) {
  // indexOf
  return series.some(s => s.elenco.some(e => e.includes(nome)));
}

//Retorna o valor total de gastos contando os diretores e o elenco
function mascadaEmSerie(serie) {
  let custoComDiretores = serie.diretor.length * 100000;
  let custoComElenco = serie.elenco.length * 40000;
  return custoComDiretores + custoComElenco;
}

function queroGenero(genero) {
  return series.filter(s => s.genero.includes(genero));
}

function queroTitulo(titulo) {
  return series
    .filter(s => s.titulo.includes(titulo))
    .map(s => s.titulo);
}

/*let subset = queroTitulo("The");
let divSubset = document.getElementById('subset');
subset.forEach(titulo => {
  let h2 = document.createElement('h2');
  h2.innerText = `${ titulo }`;
  divSubset.append(h2);
});*/

// 1. ordenar elenco pelo último nome
// 2. saber montar os créditos
function creditosIlluminatis(serie) {
  let criterioDeOrdenacao = (s1, s2) => {
    return s1.pegarUltimoNome().localeCompare(s2.pegarUltimoNome())
  }
  let elencoOrdenado = serie.elenco.sort(criterioDeOrdenacao);
  let diretoresOrdenados = serie.diretor.sort(criterioDeOrdenacao);

  console.log(serie.titulo);
  console.log("Diretores");
  console.log(diretoresOrdenados);
  console.log("Elenco");
  console.log(elencoOrdenado);
}

console.log("oi B. tchau".temAbreviacao())

function descobrirSerieComTodosAbreviados() {
  let elencoSerie = series
    .find(s => s.elenco.every(e => e.temAbreviacao()))
    .elenco
    .map(e => e.match(/ [a-z][.] /gi)[0][1])
    .join("");
  return `#${ elencoSerie }`;
}
//
