$(document).ready(function () {

    $('.leaveg').click(leavegClick);

    $('.joing').click(function (e) {
        e.preventDefault();
        $.ajax({
            url: "joingroup",
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
                    'userID': $('#userID').val(),
                    'update' : inputElement.val()
                },
                success: function(result){
                    inputElement.prop("disabled",true);
                    $(this).html("<span class='mif-pencil'></span> Edit");
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