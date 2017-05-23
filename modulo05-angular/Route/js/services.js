app.factory('aulaService', function ($http) {

  let idAtual = 0;
  let urlBase = 'http://localhost:3000';

  function getTodasAsAulas() {
    return $http.get(urlBase + '/aula');
  };

  function getAulaPorId(id) {
    return $http.get(urlBase + '/aula' + '/' + id);
  };

  function atualizar(aulaAntiga, novaAula) {
    console.log("hey", novaAula);
    return $http.put(urlBase + '/aula' + '/' + aulaAntiga.id, novaAula);
  };

  // function criar(aula) {
  //   aula.id = ++idAtual;
  //   aulas.push(angular.copy(aula));
  // };
  function criar (aula) {
    return $http.post(urlBase + '/aula', aula);
  }

  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar
  };
});
