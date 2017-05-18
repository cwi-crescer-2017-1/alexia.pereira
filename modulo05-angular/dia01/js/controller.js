var app = angular.module('myApp', []);

app.controller('MainController', ['$scope', function(model) {
  model.pokemon = {nome:'Nome Padrao', tipo: 'Default'};
}]);

app.controller('MainController2', ['$scope', function(model) {
  model.pokemons = JSON.parse('[{"nome":"Bulbasaur","tipo":"Grama"},{"nome":"Charmander","tipo":"Fogo"},{"nome":"Charizard","tipo":"Fogo"},{"nome":"Squirtle","tipo":"Água"},{"nome":"Pikachu","tipo":"Raio"},{"nome":"Caterpie","tipo":"Inseto"},{"nome":"Pidgey","tipo":"Normal"},{"nome":"Ekans","tipo":"Veneno"},{"nome":"Zubat","tipo":"Veneno"},{"nome":"Bellsprout","tipo":"Grama"}]');
}]);
