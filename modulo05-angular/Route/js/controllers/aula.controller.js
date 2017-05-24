angular.module('app').controller('AulasController', function ($scope, $routeParams, aulaService, toastr) {
  // AULAS
  $scope.id = $routeParams.idUrl;

  $scope.update = update;
  $scope.create = create;
  $scope.delete = deletar;
  // Ações executadas quando criar a controller
  list(); // listar aulas

  // Funções internas
  function create(aula) {
    if (formInvalido(false)) return;
    aulaService.create(aula).then(function () {
      list();
      toastr.success('Aula inserida com Sucesso');
    });
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
      toastr.success('Aula atualizada com Sucesso');
      $scope.showForm = false;
    });
  };

  function deletar (aula) {
    if (typeof aula === 'undefined') return;
    aulaService.delete(aula).then(function () {
      list();
      toastr.success('Aula deletada com Sucesso');
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
