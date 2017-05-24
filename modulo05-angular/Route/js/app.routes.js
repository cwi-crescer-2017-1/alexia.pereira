angular.module('app').config(function ($routeProvider) {
  $routeProvider
  .when('/aulas', {
    controller: 'AulasController',
    templateUrl: 'templates/aulas.html'
  })
  .when('/instrutores', {
    controller: 'InstrutoresController',
    templateUrl: 'templates/instrutores.html'
  })
  .otherwise({redirectTo: '/instrutores'});
});
