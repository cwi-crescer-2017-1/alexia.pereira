angular.module('app').factory('autoresService', function ($http) {

  let urlBase = 'http://localhost:50673/api/autores/';

  function getTodosOsAutores() {
    return $http.get(urlBase);
  };

  function getAutorById(id) {
    return $http.get(urlBase + id);
  };

  function atualizar(autor) {
    return $http.put(urlBase + autor.id, autor);
  };

  function criar (autor) {
    return $http.post(urlBase, autor);
  }

  function remover (autor) {
    return $http.delete(urlBase + autor.id);
  }


  return {
    listar: getTodosOsAutores,
    getAutorById: getAutorById,
    atualizar: atualizar,
    criar: criar,
    deletar: remover
  };
});
