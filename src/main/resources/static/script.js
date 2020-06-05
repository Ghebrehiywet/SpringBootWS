var testApp = angular.module("testApp", []);

testApp.controller("testController", function($scope, $http) {
    $scope.home = "This is the homepage";

    $scope.getRequest = function() {
        alert("I've been pressed! GET");
        $http.get("http://urlforapi.com/get?name=Elliot").then(
            function successCallback(response) {
                $scope.response = response;
            },
            function errorCallback(response) {
                console.log("Unable to perform get request");
            }
        );
    };

    //    Our POST request function
    $scope.postRequest = function() {
        alert("I've been pressed! POST");
        $http.post("http://urlforapi.com/", data).then(
            function successCallback(response) {
                console.log("Successfully POST-ed data");
            },
            function errorCallback(response) {
                console.log("POST-ing of data failed");
            }
        );
    };

});