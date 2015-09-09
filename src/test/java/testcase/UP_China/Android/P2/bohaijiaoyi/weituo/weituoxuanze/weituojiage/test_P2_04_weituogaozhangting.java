package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.weituoxuanze.weituojiage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_04_weituogaozhangting {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：委托价格-高于涨停价");
		up.openApp();

	}

	/**
	 * 测试名称：04 委托价格-高于涨停价
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、在价格编辑框输入高于涨停价的价格
	 * 2、焦点从价格编辑框离开
	 * [预期结果]：
	 * 1、价格编辑框数值变为涨停价；
	 * 2、买入卖出按钮上的价格与编辑框的价格一致；
	 */
	@Test
	public void testWeituogaozhangting() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
