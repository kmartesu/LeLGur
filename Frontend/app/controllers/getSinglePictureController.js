LeLGurApp.controller('GetSinglePictureController', function($scope, APIService, $routeParams) {
    console.log('Getting single picture...');
    $scope.message = "Loading picture...";
    APIService.getSinglePicture($routeParams.id).success(function(picture) {
        console.log("success fetching a specific picture!");
        $scope.picture=picture; 
        $scope.comments=picture.comments;
        $scope.message = "";
        $scope.nrOfComments = $scope.comments.length;
    });
    
    $scope.postComment = function() {
        APIService.postComment($scope.comment ,$routeParams.id).success(function(comment) {
           console.log("success posting comment..."); 
           $scope.comments.push(comment);
           $scope.nrOfComments = $scope.comments.length;
        });
    };
});

