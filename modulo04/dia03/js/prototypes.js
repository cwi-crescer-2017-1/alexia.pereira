String.prototype.temAbreviacao = function() {
  return this.match(/ [A-Z][.] /gi) !== null;
}

String.prototype.pegarUltimoNome = function(a, b) {
  let partesNome = this.trim().split(" ");
  return partesNome[partesNome.length - 1];
}

String.prototype.toBacon = function() {
  return "BACON !!!!!!!!!!";
}

if (!String.prototype.toString) {
  String.prototype.toString = function() {
    return this + this.toBacon();
  }
}
