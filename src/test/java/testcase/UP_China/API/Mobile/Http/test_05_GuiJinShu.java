package testcase.UP_China.API.Mobile.Http;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_05_GuiJinShu {

	private UP_API up;

	/**
	 * 贵金属
	 * 接口地址：
	 * http://app.0135135.com/information/actuals/mobilespotcontent.php
	 * 
	 * 参数：
	 * id：栏目分类id
	 * u：创建时间
	 */

	@Test(enabled = false)
	public void test010() {

		up = new UP_API("http://app.0135135.com", "GET");
		up.log("开始测试：行情资讯-贵金属");
		String path1 = up.getApiPath("资讯信息列表");

		up.path(path1);
		up.param("bc", "Ag");

		up.sendRequest();
		String id = up.getJsonValue("id");
		String u = up.getJsonValue("c");

		up = new UP_API("http://app.0135135.com", "GET");
		String path = up.getApiPath("行情资讯-贵金属");

		up.path(path);
		up.param("id", id);
		up.param("u", u);

		up.sendRequest();

		up.assertBody("t");
		up.assertBody("s");
		up.assertBody("c");
		up.assertBody("d");
	}
}
