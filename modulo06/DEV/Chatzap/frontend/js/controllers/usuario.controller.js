angular.module('app').controller('UsuariosController', function ($scope, usuarioService) {

  $scope.entrarNaConversa =  entrarNaConversa;
  list();

  // Funções internas
  function create(usuario) {
    usuarioService.create(usuario).then(function (response) {
      usuario = response.data;
      list();
      localStorage.setItem('userId', usuario.Id);
      localStorage.setItem('userName', usuario.Nome);
      localStorage.setItem('userPic', usuario.Foto);
    });
  };

  function entrarNaConversa () {
    if(localStorage.getItem('userId') !== null) return;
    var userName = prompt("Digite seu Nome");
    var foto = prompt("Digite uma URL pública pra sua foto");
    var usuario = {Id: 0, Nome: userName, Foto: foto};
    create(usuario);
  }

  function list() {
    usuarioService.list().then(function (response) {
      $scope.usuarios = response.data;
    });
  }

});
