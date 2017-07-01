angular.module('app').controller('LoginController', function ($location, $scope, authService) {

  $scope.login = login;

  function login (usuario) {
    authService.login(usuario)
    .then(
      function (response) {
        console.log(response);
        alert('Login com sucesso!');

      },
      function (response) {
        console.log(response);
        alert('Erro no Login!');
      });
    }

  });
