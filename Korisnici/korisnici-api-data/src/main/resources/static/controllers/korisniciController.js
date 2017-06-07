
app.controller('korisniciController', function($scope, $http) {
    $http.get('http://localhost:8082/Korisnici/').
        then(function(response) {
            $scope.sviKorisnici = response.data;
        });
});