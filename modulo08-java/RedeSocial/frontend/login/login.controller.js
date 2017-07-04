angular.module('app').controller('LoginController', function ($location, $scope, authService) {

  $scope.login = login;
  $scope.telaCadastro = telaCadastro;
  verificarUsuarioLogado();

  function login (usuario) {
    authService.login(usuario)
    .then(
      function (response) {
        alert('Login com sucesso!');

      },
      function (response) {
        alert('Erro no Login!');
      });
    }

    function telaCadastro() {
      $location.path('/cadastro');
    }

    function verificarUsuarioLogado() {
      if (authService.isAutenticado())
        $location.path('/dashboard');
    }

  });
