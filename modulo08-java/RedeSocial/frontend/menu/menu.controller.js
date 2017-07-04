angular.module('app').controller('MenuController', function ($scope, $location, authService,
  solicitacaoService) {

    $scope.usuario = authService.getUsuario();
    $scope.dashboard = dashboard;
    $scope.amigos = amigos;
    $scope.buscar = buscar;
    $scope.logout = logout;
    $scope.meuPerfil = meuPerfil;
    $scope.notificacoes = false;
    $scope.exibirNotificacoes = exibirNotificacoes;
    $scope.aceitarSolicitacao = aceitarSolicitacao;
    $scope.recusarSolicitacao = recusarSolicitacao;
    buscarSolicitacoes();

    function dashboard() {
      $location.path('/dashboard');
    }

    function amigos() {
      $location.path('/amigos');
    }

    function exibirNotificacoes() {
      $scope.notificacoes = $scope.notificacoes ? false : true;
    }

    function buscarSolicitacoes() {
      solicitacaoService.getSolicitacoesPendentes(authService.getUsuario().idUsuario)
      .then(function (response) {
        $scope.solicitacoes = response.data;
      });
    }

    function recusarSolicitacao(solicitacao) {
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

    function buscar() {
      $location.path('/busca');
    }

    function logout() {
      authService.logout();
    }

    function meuPerfil () {
      $location.path('/usuario/' + $scope.usuario.idUsuario);
    }


  });
