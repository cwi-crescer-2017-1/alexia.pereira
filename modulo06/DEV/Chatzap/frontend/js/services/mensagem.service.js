angular.module('app').factory('mensagemService', function ($http) {

  let urlBase = 'http://localhost:55221/api/mensagens';

  function getTodasAsMensagens() {
    return $http.get(urlBase);
  };

  function criar (mensagem) {
    return $http.post(urlBase, mensagem);
  }

  return {
    list: getTodasAsMensagens,
    create: criar,
  };
});
