angular.module('app').factory('pacoteService', function ($http) {

  let urlBase = 'http://localhost:64375/api/pacotes/';

  function getTodosOsPacotes() {
    return $http.get(urlBase);
  };

  return {
    listar: getTodosOsPacotes
  };
});
