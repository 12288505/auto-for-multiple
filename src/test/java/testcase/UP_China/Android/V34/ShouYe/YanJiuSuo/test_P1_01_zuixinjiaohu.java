package testcase.UP_China.Android.V34.ShouYe.YanJiuSuo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_zuixinjiaohu {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：页面交互");
		up.openApp();
	}

	/**
	 * 测试名称：01 页面交互
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、｛研究所｝，点击顶部【返回】和【搜索】
	 * 2、点击新闻区域
	 * 3、页面上拉
	 * 4、页面下拉
	 * 5、切换最新、分类栏目
	 * [预期结果]：
	 * 1、返回至首页；进入｛搜索｝
	 * 2、进入新闻详情页
	 * 3、瀑布流形式加载下页数据
	 * 4、页面刷新
	 * 5、正常切换
	 */
	@Test
	public void testZuixinjiaohu() {

		up.goHomePage();
		up.verifyIsShown("自选");
		up.goToHeader("研究所");
		
		up.verifyIsShown("研究所返回");
		up.clickOn("研究所返回");
		
		up.clickOn("研究所");
		
		up.verifyIsShown("搜索");
		up.clickOn("搜索");
		up.clickOn("返回");
		
		up.verifyIsShown("新闻详情1");
		up.clickOn("新闻详情1");
		up.swipe(3, 9, 3, 5);
		
		up.swipe(3, 2, 3, 8);
		
		up.clickOn("资讯返回");
		
		up.verifyIsShown("分类");
		up.clickOn("分类");
		up.verifyIsShown("最新");
		up.clickOn("最新");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
