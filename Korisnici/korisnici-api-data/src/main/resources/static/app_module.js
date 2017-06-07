var app=angular.module('demo',['ngRoute'])

/*.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl:"glumac.html",
		controller:'gCont'

	});
})*/




app.config(function($routeProvider, $locationProvider) {
	  $routeProvider
	   .when('/glumac/:glumacId', {
	    templateUrl: 'partials/ime.html',
	    controller: 'glumacController'
	   /* resolve: {
	      // I will cause a 1 second delay
	      delay: function($q, $timeout) {
	        var delay = $q.defer();
	        $timeout(delay.resolve, 1000);
	        return delay.promise;
	      }
	    }*/
	  })
	  .when('/glumci', {
		  templateUrl: 'partials/glumci.html',
		  controller:'glumciController'})
		  
	  .when('/s=:pretragaPojam', {
		  templateUrl: 'partials/pretraga.html',
		  controller:'pretragaController'})
		  
	  .when('/filmovi', {
		  templateUrl: 'partials/filmovi.html',
		  controller:'filmoviController'})
		  
		  
	  .when('/korisnici', {
		  templateUrl: 'partials/korisnici.html',
		  controller:'korisniciController'})
		  	  
	  .when('/registracija', {
		  templateUrl: 'partials/registracija.html',
		  controller:'registracijaController'})
		  
	  .when('/film/:filmId', {
	    templateUrl: 'partials/film.html',
	    controller: 'filmController'
	   /* resolve: {
	      // I will cause a 1 second delay
	      delay: function($q, $timeout) {
	        var delay = $q.defer();
	        $timeout(delay.resolve, 1000);
	        return delay.promise;
	      }
	    }*/
	  });
	  
	  /*
	  .when('/Book/:bookId/ch/:chapterId', {
	    templateUrl: 'chapter.html',
	    controller: 'ChapterController'
	  });*/

	  // configure html5 to get links working on jsfiddle
	  $locationProvider.html5Mode(true);
	});


