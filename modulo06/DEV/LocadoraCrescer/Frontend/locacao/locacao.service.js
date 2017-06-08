angular.module('app').factory('locacaoService', function ($http) {

  let urlBase = 'http://localhost:64375/api/locacoes/';

  function getTodasAsLocacoes() {
    return $http.get(urlBase);
  };

  function criar(locacao) {
    return $http.post(urlBase);
  }

  return {
    listar: getTodasAsLocacoes,
    criar: criar
  };
});
