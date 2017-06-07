angular.module('app').controller('AdministrativoController', function ($location, $scope, authService) {

  $scope.generos = [
    {
      Numero: 1,
      Nome: 'Masculino'
    },
    {
      Numero: 2,
      Nome: 'Feminino'
    },
    {
      Numero: 3,
      Nome: 'Não Informado'
    }
  ];

//  $scope.cliente.genero = {Numero: '3', Nome: 'Não Informado'};

});
