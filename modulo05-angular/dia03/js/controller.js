let app = angular.module('app', []);

app.controller('Controller', ['$scope', function(model) {

  let instrutores = [
    {
      nome: 'Bernardo',
      sobrenome: 'Rezende',
      idade: 30,
      email: 'bernardo@cwi.com.br',
      jaDeuAula: true,
      aula: 'OO'
    }
  ];

  let aulas = [
    'OO',
    'HTML e CSS',
    'Javascript',
    'AngularJS',
    'Banco de Dados I'
  ];

  model.instrutores = instrutores;
  model.aulas = aulas;
  model.incluir = function(instrutor) {
    if (model.meuForm.$invalid) {
      return;
    }
      model.instrutores.push(angular.copy(instrutor));
  };

}]);
