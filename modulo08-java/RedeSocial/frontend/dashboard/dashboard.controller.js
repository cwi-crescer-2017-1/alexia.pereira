angular.module('app').controller('DashboardController', function ($location, $scope,
    postService, authService) {

  buscarPostsDosAmigos();

  $scope.adicionarPost = adicionarPost;
  $scope.decrementarPagina = decrementarPagina;
  $scope.incrementarPagina = incrementarPagina;

  var pagina = 0;

  function adicionarPost(post) {
    post.usuario = authService.getUsuario();
    post.dataPublicacao = new Date();
    postService.criar(post).then(function (response) {
      alert("Post criado com sucesso");
      $scope.post = {};
    })
  }
  function buscarPostsDosAmigos () {
    pagina = pagina || 0;
    let parametros = {pagina: pagina, quantidade: 15};
    postService.listarPorAmigos(authService.getUsuario().idUsuario, parametros).then(function (response) {
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



});
