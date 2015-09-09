package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.sousuolan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_04_zhongwenpinyin {

	private UP_Android up;

	@BeforeClass
	public void setUP() {

		up = new UP_Android();
		up.log("开始测试：中文拼音品种名称搜索-完整匹配");
		up.openApp();

	}

	/**
	 * 测试名称:04 中文拼音品种名称搜索-完整匹配
	 * [前提条件]：
	 * 1、进入品种搜索界面
	 * 2、品种名字只有中文
	 * [测试步骤]：
	 * 1、输入某品种中文拼音首字母组合（如鸡蛋：JD）
	 * 2、
	 * [预期结果]：
	 * 1、搜索结果列表显示搜索框对应的品种名称和代码；
	 */
	@Test
	public void testZhongwenpinyin() {

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
