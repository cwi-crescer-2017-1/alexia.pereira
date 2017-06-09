angular.module('app').controller('LocacaoController', function ($location, $scope, veiculoService,
  clienteService, locacaoService, pacoteService, opcionalService) {

  $scope.locacao = {}
  $scope.opcionaisSelecionados = [];
  $scope.locacao.pacote = {};
  $scope.locacao.locacaoOpcionais = [];
  $scope.locacao = {};
  $scope.selecaoAlternada = selecaoAlternada;
  $scope.buscarClientePorCpf = buscarClientePorCpf;
  $scope.cadastrarCliente = cadastrarCliente;
  $scope.criarLocacao = criarLocacao;
  $scope.consultarValor = consultarValor;
  listarVeiculos();
  listarPacotes();
  listarOpcionais();

  function criarLocacao(locacao) {

    let model = {
      IdCliente: locacao.cliente.Id,
      IdVeiculo: locacao.veiculo.Id,
      IdPacote: locacao.pacote.Id || 0,
      DataEntregaPrevista: locacao.DataEntregaPrevista,
      IdLocacaoOpcional: locacao.locacaoOpcionais
    }

    locacaoService.criar(model).then(function (response) {
      console.log(response);
      alert("Locação cadastrada");
    });
  }

  function listarVeiculos() {
    veiculoService.listar().then(function (response) {
      $scope.veiculos = response.data.dados;
    })
  }

  function listarPacotes() {
    pacoteService.listar().then(function (response) {
      $scope.pacotes = response.data.dados;
    })
  }

  function listarOpcionais() {
    opcionalService.listar().then(function (response) {
      $scope.opcionais = response.data.dados;
    })
  }

  function buscarClientePorCpf(cpf) {
    clienteService.buscarClientePorCpf(cpf).then(function (response) {
      $scope.locacao.cliente = response.data.dados;
      if ($scope.locacao.cliente == null) {
        $scope.clienteCadastrado = false;
        alert("Não há nenhum cliente com esse cpf")
        return;
      } else {
        $scope.clienteCadastrado = true;
        alert('Cliente encontrado! Nome do Cliente: ' + $scope.locacao.cliente.Nome);
      }
    })
  };

  function selecaoAlternada(opcional) {
    var idx = $scope.opcionaisSelecionados.indexOf(opcional);
    if (idx > -1) {
      $scope.opcionaisSelecionados.splice(idx, 1);
    }
    else {
      $scope.opcionaisSelecionados.push(opcional);
    }
    $scope.locacao.locacaoOpcionais = $scope.opcionaisSelecionados.map(opcional => opcional.Id);
  };

  function consultarValor(locacao) {
    let model = {
      IdCliente: locacao.cliente.Id,
      IdVeiculo: locacao.veiculo.Id,
      IdPacote:  locacao.pacote.Id || 0,
      DataEntregaPrevista: locacao.DataEntregaPrevista,
      IdLocacaoOpcional: locacao.locacaoOpcionais
    }
    locacaoService.obterValor(model).then(function (response) {
      $scope.valorConsultado = true;
      $scope.mostrarValor = response.data.dados;
    })
  }

  function cadastrarCliente () {
    $location.path("/administrativo");
  }

});
