package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_1802_DanZhiGuPiaoZiJinLiu {

	private UP_API up;

	@Test
	public void Test_1802() {

		up = new UP_API();
		// up.Test1802Protocol() ;
		up.getSocketBody(1802);
		for (int i = 1; i < 14; i++) {
			 if( i == 5 ){
			 continue ;
			 }
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
