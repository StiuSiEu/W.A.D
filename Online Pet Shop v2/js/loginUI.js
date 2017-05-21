/*jQuery(document).ready(function ($) {
	$('#login').submit(function (event) {
		event.preventDefault();

		showMeYourCookies('At loginform submission');

		var cookie = Cookies.get('arthub');
		console.log(cookie.url);
		var data = 'username=' + $('#username').val() + '&password=' + $('#password').val();
		console.log(data);
		$.ajax({
			data: data,
			timeout: 1000,
			type: 'POST',
			url: 'http://localhost:8080/web/login'

		}).done(function(data, textStatus, jqXHR) {
			showMeYourCookies('When loginform is done');
			
			window.location = 'file:///C:/Users/benis/OneDrive/Documents/InformationSystems/ArtHub-Site/index.html';

		}).fail(function(jqXHR, textStatus, errorThrown) {
			showMeYourCookies('When loginform fails');

			console.error('Booh! Wrong credentials, try again!');
		});
	});
});


/*var doAsyncPost = function (URL, jsonDataToPost) {
	return $.ajax({
		url: URL,
		type: "POST",
		headers: {'X-CSRF-TOKEN': cookie.csrf},
		data: jsonDataToPost,
	});
};
	
function login(){
    var user = 'username=' + $('#username').val() + '&password=' + $('#password').val();
    console.log(user);
	
	showMeYourCookies('At loginform submission');
	var cookie = JSON.parse($.cookie('helloween'));
	
    var request = doAsyncPost("http://localhost:8080/web/login", user);
	request.done(function(data, textStatus, jqXHR) {
		showMeYourJqXHR('When loginform is done', jqXHR);
		showMeYourCookies('When loginform is done');

		window.location = cookie.url;

	});
	
	
}*/