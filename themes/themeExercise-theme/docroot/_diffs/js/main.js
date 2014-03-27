AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal', 'event-hover','transition',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		// var navbar = A.one('.navbar');
		// navbar.addClass('.hidden');

		// // show navbar when hovering over it, otherwise hide it
		// function mouseEnter() {
		// 	navbar.transition('fadeIn');
		// 	navbar.removeClass('.hidden');
		// }
		// function mouseExit() {
		// 	navbar.transition('fadeOut');
		// }
		// navbar.on('hover',mouseEnter, mouseExit);


		var pageHeight = window.innerHeight;
		var pageWidth = window.innerWidth;
		// console.log('inner Height: '+pageHeight);
		// console.log('inner Width: '+pageWidth);

		window.onresize = function() {
			pageHeight = window.innerHeight;
			pageWidth = window.innerWidth;
			// console.log('inner Height: '+pageHeight);
			// console.log('inner Width: '+pageWidth);
		}

		var siteBreadcrumbs = A.one('#breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}

		var signIn = A.one('li.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}
	}
);

