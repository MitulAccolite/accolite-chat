$(document).ready(function () {
    $('.pedit').click(function () {
        $("section").load("profile_edit?user="+$('#userEmail').val());
        $("section").addClass("profileEditSection");
    });
});