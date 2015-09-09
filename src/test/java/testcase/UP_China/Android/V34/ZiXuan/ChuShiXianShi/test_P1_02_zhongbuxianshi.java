package testcase.UP_China.Android.V34.ZiXuan.ChuShiXianShi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_zhongbuxianshi {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：中部初始列表显示");
		up.openApp();
	}

	/**
	 * 测试名称：02 中部初始列表显示
	 * [前提条件]：
	 * 1、用户已登录，同步有自选股；
	 * 
	 * [测试步骤]：
	 * 1、进入全部自选页面；
	 * 
	 * [预期结果]：
	 * 1、列表字段从左至右为：名称/代码，现价，涨跌幅，涨跌，向右箭头
	 * 2、现价、涨跌幅及涨跌按照红涨绿跌灰平配色；
	 */
	@Test
	public void testZhongbuxianshi() {

		up.goHomePage();
		up.login();
		up.clickOn("我的返回");
		up.Plusfree();
		up.clickOn("返回");
		
		up.clickOn("操作提示");
		up.clickOn("跳转自选");
		up.verifyIsShown("名称代码");
		up.verifyIsShown("现价");
		up.verifyIsShown("涨跌幅");
		up.verifyIsShown("向右箭头");
		
		up.DeleteOptional();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
