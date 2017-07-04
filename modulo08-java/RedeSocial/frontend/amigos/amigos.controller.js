angular.module('app').controller('AmigosController', function ($scope, $location, authService, usuarioService) {

  listar();
  $scope.verPerfil = verPerfil;

  function listar () {
    usuarioService.buscarAmigos(authService.getUsuario().idUsuario).then(response => {
      $scope.usuario = response.data;
      $scope.amigos = $scope.usuario.amigos;
    })
  }

  function verPerfil (usuario) {
    $location.path('/usuario/' + usuario.idUsuario);
  }

});
