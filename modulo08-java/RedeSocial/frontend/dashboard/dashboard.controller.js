angular.module('app').controller('DashboardController', function ($location, $scope,
  postService, authService, curtidasService, Alertify) {

    buscarPostsDosAmigos();

    $scope.adicionarPost = adicionarPost;
    $scope.usuario = authService.getUsuario();
    $scope.decrementarPagina = decrementarPagina;
    $scope.incrementarPagina = incrementarPagina;
    $scope.curtir = curtir;

    var pagina = 0;

    function adicionarPost(post) {
      post.usuario = authService.getUsuario();
      post.dataPublicacao = new Date();
      postService.criar(post).then(function (response) {
        Alertify.success("Post criado com sucesso");
        $scope.post = {};
      }, res => Alertify.error(res.data.message))
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

    function curtir(post) {
      let curtida = {post: post, usuario: $scope.usuario };
      curtidasService.criar(curtida).then(res => {
        if (res.data !== "") {
          post.curtidasSet.push(res.data);
        } else {
          post.curtidasSet.slice(1, post.curtidasSet.length-1);
        }
      }, res => Alertify.error('Erro inesperado'));

    }
  });
