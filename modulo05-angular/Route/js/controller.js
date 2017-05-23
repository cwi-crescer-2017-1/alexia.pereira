var app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {
  $routeProvider
  .when('/aulas', {
    controller: 'AulasController',
    templateUrl: 'aulas.html'
  })
  .when('/instrutores', {
    controller: 'InstrutoresController',
    templateUrl: 'instrutores.html'
  })
  .otherwise({redirectTo: '/aulas'});
});

app.filter('aulasDosInstrutores', function() {
  return function aulasDosInstrutores(idAula, aulas) {
    return aulas.filter(aula => aula.id === idAula).map(e => e.nome);
  }
});

app.controller('AulasController', function ($scope, $routeParams, aulaService) {
  // AULAS
  $scope.id = $routeParams.idUrl;

  $scope.update = update;
  $scope.create = create;
  $scope.delete = deletar;
  $scope.selecionado = [];
  $scope.aulasDosInstrutores = aulasDosInstrutores;
  // Ações executadas quando criar a controller
  list(); // listar aulas

  // Funções internas
  function create(aula) {
    if (formInvalido(false)) return;
    aulaService.create(aula).then(function () {list();});
  };

  function findById(id) {
    aulaService.findById(id).then(function (response) {
      $scope.aula = response.data;
    });
  };

  function list() {
    aulaService.list().then(function (response) {
      $scope.aulas = response.data;
    });
  }

  function update(aula) {
    if (formInvalido(true)) return;
    aulaService.update(aula).then(function () {
      list();
      $scope.showForm = false;
    });
  };

  function deletar (aula) {
    if (typeof aula === 'undefined') return;
    aulaService.delete(aula).then(function () {
      list();
    })
  }

  $scope.aulaSelecionada = function (aulaS) {
    $scope.aulaS = angular.copy(aulaS);
    let taSelecionada = typeof aulaS !== 'undefined';
    $scope.showForm = taSelecionada;
    return taSelecionada;
  };

  function formInvalido (update) {
    return update ? $scope.formUpdateAula.$invalid || !$scope.formUpdateAula.$valid
    : $scope.meuForm.$invalid || !$scope.meuForm.$valid;
  }

});

app.controller('InstrutoresController', function ($scope, $routeParams, instrutorService, aulaService) {

  // INSTRUTORES
  $scope.selecionado = [];
  $scope.showFormI = false;
  $scope.id = $routeParams.idUrl;
  $scope.update = update;
  $scope.create = create;
  $scope.delete = deletar;
  $scope.selecaoAlternada = selecaoAlternada;

  // Ações executadas quando criar a controller
  // findById($scope.id);
  listarAulas();
  list();

  // Funções internas
  function create(instrutor) {
    instrutor.dandoAula = instrutor.dandoAula || false;
    instrutor.urlFoto = instrutor.urlFoto || 'https://media.lovemondays.com.br/logos/e3b058/cwi-software-original.png';
    instrutor.aula.sort(ordenarAulas);
    instrutorService.create(instrutor).then(function() { list(); });
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
    instrutorService.update(instrutor).then(function () {
      list();
      $scope.showForm = false;
    });
  };

  function deletar (instrutor) {
    if (typeof aula === 'undefined') return;
    instrutorService.delete(instrutor).then(function () {
      list();
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

});
