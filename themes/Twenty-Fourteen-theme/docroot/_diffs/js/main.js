AUI().ready(
	'aui-toggler', 'liferay-sign-in-modal',
	function(A) {
		new A.Toggler(
		{
		container: '#searchToggler',
		content: '.content-toggler',
		expanded: false,
		header: '.header-toggler'
		}
		);

		var signIn = A.one('li.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}
	}

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);