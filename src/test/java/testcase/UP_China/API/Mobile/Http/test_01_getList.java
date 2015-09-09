package testcase.UP_China.API.Mobile.Http;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_01_getList {

	private UP_API up;

	/**
	 * 接口名称 获取财经数据列表
	 * 接口地址 http://api.0135135.com/uprest/common/GetCalendarCPIData
	 * HttpMethod Get/Post
	 * Charset Utf-8
	 * 请求参数 String：date：日期格式 2015-03-11
	 * 返回值 json
	 */

	@Test
	public void test010() {

		up = new UP_API("http://api.0135135.com", "GET");
		up.log("开始测试：获取财经数据列表");
		String path = up.getApiPath("获取财经数据列表");
		String date = up.getDate();
		up.path(path);
		up.param("date", date);

		up.sendRequest();

		up.assertJsonBody("Time");
		up.assertJsonBody("Country");
		up.assertJsonBody("Name");
		up.assertJsonBody("Importance");
		up.assertJsonBody("BeforeValue");
		up.assertJsonBody("CalculatedValue");
		up.assertJsonBody("PublishValue");
		up.assertJsonBody("ChildsList");
		up.assertJsonBody("Charts");
		up.assertJsonBody("Id");
		up.assertJsonBody("ChartsName");
		up.assertJsonBody("ChartsUnit");

	}
}
