angular.module('app').controller('BuscaController', function ($location, $scope,
  usuarioService, authService, solicitacaoService, Alertify) {
    $scope.buscar = buscar;
    $scope.adicionarAosAmigos = adicionarAosAmigos;
    $scope.enviarSolicitacao = enviarSolicitacao;
    $scope.verPerfil = verPerfil;
    buscarUsuarioAtual();
    buscarSolicitacoes();
    buscarMinhasSolicitacoes();

    function buscar (nome) {
      usuarioService.buscarPorNome(nome).then(res => {
        $scope.usuarios = res.data;
      })
    }

    function adicionarAosAmigos(usuario) {
      if (jaSomosAmigos(usuario) || jaMeAdicionou(usuario) || jaTeAdicionei(usuario) || souEu(usuario)) {
        return false;
      } else {
        return true;
      }
    }

    function buscarUsuarioAtual() {
      usuarioService.buscarAmigos(authService.getUsuario().idUsuario).then(response => {
        $scope.usuario = response.data;
        $scope.amigos = $scope.usuario.amigos;
      });
    }

    function buscarSolicitacoes() {
      solicitacaoService.getSolicitacoesPendentes(authService.getUsuario().idUsuario)
      .then(function (response) {
        $scope.solicitacoes = response.data;
      });
    }

    function buscarMinhasSolicitacoes() {
      solicitacaoService.getMinhasSolicitacoes(authService.getUsuario().idUsuario)
      .then(function (response) {
        $scope.minhasSolicitacoes = response.data;
      });
    }

    function jaSomosAmigos(usuario) {
      return $scope.usuario.amigos.map(a => a.idUsuario).indexOf(usuario.idUsuario) !== -1;
    }

    function jaMeAdicionou(usuario) {
      return $scope.solicitacoes.map(s => s.usuarioOwner.idUsuario).indexOf(usuario.idUsuario) !== -1;
    }

    function jaTeAdicionei(usuario) {
      return $scope.minhasSolicitacoes.map(s => s.usuarioTarget.idUsuario).indexOf(usuario.idUsuario) !== -1;
    }

    function souEu(usuario) {
      return usuario.idUsuario === $scope.usuario.idUsuario;
    }

    function enviarSolicitacao(usuario) {
      let solicitacao = {usuarioOwner: $scope.usuario, usuarioTarget: usuario};
      solicitacaoService.criar(solicitacao).then(res => {
        Alertify.success('Solicitação enviada com sucesso');
        buscarMinhasSolicitacoes();
        buscar($scope.nomeUser);
      });
    }

    function verPerfil (usuario) {
      $location.path('/usuario/' + usuario.idUsuario);
    }


  });
