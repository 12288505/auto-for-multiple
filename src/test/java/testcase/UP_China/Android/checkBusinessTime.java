package testcase.UP_China.Android;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class checkBusinessTime {

	private UP_Android up;

	@BeforeSuite
	public void setUp() {

		up = new UP_Android();
	}

	// 股票交易时间
	@Test(groups = "stock time")
	public void checkStockTime() {

		up.checkGupiaoTime();
	}

	// 渤海交易时间
	@Test(groups = "Bohai time")
	public void checkBohaiTime() {

		up.boHaiTime();
	}

	// 上海期货交易时间
	@Test(groups = "Shanghai qihuo time")
	public void checkShanghaiQihuoTime() {

		up.shangHaiqihuoTime();
	}

	// 大连期货 、郑州期货交易时间
	@Test(groups = "Dalian Zhengzhou time")
	public void checkDalianZhengzhouTime() {

		up.DalianZhengzhouTime();
	}

	// 金融期货 非交割日15:15收盘，交割日15:30收盘
	@Test(groups = "Jinrong time")
	public void checkjinrongTime() {

		up.jinrongTime();
	}

	// 天津贵金属 、广州贵金属 、大圆银泰交易时间
	@Test(groups = "Guijinshu time")
	public void checkGuijinshuTime() {

		up.PreciousMetalsTime();
	}

	// 上海黄金交易时间
	@Test(groups = "Shanghai huangjin time")
	public void checkShanghaiHuangjinTime() {

		up.shangHaihuangjinTime();
	}
}
