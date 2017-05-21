jQuery(document).ready(function($) {
	showMeYourCookies('When index document is ready');

	$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/web/arthub/user'

	}).done(function (data, textStatus, jqXHR) {
		showMeYourCookies('When GET /arthub/user is done');
		
		$('#test').html(data.message);

	}).fail(function (jqXHR, textStatus, errorThrown) {
		showMeYourCookies('When GET /arthub/user fails');

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			var cookie = JSON.stringify({method: 'GET', url: 'file:///C:/Users/benis/OneDrive/Documents/InformationSystems/ArtHub-Site/index.html'});
			Cookies.set('arthub', cookie);
			window.location = 'login.html';

		} else {
			console.error('Houston, we have a problem...');
		}
	});
});