package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4223_DuoGuZiJinLiu {

	private UP_API up;

	@Test
	public void Test4223() {

		up = new UP_API();
		// up.Test4223Protocol() ;
		up.getSocketBody(4223);
		for (int i = 1; i < 14; i++) {
			// 返回数据段没有字段5 正常
			if (i == 5) {
				continue;
			}
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
