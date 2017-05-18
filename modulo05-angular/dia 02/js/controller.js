var aplicacao = angular.module('aula02', []);

aplicacao.controller('Controller', ['$scope', function(model) {
model.formatar = formatar;
function formatar (data) {
    var parts = data.split("/");
    var dt = new Date(parseInt(parts[2], 10),
                  parseInt(parts[1], 10) - 1,
                  parseInt(parts[0], 10));
    model.dataObjeto = dt;
}

}]);
