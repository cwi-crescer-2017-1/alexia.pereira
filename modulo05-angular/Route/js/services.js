app.factory('aulaService', function ($http) {

  let idAtual = 0;
  let urlBase = 'http://localhost:3000';

  function getTodasAsAulas() {
    return $http.get(urlBase + '/aula');
  };

  function getAulaPorId(id) {
    return $http.get(urlBase + '/aula' + '/' + id);
  };

  function atualizar(aula) {
    return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
  };

  // function criar(aula) {
  //   aula.id = ++idAtual;
  //   aulas.push(angular.copy(aula));
  // };
  function criar (aula) {
    aula.id = ++idAtual;
    return $http.post(urlBase + '/aula')
  }

  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar
  };
});
