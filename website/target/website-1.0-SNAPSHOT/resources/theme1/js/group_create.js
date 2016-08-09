$(document).ready(function () {
    $('.gentry').click(function (e) {
        e.preventDefault();
        if($(this).hasClass("mif-user-minus")){
            $(this).removeClass("mif-user-minus");
            $(this).addClass("mif-user-plus");
        }else{
            $(this).removeClass("mif-user-plus");
            $(this).addClass("mif-user-minus");
        }
    });
});