package testcase.UP_China.API.Mobile.Http;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_13_BohaiZhiBo {

	private UP_API up;

	/**
	 * 接口名称：实盘直播首页直播大厅20条数据
	 * 接口地址：http://app.upchina.com/news/analystlive/analystlivejson.html
	 * 用途：在后台添加数据直接生成静态数据，能使前台页面加载速度提高，避免因数据库查询量大而影响用户体验。(首页第一次读取数据可调用此接口)
	 */

	@Test
	public void test010() {

		up = new UP_API("http://app.upchina.com", "GET");
		up.log("开始测试：渤海直播");
		String path = up.getApiPath("渤海直播");

		up.path(path);

		up.sendRequest();

		up.assertJsonBody("LiveId");
		up.assertJsonBody("LiveType");
		up.assertJsonBody("ActualName");
		up.assertJsonBody("ActualCode");
		up.assertJsonBody("TransPrice");
		up.assertJsonBody("TransType");
		up.assertJsonBody("StopProfit");
		up.assertJsonBody("StopLoss");
		up.assertJsonBody("CreateTime");
		up.assertJsonBody("AnalystId");
		up.assertJsonBody("AnalystName");
		up.assertJsonBody("Info");
		up.assertJsonBody("ImgUrl");
		up.assertJsonBody("LinkUrl");
		up.assertJsonBody("BuyLiveId");
		up.assertJsonBody("ProfitRate");
		up.assertJsonBody("IsSell");
		up.assertJsonBody("SuccessRate");
		up.assertJsonBody("FansNum");
		up.assertJsonBody("Intro");
		up.assertJsonBody("AnalystImg");
		up.assertJsonBody("ShowTime");

	}
}
