angular.module('app').controller('LivrosController', function ($location, $scope, livrosService) {

  $scope.visualizar = visualizar;
  $scope.pagina = 1;
  $scope.decrementarPagina = decrementarPagina;
  $scope.incrementarPagina = incrementarPagina;
  $scope.criarLivro = criarLivro;
  listar();
  lancamentos();
  quantidadePaginas(6);

  function listar (skip = 0) {
    let parametros = {skip:skip, quantidade: 6}
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
    listar(($scope.pagina-2) * 6);
    $scope.pagina = $scope.pagina-1;
  }

  function incrementarPagina () {
    listar($scope.pagina++ * 6);
  }

  function criarLivro (livro) {
    livrosService.criar(livro).then(function(response) {
      alert("Livro criado com sucesso")
      $location.path('/livros/visualizar/' + response.data.dados.Isbn);
    })
  }

});
