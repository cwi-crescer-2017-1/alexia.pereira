angular.module('app')
  .controller('UsuarioController', function ($scope, $routeParams, usuarioService, authService) {
    // , postService) {

    $scope.usuario = {};
    $scope.permitirEdicao = permitirEdicao;
    $scope.edit = usuarioService.edit;
    $scope.usuarioLogado = usuarioLogado;
    $scope.atualizarUsuario = atualizarUsuario;

    buscarUsuario($routeParams.idUsuario);
    // buscarPosts();

    function buscarUsuario(id) {
    usuarioService.buscarPorId(id).then(function (response) {
        $scope.usuario = response.data;
      })
    };

    function buscarPosts () {
      postService.listarPorUsuario($scope.usuario.id).then(function (response) {
        $scope.posts = response.data;
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
