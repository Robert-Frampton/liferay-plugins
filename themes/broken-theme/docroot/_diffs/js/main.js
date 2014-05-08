AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal', 'aui-io-request', 'node','aui-modal',
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


		var crumbSignIn = function(event) {
			event.preventDefault();
			
			var crumbSignIn = A.io.request(
				'http://localhost:8080/web/guest/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Flogin',
				{
					on: {
						success: function() {
							var responseData = this.get('responseData');

							var signInModal = new A.Modal(
							{
								bodyContent: responseData,
								centered: true,
								height: 790,
								modal: true,
								render: '#signInModal',
								width: 590
							}
							).render();
						}
					}
				}
			);
		}
	A.getBody().delegate ('click', eventHandler, siteBreadcrumbs);

	}
);