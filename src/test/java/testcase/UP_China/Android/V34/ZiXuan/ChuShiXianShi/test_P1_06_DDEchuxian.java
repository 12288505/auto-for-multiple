package testcase.UP_China.Android.V34.ZiXuan.ChuShiXianShi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_06_DDEchuxian {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：DDE页面初始显示");
		up.openApp();
	}

	/**
	 * 测试名称：06 DDE页面初始显示
	 * [前提条件]：
	 * 1、用户已登录，同步有自选股；
	 * 
	 * [测试步骤]：
	 * 1、点击自选进入全部自选页面；
	 * 2、点击上部DDE栏
	 * 
	 * 
	 * [预期结果]：
	 * 1、列表字段从左至右为：名称/代码，现价，涨跌幅，DDX，向右箭头
	 * 2、现价、涨跌幅及DDX按照红涨绿跌灰平配色；
	 */
	@Test
	public void testDDEchuxian() {

		up.goHomePage();
		up.login();
		up.clickOn("我的返回");
		up.Plusfree();
		up.clickOn("返回");
		
		up.clickOn("操作提示");
		up.clickOn("跳转自选");
		up.verifyIsShown("DDE");
		up.clickOn("DDE");
		
		up.verifyIsShown("名称代码");
		up.verifyIsShown("现价");
		up.verifyIsShown("涨跌幅");
		
		up.clickOn("行情");
		up.DeleteOptional();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
