angular.module('app').controller('AmigosController', function ($scope, $location, authService, usuarioService) {

  listar();

  function listar () {
    usuarioService.buscarAmigos(authService.getUsuario().idUsuario).then(response => {
      $scope.usuario = response.data;
      $scope.amigos = $scope.usuario.amigos;
    })
  }

});
