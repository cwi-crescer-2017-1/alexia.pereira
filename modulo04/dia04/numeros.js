Number.prototype.arredonda = function (casasDecimais) {
  return (typeof casasDecimais !== 'undefined' && casasDecimais !== null) ?
   Number(this.toFixed(casasDecimais)) :
   Number(this.toFixed(2));
};
