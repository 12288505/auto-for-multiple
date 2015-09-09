package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4203_FenLeiHangQing {

	private UP_API up;

	@Test
	public void test_4203() {

		up = new UP_API();
		// up.Test4203Protocol();
		up.getSocketBody(4203);
		// 接下来解析这个字符串的正确性
		for (int i = 1; i < 42; i++) {
			// if( i == 6 )
			// continue ;
			// if( i == 12)
			// continue ;
			// if( i == 13)
			// continue ;
			// if( i >= 17 && i <= 19 )
			// continue ;
			//
			// if( i >= 26 && i <= 33 )
			// continue ;
			// if( i >= 35 && i <= 38 )
			// continue ;
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
