package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4201_ReMenMuBan {

	private UP_API up;

	@Test
	public void test_4201() {

		up = new UP_API((short) 4201, "882059");
		// up.Test4201Protocol();
		up.getSocketBody(4201);
		// 接下来解析这个字符串的正确性
		for (int i = 1; i < 15; i++) {
			up.assertJsonBody(String.valueOf(i));
		}
	}

}
