$(document).ready(function () {

    $('.gentry').click(groupEntry);

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
                    'groupID':$('#groupID').val(),
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