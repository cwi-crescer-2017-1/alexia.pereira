angular.module('app').factory('solicitacaoService', function ($http) {

  let urlBase = 'http://localhost:9090/solicitacoes/';

  function getSolicitacaoPorId(id) {
    return $http.get(urlBase + id);
  };

  function criar (solicitacao) {
    return $http.post(urlBase, solicitacao);
  }

  function getSolicitacoesPendentes(idUsuario) {
    return $http.get(urlBase + 'pendentes/' + idUsuario);
  }

  function aceitar (solicitacao) {
    return $http.post(urlBase + 'aceitar', solicitacao);
  }

  function deletar (idSolicitacao) {
    return $http.delete(urlBase + 'delete/' + idSolicitacao);
  }

  return {
    buscarSolicitacaoPorId: getSolicitacaoPorId,
    getSolicitacoesPendentes: getSolicitacoesPendentes,
    criar: criar,
    aceitar: aceitar,
    deletar: deletar
  };
});
