AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal', 'aui-modal', 'aui-node', 'aui-io-request',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var siteBreadcrumbs = A.one('#breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}

		A.getBody().delegate('click', eventHandler, 'a.logo');

		var eventHandler = function(event) {
			event.preventDefault();
			alert(event.currentTarget.attr('title'));
		}

		var signIn = A.one('li.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}

		var footer = A.one('p.powered-by a');

		if (footer) {
			var liferayPopup = '<iframe src="http://www.liferay.com" style="height: 100%; width: 100%; z-index: 999;"></iframe>';

			footer.on('click', 
				function(event) {
					event.preventDefault();

					var windowHeight = window.innerHeight,
						windowWidth = window.innerWidth,
						height = (windowHeight * 0.75),
						width = (windowWidth * 0.75);

					var modal = new A.Modal(
						{
						bodyContent: liferayPopup,
						centered: true,
						height: height,
						render: '#popup-modal',
						width: width
						}
					).render();
				}
			);
		}

		if (themeDisplay.isSignedIn() !== true) {
			var signinBreadcrumb = A.one('.breadcrumb li a');

			if (signinBreadcrumb) {

				signinBreadcrumb.on('click', 
					function(event) {
						event.preventDefault();

						var signIn = A.io.request(
							'http://localhost:8080/c/portal/login',
							{
								on: {
									'success': function() {
										var signinPopup = this.get('responseData');

										var modal = new A.Modal(
											{
											bodyContent: signinPopup,
											centered: true,
											height: 750,
											render: '#breadcrumb-modal',
											width: 750
											}
										).render();
									}
								}
							}
						);
					}
				);
			}
		}
	}
);