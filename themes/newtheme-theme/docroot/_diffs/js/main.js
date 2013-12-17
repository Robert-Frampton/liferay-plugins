
AUI().ready(
	'liferay-sign-in-modal',
	function(A) {
		var signIn = A.one('.footer-block #sign-in');
		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}
	}
);