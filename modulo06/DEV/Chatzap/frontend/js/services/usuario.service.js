angular.module('app').factory('usuarioService', function ($http) {

  let urlBase = 'http://localhost:55221/api/usuarios';

  function getTodosOsUsuarios() {
    return $http.get(urlBase);
  };

  function criar (usuario) {
    return $http.post(urlBase, usuario);
  }


  return {
    list: getTodosOsUsuarios,
    create: criar,
  };
});
