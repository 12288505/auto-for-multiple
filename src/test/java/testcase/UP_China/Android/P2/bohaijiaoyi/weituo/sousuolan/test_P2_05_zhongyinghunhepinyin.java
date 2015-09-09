package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.sousuolan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_05_zhongyinghunhepinyin {

	private UP_Android up;

	@BeforeClass
	public void setUP() {

		up = new UP_Android();
		up.log("开始测试：中英文混合拼音品种名称搜索-完整匹配");
		up.openApp();

	}

	/**
	 * 测试名称:05 中英文混合拼音品种名称搜索-完整匹配
	 * [前提条件]：
	 * 1、进入品种搜索界面
	 * 2、品种名字既有中文又有
	 * [测试步骤]：
	 * 1、输入品种中文拼音首字母组合和英文部分（如PVC华东：PVCHD）
	 * 2、
	 * [预期结果]：
	 * 1、搜索结果列表显示搜索框对应的品种名称和代码；
	 */
	@Test
	public void testZhongyinghunhepinyin() {

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
