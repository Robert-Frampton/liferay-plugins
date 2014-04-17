AUI().ready(
	'aui-io-request','aui-node','liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var siteBreadcrumbs = A.one('#breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}

		var modal = new A.Modal (
			{
				bodyContent: '<iframe src="http://localhost:8080/web/guest/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Flogin" style="height:100%;width:100%" />',
				centered: true,
				destroyOnHide: false,
				headerContent: '<h3>Sign In</h3>',
				modal: true,
				render: '#modal',
				visible: false,
			}
		).render();

		A.one('#showModal').on(
			'click',
			function() {
				modal.show();
			});
		}
);