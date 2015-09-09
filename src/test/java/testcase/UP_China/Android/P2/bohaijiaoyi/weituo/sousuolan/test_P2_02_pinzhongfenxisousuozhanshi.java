package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.sousuolan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_02_pinzhongfenxisousuozhanshi {

	private UP_Android up;

	@BeforeClass
	public void setUP() {

		up = new UP_Android();
		up.log("开始测试：搜索框数据展示-从品种分析页交易进入");
		up.openApp();

	}

	/**
	 * 测试名称:02 搜索框数据展示-从品种分析页交易进入
	 * [前提条件]：
	 * 1、从品种分析页交易按钮处进入
	 * [测试步骤]：
	 * 1、查看搜索框品种名字
	 * 2、
	 * [预期结果]：
	 * 1、搜索框显示的名字为：渤海直播中点击跟单的品种的名字
	 */
	@Test
	public void testPinzhongfenxisousuozhanshi() {

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
