package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4206_FenXiShuJu {

	private UP_API up;

	@Test
	public void test_4206() {

		up = new UP_API();
		// up.Test4206Protocol() ;
		up.getSocketBody(4206);

		for (int i = 1; i < 14; i++) {
			up.assertJsonBody(String.valueOf(i));
		}

	}
}
