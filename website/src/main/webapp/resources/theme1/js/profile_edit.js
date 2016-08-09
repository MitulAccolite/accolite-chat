$(document).ready(function () {
    $('.groupedit li').hover(
        function () {
            $(this).find('.gsettings span').addClass("mif-cog");
        },
        function () {
            $(this).find('.gsettings span').removeClass("mif-cog");
        }
    );

    $('.leaveg').click(function (e) {
        e.preventDefault();
        $.ajax({
            url: "leavegroup",
            method: 'POST',
            data: {
                'userID': $('#userID').val(),
                'groupID' : $(this).parent().children(".groupID").val()
            },
            success: function(result){
                $(this).parent().parent().remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus+": "+errorThrown);
            }
        });
    });

    $('.edit').click(function (e) {
        e.preventDefault();
        var inputElement =$(this).parent().children("input");
        if(/save/.test($(this).html())){
            var param=inputElement.attr("name");
            $.ajax({
                url: "update_"+param,
                method: 'POST',
                data: {
                    'user': $('#userEmail').val(),
                    'update' : inputElement.val()
                },
                success: function(result){
                    inputElement.prop("disabled",true);
                    $('.edit').html("<span class='mif-pencil'></span> Edit");
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus+": "+errorThrown);
                }
            });
        }else{
            inputElement.prop("disabled",false);
            $(this).html("save <span class='mif-thumbs-up'></span>");
        }
    });
});