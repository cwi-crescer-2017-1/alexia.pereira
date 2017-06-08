angular.module('app').controller('AdministrativoController', function ($location, $scope, authService, clienteService, veiculoService) {

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

  $scope.registrarCliente = registrarCliente;

  function registrarCliente (cliente) {
    cliente.genero = cliente.genero.Numero || 3;
    clienteService.criar(cliente).then(function(response){
      alert("Cliente registrado");
    })
  }

});
