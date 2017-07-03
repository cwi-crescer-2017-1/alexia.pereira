angular.module('app').controller('MenuController', function ($scope, $location, authService) {
  $scope.usuario = authService.getUsuario();
  $scope.dashboard = dashboard;
  $scope.amigos = amigos;

  function dashboard() {
    $location.path('/dashboard');
  }

  function amigos() {
    $location.path('/amigos');
  }

});
