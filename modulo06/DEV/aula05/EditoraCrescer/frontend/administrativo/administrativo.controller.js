angular.module('app').controller('AdministrativoController', function ($location, $scope, livrosService) {

  $scope.visualizar = visualizar;
  $scope.editar = editar;
  $scope.remover = removerLivro;
  listarLivros();

  function listarLivros () {
    let parametros = {skip:0, quantidade: 1};
    livrosService.paginarLivros(parametros).then(function (response) {
          $scope.livros = response.data.dados;
        });
  };

  function visualizar(livro) {
    $location.path('/livros/visualizar/' + livro.Isbn);
  }

  function editar(livro) {
    livrosService.edit = true;
    $location.path('/livros/visualizar/' + livro.Isbn);
  }

  function removerLivro (livro) {
    var tenhoCerteza = confirm("Tem certeza que deseja remover esse livro?");
    if (tenhoCerteza) {
      livrosService.deletar(livro).then(function () {
        alert("Livro deletado com sucesso");
        listarLivros();
      })
    }
  };

});
