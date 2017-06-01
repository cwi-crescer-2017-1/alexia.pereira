angular.module('app').config(function ($routeProvider) {
  $routeProvider
  .when('/livros', {
    controller: 'LivrosController',
    templateUrl: '/templates/livros.html'
  })
  .when('/livros/visualizar/:isbn', {
    controller: 'LivroVisualizarController',
    templateUrl: '/templates/livro.visualizar.html'
  })
  .otherwise({redirectTo: '/livros'});
});
