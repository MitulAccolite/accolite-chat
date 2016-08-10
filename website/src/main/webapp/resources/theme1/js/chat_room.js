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
    $.Topic('updateActiveUsers').subscribe(function (users) {
        console.log(users);
        var activeUsers="";
        if(users==undefined)return;
        for(var i=0;i<users.length;i++){
            activeUsers+='<li>'+
                '<a href="profileView?user='+users[i].emailID+'">'+
                '<img src="/resources/theme1/img/placeholder.jpg" width="38" height="38" alt="nick name">'+
                '<span class="nickname">'+users[i].nickName+'</span>'+
                '<span class="onlinestatus ';
            if(users[i].active||users[i].active=="true")
                activeUsers+="online";
            activeUsers+='"></span>'+
                '</a>'+
                '</li>'
        }
        $('.userpan ul').html(activeUsers);
    });
    $.Topic('updateGroup').subscribe(function (groups) {
        console.log(groups);
        var userGroups="";
        if(users==undefined)return;
        for(var i=0;i<groups.length;i++){
            userGroups+='<li>'+
                '<div class="gsettings">'+
                '<a href="groupView?groupID='+groups[i].groupId+'&userEmail='+$('#userEmail').val()+'"><span></span></a>'+
                '</div>'+
                '<a href="#">'+
                '<img src="/resources/theme1/img/placeholder.jpg" width="20" height="20" alt="group name">'+
                '<span class="gname">'+groups[i].groupName+'</span>'+
                '<span class="gloader"></span>'+
                '<input type="hidden" value='+groups[i].groupId+' class="groupID">'+
                '</a>'+
                '</li>';
        }
        $('.userpan ul').html(activeUsers);
    });
    $.Topic('updateChatbox').subscribe(function (message) {
        console.log(message);
        var addition=$('.chatbox ul').html();
        for(var i=0;i<message.length;i++){
            var date=new Date(message[i].created);
            addition+='<li class="msg-body">'+
            '<div class="dp-container">'+
            '<a href="/profileView?user='+message[i].email+'"><img src="/resources/theme1/img/placeholder.jpg" width="32" height="32" alt="user nickname"></a>'+
            '</div>'+
            '<div class="msg-container">'+
            '<div class="msg-timestamp">'+
            '<abbr title="Today" >'+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds()+'</abbr>'+
            '</div>'+
            '<strong>'+
            '<a href="/profileView?user='+message[i].email+'">'+message[i].nickName+'</a>'+
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
                $.Topic('updateActiveUsers').publish(result["activeUsers"]);
                $.Topic('updateGroup').publish(result["groups"]);
                $.Topic('updateChatbox').publish(result["messages"]);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(textStatus+": "+errorThrown);
                $(this).prop('disabled',false);
            }
        });
    });


    // (function pollGroup() {
    //     $.ajax({
    //         url: "pollGroup",
    //         method: 'GET',
    //         data: {
    //             'user': $('#userEmail').val()
    //         },
    //         success: function(result){
    //             $.Topic('updateGroup').publish(result["groups"]);
    //             var timeout=($(".chattext").is(":focus"))?5000:10000;
    //             setTimeout(function () {
    //                 pollGroup();
    //             },timeout);
    //         },
    //         error: function (jqXHR, textStatus, errorThrown) {
    //             console.log(textStatus+": "+errorThrown);
    //             var timeout=($(".chattext").is(":focus"))?5000:10000;
    //             setTimeout(function () {
    //                 pollGroup();
    //             },timeout);
    //         }
    //     });
    // })();
    //
    //
    // (function pollActiveUsers() {
    //     $.ajax({
    //         url: "pollActiveUsers",
    //         method: 'GET',
    //         success: function(result){
    //             $.Topic('updateActiveUsers').publish(result["activeUsers"]);
    //             var timeout=($(".chattext").is(":focus"))?5000:10000;
    //             setTimeout(function () {
    //                 pollActiveUsers();
    //             },timeout);
    //         },
    //         error: function (jqXHR, textStatus, errorThrown) {
    //             console.log(textStatus+": "+errorThrown);
    //             var timeout=($(".chattext").is(":focus"))?5000:10000;
    //             setTimeout(function () {
    //                 pollActiveUsers();
    //             },timeout);
    //         }
    //     });
    // })();


    (function poll() {
        $.ajax({
            url: "poll",
            method: 'POST',
            dataType: 'json',
            data: {
                'user': $('#userID').val(),
                'groupID' : $('#groupID').val(),
                'lastUpdated': lastUpdated
            },
            success: function(result){
                if(lastUpdated==-1)
                    $('.chatbox ul').html("");
                lastUpdated=new Date().getTime();
                $.Topic('updateActiveUsers').publish(result["activeUsers"]);
                $.Topic('updateGroup').publish(result["groups"]);
                $.Topic('updateChatbox').publish(result["messages"]);
                var timeout=($(".chattext").is(":focus"))?10000:20000;
                setTimeout(function () {
                    poll();
                },timeout);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus+": "+errorThrown);
                var timeout=($(".chattext").is(":focus"))?10000:20000;
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
        var spinnerSpan=$(this).children('.gloader');
        spinnerSpan.addClass("mif-spinner5");
        spinnerSpan.addClass("mif-ani-spin");
        $("#groupID").val($(this).children('.groupID').val());
        $.ajax({
            url: "getGroup",
            method: 'POST',
            dataType: 'json',
            data: {
                'user': $('#userID').val(),
                'groupID' : $('#groupID').val(),
            },
            success: function(result){
                spinnerSpan.removeClass("mif-spinner5");
                spinnerSpan.removeClass("mif-ani-spin");
                $('.chatbox ul').html("");
                $.Topic('updateActiveUsers').publish(result["activeUsers"]);
                $.Topic('updateGroup').publish(result["groups"]);
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