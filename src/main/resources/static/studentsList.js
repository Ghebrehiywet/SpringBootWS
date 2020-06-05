
// For the deleteModalDialog
$(document).ready(function(){
    $("#confirmDeleteBookModal").on("show.bs.modal", function(event){
        const deleteLink = $(event.relatedTarget);
        const bookId = deleteLink.data("bookid");
        const bookISBN = deleteLink.data("bookisbn");
        const bookTitle = deleteLink.data("booktitle");
        const theModalDialog = $(this);
        theModalDialog.find("#deleteModalBookISBN").text("ISBN:  " + bookISBN);
        theModalDialog.find("#deleteModalBookTitle").text("Book Title:  " + bookTitle);
        // Event-handler for the 'Yes' button click event
        $("#deleteModalBtnYes").on("click", function(evt) {
            fetch("https://elibraryrestapi.herokuapp.com/elibrary/api/book/delete/"+bookId, {
                method: "delete"
            }).then(function(response) {
                console.log(`Successfully deleted Book with bookId: ${bookId}`);
                // Dismiss modal dialog
                $("#confirmDeleteBookModal").modal("hide");
                getBooks();
                alertMessageBox.style.display = "inline-block";
            }).catch(function(error) {
                console.error(error);
                alertMessageBox.classList.remove("alert-success");
                alertMessageBox.classList.add("alert-danger");
                alertMessageBox.style.display = "inline-block";
            })
        });
    });
});

var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("https://elibraryrestapi.herokuapp.com/elibrary/api/book/list")
        .then(function (response) {$scope.names = response.data;});
});