$(document).ready(function () {
    $('.pedit').click(function () {
        $("section").load("profile_edit?userEmail="+$('#userEmail').val());
        $("section").addClass("profileEditSection");
    });
});