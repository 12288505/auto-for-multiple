package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4212_ZuHeHangQing2 {

	private UP_API up;

	@Test
	public void test_4212() {

		up = new UP_API();
		// up.Test4206Protocol() ;
		up.getSocketBody(4212);
		for (int i = 1; i < 12; i++) {
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
