package testcase.UP_China.API.Mobile.Http;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_03_masterInformation {

	private UP_API up;

	/**
	 * 接口地址：
	 * http://api.0135135.com/uprest/topic/getcontent
	 * 参数：
	 * type：1、高手策略，2、高手藏金阁
	 * createdTime：创建时间
	 * 返回Json：
	 * Author：来源
	 * Content：正文内容
	 * Author2：
	 */

	@Test
	public void test010() {

		up = new UP_API("http://api.0135135.com", "GET");
		up.log("开始测试：高手藏金阁资讯");
		String path = up.getApiPath("高手藏金阁资讯");
		String date = up.getYeasterdayDate();
		up.path(path);
		up.param("type", "2");
		up.param("createdTime", date);

		up.sendRequest();

		up.assertJsonBody("Author");
		up.assertJsonBody("Content");
		up.assertJsonBody("Author2");

	}
}
