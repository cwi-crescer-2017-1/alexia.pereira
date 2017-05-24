angular.module('app').controller('InstrutoresController', function ($anchorScroll, $location, $scope, $routeParams, instrutorService, aulaService,  toastr) {

  $scope.selecionado = [];
  $scope.showFormI = false;
  $scope.id = $routeParams.idUrl;
  $scope.update = update;
  $scope.create = create;
  $scope.delete = deletar;
  $scope.selecaoAlternada = selecaoAlternada;
  $scope.instrutorSelecionado = instrutorSelecionado;
  $scope.viewUpdate = viewUpdate;
  $scope.geraNomeDasAulas = geraNomeDasAulas;

  listarAulas();
  list();

  // Funções internas
  function create(instrutor) {
    instrutor.dandoAula = instrutor.dandoAula || false;
    instrutor.urlFoto = instrutor.urlFoto || 'https://media.lovemondays.com.br/logos/e3b058/cwi-software-original.png';
    instrutor.aula.sort(ordenarAulas);
    instrutorService.create(instrutor).then(function() {
      list();
      toastr.success('instrutor inserido com Sucesso');
      $scope.novoInstrutor = {};
    });
  };

  function findById(id) {
    instrutorService.findById(id).then(function (response) {
      $scope.instrutor = response.data;
    });
  };

  function list() {
    instrutorService.list().then(function (response) {
      $scope.instrutores = response.data;
    });
  }

  function update(instrutor) {
    $scope.showFormI = false;
    instrutorService.update(instrutor).then(function () {
      list();
      toastr.success('instrutor atualizado com Sucesso');
      $scope.novoInstrutor = {};
    });
  };

  function deletar (instrutor) {
    if (typeof instrutor === 'undefined') return;
    instrutorService.delete(instrutor).then(function () {
      list();
      toastr.success('instrutor deletado com Sucesso');
    })
  }

  function listarAulas() {
    aulaService.list().then(function (response) {
      $scope.aulas = response.data;
    });
  };

  function selecaoAlternada(aula) {
    console.log($scope.selecionado);
    var idx = $scope.selecionado.indexOf(aula);
    if (idx > -1) {
      $scope.selecionado.splice(idx, 1);
    }
    else {
      $scope.selecionado.push(aula);
    }
    $scope.novoInstrutor.aula = $scope.selecionado.map(aula => aula.id);
  };

  function aulasDosInstrutores (idAula) {
    return $scope.aulas.filter(aula => aula.id === idAula).map(e => e.nome).shift();
  };

  function ordenarAulas (aula1,aula2) {
    if (typeof $scope.aulas[aula1] === 'undefined' || typeof $scope.aulas[aula2] === 'undefined') return 0;
    if($scope.aulas[aula1].nome.toLowerCase() > $scope.aulas[aula2].nome.toLowerCase()) return 1;
    if($scope.aulas[aula1].nome.toLowerCase() < $scope.aulas[aula2].nome.toLowerCase()) return -1;
    return 0;
  }

  function instrutorSelecionado (instrutorS) {
    let taSelecionado = typeof instrutorS !== 'undefined';
    $scope.showFormI = taSelecionado;
    $scope.novoInstrutor = angular.copy(instrutorS);
    return taSelecionado;
  };

    function viewUpdate () {
    $anchorScroll();
  };

  function geraNomeDasAulas (aulasDoInstrutor) {
    //Aulas é um Array de id de aulas
    let nomeDasAulas = [];
    for (let idAula of aulasDoInstrutor) {
      nomeDasAulas.push($scope.aulas.filter(a => a.id === idAula).map(a => a.nome).shift());
    }
    return nomeDasAulas.sort();
  }

});
