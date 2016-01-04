LeLGurApp.service('APIService', function($http) {
   this.getAllPictures = function() {
       console.log("Getting pictures from API");
       return $http.get('https://aqueous-escarpment-7261.herokuapp.com/images');
   };
   
   this.getSinglePicture = function(id) {
       console.log("Getting single picture from API");
       return $http.get('https://aqueous-escarpment-7261.herokuapp.com/images/'+id);
   };
   
   this.getComments = function(pictureId) {
       console.log("Gettung picture comments...");
   };
   
   this.postComment = function(comment, id) {
       console.log("Posting comment to picture...");
       return $http({
           url: 'https://aqueous-escarpment-7261.herokuapp.com/images/'+id,
           method: "POST",
           params: {'poster': comment.poster, 'content' : comment.content},
       }).success(function(data, status, headers, config){
           return data;
       }).error(function(data, status, headers, config){
           console.log(status);
       });
   };
   
   this.postPicture = function(name, picture) {
        console.log("Uploading new picture...");

        var fd = new FormData();
        fd.append("file", picture);
        fd.append("name", name);
        
        return $http.post('https://aqueous-escarpment-7261.herokuapp.com/images', fd, {
            withCredentials: true,
            headers: {'Content-Type': undefined },
            transformRequest: angular.identity
        }).success(function(data, status, headers, config) {
            console.log(status);
            return data;
        });
    };
});

