angular.module("myApp")

.service('HttpRequestService', function($http) {

	return function(url, method, data, callback) {
		var requestParams = {
			method: method,
			url: url,
			headers: { 'Content-type': 'application/json'},
			data: data
		};

		$http(requestParams).then(
			function successCallback(response) {
				callback && callback(response);
			},

			function errorCallback(response) {

			}
		);
	};

})

.service('RestService', function(HttpRequestService) {
	var restFactory = {};

	restFactory.find = function(url, callback) {
		HttpRequestService(url, "GET", {}, callback);
	};

	restFactory.add = function(url, data, callback) {
		HttpRequestService(url, "POST", data, callback);
	};

	restFactory.edit = function(url, data, callback) {
		HttpRequestService(url, "PUT", data, callback);
	};

	restFactory.delete = function(url) {
		HttpRequestService(url, "DELETE", null, null);
	};

	return restFactory;
});