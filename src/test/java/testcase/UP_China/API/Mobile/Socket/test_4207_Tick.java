package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4207_Tick {

	private UP_API up;

	@Test
	public void test_4207() {

		up = new UP_API();
		// up.Test4207Protocol() ;
		up.getSocketBody(4207);

		for (int i = 1; i < 8; i++) {
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
