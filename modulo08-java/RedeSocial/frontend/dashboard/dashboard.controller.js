angular.module('app').controller('DashboardController', function ($location, $scope, authService) {
  $scope.logout = logout;
  function logout() {
    authService.logout();
  };
});
