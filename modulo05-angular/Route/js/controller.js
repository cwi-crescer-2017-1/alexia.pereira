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

var idAula = 0;
var idInstrutor = 0;

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
  // Ações executadas quando criar a controller
  // findById($scope.id);
  list(); // listar aulas

  // Funções internas
  function create(aula) {
    aulaService.create(aula).then(response => $scope.aulas.push(response.data));
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
    aulaService.update(aula).then(function () {
      list();
      $scope.showForm = false;
    });
  };

  function deletar (aula) {
    aulaService.delete(aula).then(function () {
      list();
    })
  }


  // $scope.aulaPraDeletar = undefined;
  // $scope.showForm = false;
  // $scope.aulasendoUtilizada = false;
  //
  // $scope.incluirAula = function (nomeAula) {
  //   if ($scope.meuForm.$invalid || !$scope.meuForm.$valid) {
  //     return;
  //   }
  //   let novaAula = {id: ++idAula, nome: nomeAula };
  //   $scope.aulas.push(angular.copy(novaAula));
  //   $scope.novaAula = "";
  //   alert("Aula incluída com sucesso");
  // }
  //
  // $scope.aulaJaCadastrada = function(nomeAula, update) {
  //   // if($scope.aulaselecionada($scope.aulas)) {
  //   let validade = $scope.aulas.filter(aula => aula.nome === nomeAula).length > 0;
  //   if (!update) {
  //     $scope.meuForm.$invalid = validade;
  //   } else {
  //     $scope.formUpdateAula.$invalid = validade;
  //   }
  //   return validade;
  //   // }
  // };
  //
  $scope.aulaSelecionada = function (aulaS) {
    $scope.aulaS = angular.copy(aulaS);
    let taSelecionada = typeof aulaS !== 'undefined';
    $scope.showForm = taSelecionada;
    return taSelecionada;
  };
  //
  // $scope.updateAula = function (nomeNovaAula) {
  //   $scope.aulaJaCadastrada(nomeNovaAula, true);
  //   if ($scope.formUpdateAula.$invalid || !$scope.formUpdateAula.$valid) {
  //     return;
  //   }
  //   $scope.aulas.nome = nomeNovaAula;
  //   $scope.novoNomeAula = "";
  //   alert("Aula atualizada com sucesso");
  // }
  //
  // $scope.deletarAula = function (aulaPraDeletar) {
  //   let aulaSendoUtilizada = $scope.instrutores.filter(i => i.aula.includes(aulaPraDeletar.id)).length > 0;
  //   $scope.aulasendoUtilizada = aulaSendoUtilizada;
  //   if (aulaSendoUtilizada) {
  //     return;
  //   }
  //   let i = aulas.indexOf(aulaPraDeletar);
  //   aulas.splice(i, 1);
  //   alert("Aula deletada com sucesso");
  // }
  //
  // $scope.aulaNaoEstaSendoUtilizada = function () {
  //   $scope.aulasendoUtilizada = false;
  // }
});

app.controller('InstrutoresController', function ($scope) {

  // INSTRUTORES
  $scope.showFormI = false;
  $scope.instrutorS = $scope.instrutores[0];
  $scope.selecionado = [];
  $scope.instrutorSendoUtilizado = false;

  $scope.incluirInstrutor = function (novoInstrutor) {
    if ($scope.meuFormI.$invalid || !$scope.meuFormI.$valid) {
      return;
    }
    novoInstrutor.aula.sort(ordenarAulas);
    novoInstrutor.id = ++idInstrutor;
    novoInstrutor.dandoAula = novoInstrutor.dandoAula || false;
    novoInstrutor.urlFoto = novoInstrutor.urlFoto || "https://media.lovemondays.com.br/logos/e3b058/cwi-software-original.png";
    $scope.instrutores.push(angular.copy(novoInstrutor));
    alert("Instrutor incluído com sucesso");
    // $scope.novoInstrutor = {};
  }

  $scope.aulasDosInstrutores = function (idAula) {
    return $scope.aulas.filter(aula => aula.id === idAula).map(e => e.nome).shift();
  };

  $scope.selecaoAlternada = function (aula) {
    var idx = $scope.selecionado.indexOf(aula);
    if (idx > -1) {
      $scope.selecionado.splice(idx, 1);
    }
    else {
      $scope.selecionado.push(aula);
    }
    $scope.novoInstrutor.aula = $scope.selecionado.map(aula => aula.id);
  };

  $scope.instrutorJaCadastrado = function(nomeInstrutor) {
    // if($scope.instrutorSelecionado($scope.instrutorS)) {
    let validade = $scope.instrutores.filter(instrutor => {
      if (typeof $scope.instrutorS === 'undefined' || $scope.instrutorS === null) return false;
      return instrutor.id !== $scope.instrutorS.id && instrutor.nome === nomeInstrutor
    }).length > 0;

    $scope.meuFormI.$invalid = $scope.meuFormI.$invalid || validade;
    return validade;
    // }
  };

  $scope.emailJaCadastrado = function (emailInstrutor) {
    let validade = $scope.instrutores.filter(instrutor => {
      if (typeof $scope.instrutorS === 'undefined' || $scope.instrutorS === null) return false;
      return instrutor.id !== $scope.instrutorS.id && instrutor.email === emailInstrutor
    }).length > 0;
    $scope.meuFormI.$invalid = $scope.meuFormI.$invalid || validade;
    return validade;

  }

  $scope.instrutorSelecionado = function (instrutorS) {
    let taSelecionado = typeof instrutorS !== 'undefined';
    $scope.showFormI = taSelecionado;
    $scope.novoInstrutor = angular.copy(instrutorS);
    return taSelecionado;
  };

  $scope.atualizarInstrutor = function (novoInstrutor) {
    if ($scope.meuFormI.$invalid || !$scope.meuFormI.$valid) {
      return;
    }
    novoInstrutor.aula.sort(ordenarAulas);
    let i = $scope.instrutores.indexOf($scope.instrutorS);
    $scope.instrutores[i] = novoInstrutor;
    $scope.novoInstrutor = {};
    $scope.showFormI = false;
    alert("Instrutor atualizado com sucesso");
  }

  $scope.deletarInstrutor = function (instrutorParaDeletar) {
    let sendoUtilizado = instrutorParaDeletar.dandoAula;
    if(!sendoUtilizado) {
      $scope.instrutores = $scope.instrutores.filter(instrutor => instrutor.id !== instrutorParaDeletar.id);
      alert("Instrutor deletado com sucesso");
    }
    $scope.instrutorSendoUtilizado = sendoUtilizado;

  }

  $scope.instrutorNaoEstaSendoUtilizado = function () {
    $scope.instrutorSendoUtilizado = false;
  }

  let ordenarAulas = function(aula1,aula2) {
    if (typeof $scope.aulas[aula1] === 'undefined' || typeof $scope.aulas[aula2] === 'undefined') return 0;
    if($scope.aulas[aula1].nome.toLowerCase() > $scope.aulas[aula2].nome.toLowerCase()) return 1;
    if($scope.aulas[aula1].nome.toLowerCase() < $scope.aulas[aula2].nome.toLowerCase()) return -1;
    return 0;
  }
});
