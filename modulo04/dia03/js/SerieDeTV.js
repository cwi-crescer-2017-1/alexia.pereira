/*function SerieDeTV(nome, anoEstreia) {
  this.nome = nome || 'NI';
  this.anoEstreia = anoEstreia;
}

SerieDeTV.prototype.imprimirNome = function() {
  console.log(this.nome.toUpperCase());
}*/

class SerieDeTV {
  constructor(nome, anoEstreia) {
    this.nome = nome || 'NI';
    this.anoEstreia = anoEstreia;
  }

  imprimirNome() {
    console.log(this.nome.toUpperCase());
  }

  html() {
    return `<h2>${ this.nome }</h2><br/><h3>${ this.anoEstreia }</h3>`;
  }

}
