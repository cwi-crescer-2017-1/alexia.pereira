angular.module('app').controller('AdministrativoController', function ($location, $scope, authService, clienteService, veiculoService) {

  $scope.ufs = ['AC', 'AL', 'AP', 'AM','BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 'PA',
  'PB', 'PR', 'PE','PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO']

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
