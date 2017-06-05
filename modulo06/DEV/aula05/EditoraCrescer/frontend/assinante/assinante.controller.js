angular.module('app').controller('AssinantesController', function ($location, $scope, assinantesService) {

  $scope.criar = criar;

  function criar (assinante) {
    assinantesService.criar(assinante).then(function(response) {
      alert("Obrigado por assinar a Editora Crescer! Enviaremos as novidades para o seu email")
      $location.path('/livros');
    }, function () {
      alert("Email Inválido");
    })
  }
});
