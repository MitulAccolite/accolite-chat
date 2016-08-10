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
        var addition=$('.chatbox ul').html();
        for(var i=0;i<message.length;i++){
            var date=new Date(message[i].created);
            addition+='<li class="msg-body">'+
            '<div class="dp-container">'+
            '<a href="/profileView?user='+message[i].user.email+'"><img src="/resources/theme1/img/placeholder.jpg" width="32" height="32" alt="user nickname"></a>'+
            '</div>'+
            '<div class="msg-container">'+
            '<div class="msg-timestamp">'+
            '<abbr title="Today" >'+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds()+'</abbr>'+
            '</div>'+
            '<strong>'+
            '<a href="/profileView?user='+message[i].user.email+'">'+message[i].user.nickName+'</a>'+
            '</strong>'+
            '<div class="message">'+
            '<p>'+message[i].message+'</p>'+
            '</div>'+
            '</div>'+
            '</li>'
        }
        $('.chatbox ul').html(addition);
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
                groupID: $('#groupID').val()
            },
            success: function(result){
                this.disabled=false;
                $('.chattext').val("");
                // $.Topic('updateChatbox').publish(result);
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
            data: {
                'user': $('#userEmail').val(),
                'groupID' : $('#groupID').val(),
                'lastUpdated': lastUpdated
            },
            success: function(result){
                lastUpdated=new Date().getTime();
                // console.log(result['mmessages']);
                $.Topic('updateChatbox').publish(result["messages"]);
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
            data: {
                'user': $('#userEmail').val(),
                'groupID' : $('#groupID').val(),
                'lastUpdated': lastUpdated
            },
            success: function(result){
                lastUpdated=new Date().getTime();
                spinnerSpan.removeClass("mif-spinner5");
                spinnerSpan.removeClass("mif-ani-spin");
                // console.log(result['mmessages']);
                $('.chatbox ul').html("");
                $.Topic('updateChatbox').publish(result["messages"]);
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