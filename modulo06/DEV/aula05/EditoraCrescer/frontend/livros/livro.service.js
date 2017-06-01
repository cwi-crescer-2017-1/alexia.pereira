angular.module('app').factory('livrosService', function ($http) {

  let urlBase = 'http://localhost:50673/api/livros/';

  function getTodosOsLivros() {
    return $http.get(urlBase);
  };

  function paginarLivros(skip, quantidade) {
    return $http.get(urlBase + skip + "/" + quantidade);
  };

  function getLivroPorIsbn(isbn) {
    return $http.get(urlBase + isbn);
  };

  function atualizar(livro) {
    return $http.put(urlBase + instrutor.id, instrutor);
  };

  function criar (livro) {
    return $http.post(urlBase, livro);
  }

  function remover (livro) {
    return $http.delete(urlBase + instrutor.id);
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
