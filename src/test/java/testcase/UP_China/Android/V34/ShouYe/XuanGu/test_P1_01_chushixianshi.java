package testcase.UP_China.Android.V34.ShouYe.XuanGu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_chushixianshi {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：初始显示");
		up.openApp();
	}

	/**
	 * 测试名称：01 初始显示
	 * [测试步骤]：
	 * 1、首页－选股－一键选股
	 * 2、观察｛一键选股｝页面
	 * 
	 * [预期结果]：
	 * 1、页面顶部：返回图标＋一键选股标题
	 * 2、页面中部：形态、特色、经典、用户、名家　导航菜单
	 * 3、默认显示｛形态｝
	 */
	@Test
	public void testChushixianshi() {

		up.goHomePage();
		up.verifyIsShown("智能选股");
		up.clickOn("智能选股");
		
		up.verifyIsShown("一键选股");
		up.clickOn("一键选股");
		
		up.verifyIsShown("一键选股返回");
		up.verifyIsShown("一键选股标题");
		up.verifyIsShown("形态");
		up.verifyIsShown("特色");
		up.verifyIsShown("经典");
		up.verifyIsShown("用户");
		up.verifyIsShown("名家");
		up.verifyIsShown("MACD金叉");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
