angular.module('app').controller('LivrosController', function ($location, $scope, livrosService) {

  $scope.visualizar = visualizar;
  $scope.pagina = 1;
  $scope.decrementarPagina = decrementarPagina;
  $scope.incrementarPagina = incrementarPagina;
  listar();
  lancamentos();
  quantidadePaginas(10);

  function listar (skip = 0) {
    let parametros = {skip:skip, quantidade: 10}
    livrosService.paginarLivros(parametros).then(function (response) {
          $scope.livros = response.data.dados;
        });
  };

  function lancamentos () {
    livrosService.lancamentos().then(function (response) {
          $scope.lancamentos = response.data.dados;
        });
  }

  function visualizar(livro) {
    $location.path('/livros/visualizar/' + livro.Isbn);
  }

  function quantidadePaginas (quantidade) {
    let parametro = {quantidade: quantidade};
    livrosService.quantidadePaginas(parametro).then(function(response) {
      $scope.totalPaginas = response.data.dados;
    })
  }

  function decrementarPagina () {
    listar(($scope.pagina-2) * 10);
    $scope.pagina = $scope.pagina-1;
  }

  function incrementarPagina () {
    listar($scope.pagina++ * 10);
  }

});
