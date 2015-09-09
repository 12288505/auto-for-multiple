package testcase.UP_China.API.Mobile.Http;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_15_FenXiShiZhiBo {

	private UP_API up;

	/**
	 * 接口名称：取某一个分析师的直播数据
	 * 接口地址：http://app.upchina.com/sasweb/xysidkdydnhensydn_cdhds.dyshg/dsfyewlrndsfpoidsfewlkdsnf.cxgdsf_hdsfnew_gz/
	 * analystlive/getmobileanalystlist.aspx?top=20&analystId=103&vipType=0
	 * 用途：取某一个分析师的直播数据
	 * 输入参数：top:取多少条数据
	 * analystId : 分析师ID
	 * vipType:默认为0为普通版 1白金版 2，钻石版，3至尊版，4，银利阁 5，淘金殿
	 */

	@Test
	public void test010() {

		up = new UP_API("http://app.upchina.com", "GET");
		String path1 = up.getApiPath("渤海直播");

		up.path(path1);
		up.param("page", "1");
		up.param("rows", "20");
		up.param("livetype", "0");
		up.param("analystType", "1");

		up.sendRequest();
		String analystId = up.getJsonValue("AnalystId");

		up = new UP_API("http://app.upchina.com", "GET");
		up.log("开始测试：指定分析师直播");
		String path = up.getApiPath("指定分析师直播");

		up.path(path);
		up.param("top", "20");
		up.param("analystId", analystId);
		up.param("vipType", "0");

		up.sendRequest();

		up.assertJsonBody("FansNum");
		// up.assertJsonBody("Notice");
		up.assertJsonBody("Intro");
		up.assertJsonBody("AnalystImg");
		up.assertJsonBody("ShowTime");
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
		// up.assertJsonBody("BuyLiveId");
		up.assertJsonBody("ProfitRate");
		// up.assertJsonBody("IsSell");

	}
}
