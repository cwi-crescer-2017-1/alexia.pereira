angular.module('app').config(function ($routeProvider) {
  $routeProvider
  .when('/livros', {
    controller: 'LivrosController',
    templateUrl: '/livros/livros.html'
  })
  .when('/livros/visualizar/:isbn', {
    controller: 'LivroVisualizarController',
    templateUrl: '/livros/livro.visualizar.html'
  })
  .when('/login', {
    controller: 'LoginController',
    templateUrl: 'login/login.html'
  })
  .when('/adminstrativo', {
      controller: 'AdministrativoController',
      templateUrl: 'administrativo/administrativo.html',
      resolve: {
        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/livros/criar', {
        controller: 'LivrosController',
        templateUrl: 'livros/criar.html',
        resolve: {
          // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
          autenticado: function (authService) {
            return authService.isAutenticadoPromise();
          }
        }
      })
  .otherwise({redirectTo: '/livros'});
});
