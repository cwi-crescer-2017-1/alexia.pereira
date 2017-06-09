angular.module('app').factory('locacaoService', function ($http) {

  let urlBase = 'http://localhost:64375/api/locacoes/';

  function getTodasAsLocacoes() {
    return $http.get(urlBase + 'obter');
  };

  function criar(locacao) {
    return $http.post(urlBase + 'cadastrar', locacao);
  }


  function obterValor(locacao) {
    let parametros = {locacao: locacao};
    return $http({
      url: urlBase + 'valor',
      method: 'GET',
      params: parametros
    });
  };

  function gerarRelatorioMensal(data) {
    let parametros = {data: data};
    return $http({
      url: urlBase + 'relatorio',
      method: 'GET',
      params: parametros
    });
  }

  return {
    listar: getTodasAsLocacoes,
    criar: criar,
    obterValor: obterValor,
    gerarRelatorioMensal: gerarRelatorioMensal
  };
});
