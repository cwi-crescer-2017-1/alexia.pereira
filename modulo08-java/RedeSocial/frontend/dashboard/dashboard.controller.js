angular.module('app').controller('DashboardController', function ($location, $scope,
  solicitacaoService, authService) {

  buscarSolicitacoes();

  $scope.logout = logout;
  $scope.recusarSolicitacao = recusarSolicitacao;
  $scope.aceitarSolicitacao = aceitarSolicitacao;


  function buscarSolicitacoes() {
    solicitacaoService.getSolicitacoesPendentes(authService.getUsuario().idUsuario)
    .then(function (response) {
      $scope.solicitacoes = response.data;
    });
  }

  function recusarSolicitacao(solicitacao) {
    debugger;
    solicitacaoService.deletar(solicitacao.idSolicitacao)
    .then(function (response) {
      buscarSolicitacoes();
    });
  }

  function aceitarSolicitacao(solicitacao) {
    solicitacaoService.aceitar(solicitacao).then(function (response) {
      buscarSolicitacoes();
    })
  }

  function logout() {
    authService.logout();
  };



});
