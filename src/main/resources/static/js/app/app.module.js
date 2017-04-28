const module = angular.module('app', []);

function LodashFactory($window) {
    console.log($window);
    console.log($window._);
    return $window._;
}

// Define dependencies
LodashFactory.$inject = ['$window'];

// Register factory
module.factory('_', LodashFactory);