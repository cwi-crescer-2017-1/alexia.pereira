var aplicacao = angular.module('ex02', []);

aplicacao.filter('mascada', function() {
    return function mascada(nome) {
        return nome.replace(/(nunes)/ig, '$ $1 $');
    }
})


aplicacao.controller('Controller', ['$scope', function(model) {
let instrutores = [{
    nome: 'Bernardo',
    aula: [{
        numero: 1,
        nome: 'OO'
      },
      {
        numero: 4,
        nome: 'Javascript'
      }
    ]
  },
  {
    nome: 'Nunes',
    aula: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
  },
  {
    nome: 'Pedro (PHP)',
    aula: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
  },
  {
    nome: 'Zanatta',
    aula: [{
      numero: 5,
      nome: 'AngularJS'
    }]
  }
];
model.instrutores = instrutores;
}]);