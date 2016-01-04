var LeLGurApp = angular.module('LeLGurApp', ['ngRoute']);

LeLGurApp.config(function($routeProvider) {
    $routeProvider
            .when('/', {
                controller: 'GetPicturesController',
                templateUrl: 'app/views/pictures.html'
            })
            .when('/pictures/:id', {
                controller: 'GetSinglePictureController',
                templateUrl: 'app/views/singlePicture.html'
            })
            .otherwise({
                redirectTo: '/'
            });
}, ['$httpProvider', function($httpProvider) {
    delete $httpProvider.defaults.header.common["X-Requested-With"]    
}]);