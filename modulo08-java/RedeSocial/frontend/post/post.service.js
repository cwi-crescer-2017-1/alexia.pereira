angular.module('app').factory('postService', function ($http) {

  let urlBase = 'http://localhost:9090/posts/';

  function getPostPorId(id) {
    return $http.get(urlBase + id);
  };


  function postsDeUsuario(idUsuario, parametros) {
    return $http({
      url: urlBase + idUsuario,
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
    postsDeUsuario: postsDeUsuario,
    criar: criar,
    deletar: deletar
  };
});
