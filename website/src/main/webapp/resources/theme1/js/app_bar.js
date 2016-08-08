$( document ).ready(function() {
    $('.logout').click(function (e) {
        e.preventDefault();
        var form = $("<form/>",{ action:'logout?user='+$('#userEmail').val(),method:'POST'});
        $("body").append(form);
        form.submit();
    });
    $('.userhandle').click(function (e) {
        e.preventDefault();
        var form = $("<form/>",{ action:'userprofile?user='+$('#userEmail').val(),method:'POST'});
        $("body").append(form);
        form.submit();
    });
});