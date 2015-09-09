package testcase.UP_China.Android.P2.bohaijiaoyi.chaxun;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_01_chaweituo {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：初始展示-盘中-有委托单");
		up.openApp();

	}

	/**
	 * 测试名称：01 初始展示-盘中-有委托单
	 * [前提条件]：
	 * 1、进入渤海交易查询界面
	 * 2、收盘前有过下单操作
	 * 3、盘中进行测试
	 * [测试步骤]：
	 * 1、查看查委托界面
	 * [预期结果]：
	 * 1、查委托列表按照委托时间降序排列，最新时间成交的排在前面；
	 * 2、每条委托信息展示品种名称和代码，委托时间，类型，数量，价格，状态，剩余
	 * 3、价格小数精度与品种最小变价单位一致；
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testChaweituo() {

		up.goHomePage();
		up.verifyIsShown("自选");
		up.goToHeader("渤海交易");
		up.login_BH();
		up.verifyIsShown("卖出");
		up.clickOn("卖出");
		up.clickOn("委托确定1");
		up.clickOn("委托确定2");
		up.clickOn("操作提示");
		up.verifyIsShown("查委托");
		up.clickOn("查委托");
		
		up.log(up.getValueOf("名称"));
		up.log(up.getValueOf("代码"));
		up.log(up.getValueOf("委托时间"));
		up.log(up.getValueOf("类型"));
		up.log(up.getValueOf("数量"));
		up.log(up.getValueOf("价格"));
		up.log(up.getValueOf("状态"));
		up.log(up.getValueOf("剩余量"));
		up.cheDan();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
