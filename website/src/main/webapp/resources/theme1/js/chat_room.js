var topics = {};
var lastUpdated=new Date().getTime();

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
            async:false,
            url: "tweet",
            method: 'POST',
            context: $('.sender'),
            data: {
                message: $('.chattext').val(),
                userID: $('#userID').val(),
                created: new Date().getTime(),
                groupID: $('#groupID').val()
            },
            success: function(result){
                this.disabled=false;
                $('.chattext').html("");
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
            $('.gsettings span').addClass("mif-cog");
        },
        function () {
            $('.gsettings span').removeClass("mif-cog");
        }
    );

    $('.grouplist li a').click(function (e) {
        e.preventDefault();
        $('.gloader').addClass("mif-spinner5");
        $('.gloader').addClass("mif-ani-spin");
    });
});