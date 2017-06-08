angular.module('app').controller('LocacaoController', function ($location, $scope, veiculoService) {

  listarVeiculos();
  
  function listarVeiculos() {
    veiculoService.listar().then(function (response) {
      $scope.veiculos = response.data.dados;
    })
  }

});
