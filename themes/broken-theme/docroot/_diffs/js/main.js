AUI().ready(
	'aui-io-plugin-deprecated', 'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var siteBreadcrumb = A.one('#breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}

		A.getBody().delegate('click', eventHanler, 'a.logo');

		var eventHandler function(event) {
			event.preventDefault();
			alert(event.currentTarget.attr('title'));
		}

		var signIn = A.one('li.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}

		A.one('#footer').delegate(
			'click',
			function(event) {
				event.preventDefault();

				Liferay.Util.openInDialog(event);
			},
			'a'
		);

		if (!Liferay.ThemeDisplay.isSignedIn()) {
			siteBreadcrumbs.delegate(
				'click',
				function(event) {
					event.preventDefault();

					Liferay.Util.openWindow(
						{
							dialog: {
								height: 390,
								width: 560
							},
							title: Liferay.Language.get('sign-in')
						},
						function(dialogWindow) {
							dialogWindow.bodyNode.plug(
								A.Plugin.IO,
								{
									data: {
										doAsUserId: themeDisplay.getDoAsUserIdEncoded(),
										p_l_id: themeDisplay.getPlid(),
										p_p_id: 58,
										p_p_state: 'exclusive'
									},
									uri: themeDisplay.getPathMain() + '/portal/render_portlet'
								}
							);
						}
					);
				},
				'a'
			);
		}
	}
);