angular.module('app').factory('usuarioService', function ($http) {

  let urlBase = 'http://localhost:9090/usuarios/';

  function getTodosOsUsuarios() {
    return $http.get(urlBase);
  };

  function getUsuarioPorEmail(email) {
    return $http.get(urlBase + email);
  };

  function getUsuarioPorId(id) {
    return $http.get(urlBase + id);
  };

  function atualizar(usuario) {
    return $http.put(urlBase + 'atualizar', usuario);
  };

  function criar (usuario) {
    return $http.post(urlBase, usuario);
  }

  function getAmigos(idUsuario) {
    return $http.get(urlBase + 'amigos/' + idUsuario);
  }

  return {
    buscarUsuarioPorEmail: getUsuarioPorEmail,
    buscarPorId: getUsuarioPorId,
    buscarAmigos: getAmigos,
    listar: getTodosOsUsuarios,
    atualizar: atualizar,
    criar: criar
  };
});
