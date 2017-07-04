angular.module('app')
.controller('CadastroController', function ($scope, $location, usuarioService, authService, Alertify) {

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
  $scope.redirecionarLogin = redirecionarLogin;


  function redirecionarLogin() {
    $location.path('/login')
  }

  function cadastrar (usuario) {
    usuario.sexo = usuario.sexo.sigla;
    usuario.foto = usuario.foto || 'https://vignette1.wikia.nocookie.net/harrypotter/images/2/23/Hallows.png/revision/latest?cb=20090309113642';
    usuarioService.criar(usuario).then(res => {
      Alertify.success("Cadastro realizado com sucesso")
      $location.path('/login');
    }, res => {Alertify.error(res.data.message);})
  }


});
