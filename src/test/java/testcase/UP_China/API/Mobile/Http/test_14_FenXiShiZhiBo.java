package testcase.UP_China.API.Mobile.Http;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_14_FenXiShiZhiBo {

	private UP_API up;

	/**
	 * 接口名称：分析师直播分页列表
	 * 接口地址：http://app.upchina.com/sasweb/xysidkdydnhensydn_cdhds.dyshg/dsfyewlrndsfpoidsfewlkdsnf.cxgdsf_hdsfnew_gz/
	 * analystlive/mobileanalystliveinfo.aspx?page=1&rows=20&livetype=0&analystType=1
	 * 用途：分析师直播数据接口调用(分页读取数据可调用此接口)
	 * 输入参数：page ：当前页码
	 * row : 当前页码显示条数
	 * livetype : 0 全部直播信息，1开仓、2平仓、3观点
	 * analystType: 1：现货分析师数据，2：贵金属分析师数据
	 */

	@Test
	public void test010() {

		up = new UP_API("http://app.upchina.com", "GET");
		up.log("开始测试：分析师直播");
		String path = up.getApiPath("分析师直播");

		up.path(path);
		up.param("page", "1");
		up.param("rows", "20");
		up.param("livetype", "0");
		up.param("analystType", "1");

		up.sendRequest();

		up.assertJsonBody("FansNum");
		up.assertJsonBody("Notice");
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
		up.assertJsonBody("BuyLiveId");
		up.assertJsonBody("ProfitRate");
		up.assertJsonBody("IsSell");

	}
}
