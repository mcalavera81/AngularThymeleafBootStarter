// Here we get the module we created in file one
angular.module('app')

// We are adding a function called Ctrl1
// to the module we got in the line above
    .controller('MyController', MyController);


// Inject my dependencies
MyController.$inject = ['$scope', '$http', '_', '$window'];

// Now create our controller function with all necessary logic
function MyController($scope, $http, _, $window) {
    // Logic here
    var vm = this;
    init();

    function init() {
        vm.features = [];
        vm.deleteFeature = deleteFeature;
        vm.showForm = showForm;

        if (_ === undefined) {
            vm.getAll = getAll;
        } else {
            vm.getAll = _.debounce(getAll, 300);
        }
    }

    function getAll() {

        var url = "/rest/feature";
        if (vm.filter !== "" && vm.filter !== undefined) {
            url = url + "?filter=" + vm.filter;
        }

        $http.get(url).then(function (response) {
            vm.features = response.data;
        });
    }

    function deleteFeature(featureId) {
        console.log('Deleting..', featureId);
        var url = "/rest/feature/" + featureId;
        $http.delete(url).success(function (data, status, headers, config) {
            //$window.location.href = 'login';
            vm.getAll();
        }).error(function (data, status, headers, config) {
            console.error(status, data, headers);
        });
    }

    function showForm() {
        console.log('Route to Form');
        $window.location.href = '/feature/create_feature';
    }


}