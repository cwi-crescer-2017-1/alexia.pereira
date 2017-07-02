angular.module('app')
.controller('UsuarioController', function ($scope, $routeParams, $location, usuarioService, authService, postService) {

  $scope.usuario = {};
  $scope.permitirEdicao = permitirEdicao;
  $scope.edit = usuarioService.edit;
  $scope.usuarioLogado = usuarioLogado;
  $scope.atualizarUsuario = atualizarUsuario;
  $scope.editarPerfil = editarPerfil;
  buscarUsuario($routeParams.idUsuario);

  function editarPerfil() {
    $location.url($location.path() + "/edit");
  }

  function verificarPossibilidadeDeEdicaoDePerfil() {
    $scope.meuPerfil = $scope.usuario.idUsuario === authService.getUsuario().idUsuario;
  }

  function buscarUsuario(id) {
    usuarioService.buscarPorId(id).then(function (response) {
      $scope.usuario = response.data;
      buscarPosts();
      verificarPossibilidadeDeEdicaoDePerfil();
    })
  };

  function buscarPosts () {
    let parametros = {pagina: 0, quantidade: 5};
    postService.listarPorUsuario($scope.usuario.idUsuario, parametros).then(function (response) {
      $scope.posts = response.data.content;
    })
  };

  function atualizarUsuario(usuario) {
    usuarioService.atualizar(usuario).then(function(response) {
      $scope.usuario = response.data;
      $scope.edit = false;
      usuarioService.edit = false;
    });
  }

  function permitirEdicao() {
    $scope.edit = true;
  }

  function usuarioLogado() {
    return authService.isAutenticado();
  }

});
