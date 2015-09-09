package testcase.UP_China.Android.P1.BoHaiJiaoYi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_04_searchPart {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：渤海商品综合屏顶部三个品种数据刷新");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：品种代码搜索-部分匹配
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、输入某品种代码的一部分（如苹果BAPYT,输入BA）
	 * 2、
	 * [预期结果]：
	 * 1、搜索结果中显示：拼音首字母组合含该代码的品种，代码中含该代码的品种
	 */
	@Test
	public void testSearchPart() {

		up.goHomePage();
		
		up.verifyIsShown("自选");
		up.verifyIsShown("沪深股票");

		up.goToHeader("渤海交易");
		up.login_BH();

		up.verifyIsShown("搜索按钮");
		
		up.clickOn("搜索按钮");
		
		up.verifyIsShown("搜索按钮");
		up.verifyIsShown("搜索");
		
		up.clickOn("搜索");
		up.sendB();
		up.sendA();
		up.sendP();
		
		String codeResult = up.getValueOf("代码1");
		String searchResult = up.getValueOf("搜索");
		up.log(searchResult);
		String UpperCase = searchResult.toUpperCase();
		up.log(UpperCase);
		if(codeResult.contains(UpperCase))
			up.log("拼音首字母组合含该代码的品种，代码中含该代码的品种");
		else throw new RuntimeException("搜索结果中没有 ‘"+codeResult+"’.");
	}
}
