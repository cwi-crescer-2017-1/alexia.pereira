angular.module('app').factory('locacaoService', function ($http) {

  let urlBase = 'http://localhost:64375/api/locacoes/';

  function getTodasAsLocacoes() {
    return $http.get(urlBase + 'obter');
  };

  function criar(locacao) {
    return $http.post(urlBase + 'cadastrar', locacao);
  }


  function obterValor(model) {
    return $http.post(urlBase + 'valor', model)
  };

  function gerarRelatorioMensal(data) {
    let parametros = {data: data};
    return $http({
      url: urlBase + 'relatorio',
      method: 'GET',
      params: parametros
    });
  }

  function devolver (id) {
    return $http.put(urlBase + 'devolver/' + id);
  }

  function gerarRelatorioAtrasos() {
    return $http.get(urlBase + 'atrasados');
  }

  return {
    listar: getTodasAsLocacoes,
    criar: criar,
    obterValor: obterValor,
    gerarRelatorioMensal: gerarRelatorioMensal,
    devolver: devolver,
    gerarRelatorioAtrasos: gerarRelatorioAtrasos
  };
});
