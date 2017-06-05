angular.module('app').factory('assinantesService', function ($http) {

  let urlBase = 'http://localhost:50673/api/assinantes/';

  function getTodosOsAssinantes() {
    return $http.get(urlBase);
  };

  function getAssinanteById(id) {
    return $http.get(urlBase + id);
  };

  function atualizar(assinante) {
    return $http.put(urlBase + assinante.Id, assinante);
  };

  function criar (assinante) {
    return $http.post(urlBase, assinante);
  }

  function remover (assinante) {
    return $http.delete(urlBase + assinante.Id);
  }

  return {
    listar: getTodosOsAssinantes,
    getAssinanteById: getAssinanteById,
    atualizar: atualizar,
    criar: criar,
    deletar: remover
  };
});
