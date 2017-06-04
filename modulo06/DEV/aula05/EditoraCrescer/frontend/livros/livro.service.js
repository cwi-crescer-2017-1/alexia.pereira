angular.module('app').factory('livrosService', function ($http) {

  let urlBase = 'http://localhost:50673/api/livros/';

  function getTodosOsLivros() {
    return $http.get(urlBase);
  };

  function paginarLivros(parametros) {
    return $http({
      url: urlBase,
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

  return {
    listar: getTodosOsLivros,
    procurarPorIsbn: getLivroPorIsbn,
    procurarPorGenero: procurarPorGenero,
    paginarLivros: paginarLivros,
    lancamentos: lancamentos,
    atualizar: atualizar,
    criar: criar,
    deletar: remover
  };
});
