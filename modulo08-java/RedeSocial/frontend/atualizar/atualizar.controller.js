angular.module('app')
.controller('AtualizarController', function ($scope, $location, usuarioService, authService, Alertify) {

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
  $scope.atualizar = atualizar;
  $scope.redirecionarLogin = redirecionarLogin;
  $scope.usuario = authService.getUsuario();
  $scope.usuario.dataNascimento = new Date($scope.usuario.dataNascimento);


  function redirecionarLogin() {
    $location.path('/dashboard')
  }

  function atualizar (usuario) {
    usuario.sexo = usuario.sexo.sigla;
    usuario.foto = usuario.foto || 'https://vignette1.wikia.nocookie.net/harrypotter/images/2/23/Hallows.png/revision/latest?cb=20090309113642';
    usuarioService.atualizar(usuario).then(res => {
      Alertify.success("Perfil alterado com sucesso")
      $location.path('/login');
    }, res => {Alertify.error(res.data.message);})
  }


});
