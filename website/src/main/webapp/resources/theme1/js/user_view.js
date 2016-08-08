$(document).ready(function () {
    $('.pedit').click(function () {
        $("section").load("profile_edit");
        $("section").addClass("profileEditSection");
    });
});