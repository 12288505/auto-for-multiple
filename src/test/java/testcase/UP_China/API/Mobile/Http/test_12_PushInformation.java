package testcase.UP_China.API.Mobile.Http;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_12_PushInformation {

	private UP_API up;

	/**
	 * 五、 推送消息资讯正文
	 * 接口地址：
	 * http://api.0135135.com/uprest/mobilepush/getmobileinfocontent
	 * 
	 * 参数：
	 * id：消息id
	 * baiduId：百度用户id
	 */

	@Test(enabled = false)
	public void test010() {

		up = new UP_API("http://api.0135135.com", "GET");
		up.log("开始测试：推送消息资讯正文");
		String path = up.getApiPath("推送消息资讯正文");

		up.path(path);
		up.param("id", "");
		up.param("baiduId", "");

		up.sendRequest();

		up.assertJsonBody("InfoId");
		up.assertJsonBody("Title");
		up.assertJsonBody("Author");
		up.assertJsonBody("CreatedTime");
		up.assertJsonBody("InfoType");
		up.assertJsonBody("InfoContent");

	}
}
