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

		var eventHandler = function(event) {
			event.preventDefault();
			alert(event.currentTarget.attr('title'));
		}

		A.getBody().delegate('click', eventHandler, 'a.logo');

		var signIn = A.one('li.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}

		var footer = A.one('p.powered-by a');
			href = footer.attr('href')

		if (footer) {
			var liferayPopup = '<iframe src=' + href +' style="height: 100%; width: 100%; z-index: 999;"></iframe>';

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
						width: width,
						zIndex: 10000
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

						var portletURL = Liferay.PortletURL.createURL();
						portletURL.setPortletId(58);
						portletURL.setWindowState('exclusive');

						{
						uri: portletURL.toString();
						}

						var signIn = A.io.request(
							portletURL.toString(),
							{
								on: {
									'success': function() {
										var signinPopup = this.get('responseData');

										var modal = new A.Modal(
											{
											bodyContent: signinPopup,
											centered: true,
											headerContent: 'Sign-in',
											height: 400,
											render: '#breadcrumb-modal',
											width: 500,
											zIndex: 10000
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