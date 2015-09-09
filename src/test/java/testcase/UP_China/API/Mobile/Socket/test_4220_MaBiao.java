package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4220_MaBiao {

	private UP_API up;

	@Test
	public void Test_4220() {

		up = new UP_API();
		// up.Test4220Protocol();
		up.getSocketBody(4220);
		for (int i = 1; i < 4; i++) {
			// if( i >= 1 && i <= 3){
			// continue ;
			// }
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
