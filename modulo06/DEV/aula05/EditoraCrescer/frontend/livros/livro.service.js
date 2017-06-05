angular.module('app').factory('livrosService', function ($http) {

  let urlBase = 'http://localhost:50673/api/livros/';

  function getTodosOsLivros() {
    return $http.get(urlBase);
  };

  function revisar(livro) {
    return $http.put(urlBase + 'revisar', livro);
  }

  function publicar(livro) {
    return $http.put(urlBase + 'publicar', livro);
  }

  function paginarLivros(parametros) {
    return $http({
      url: urlBase,
      method: 'GET',
      params: parametros
    });
  };

  function paginarLivrosADM(parametros) {
    return $http({
      url: urlBase + "adm",
      method: 'GET',
      params: parametros
    });
  };

  function getLivroPorIsbn(isbn) {
    return $http.get(urlBase + isbn);
  };

  function atualizar(livro) {
    return $http.put(urlBase + livro.Isbn, livro);
  };

  function criar (livro) {
    return $http.post(urlBase, livro);
  }

  function remover (livro) {
    return $http.delete(urlBase + livro.Isbn);
  }

  function procurarPorGenero (genero) {
    return $http.get(urlBase + genero);
  }

  function lancamentos () {
    return $http.get(urlBase + "lancamentos");
  }

  function quantidadePaginas(parametro) {
    return $http({
      url: urlBase + "quantidadepaginas",
      method: 'GET',
      params: parametro
    });
  };

  return {
    listar: getTodosOsLivros,
    procurarPorIsbn: getLivroPorIsbn,
    procurarPorGenero: procurarPorGenero,
    paginarLivros: paginarLivros,
    lancamentos: lancamentos,
    quantidadePaginas: quantidadePaginas,
    atualizar: atualizar,
    criar: criar,
    deletar: remover,
    revisar: revisar,
    publicar: publicar,
    paginarLivrosADM: paginarLivrosADM
  };
});
