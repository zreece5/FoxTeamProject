'use strict';

// Creating angular Application with module name "playerService"
var app = angular.module('playerService',[]);

app.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}]);