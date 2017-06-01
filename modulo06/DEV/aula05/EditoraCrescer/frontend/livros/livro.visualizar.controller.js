angular.module('app')
  .controller('LivroVisualizarController', function ($scope, $routeParams, livrosService) {

    $scope.livro = {};

    buscarLivro($routeParams.isbn);

    function buscarLivro(isbn) {
    livrosService.procurarPorIsbn(isbn).then(function (response) {
        $scope.livro = response.data;
      })
    };

  });
