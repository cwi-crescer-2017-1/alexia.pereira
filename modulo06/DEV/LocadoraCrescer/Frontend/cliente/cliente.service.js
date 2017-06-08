angular.module('app').factory('clienteService', function ($http) {

  let urlBase = 'http://localhost:64375/api/clientes/';

  function getTodosOsClientes() {
    return $http.get(urlBase + 'todos');
  };

  function getUsuarioPorCpf(cpf) {
    return $http.get(urlBase + cpf);
  };

  function atualizar(cliente) {
    return $http.put(urlBase + 'atualizar', cliente);
  };

  function criar (cliente) {
    return $http.post(urlBase + 'registrar', cliente);
  }

  return {
    listar: getTodosOsClientes,
    buscarClientePorCpf: getUsuarioPorCpf,
    atualizar: atualizar,
    criar: criar
  };
});
