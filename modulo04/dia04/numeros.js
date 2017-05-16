// Number.prototype.arredonda = function (casasDecimais) {
//   casasDecimais = casasDecimais || 2;
//   return Number(this.toFixed(casasDecimais));
// };


Number.prototype.arredondar = function(casasDecimais) {
  casasDecimais = casasDecimais || 2;
  marcador = Math.pow(10, casasDecimais);
  return Math.round(this * marcador) / marcador;
};
