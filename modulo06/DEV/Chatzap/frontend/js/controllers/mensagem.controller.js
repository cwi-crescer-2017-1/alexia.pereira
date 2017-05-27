angular.module('app').controller('MensagensController', function ($scope, mensagemService, usuarioService) {

  $scope.create = create;
  list();

  // Funções internas
  function create(mensagem) {
    console.log(mensagem);
    mensagem.Usuario = usuarioService.usuario;
    console.log(mensagem.Usuario);
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
