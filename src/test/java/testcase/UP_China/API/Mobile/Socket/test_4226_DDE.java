package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4226_DDE {

	private UP_API up;

	@Test
	public void Test4226() {

		up = new UP_API();
		// up.Test4226Protocol() ;
		up.getSocketBody(4226);
		for (int i = 1; i < 16; i++) {
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
