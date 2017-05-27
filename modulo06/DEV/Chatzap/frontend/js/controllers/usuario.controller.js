angular.module('app').controller('UsuariosController', function ($scope, usuarioService) {

  $scope.entrarNaConversa =  entrarNaConversa;
  list();

  // Funções internas
  function create(usuario) {
    usuarioService.create(usuario).then(function () {
      list();
    });
  };

  function entrarNaConversa () {
    var userName = prompt("Digite seu Nome");
    var foto = prompt("Digite uma URL pública pra sua foto");
    var usuario = {Id: 0, Nome: userName, Foto: foto};
    $scope.usuario = usuario;
    create(usuario);
  }

  function list() {
    usuarioService.list().then(function (response) {
      $scope.usuarios = response.data;
    });
  }

});
