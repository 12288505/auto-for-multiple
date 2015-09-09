package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4225_ZiJin {

	private UP_API up;

	@Test
	public void Test_4225() {

		up = new UP_API();
		// up.Test4225Protocol() ;
		up.getSocketBody(4225);
		for (int i = 1; i < 19; i++) {
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
