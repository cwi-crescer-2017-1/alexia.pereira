angular.module('app').controller('RelatorioController', function ($location, $scope, locacaoService) {

  usuarioNaoGerenteAcessaPagina();
  $scope.gerarRelatorioMensal = gerarRelatorioMensal;

  function calcularTotalRelatorioMensal() {
    return $scope.locacoesMensais.map(l => l.ValorLocacao + l.ValorDesconto);
  }

  function gerarRelatorioMensal(data) {
    locacaoService.gerarRelatorioMensal(data).then(function (response) {
      $scope.locacoesMensais = response.data.dados;
      console.log($scope.locacoesMensais);
      $scope.relatorioMensal.valotTotal = calcularTotalRelatorioMensal();
    })
  }

  function usuarioNaoGerenteAcessaPagina() {
    let usuarioLogado = JSON.parse(localStorage.getItem('ngStorage-usuarioLogado'));
    if (usuarioLogado.Permissao != 'Gerente')
      $location.path('administrativo')
  }

});
