AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal', 'aui-io-request', 'node','aui-modal', 'liferay-portlet-url',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var siteBreadcrumbs = A.one('#breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}

		var signIn = A.one('li.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}

		var eventHandler = function(event) {
			event.preventDefault();
			alert(event.currentTarget.attr('title'));
		}

		A.getBody().delegate('click', eventHandler, 'a.logo');

		function createLoginURL(){
			var loginURL = new Liferay.PortletURL();
			loginURL.setPortletId('58');
			loginURL.setWindowState('pop_up');

			return loginURL.toString();
		}

		var crumbSignIn = function(event) {
			event.preventDefault();

			var crumbSignIn = A.io.request(
				createLoginURL(),
				{
					on: {
						success: function() {
							var responseData = this.get('responseData');

							var signInModal = new A.Modal(
							{
								bodyContent: responseData,
								centered: true,
								headerContent: '<h5>Sign In</h5>',
								height: 480,
								modal: true,
								render: '#signInModal',
								width: 300
							}
							).render();
						}
					}
				}
			);
		}

		siteBreadcrumbs.on('click', crumbSignIn);

		var footerLink = function(event) {
			event.preventDefault();

			var footerModal = new A.Modal (
			{
				bodyContent: '<iframe src="http://www.liferay.com" height="100%" width="100%" overyflow-y: "hidden" />',
				centered: true,
				height: 800,
				modal: true,
				render: '#footerModal',
				width: 1200
			}
			).render();
		}

		var siteFooter = A.one('#footer');
		siteFooter.on('click', footerLink)

	}
);