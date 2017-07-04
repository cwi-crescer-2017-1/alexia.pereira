angular.module('app')
.controller('UsuarioController', function ($scope, $routeParams, $location, usuarioService, authService, postService) {

  $scope.usuario = {};
  $scope.permitirEdicao = permitirEdicao;
  $scope.edit = usuarioService.edit;
  $scope.usuarioLogado = usuarioLogado;
  $scope.atualizarUsuario = atualizarUsuario;
  $scope.editarPerfil = editarPerfil;
  $scope.incrementarPagina = incrementarPagina;
  $scope.decrementarPagina = decrementarPagina;
  $scope.buscarSexo = buscarSexo;
  $scope.buscarImagemDeFundo = buscarImagemDeFundo;
  buscarUsuario($routeParams.idUsuario);
  var pagina = 0;


  function editarPerfil() {
    $location.url("/atualizar");
  }

  function verificarPossibilidadeDeEdicaoDePerfil() {
    $scope.meuPerfil = $scope.usuario.idUsuario === authService.getUsuario().idUsuario;
  }

  function buscarUsuario(id) {
    usuarioService.buscarPorId(id).then(function (response) {
      $scope.usuario = response.data;
      buscarPosts();
      verificarPossibilidadeDeEdicaoDePerfil();
    })
  };

  function buscarPosts () {
    pagina = pagina || 0;
    let parametros = {pagina: pagina, quantidade: 5};
    postService.listarPorUsuario($scope.usuario.idUsuario, parametros).then(function (response) {
      $scope.posts = response.data.content;
      $scope.primeiraPagina = response.data.first;
      $scope.ultimaPagina = response.data.last;
    })
  };


  function decrementarPagina () {
    pagina = (pagina-1);
    buscarPosts();
  }

  function incrementarPagina () {
    pagina = (pagina+1);
    buscarPosts();
  }

  function atualizarUsuario(usuario) {
    usuarioService.atualizar(usuario).then(function(response) {
      $scope.usuario = response.data;
      $scope.edit = false;
      usuarioService.edit = false;
    });
  }

  function permitirEdicao() {
    $scope.edit = true;
  }

  function usuarioLogado() {
    return authService.isAutenticado();
  }

  function buscarSexo(sexo) {
    if (sexo === 'M') {
      return 'Masculino'
    } else if (sexo === 'F') {
      return 'Feminino'
    } else {
      return 'Outro'
    }
  }

  function buscarImagemDeFundo () {
    let casa = $scope.usuario.casa;
    if (casa === 'Corvinal') {
      return '/icons/corvinal.jpg';
    } else if (casa === 'Grifinória') {
      return '/icons/grifinoria.jfif';
      // return 'https://s-media-cache-ak0.pinimg.com/originals/96/20/c6/9620c6daa67c6c448eba32bce29749fa.png';
    } else if (casa === 'Lufa-Lufa') {
      return '/icons/lufa-lufa.jfif'
    } else {
      return '/icons/sonserina.jfif';
      // return 'http://orig08.deviantart.net/8443/f/2015/171/f/7/harry_potter___slytherin_facebook_cover_by_valquiria_l-d8y078o.png'
    }

  }

});
