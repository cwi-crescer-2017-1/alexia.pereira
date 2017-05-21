var app = angular.module('crud', []);

var contId = 0;


app.controller('Controller', ['$scope', function(model) {

  let aulas = [
    {
      id: contId,
      nome: 'OO' // Obrigatório (length = min 3, max 20)
    }
  ];

  model.aulas = aulas;
  model.aulaS = undefined;
  model.aulaPraDeletar = undefined;


  model.incluirAula = function (nomeAula) {
    if (model.meuForm.$invalid || !model.meuForm.$valid) {
      return;
    }
    let novaAula = {id: ++contId, nome: nomeAula };
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

  model.showForm = false;

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


}]);
