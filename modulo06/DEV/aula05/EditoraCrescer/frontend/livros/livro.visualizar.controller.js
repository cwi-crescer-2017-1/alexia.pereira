angular.module('app')
  .controller('LivroVisualizarController', function ($scope, $routeParams, livrosService, autoresService, authService) {

    $scope.livro = {};
    $scope.permitirEdicao = permitirEdicao;
    $scope.edit = livrosService.edit;
    $scope.usuarioLogado = usuarioLogado;
    $scope.atualizarLivro = atualizarLivro;

    buscarLivro($routeParams.isbn);
    buscarAutores();

    function buscarLivro(isbn) {
    livrosService.procurarPorIsbn(isbn).then(function (response) {
        $scope.livro = response.data.dados;
      })
    };

    function buscarAutores () {
      autoresService.listar().then(function (response) {
        console.log(response.data);
        $scope.autores = response.data;
      })
    };

    function atualizarLivro(livro) {
      livrosService.atualizar(livro).then(function(response) {
        $scope.livro = response.data.dados;
        $scope.edit = false;
        livrosService.edit = false;
      });
    }

    function permitirEdicao() {
      $scope.edit = true;
    }

    function usuarioLogado() {
      return authService.isAutenticado();
    }

  });
