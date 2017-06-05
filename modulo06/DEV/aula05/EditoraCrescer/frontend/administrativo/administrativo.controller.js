angular.module('app').controller('AdministrativoController', function ($location, $scope, $http, livrosService, authService) {

  $scope.visualizar = visualizar;
  $scope.editar = editar;
  $scope.remover = removerLivro;
  $scope.logout = logout;
  $scope.revisor = verificarPermissao("Revisor");
  $scope.livroPodeSerRevisado = livroPodeSerRevisado;
  $scope.revisarLivro = revisarLivro;
  listarLivros();

  function listarLivros (skip = 0) {
    let parametros = {skip:skip, quantidade: 10}
    livrosService.paginarLivrosADM(parametros).then(function (response) {
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

  function logout () {
    authService.logout()
  }

  function verificarPermissao (nomePermissao) {
    return angular.isDefined(authService.possuiPermissao(nomePermissao));
  }

  function livroPodeSerRevisado (revisor, livro) {
    return revisor && livro.DataRevisão == null;
  }
  function revisarLivro (livro) {
    let parametros = {email: authService.getUsuario().Email};
      $http({
      url: 'http://localhost:50673/api/acessos/obtemlogin',
      method: 'GET',
      params: parametros
    })
    .then(function(response){
        livro.IdUsuarioRevisor = response.data.dados.Id;
        livrosService.revisar(livro).then(function (response){
          $scope.livro = response.data.dados;
          alert("Livro revisado com sucesso");
          livroPodeSerRevisado(false, $scope.livro);
        })
    })
  };

});
