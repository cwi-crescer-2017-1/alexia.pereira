angular.module('app').controller('DashboardController', function ($location, $scope,
  solicitacaoService, postService, authService) {

  buscarSolicitacoes();

  $scope.logout = logout;
  $scope.recusarSolicitacao = recusarSolicitacao;
  $scope.aceitarSolicitacao = aceitarSolicitacao;
  $scope.adicionarPost = adicionarPost;

  function adicionarPost(post) {
    debugger;
    post.usuario = authService.getUsuario();
    post.dataPublicacao = new Date();
    postService.criar(post).then(function (response) {
      alert("Post criado com sucesso");
      $scope.post = {};
    })
  }

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
