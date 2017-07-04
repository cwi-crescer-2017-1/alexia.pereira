angular.module('app').factory('curtidasService', function ($http) {

  let urlBase = 'http://localhost:9090/curtidas/';

  function getCurtidaById(id) {
    return $http.get(urlBase + id);
  };

  function criar (curtida) {
    return $http.post(urlBase, curtida);
  }

  function deletar (curtida) {
    return $http.delete(urlBase, curtida);
  }

  function getCurtidasByPost (idPost) {
    return $http.get(urlBase + 'post/' + idPost)
  }

  return {
    getCurtidaById: getCurtidaById,
    getCurtidasByPost: getCurtidasByPost,
    criar: criar,
    deletar: deletar
  };
});
