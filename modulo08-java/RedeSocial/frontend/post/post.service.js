angular.module('app').factory('postService', function ($http) {

  let urlBase = 'http://localhost:9090/posts/';

  function getPostPorId(id) {
    return $http.get(urlBase + id);
  };


  function postsDeUsuario(idUsuario, parametros) {
    return $http({
      url: urlBase + 'usuario/' + idUsuario,
      method: 'GET',
      params: parametros
    });
  }

  function postsDeAmigos(idUsuario, parametros) {
    return $http({
      url: urlBase + 'amigos/' + idUsuario,
      method: 'GET',
      params: parametros
    });
  }


  function criar (post) {
    return $http.post(urlBase, post);
  }

  function deletar (idSolicitacao) {
    return $http.delete(urlBase + 'delete/' + idSolicitacao);
  }

  return {
    getPostPorId: getPostPorId,
    listarPorUsuario: postsDeUsuario,
    listarPorAmigos: postsDeAmigos,
    criar: criar,
    deletar: deletar
  };
});
