package testcase.UP_China.API.Mobile.Http;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_02_getChart {

	private UP_API up;

	/**
	 * 接口名称 获取手机财经数据图表
	 * 接口地址 http://api.0135135.com /uprest/common/GetCPIChartsList
	 * HttpMethod Get/Post
	 * Charset Utf-8
	 * 请求参数 Int: id 图表Id,由上面接口获取。
	 * 
	 * 返回值 json
	 */

	@Test
	public void test010() {

		up = new UP_API("http://api.0135135.com", "GET");
		up.log("开始测试：获取财经数据图表");

		String path1 = up.getApiPath("获取财经数据列表");
		String date = up.getDate();
		up.path(path1);
		up.param("date", date);
		up.sendRequest();

		String id = up.getJsonValue("Id");

		up = new UP_API("http://api.0135135.com", "GET");
		String path2 = up.getApiPath("获取财经数据图表");
		up.path(path2);
		up.param("Id", id);
		up.sendRequest();

		up.assertJsonBody("Date");
		up.assertJsonBody("Num");

	}
}
