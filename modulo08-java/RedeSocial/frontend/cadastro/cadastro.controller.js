angular.module('app')
  .controller('CadastroController', function ($scope, $location, usuarioService, authService) {

    $scope.sexos = [
    {
      nome: 'Masculino',
      sigla: 'M'
    },
    {
      nome: 'Feminino',
      sigla: 'F'
    },
    {
      nome: 'Outro',
      sigla: 'O'
    }
  ];
    $scope.casas = ['Corvinal', 'Grifinória', 'Lufa-Lufa', 'Sonserina'];
    $scope.cadastrar = cadastrar;




  function cadastrar (usuario) {
    usuario.sexo = usuario.sexo.sigla;
    usuarioService.criar(usuario).then(res => {
      alert("Cadastro realizado com sucesso")
      $location.path('/login');
    })
  }


  });
