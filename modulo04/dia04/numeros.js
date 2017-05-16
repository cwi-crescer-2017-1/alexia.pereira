Number.prototype.arredonda = function (casasDecimais) {
  return (typeof casasDecimais !== 'undefined' && casasDecimais !== null) ?
   this.toFixed(casasDecimais) :
   this.toFixed(2);
};
