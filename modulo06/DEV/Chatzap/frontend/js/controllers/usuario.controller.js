angular.module('app').controller('UsuariosController', function ($scope, usuarioService, $location) {

  usuarioLogado();
  $scope.create =  create;
  list();

  // Funções internas
  function create(usuario) {
    debugger;
    usuarioService.create(usuario).then(function (response) {
      usuario = response.data;
      list();
      localStorage.setItem('userId', usuario.Id);
      localStorage.setItem('userName', usuario.Nome);
      localStorage.setItem('userPic', usuario.Foto);
      usuarioLogado();
      $scope.usuario = {};
    });

  };

  function list() {
    usuarioService.list().then(function (response) {
      $scope.usuarios = response.data;
    });
  }

  function usuarioLogado () {
    var logado = localStorage.getItem('userId');
    if (logado !== null) {
      $location.path('/chat').replace();
    }
  }

});
