angular.module('app').config(function ($routeProvider) {
  $routeProvider
  .when('/locacoes', {
    controller: 'LocacoesController',
    templateUrl: '/locacoes/locacoes.html',
    resolve: {
      autenticado: function (authService) {
        return authService.isAutenticadoPromise();
      }
    }
  })
  .when('/locacoes/visualizar/:id', {
    controller: 'LocacacaoVisualizarController',
    templateUrl: '/locacoes/locacoes.visualizar.html',
    resolve: {
      autenticado: function (authService) {
        return authService.isAutenticadoPromise();
      }
    }
  })
  .when('/login', {
    controller: 'LoginController',
    templateUrl: 'login/login.html'
  })
  .when('/adminstrativo', {
    controller: 'AdministrativoController',
    templateUrl: 'administrativo/administrativo.html',
    resolve: {
      autenticado: function (authService) {
        return authService.isAutenticadoPromise();
      }
    }
  })
  .otherwise({redirectTo: '/login'});
});