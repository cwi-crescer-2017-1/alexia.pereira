angular.module('app').controller('RelatorioAtrasoController', function ($location, $scope, locacaoService) {

  $scope.gerarRelatorioAtrasos = gerarRelatorioAtrasos;
  gerarRelatorioAtrasos();

  function gerarRelatorioAtrasos() {
    locacaoService.gerarRelatorioAtrasos().then(function (response) {
      console.log(response.data.dados);
      $scope.clientes = response.data.dados;
    })
  }

});
