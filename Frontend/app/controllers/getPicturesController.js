LeLGurApp.controller('GetPicturesController', function($scope, APIService, $location) {
    console.log('Getting pictures...');
    $scope.message = "Loading pictures...";
    APIService.getAllPictures().success(function(pictures) {
        console.log("success fetching all pictures!");
        $scope.pictures = pictures; 
        $scope.message = "";
        $scope.nrOfPictures = $scope.pictures.length;
    });
    
    $scope.postPicture = function(files) {
        $scope.message = "Uploading picture...";
        APIService.postPicture($scope.pictureName, files[0]).success(function(picture) {
            console.log("success uploading picture!");
            $location.path("/pictures/"+picture.id);
        });
    };
});

