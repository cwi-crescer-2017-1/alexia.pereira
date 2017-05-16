// Number.prototype.arredonda = function (casasDecimais) {
//   casasDecimais = casasDecimais || 2;
//   return Number(this.toFixed(casasDecimais));
// };


Number.prototype.arredondar = function(casasDecimais) {
  casasDecimais = casasDecimais || 2;
 return Math.round(this * Math.pow(10, casasDecimais)) / (Math.pow(10, casasDecimais));
};
