package testcase.UP_China.API.Mobile.Http;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_11_DailyInformation {

	private UP_API up;

	/**
	 * 四、 研究所、高层决策、每日电讯资讯
	 * 接口地址：
	 * http://app.0135135.com/sasweb/xysidkdydnhensydn_cdhds.dyshg/dsfyewlrndsfpoidsfewlkdsnf.cxgdsf_hdsfnew_gz/
	 * AjaxFRInews/GetNewsForMobile.cspx
	 * 
	 * 参数：
	 * id：资讯对应的id
	 */

	@Test(enabled = false)
	public void test010() {

		up = new UP_API("http://app.0135135.com", "GET");
		up.log("开始测试：研究所、高层决策、每日电讯资讯");
		String path = up.getApiPath("研究所、高层决策、每日电讯资讯");

		up.path(path);
		up.param("id", "");

		up.sendRequest();

		up.assertJsonBody("Title");
		up.assertJsonBody("Content");
		up.assertJsonBody("CreatedTime");

	}
}
