AUI().ready(
	function(A) {
		var win = A.getWin();
		var welcomePage = A.one('#page-welcome');
		var dockbar = A.one('.dockbar');

		var welcomePageHeight = win.get('innerHeight') - dockbar.get('offsetHeight');

		welcomePage.setStyle('height', welcomePageHeight);
	}
);