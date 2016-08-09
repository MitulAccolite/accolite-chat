var groupEntry = function (e) {
    e.preventDefault();
    if($(this).hasClass("mif-user-minus")){
        $.ajax({
            url: "leavegroup",
            method: 'POST',
            data: {
                'groupID': $('#groupID').val(),
                'userID' : $(this).parent().children(".userID").val()
            },
            success: function(result){
                $(this).removeClass("mif-user-minus");
                $(this).addClass("mif-user-plus");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus+": "+errorThrown);
            }
        });
    }else{
        $.ajax({
            url: "joingroup",
            method: 'POST',
            data: {
                'groupID': $('#groupID').val(),
                'userID' : $(this).parent().children(".userID").val()
            },
            success: function(result){
                $(this).removeClass("mif-user-plus");
                $(this).addClass("mif-user-minus");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus+": "+errorThrown);
            }
        });
    }
}
$(document).ready(function () {

    $('.gedit').click(function () {
        $("section").load("group_edit?groupID="+$('#groupID').val()+"&userEmail="+$('#userEmail').val());
        $("section").addClass("groupEditSection");
    });

    $('.gentry').click(groupEntry);
});