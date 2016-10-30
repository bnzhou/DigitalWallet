angular.module('fortunes', ['ngRoute']).config(function ($routeProvider) {

    $routeProvider.when('/test', {
        templateUrl: 'fortune.html',
        controller: 'fortune'
    })

}).controller('fortune', function ($scope, $http) {

    $http.get('items').success(function (data) {
        $scope.fortune = data;
    });

});