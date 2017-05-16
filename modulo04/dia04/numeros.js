Number.prototype.arredonda = function (casasDecimais) {
  casasDecimais = casasDecimais || 2;
  return Number(this.toFixed(casasDecimais));
};
