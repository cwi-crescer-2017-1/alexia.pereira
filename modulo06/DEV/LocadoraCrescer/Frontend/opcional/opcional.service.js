angular.module('app').factory('opcionalService', function ($http) {

  let urlBase = 'http://localhost:64375/api/opcionais/';

  function getTodosOsOpcionais() {
    return $http.get(urlBase);
  };

  return {
    listar: getTodosOsOpcionais
  };
});
