angular.module('app').config(function ($routeProvider) {
  $routeProvider
  .when('/chat', {
    controller: 'MensagensController',
    templateUrl: 'templates/chat.html'
  })
  .when('/login', {
    controller: 'UsuariosController',
    templateUrl: 'templates/login.html'
  })
  .otherwise({redirectTo: '/login'});
});
