AUI().ready(
	'aui-modal', 'aui-dialog-iframe-deprecated', 'aui-io-plugin-deprecated', 'liferay-util-window', 'aui-base', 'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var siteBreadcrumbs = A.one('#breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}

		var eventHandler = function(event) {
			event.preventDefault();
			alert(event.currentTarget.attr('title'));
		}

		A.getBody().delegate('click', eventHandler, 'a.logo');

		var signIn = A.one('li.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}

		var poweredByLink = A.one('#poweredByLink');

		// Liferay.provide (
		// 	window,
		// 	'popup',
		// 	function() {
		// 		var A = AUI();
		// 		var portletURL = 'https://www.liferay.com/';
		// 		var dialog = new A.Dialog (
		// 			{
		// 				destroyOnClose: true,
		// 				modal: false,
		// 				title: 'Liferay',
		// 				width: 900
		// 			}
		// 		).plug(
		// 			A.Plugin.IO,
		// 				{
		// 					uri: portletURL.toString()
		// 				}
		// 		).render();
		// 	}
		// 	['aui-base', 'aui-io-plugin-deprecated', 'aui-dialog-iframe-deprecated', 'liferay-util-window']
		// );

		// poweredByLink.on (
		// 	'click',
		// 	function(event) {
		// 		window['popup'];
		// 	}
		// );

		// poweredByLink.on(
		// 	'click',
		// 	function(event) {
		// 		event.preventDefault();

		// 		var winWidth = 750;
		// 		var winHeight = 600;
		// 		var positionLeft = (screen.availWidth/2) - (winWidth/2);
		// 		var positionTop = (screen.availHeight/2) - (winHeight/2);
		// 		var settings = 'height=' + winHeight + ',width=' + winWidth + ',top=' + positionTop + ',left=' + positionLeft + '';
		// 		window.open('https://www.liferay.com/', '_blank', settings);

		// 	}
		// );

		// function popup(url) {
		// 	Liferay.Util.Window.openWindow (
		// 		{
		// 			centered: true,
		// 			constrain2view: true,
		// 			modal: true,
		// 			resizable: true,
		// 			width: 750,
		// 			title: 'http://www.liferay.com'
		// 		}
		// 	).plug(
		// 		A.Plugin.IO,
		// 		{
		// 			uri: url
		// 		}
		// 	).render();
		// }

		function popup(url) {
			Liferay.Util.openWindow (
				{
					dialog: {
						cache: false,
						modal: true,
						resizable: true
					},
					uri: url
				}
			);
		}

		poweredByLink.on(
			'click',
			function(event) {
				event.preventDefault();

				popup('http://www.liferay.com');

		});

		// var modalPopup = new A.Modal (
		// 	{
		// 		bodyContent: 'Modal body,
		// 		centered: true,
		// 		headerContent: 'Modal header',
		// 		render: 'https://www.liferay.com/'
		// 	}
		// ).render();
	}
);