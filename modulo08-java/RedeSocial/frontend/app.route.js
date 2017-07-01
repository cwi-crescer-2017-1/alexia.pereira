angular.module('app').config(function ($routeProvider) {
  $routeProvider
  .when('/login', {
    controller: 'LoginController',
    templateUrl: '/login/login.html'
  })
  .when('/dashboard', {
      controller: 'DashboardController',
      templateUrl: 'dashboard/dashboard.html',
      resolve: {
        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
  .otherwise({redirectTo: '/login'});
});
