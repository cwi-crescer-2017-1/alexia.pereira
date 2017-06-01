angular.module('app').controller('LivrosController', function ($scope, livrosService) {

  listar();

  function listar () {
    console.log("na function");
    livrosService.listar().then(function (response) {
          $scope.livros = response.data;
        });
  };

});
