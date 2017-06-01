angular.module('app').controller('LivrosController', function ($scope, livrosService) {

  listar();
  lancamentos();

  function listar () {
    livrosService.paginarLivros(1, 0).then(function (response) {
          $scope.livros = response.data;
        });
  };

  function lancamentos () {
    livrosService.lancamentos().then(function (response) {
          $scope.lancamentos = response.data;
        });
  }

});
