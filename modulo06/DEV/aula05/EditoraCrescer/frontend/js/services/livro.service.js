angular.module('app').factory('livrosService', function ($http) {

  let urlBase = 'http://localhost:50673/api/livros/';

  function getTodosOsLivros() {
    return $http.get(urlBase);
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

  return {
    listar: getTodosOsLivros,
    procurarPorIsbn: getLivroPorIsbn,
    procurarPorGenero: procurarPorGenero,
    atualizar: atualizar,
    criar: criar,
    deletar: remover
  };
});
