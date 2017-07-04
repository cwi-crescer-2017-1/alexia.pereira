angular.module('app').config(function ($routeProvider) {
  $routeProvider
  .when('/login', {
    controller: 'LoginController',
    templateUrl: '/login/login.html'
  })
  .when('/cadastro', {
    controller: 'CadastroController',
    templateUrl: '/cadastro/cadastro.html'
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
    .when('/busca', {
        controller: 'BuscaController',
        templateUrl: 'busca/busca.html',
        resolve: {
          // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
          autenticado: function (authService) {
            return authService.isAutenticadoPromise();
          }
        }
      })
    .when('/amigos', {
        controller: 'AmigosController',
        templateUrl: 'amigos/amigos.html',
        resolve: {
          // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
          autenticado: function (authService) {
            return authService.isAutenticadoPromise();
          }
        }
      })
    .when('/usuario/:idUsuario', {
        controller: 'UsuarioController',
        templateUrl: 'usuario/usuario.html',
        resolve: {
          // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
          autenticado: function (authService) {
            return authService.isAutenticadoPromise();
          }
        }
      })
  .otherwise({redirectTo: '/login'});
});
