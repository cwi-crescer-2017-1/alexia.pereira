angular.module('app')
.controller('UsuarioController', function ($scope, $routeParams, $location, usuarioService, authService, postService) {

  $scope.usuario = {};
  $scope.permitirEdicao = permitirEdicao;
  $scope.edit = usuarioService.edit;
  $scope.usuarioLogado = usuarioLogado;
  $scope.atualizarUsuario = atualizarUsuario;
  $scope.editarPerfil = editarPerfil;
  $scope.incrementarPagina = incrementarPagina;
  $scope.decrementarPagina = decrementarPagina;
  buscarUsuario($routeParams.idUsuario);
  var pagina = 0;


  function editarPerfil() {
    $location.url($location.path() + "/edit");
  }

  function verificarPossibilidadeDeEdicaoDePerfil() {
    $scope.meuPerfil = $scope.usuario.idUsuario === authService.getUsuario().idUsuario;
  }

  function buscarUsuario(id) {
    usuarioService.buscarPorId(id).then(function (response) {
      $scope.usuario = response.data;
      incrementarPagina(true);
      verificarPossibilidadeDeEdicaoDePerfil();
    })
  };

  function buscarPosts () {
    pagina = pagina || 0;
    let parametros = {pagina: pagina, quantidade: 5};
    postService.listarPorUsuario($scope.usuario.idUsuario, parametros).then(function (response) {
      $scope.posts = response.data.content;
      $scope.primeiraPagina = response.data.first;
      $scope.ultimaPagina = response.data.last;
    })
  };


  function decrementarPagina () {
    pagina = (pagina-1);
    buscarPosts();
  }

  function incrementarPagina () {
    pagina = (pagina+1);
    buscarPosts();
  }

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
