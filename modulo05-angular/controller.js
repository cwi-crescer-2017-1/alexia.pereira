var app = angular.module('myApp', []);

app.controller('MainController', ['$scope', function(model) {
  model.pokemon = {nome:'Nome Padrao', tipo: 'Default'};
}]);

