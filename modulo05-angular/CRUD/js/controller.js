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
  model.aulaSendoUtilizada = false;

  model.incluirAula = function (nomeAula) {
    if (model.meuForm.$invalid || !model.meuForm.$valid) {
      return;
    }
    let novaAula = {id: ++idAula, nome: nomeAula };
    model.aulas.push(angular.copy(novaAula));
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
  }

  model.deletarAula = function (aulaPraDeletar) {
    let aulaSendoUtilizada = model.instrutores.filter(i => i.aula.includes(aulaPraDeletar.id)).length > 0;
    model.aulaSendoUtilizada = aulaSendoUtilizada;
    if (aulaSendoUtilizada) {
      return;
    }
    let i = aulas.indexOf(aulaPraDeletar);
    aulas.splice(i, 1);
  }

  model.aulaNaoEstaSendoUtilizada = function () {
    model.aulaSendoUtilizada = false;
  }

  // INSTRUTORES
  model.instrutores = instrutores;
  model.showFormI = false;
  model.instrutorS;
  model.selecionado = [];
  model.instrutorSendoUtilizado = false;
  model.incluirInstrutor = function (novoInstrutor) {
    novoInstrutor.id = ++idInstrutor;
    novoInstrutor.urlFoto = novoInstrutor.urlFoto || "https://media.lovemondays.com.br/logos/e3b058/cwi-software-original.png";
    model.instrutores.push(angular.copy(novoInstrutor));
  }

  model.aulasDosInstrutores = function (idAula) {
    return model.aulas.filter(aula => aula.id === idAula).map(e => e.nome).shift();
  };

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
    model.novoInstrutor.aula = model.selecionado.map(aula => aula.id);
  };

  model.instrutorJaCadastrado = function(nomeInstrutor) {
    // if(model.instrutorSelecionado(model.instrutorS)) {
      let validade = model.instrutores.filter(instrutor => instrutor.nome === nomeInstrutor).length > 0;
      model.meuFormI.$invalid = validade;
      return validade;
    // }
  };

  model.instrutorSelecionado = function (instrutorS) {
    let taSelecionado = typeof instrutorS !== 'undefined';
    model.showFormI = taSelecionado;
    model.novoInstrutor = angular.copy(instrutorS);
    return taSelecionado;
  };

  model.atualizarInstrutor = function (novoInstrutor) {
    if (model.meuFormI.$invalid || !model.meuFormI.$valid) {
      return;
    }
    let i = model.instrutores.indexOf(model.instrutorS);
    model.instrutores[i] = novoInstrutor
    model.novoInstrutor = "";
    model.showFormI = false;
  }

  model.deletarInstrutor = function (instrutorParaDeletar) {
    let sendoUtilizado = instrutorParaDeletar.dandoAula;
    if(!sendoUtilizado) {
      model.instrutores = model.instrutores.filter(instrutor => instrutor.id !== instrutorParaDeletar.id);
    }
    model.instrutorSendoUtilizado = sendoUtilizado;
  }

  model.instrutorNaoEstaSendoUtilizado = function () {
    model.instrutorSendoUtilizado = false;
  }

}]);
