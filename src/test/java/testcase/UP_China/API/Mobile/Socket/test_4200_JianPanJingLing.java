package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4200_JianPanJingLing {

	private UP_API up;

	@Test
	public void Test_4200() {

		up = new UP_API();
		// up.Test4200Protocol() ;
		up.getSocketBody(4200);

		for (int i = 1; i < 4; i++) {
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
