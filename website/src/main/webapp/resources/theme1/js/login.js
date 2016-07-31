function notifyOnErrorInput(input){
	var message = input.data('validateHint');
	$.Notify({
		caption: 'Error',
		content: message,
		type: 'alert'
	});
}
$( document ).ready(function() {
	var form = $(".login-form");

    form.css({
        opacity: 1,
        "-webkit-transform": "scale(1)",
        "transform": "scale(1)",
        "-webkit-transition": ".5s",
        "transition": ".5s"
    });
    
    $('.button.register').click(function(){
    	$("section").load("register.jsp");
    	$("section").addClass("register");
    });
});