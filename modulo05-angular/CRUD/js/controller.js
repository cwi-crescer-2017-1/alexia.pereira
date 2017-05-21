var app = angular.module('crud', []);

var idAula = 0;
var idInstrutor = 0;

app.filter('aulasDosInstrutores', function() {
  return function aulasDosInstrutores(idAula, aulas) {
    return aulas.filter(aula => aula.id === idAula).map(e => e.nome);
  }
});


app.controller('Controller', ['$scope', function(model) {

  let instrutores = [
    {
      id: idInstrutor,                            // Gerado
      nome: 'Nome',                     // Obrigatório (length = min 3, max 20)
      sobrenome: 'Sobrenome',           // Opcional (length = max 30)
      idade: 25,                        // Obrigatório (max 90)
      email: 'email@cwi.com.br',        // Obrigatório (type=email)
      dandoAula: true,                  // true ou false
      aula: [1, 4],                     // Opcional (array)
      urlFoto: 'https://media.lovemondays.com.br/logos/e3b058/cwi-software-original.png'  // Opcional (porém tem uma default de livre escolha)
    }
  ];

  let aulas = [
    {
      id: idAula,
      nome: 'OO' // Obrigatório (length = min 3, max 20)
    }
  ];

  // AULAS
  model.aulas = aulas;
  model.aulaS = undefined;
  model.aulaPraDeletar = undefined;
  model.showForm = false;

  model.incluirAula = function (nomeAula) {
    if (model.meuForm.$invalid || !model.meuForm.$valid) {
      return;
    }
    let novaAula = {id: ++idAula, nome: nomeAula };
    model.aulas.push(novaAula);
    model.novaAula = "";
  }

  model.aulaJaCadastrada = function(nomeAula, update) {
    if(model.aulaSelecionada(model.aulaS)) {
      let validade = model.aulas.filter(aula => aula.nome === nomeAula).length > 0;
      if (!update) {
        model.meuForm.$invalid = validade;
      } else {
        model.formUpdateAula.$invalid = validade;
      }
      return validade;
    }
  };

  model.aulaSelecionada = function (aulaS) {
    let taSelecionada = typeof aulaS !== 'undefined';
    model.showForm = taSelecionada;
    return taSelecionada;
  };

  model.updateAula = function (nomeNovaAula) {
    model.aulaJaCadastrada(nomeNovaAula, true);
    if (model.formUpdateAula.$invalid || !model.formUpdateAula.$valid) {
      return;
    }
    model.aulaS.nome = nomeNovaAula;
    model.novoNomeAula = "";
    console.log(aulas);
  }

  model.deletar = function (aulaPraDeletar) {
    let i = aulas.indexOf(aulaPraDeletar);
    aulas.splice(i, 1);
  }

  // INSTRUTORES
  model.instrutores = instrutores;

  model.incluirInstrutor = function (novoInstrutor) {
    novoInstrutor.id = ++idInstrutor;
    model.instrutores.push(angular.copy(novoInstrutor));
  }

  model.aulasDosInstrutores = function (idAula) {
    return model.aulas.filter(aula => aula.id === idAula).map(e => e.nome).shift();
  };

  model.selecionado = [];

  // Toggle selection for a given fruit by name
  model.selecaoAlternada = function (aula) {
    var idx = model.selecionado.indexOf(aula);
    // Is currently selected
    if (idx > -1) {
      model.selecionado.splice(idx, 1);
    }
    // Is newly selected
    else {
      model.selecionado.push(aula);
    }
    console.log(model.selecionado);
    model.novoInstrutor.aula = model.selecionado.map(aula => aula.id);
  };


}]);
