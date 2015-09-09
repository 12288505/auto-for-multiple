package testcase.UP_China.Android.V33.oneKeyChoose.checkFeature;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_V33_01_tabSwitch {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：tab切换");
		up.openApp();
	}

	/**
	 * 测试名称：01 tab切换
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、进入｛一键选股｝，分别点击顶部形态、特色、经典、用户、名家菜单切换
	 * [预期结果]：
	 * 1、菜单之间正常切换
	 */
	@Test
	public void test010Demo() {

		up.goHomePage();

		up.verifyIsShown("选股");
		up.clickOn("选股");

		up.verifyIsShown("一键选股");
		up.clickOn("一键选股");

		up.verifyIsShown("形态");
		up.verifyIsShown("MACD金叉");
		up.verifyIsShown("形态");
		up.verifyIsShown("深跌回弹");

		up.clickOn("特色");
		up.verifyIsShown("操盘论势");
		up.verifyIsShown("资金博弈");
		up.verifyIsShown("MACD多周期共振");

		up.clickOn("经典");
		up.verifyIsShown("冰火两重天");
		up.verifyIsShown("买卖频谱");
		up.verifyIsShown("趋势顶底");

		up.clickOn("用户");
		up.verifyIsShown("资金谐波");
		up.verifyIsShown("黄金柱");

		up.clickOn("名家");
		up.verifyIsShown("短线猎杀");
		up.verifyIsShown("顺势擒龙");
		up.verifyIsShown("一线擒牛");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
