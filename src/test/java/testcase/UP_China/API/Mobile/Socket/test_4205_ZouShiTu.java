package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4205_ZouShiTu {

	private UP_API up;

	@Test
	public void test_4205() {

		up = new UP_API();
		// up.Test4205Protocol();
		up.getSocketBody(4205);

		for (int i = 1; i < 11; i++) {
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
