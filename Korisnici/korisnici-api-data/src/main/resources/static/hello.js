



//angular.module('demo')
/*
hello.service('productService', function() {
  var productList = {};

  var addProduct = function(newObj) {
      productList.set(newObj);
  };

  var getProducts = function(){
      return productList;
  };

  return {
    addProduct: addProduct,
    getProducts: getProducts
  };

});*/

app.controller('korisniciController', function($scope, $http) {
    $http.get('http://localhost:8082/Korisnici/').
        then(function(response) {
            $scope.sviKorisnici = response.data;
        });
});

/*hello.controller('gCont', function($scope, $http) {
    $http.get('http://localhost:8084/Glumci/getMoviesById/2').
        then(function(response) {
            $scope.filmT1 = response.data;
        });
});*/
    

app.controller('glumciController', function($scope, $http) {
    $http.get('http://localhost:8084/Glumci/').
        then(function(response) {
            $scope.sviGlumci = response.data;
        });
    //$window.location.href=("g/");

})
/*
hello.controller('glumacController', function($scope, $http, productService) {
	var id=productService.getProducts();
    $http.get('http://localhost:8084/Glumci/',{params: id}).
        then(function(response) {
            $scope.glumac = response.data;
        });
});*/

/*hello.controller('glumacCont', ['$scope','$http','$window','productService', function($scope,$http,$window,productService) {
	//$scope.glumac={};

    $scope.myFunction = function(id) {
    	// var response=$http.get('http://localhost:8084/Glumci/2',{params: id});
             //$scope.glumac = response.data;
             productService.addProduct(id);

             $window.location.href=("ime.html");


         ;
    };
}]);*/

/*
.controller('mainController', function($scope, $route, $routeParams, $location) {
    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;
})
*/
app.controller('filmoviController', function($scope, $routeParams, $http) {
    $scope.name = 'filmoviController';
   // $scope.params = $routeParams;
    $http.get('http://localhost:8083/films/').
    then(function(response) {
        $scope.sviFilmovi = response.data;
    });
})
/*
.controller('glumciController', function($scope, $routeParams, $http) {
    $scope.name = 'glumciController';
    $scope.params = $routeParams;
   
})
*/
app.controller('glumacController', function($scope, $routeParams, $http) {
    $scope.name = 'glumacController';
    $scope.params = $routeParams;
    $http.get('http://localhost:8084/Glumci/'+$routeParams.glumacId).
    then(function(response) {
        $scope.glumac = response.data;
    });
    $http.get('http://localhost:8083/films/filmoveOdGlumca/'+$routeParams.glumacId).
    then(function(response) {
        $scope.glumacFilmovi = response.data;
    });
    
})



app.controller('pretragaController', function($scope, $routeParams,$http) {
	 $scope.name = 'pretragaController';
	    $scope.params = $routeParams;
	   // var x = document.getElementById("tekstPretrage");

    $http.get('http://localhost:8083/films/searchByName/'+$routeParams.pretragaPojam).
        then(function(response) {
            $scope.sviFilmoviPretraga = response.data;
        });
    //window.location = "http://localhost:8082/s=" + x.value;

   // $window.location.href=(x.value);

})

app.controller('filmController', function($scope, $routeParams, $http) {
    $scope.name = 'filmController';
    $scope.params = $routeParams;
    $http.get('http://localhost:8083/films/'+$routeParams.filmId).
    then(function(response) {
        $scope.film = response.data;
    });
   $http.get('http://localhost:8081/komentariPoFilmu/'+$routeParams.filmId).
    then(function(response) {
        $scope.komentariFilm = response.data;
    });
    
})


app.controller('slanjeKomentaraController',
		['$scope','$http', 
		function($scope,$http) {
$scope.posaljiKomentar=function(tekst){
	var parameter = JSON.stringify({"idKomentara":11212,"tekstKomentara":tekst,"idUsera":1,"idFilma":1 });

    	$http({
    		  method: 'POST',
    		  url: 'http://localhost:8081/komentari',
    		  data: parameter,
    		   headers: {
    			   'Content-Type': 'application/json'    	   }
    		}).then(function(response){});    }}
]
)


app.controller('registracijaController', function($scope, $http) {
    $scope.name = 'registracijaController';
    $scope.registrujKorisnika=function(){
    	var parameter = JSON.stringify({"ime":$scope.user.ime, "prezime":$scope.user.prezime, "username":$scope.user.username,"password":$scope.user.password });

        	$http({
        		  method: 'POST',
        		  url: 'http://localhost:8082/Korisnici',
        		  data: parameter,
        		   headers: {
        			   'Content-Type': 'application/json'    	   }
        		}).then(function(response){});    }
   
    
})