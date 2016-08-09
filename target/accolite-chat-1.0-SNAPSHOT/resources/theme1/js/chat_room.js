var topics = {};
var lastUpdated=-1;

jQuery.Topic = function( id ) {
    var callbacks, method,
        topic = id && topics[ id ];

    if ( !topic ) {
        callbacks = jQuery.Callbacks();
        topic = {
            publish: callbacks.fire,
            subscribe: callbacks.add,
            unsubscribe: callbacks.remove
        };
        if ( id ) {
            topics[ id ] = topic;
        }
    }
    return topic;
};

$( document ).ready(function() {
    $.Topic('updateChatbox').subscribe(function (message) {
        console.log(message);
    });
    $('.sender').click(function () {
        $(this).prop('disabled',true);
        $.ajax({
            url: "sendMessage",
            method: 'POST',
            context: $('.sender'),
            data: {
                message: $('.chattext').val(),
                userID: $('#userID').val(),
                userEmail:$('#userEmail').val(),
                created: new Date().getTime(),
               // groupID: $('#groupID').val()
                groupID: 1
            },
            success: function(result){
                this.disabled=false;
                $('.chattext').val("");
                $.Topic('updateChatbox').publish(result);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(textStatus+": "+errorThrown);
                $(this).prop('disabled',false);
            }
        });
    });
    (function poll() {
        $.ajax({
            url: "poll",
            method: 'GET',
            dataType: 'json',
            data: {
                'userID': $('#userID').val(),
                'groupID' : $('#groupID').val(),
                'lastUpdated': lastUpdated
            },
            success: function(result){
                lastUpdated=new Date().getTime();
                $.Topic('updateChatbox').publish(result);
                var timeout=($(".chattext").is(":focus"))?5000:10000;
                setTimeout(function () {
                    poll();
                },timeout);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus+": "+errorThrown);
                var timeout=($(".chattext").is(":focus"))?5000:10000;
                setTimeout(function () {
                    poll();
                },timeout);
            }
        });
    })();

    $('.grouplist li').hover(
        function () {
            $(this).find('.gsettings span').addClass("mif-cog");
        },
        function () {
            $(this).find('.gsettings span').removeClass("mif-cog");
        }
    );

    $('.grouplist li>a').click(function (e) {
        e.preventDefault();
        lastUpdated=-1;
        var spinnerSpan=$(this).children('.gloader');
        spinnerSpan.addClass("mif-spinner5");
        spinnerSpan.addClass("mif-ani-spin");
        $("#groupID").val($(this).children('.groupID').val());
        $.ajax({
            url: "poll",
            method: 'GET',
            dataType: 'json',
            data: {
                'userID': $('#userID').val(),
                'groupID' : $('#groupID').val(),
                'lastUpdated': lastUpdated
            },
            success: function(result){
                lastUpdated=new Date().getTime();
                spinnerSpan.removeClass("mif-spinner5");
                spinnerSpan.removeClass("mif-ani-spin");
                $.Topic('updateChatbox').publish(result);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus+": "+errorThrown);
            }
        });
    });

    $('.gadd').click(function () {
        var form = $("<form/>",{ action:'group_create',method:'POST'});
        var userMail = $("<input>",{name:"user",type:"text",value:$("#userEmail").val()});
        form.append(userMail);
        $("body").append(form);
        form.submit();
    });
});