package testcase.UP_China.Android.V34.ShouYe.YanJiuSuo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_08_zhengcejiaohu {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：页面交互");
		up.openApp();
	}

	/**
	 * 测试名称：08 页面交互
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、｛研究所｝-分类-政策，点击顶部【返回】和【搜索】
	 * 2、点击新闻区域
	 * 3、页面上拉
	 * 4、页面下拉
	 * 
	 * [预期结果]：
	 * 1、返回至研究所分类页面，进入｛搜索｝
	 * 2、进入新闻详情页
	 * 3、瀑布流形式加载下页数据
	 * 4、页面刷新
	 */
	@Test
	public void testZhengcejiaohu() {

		up.goHomePage();

		up.verifyIsShown("自选");
		up.goToHeader("研究所");
		up.verifyIsShown("分类");
		up.clickOn("分类");
		up.verifyIsShown("政策");
		up.clickOn("政策");
		
		up.clickOn("新闻返回");
		up.clickOn("政策");
		up.verifyIsShown("股票搜索");
		up.clickOn("股票搜索");
		up.clickOn("返回");
		
		up.verifyIsShown("新闻内容1");
		up.clickOn("新闻内容1");
		
		up.swipe(3, 9, 3, 5);
		up.waitByTimeout(3000);
		up.swipe(3, 2, 3, 8);
		up.waitByTimeout(1000);
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
