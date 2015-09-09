package testcase.UP_China.API.Mobile.Http;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_06_QiHuo {

	private UP_API up;

	/**
	 * 期货
	 * 接口地址：
	 * http://app.0135135.com/information/actuals/mobilespotcontent.php
	 * 
	 * 参数：
	 * id：栏目分类id
	 * u：创建时间
	 */

	@Test(enabled = false)
	public void test010() {

		up = new UP_API("http://api.0135135.com", "GET");
		up.log("开始测试：行情资讯-期货");
		String path = up.getApiPath("行情资讯-期货");

		up.path(path);
		up.param("id", "");
		up.param("u", up.getYeasterdayDate());

		up.sendRequest();

		up.assertJsonBody("t");
		up.assertJsonBody("s");
		up.assertJsonBody("c");
		up.assertJsonBody("d");

	}
}
