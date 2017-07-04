angular.module('app').controller('LoginController', function ($location, $scope, authService, Alertify) {

  $scope.login = login;
  $scope.telaCadastro = telaCadastro;
  verificarUsuarioLogado();

  function login (usuario) {
    authService.login(usuario)
    .then(
      function (response) {
        Alertify.success('Login com sucesso!');

      },
      function (response) {
        Alertify.error('Email ou Senha Incorretos!');
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
