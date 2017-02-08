angular.module("myApp", ['ui.router', 'ngMaterial', 'ngMessages']) 

.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
    
    $urlRouterProvider.otherwise("/");
     
    $stateProvider
            
            .state('home', {
                url: "/",
                templateUrl: "views/home.html",
                controller: "myController"
            })

            .state('adicionarTarefa', {
                url: "/adicionarTarefa",
                templateUrl: "views/addTarefa.html",
                controller: "myController"
            })

            .state('contato', {
                url: "/contato",
                templateUrl: "views/contato.html"
            });
}]);