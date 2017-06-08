angular.module('app').factory('veiculoService', function ($http) {

  let urlBase = 'http://localhost:64375/api/veiculos/';

  function getTodosOsVeiculos() {
    return $http.get(urlBase);
  };

  return {
    listar: getTodosOsVeiculos
  };
});
