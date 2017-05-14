// Exercicio 01
function seriesInvalidas (series) {
  var seriesInvalidas = [];
  for (let i = 0; i < series.length; i++) {
    if ( series[i].anoEstreia > new Date().getFullYear() || campoUndefined (series[i]) ) {
      seriesInvalidas.push(series[i].titulo);
    }
  }
  return "Séries Inválidas: " + seriesInvalidas.join(" - ");
}

function campoUndefined (serie) {
  for (prop in serie) {
    if (typeof serie[prop] === "undefined" || serie[prop] === null) return true;
  }
}

console.log(seriesInvalidas(series));

// Exercicio 02
function filtrarSeriesPorAno(series, ano) {
  return series.filter((serie) => serie.anoEstreia >= ano);
}
console.log(filtrarSeriesPorAno(series, 2017));

// Exercicio 03
function mediaDeEpisodios(series) {
  return series.reduce(function (a,b) { return a + b.numeroEpisodios; }, 0) / series.length;
}
console.log(mediaDeEpisodios(series));

// Exercicio 04
function procurarPorNome(series, nome) {
  return series.filter(e => e.elenco.toString().includes(nome)).length > 0;
}
console.log(procurarPorNome(series, "Alexia"));

// Exercicio 05
function mascadaEmSerie (serie) {
  return serie.diretor.length*100000 + serie.elenco.length*40000;
}
console.log(mascadaEmSerie(series[0]));

// Exercicio 06
function queroGenero (genero, series) {
  return series.filter(e => e.genero.toString().includes(genero)).map(e => e.titulo);
}
function queroTitulo (titulo, series) {
  return series.filter(e => e.titulo.includes(titulo)).map(e => e.titulo);
}
console.log(queroGenero("Caos", series));
console.log(queroTitulo("The", series));

// Exercicio 07
function creditosIlluminatis (serie) {
  console.log(serie.titulo);
  console.log("Diretores: ");
  serie.diretor.sort(sortPorUltimoNome).forEach(logElements);
  console.log("Elenco: ");
  serie.elenco.sort(sortPorUltimoNome).forEach(logElements);
}
console.log(creditosIlluminatis(series[4]));

function logElements (e) {
  console.log(e);
}

function sortPorUltimoNome (a, b) {
  var aName = a.split(" ");
  var bName = b.split(" ");
  var aLastName = aName[aName.length - 1];
  var bLastName = bName[bName.length - 1];
  if (aLastName < bLastName) return -1;
  if (aLastName > bLastName) return 1;
  return 0;
}

// Exercicio 08

function serieIlluminati (series) {
  var elenco = contemTodosOsNomesAbreviados(series.filter(e => e.elenco.toString().includes(".")))[0];
  return "#"+elenco.map(nome => nome.match(/[A-Z]\./g)).map(nome => nome[0].replace('.', '')).join("");

}

function contemTodosOsNomesAbreviados (seriesQueContemAlgumPonto) {
  return seriesQueContemAlgumPonto.filter(e => (e.elenco.filter(e => e.match(/[A-Z]\./g)).length === e.elenco.length)).map(e => e.elenco);
}

console.log(serieIlluminati(series));
