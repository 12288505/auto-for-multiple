package testcase.UP_China.Android.V33.oneKeyChoose.mainContent;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_V33_02_listshows {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：列表展示");
		up.openApp();
	}

	/**
	 * 测试名称：02 列表展示
	 * [前提条件]：
	 * [测试步骤]： 1、进入指标内容页，观察页面展示
	 * [预期结果]：
	 * 1、顶部返回图标＋指标名称
	 * 2、页面上方左侧展示指标名及其说明，右侧显示选股日期
	 * 3、页面下方列表形式展示选中股票。
	 * 4、列表字段：名称（名称+代码），现价（观察是否红涨绿跌），涨幅（观察是否红涨绿跌）
	 * 5、页面下方【分享】按钮
	 */
	@Test
	public void test010listshows() {

		up.goHomePage();

		up.verifyIsShown("选股");
		up.clickOn("选股");

		up.verifyIsShown("一键选股");
		up.clickOn("一键选股");

		up.verifyIsShown("MACD金叉");
		up.clickOn("MACD金叉");

		up.verifyIsShown("形态名称");
		up.verifyIsShown("文案描述");
		up.verifyIsShown("选股日期");

		up.verifyIsShown("名称代码");
		up.verifyIsShown("现价");
		up.verifyIsShown("涨幅");

		up.verifyIsShown("分享");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
