package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4213_FenLeiHangQing2 {

	private UP_API up;

	@Test
	public void Test_4213() {

		up = new UP_API();
		// up.Test4213Protocol() ;
		up.getSocketBody(4213);
		for (int i = 1; i < 16; i++) {
			//
			// if( i >= 11 && i <= 13)
			// continue ;
			//
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
