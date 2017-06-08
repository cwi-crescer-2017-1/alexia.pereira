angular.module('app').controller('LocacaoController', function ($location, $scope, veiculoService, clienteService, locacaoService) {

  $scope.locacao = {};
  $scope.buscarClientePorCpf = buscarClientePorCpf;
  $scope.cadastrarCliente = cadastrarCliente;
  listarVeiculos();

  function listarVeiculos() {
    veiculoService.listar().then(function (response) {
      $scope.veiculos = response.data.dados;
    })
  }

  function buscarClientePorCpf(cpf) {
    $scope.clienteCadastrado = true;
    clienteService.buscarClientePorCpf(cpf).then(function (response) {
      $scope.locacao.cliente = response.data.dados;
      if ($scope.locacao.cliente == null) {
        $scope.clienteCadastrado = false;
        alert("Não há nenhum cliente com esse cpf")
        return;
      }
      alert('Cliente encontrado! Nome do Cliente: ' + $scope.locacao.cliente.Nome);
      })
    };


  function cadastrarCliente () {
    $location.path("/administrativo");
  }

});
