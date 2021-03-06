angular.module('app').directive('ngEnter', function() {
    return function(scope, element, attrs) {
        element.bind("keydown", function(e) {
            if(e.which === 13 && !e.shiftKey) {
                scope.$apply(function(){
                    scope.$eval(attrs.ngEnter, {'e': e});
                });
                e.preventDefault();
            }
        });
    };
});


angular.module('app').controller('MensagensController', function ($scope, mensagemService, usuarioService, $location) {

  $scope.create = create;
  $scope.minhaMensagem = minhaMensagem;
  $scope.$watch('mensagens', function() {
        list();
  });
  usuarioLogado();
  list();

  // Funções internas
  function create(mensagem) {
    var usuario = {
      Id: localStorage.getItem('userId'),
      Nome: localStorage.getItem('userName'),
      Foto: localStorage.getItem('userPic')
    };
    mensagem.usuario = usuario;
    mensagem.Id = 0;
    $scope.novaMensagem = {}
    mensagemService.create(mensagem).then(function () {
      list();
    });
  };

  function list() {
    mensagemService.list().then(function (response) {
      $scope.mensagens = response.data;
      $scope.mensagens.forEach(arrumarDatas);
    });
  }

  function arrumarDatas (e, i, a) {
    e.DataMensagem = new Date(Date.parse(e.DataMensagem));
  }

  function minhaMensagem (mensagem) {
    return mensagem.usuario.Id == localStorage.getItem('userId');
  }

  function usuarioLogado () {
    var logado = localStorage.getItem('userId');
    if (logado === null) {
      $location.path('/login').replace();
    }
  }

});
