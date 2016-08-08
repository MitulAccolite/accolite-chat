var leavegClick = function (e) {
    e.preventDefault();
    $.ajax({
        url: "leavegroup",
        method: 'POST',
        data: {
            'groupID': $('#groupID').val(),
            'userID' : $(this).parent().children(".userID").val()
        },
        success: function(result){
            $(this).parent().parent().remove();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus+": "+errorThrown);
        }
    });
}
$(document).ready(function () {

    $('.gedit').click(function () {
        $("section").load("group_edit");
        $("section").addClass("groupEditSection");
    });

    $('.leaveg').click(leavegClick);
});