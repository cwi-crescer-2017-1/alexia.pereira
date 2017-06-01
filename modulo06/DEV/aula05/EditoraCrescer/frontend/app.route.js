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
  .otherwise({redirectTo: '/livros'});
});
