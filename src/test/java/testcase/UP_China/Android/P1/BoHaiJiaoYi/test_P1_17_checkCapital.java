package testcase.UP_China.Android.P1.BoHaiJiaoYi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_17_checkCapital {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：资金数据校验
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、查看查资金页面
	 * 2、与官方软件比较同一账号资金数据结果
	 * [预期结果]：
	 * 1、订货盈亏区域的底色根据订货盈亏字段红涨绿跌灰平显示；
	 * 2、订货盈亏，可用资金，当前权益三个字段均保持两位小数；
	 * 3、订货盈亏、可用资金、当前权益三个字段的值与官方软件保持一致；
	 * 4、资金正文部分展示以下十四个字段：当前可用资金、期初余额，上日保证金、上日浮亏，当日保证金，当日浮亏，远期委托冻结资金，其它冻结资金，当日手续费
	 * ，当日转让盈亏，出入金，订货盈亏，其它变化，质押资金；
	 * 5、资金正文的十四个字段的值必须与官方渤海交易软件保持一致；
	 */
	@Test
	public void testDataRefresh() {

		up.log("开始测试：渤海商品综合屏顶部三个品种数据刷新");

	}
}
