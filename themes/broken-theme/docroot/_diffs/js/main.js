AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'aui-io-request', 'node', 'aui-modal',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var siteBreadcrumbs = A.one('#breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}

		A.getBody().delegate('click', eventHanler, 'a.logo');

		var eventHandler function(event) {
			event.preventDefault();
			alert(event.currentTarget.attr('title'));
		}

		A.io.request(
			'',
			{
				dataType: 'json',
				on: {
					success: function() {
						var data = this.get('responseData');
						alert(data);
					}
				}
			}
		);

		var signinModal = new A.Modal(
			{
				bodyContent: '<iframe src="http://localhost:8080/c/portal/login?p_l_id=10190"></iframe>',
				centered: true,
				modal: true,
				render: '#signinModal',
			}
			).render();
	}
);