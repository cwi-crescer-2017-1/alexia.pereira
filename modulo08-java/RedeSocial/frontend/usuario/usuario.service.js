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

  function atualizar(cliente) {
    return $http.put(urlBase + 'atualizar', cliente);
  };

  function criar (cliente) {
    return $http.post(urlBase, cliente);
  }

  function getAmigos(idUsuario) {
    return $http.get(urlBase + 'amigos');
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
