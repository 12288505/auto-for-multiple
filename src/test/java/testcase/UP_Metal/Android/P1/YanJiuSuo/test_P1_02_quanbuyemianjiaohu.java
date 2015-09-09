package testcase.UP_Metal.Android.P1.YanJiuSuo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_02_quanbuyemianjiaohu {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：页面交互？？？？");
		up.openApp();
	}

	/**
	 * 测试名称：02 页面交互？？？？
	 * [前提条件]：研究所－全部
	 * [测试步骤]：
	 * 1、在栏目处左右滑动，观察页面
	 * 2、分别点击策略速递、每日必读、焦点透视、技术学堂
	 * 3、点击列表中任意项
	 * 4、页面刷新？？？？页面加载？？？？（屏幕上拉下拉）
	 * 
	 * [预期结果]：
	 * 1、栏目可左右滑动
	 * 2、正常跳转
	 * 3、进入资讯页
	 */
	@Test
	public void testQuanbuyemianjiaohu() {

		up.goHomePage();
		up.verifyIsShown("跳转研究所");
		up.clickOn("跳转研究所");
		up.verifyIsShown("全部");
		
		up.clickOn("策略速递");
		up.clickOn("每日必读");
		up.clickOn("焦点透视");
		up.clickOn("技术学堂");
		up.swipe(5,1.8,9,1.8,3000);
		up.clickOn("全部");
		
		up.clickOn("新闻1");
		up.clickOn("操作提示");
		up.verifyIsShown("收藏");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
