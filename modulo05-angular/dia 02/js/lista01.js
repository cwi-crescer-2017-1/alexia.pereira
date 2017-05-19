var aplicacao = angular.module('ex02', []);

aplicacao.filter('mascada', function() {
  return function mascada(nome) {
    return nome.replace(/(nunes)/ig, '$ $1 $');
  }
})

aplicacao.filter('listarAulas', function() {
  return function listarAulas(aula) {
    var str = "" + aula.numeroAula;
    var pad = "000"
    var num = pad.substring(0, pad.length - str.length) + str
    let formatacao = num + " - " + aula.nomeAula.toUpperCase();
    return formatacao;
  }
});

aplicacao.controller('Controller', ['$scope', function(model) {
  let instrutores = [{
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
  },
  {
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
}
];
model.instrutores = instrutores;

function converterPraAulas (instrutores) {
  let aulas = [];
  instrutores.map(function(i) {
    for (let cont = 0; cont < i.aula.length; cont ++) {
      let c = {nomeAula: i.aula[cont].nome, numeroAula: i.aula[cont].numero, nomeInstrutor: i.nome};
      aulas.push(c);
    }
  }
);
console.log(aulas);
return aulas;
};

model.aulas = converterPraAulas(model.instrutores);

}]);
