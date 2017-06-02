angular.module('app').controller('LivrosController', function ($location, $scope, livrosService) {

  $scope.visualizar = visualizar;

  listar();
  lancamentos();

  function listar () {
    livrosService.paginarLivros(1, 0).then(function (response) {
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

});
