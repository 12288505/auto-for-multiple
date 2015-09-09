package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.sousuolan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_03_zhongyingwenhunhepinzhong {

	private UP_Android up;

	@BeforeClass
	public void setUP() {

		up = new UP_Android();
		up.log("开始测试：中英文混合品种名称搜索-完整匹配");
		up.openApp();

	}

	/**
	 * 测试名称:03 中英文混合品种名称搜索-完整匹配
	 * [前提条件]：
	 * 1、进入品种搜索界面
	 * 2、品种名字既有中文又有英文
	 * [测试步骤]：
	 * 1、输入某品种完整品种名字（如PVC华东）
	 * 2、
	 * [预期结果]：
	 * 1、搜索结果列表显示搜索框对应的品种名称和代码；
	 */
	@Test
	public void testZhongyingwenhunhepinzhong() {

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
