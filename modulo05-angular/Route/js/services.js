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

  function criar (aula) {
    return $http.post(urlBase + '/aula', aula);
  }

  function remover (aula) {
    return $http.delete(urlBase + '/aula' + '/' + aula.id);
  }

  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar,
    delete: remover
  };
});

app.factory('instrutorService', function ($http) {

  let idAtual = 0;
  let urlBase = 'http://localhost:3000';

  function getTodaosOsInstrutores() {
    return $http.get(urlBase + '/instrutor');
  };

  function getInstrutorPorId(id) {
    return $http.get(urlBase + '/instrutor' + '/' + id);
  };

  function atualizar(instrutor) {
    return $http.put(urlBase + '/instrutor' + '/' + instrutor.id, instrutor);
  };

  function criar (instrutor) {
    return $http.post(urlBase + '/instrutor', instrutor);
  }

  function remover (instrutor) {
    return $http.delete(urlBase + '/instrutor' + '/' + instrutor.id);
  }

  return {
    list: getTodaosOsInstrutores,
    findById: getInstrutorPorId,
    update: atualizar,
    create: criar,
    delete: remover
  };
});
