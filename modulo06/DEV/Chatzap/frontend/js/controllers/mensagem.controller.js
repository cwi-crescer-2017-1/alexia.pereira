angular.module('app').controller('MensagensController', function ($scope, mensagemService, usuarioService) {

  $scope.create = create;
  list();

  // Funções internas
  function create(mensagem) {
    var usuario = {
      Id: localStorage.getItem('userId'),
      Nome: localStorage.getItem('userName'),
      Foto: localStorage.getItem('userPic')
    };
    mensagem.usuario = usuario;
    mensagem.Id = 0;
    $scope.novaMensagem = {}
    mensagemService.create(mensagem).then(function () {
      list();
    });
  };

  function list() {
    mensagemService.list().then(function (response) {
      $scope.mensagens = response.data;
    });
  }
});
