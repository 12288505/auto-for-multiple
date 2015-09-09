package testcase.Demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class testAndroidMonkey {

	private UPMetal_Android up;

	@BeforeClass
	public void setUp() {

		up = new UPMetal_Android();

	}

	/**
	 * 测试名称：Monkey随机事件测试
	 */
	@Test
	public void test010Navigation() {

		up.log(">========================<");
		up.log("开始测试：Monkey随机事件测试");
		up.monkeyTest(10000);
	}

}
