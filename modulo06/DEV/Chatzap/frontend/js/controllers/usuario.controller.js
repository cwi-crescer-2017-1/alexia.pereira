angular.module('app').controller('UsuariosController', function ($scope, usuarioService) {

  $scope.create = create;
  list();

  // Funções internas
  function create(usuario) {
    usuarioService.create(usuario).then(function () {
      list();
    });
  };

  function list() {
    usuarioService.list().then(function (response) {
      $scope.usuarios = response.data;
    });
  }

});
