package fwk;

import org.testng.Assert;

import tools.GeneralMethods;
import base.AndroidFramework;

public class UP_Android extends AndroidFramework {

	private String BoHaiuserName = getProperty("app.bh.username");
	private String BoHaipassword = getProperty("app.bh.password");

	public  String UPuserName = getProperty("app.up.username");
	public  String UPpassword = getProperty("app.up.password");
	
	public  String PermissionsName = getProperty("app.bh.Permissionsname");
	public  String Permissionsword = getProperty("app.bh.Permissionsword");

	public  String UPnewpassword = getProperty("app.up.newpassword");

	protected String getAppName() {

		return "UP_China";
	}

	public void goHomePage() {

		try {
			waitByTimeout(3000);
			for (int times = 1; times < 10; times++) {
				if (!isElementShown("立刻体验")) {
					log("未找到立刻体验，向左滑动！");
					swipe("left");
				} else
					break;
			}
			tapOn("立刻体验");
		} catch (Exception e) {
			log("Go To Home Page failed!");
		}
	}

	public void goToHeader(String elementName) {

		for (int times = 1; times < 10; times++) {
			if (!isElementShown(elementName)) {
				swipe(9, 3, 1, 3);
				waitByTimeout(1000);
			}
		}
		clickOn(elementName);
	}

	public boolean checkGupiaoTime() {

		boolean validate = false;
		String currentTime = GeneralMethods.getCurrentTime();
		String hour = currentTime.split(":")[0];
		String minite = currentTime.split(":")[1];
		int time = Integer.parseInt(hour + minite);
		if ((time >= 930 && time <= 1130) || (time >= 1300 && time <= 1500))
			validate = true;

		else
			throw new RuntimeException("当前是非交易时间，退出测试");

		return validate;
	}

	public boolean boHaiTime() {// 渤海

		boolean validate = false;
		String currentTime = GeneralMethods.getCurrentTime();
		String hour = currentTime.split(":")[0];
		String minite = currentTime.split(":")[1];
		int time = Integer.parseInt(hour + minite);
		if ((time >= 900 && time <= 1130) || (time >= 1330 && time <= 1600) || (1900 <= time && time <= 2359)
				|| (0 <= time && time <= 300))
			validate = true;

		else
			throw new RuntimeException("当前是非交易时间，退出测试");

		return validate;
	}

	public boolean shangHaiqihuoTime() {// 上海期货

		boolean validate = false;
		String currentTime = GeneralMethods.getCurrentTime();
		String hour = currentTime.split(":")[0];
		String minite = currentTime.split(":")[1];
		int time = Integer.parseInt(hour + minite);
		if ((time >= 900 && time <= 1015) || (time >= 1030 && time <= 1130) || (1330 <= time && time <= 1410)
				|| (1420 <= time && time <= 1500))
			validate = true;

		else
			throw new RuntimeException("当前是非交易时间，退出测试");

		return validate;
	}

	public boolean DalianZhengzhouTime() {// 大连期货 、郑州期货

		boolean validate = false;
		String currentTime = GeneralMethods.getCurrentTime();
		String hour = currentTime.split(":")[0];
		String minite = currentTime.split(":")[1];
		int time = Integer.parseInt(hour + minite);
		if ((time >= 900 && time <= 1015) || (time >= 1030 && time <= 1130) || (1330 <= time && time <= 1500))
			validate = true;

		else
			throw new RuntimeException("当前是非交易时间，退出测试");

		return validate;
	}

	// 金融期货 非交割日15:15收盘，交割日15:30收盘
	public boolean jinrongTime() {

		boolean validate = false;
		String currentTime = GeneralMethods.getCurrentTime();
		String hour = currentTime.split(":")[0];
		String minite = currentTime.split(":")[1];
		int time = Integer.parseInt(hour + minite);
		if ((time >= 915 && time <= 1130) || (time >= 1300 && time <= 1500))
			validate = true;

		else
			throw new RuntimeException("当前是非交易时间，退出测试");

		return validate;
	}

	public boolean PreciousMetalsTime() {// 天津贵金属 、广州贵金属 、大圆银泰

		boolean validate = false;
		String currentTime = GeneralMethods.getCurrentTime();
		String hour = currentTime.split(":")[0];
		String minite = currentTime.split(":")[1];
		int time = Integer.parseInt(hour + minite);
		if ((time >= 600 && time <= 2359) || (time >= 0 && time <= 400))
			validate = true;

		else
			throw new RuntimeException("当前是非交易时间，退出测试");

		return validate;
	}

	public boolean shangHaihuangjinTime() {// 上海黄金

		boolean validate = false;
		String currentTime = GeneralMethods.getCurrentTime();
		String hour = currentTime.split(":")[0];
		String minite = currentTime.split(":")[1];
		int time = Integer.parseInt(hour + minite);
		if ((time >= 900 && time <= 1130) || (time >= 1300 && time <= 1530) || (2000 <= time && time <= 2359)
				|| (0 <= time && time <= 230))
			validate = true;

		else
			throw new RuntimeException("当前是非交易时间，退出测试");

		return validate;
	}

	public void login_BH() {

		verifyIsShown("帐号");
		setValueTo("帐号", BoHaiuserName);
		verifyIsShown("密码");
		setValueTo("密码", BoHaipassword);
		verifyIsShown("登录主站");
		clickOn("登录主站");
		clickOn("电信模拟");
		tapOn(9.9, 9.9);
		verifyIsShown("帐号登录");
		clickOn("帐号登录");

		verifyIsShown("交易所承诺");
		verifyIsShown("确定");
		clickOn("确定");
	}

	public void login() {

		verifyIsShown("跳转我的");
		clickOn("跳转我的");
		clickOn("登录导航");
		verifyIsShown("点击登录");
		clickOn("点击登录");
		
		setValueTo("帐号", UPuserName);
		setValueTo("密码", UPpassword);
		verifyIsShown("登录");
		clickOn("登录");

	}
	
	public void Permissions() {

		verifyIsShown("跳转我的");
		clickOn("跳转我的");
		clickOn("登录导航");
		verifyIsShown("点击登录");
		clickOn("点击登录");
		
		setValueTo("帐号", PermissionsName);
		setValueTo("密码", Permissionsword);
		verifyIsShown("登录");
		clickOn("登录");

	}

	public void checkAlert() {

		androidDriver.openNotifications();
		if (verifyIsShown("msg.alert.high") || verifyIsShown("msg.alert.low"))
			log("发现预警通知");
	}

	public void removeAlert() {

		verifyIsShown("跳转我的");
		clickOn("跳转我的");
		clickOn("预警管理");
		waitByTimeout(5000);
		if (!isElementShown("没有预警提示")) {
			clickOn("编辑");
			clickOn("选择所有");
			clickOn("删除");
			clickOn("是");
			clickOn("完成");
			verifyIsShown("没有预警提示");
		}
		clickOn("返回");
	}

	public boolean checkDataRefresh(String d1, String d2) {

		verifyIsShown(d1);
		verifyIsShown(d2);
		boolean validate = false;
		for (int i = 0; i < 10; i++) {
			String sh = getValueOf(d1);
			String sz = getValueOf(d2);

			log("等待5秒");
			waitByTimeout(5000);
			String sh2 = getValueOf(d1);
			String sz2 = getValueOf(d2);

			validate = (sh.equals(sh2) && sz.equals(sz2));
			if (!validate)
				break;
			else
				log("股票综合屏指数在五秒内没有刷新，继续等待");
		}
		if (validate) {
			log("股票综合屏指数在一分钟内没有刷新.", 2);
			Assert.assertFalse(validate, "股票综合屏指数在一分钟内没有刷新.");
		}
		return validate;

	}

	public boolean checkDataRefresh(String value, int time) {

		verifyIsShown(value);
		boolean validate = false;
		for (int i = 0; i < 60 / time; i++) {
			String d1 = getValueOf(value);

			log("等待" + time + "秒");
			waitByTimeout(time * 1000);
			String d2 = getValueOf(value);

			validate = (d1.equals(d2));
			if (!validate)
				break;
			else
				log("股票综合屏指数没有刷新，继续等待");
		}
		if (validate) {
			log("股票综合屏指数在一分钟内没有刷新.", 2);
			Assert.assertFalse(validate, "股票综合屏指数在一分钟内没有刷新.");
		}
		return validate;

	}

	public void sendNum(String price) {

		int temp = Integer.parseInt(price);
		int a = temp / 1000;
		int b = (temp - a * 1000) / 100;
		int c = (temp - a * 1000 - b * 100) / 10;
		int d = (temp - a * 1000 - b * 100 - c * 10);
		if (a == 0) {
			sendNum(b);
			waitByTimeout(1000);
			sendNum(c);
			waitByTimeout(1000);
			sendNum(d);
			waitByTimeout(1000);
		} else {
			sendNum(a);
			waitByTimeout(1000);
			sendNum(b);
			waitByTimeout(1000);
			sendNum(c);
			waitByTimeout(1000);
			sendNum(d);
			waitByTimeout(1000);
		}
	}

	private void sendNum(int num) {

		switch (num) {
		case 1: {
			send1();
			break;
		}
		case 2: {
			send2();
			break;
		}
		case 3: {
			send3();
			break;
		}
		case 4: {
			send4();
			break;
		}
		case 5: {
			send5();
			break;
		}
		case 6: {
			send6();
			break;
		}
		case 7: {
			send7();
			break;
		}
		case 8: {
			send8();
			break;
		}
		case 9: {
			send9();
			break;
		}
		case 0: {
			send0();
			break;
		}
		default:
			break;
		}
	}

	private void send1() {

		tapOn(2, 7);
	}

	private void send2() {

		tapOn(4, 7);
	}

	private void send3() {

		tapOn(7, 7);
	}

	private void send4() {

		tapOn(2, 8);
	}

	private void send5() {

		tapOn(4, 8);
	}

	private void send6() {

		tapOn(7, 8);
	}

	private void send7() {

		tapOn(2, 9);
	}

	private void send8() {

		tapOn(4, 9);
	}

	private void send9() {

		tapOn(7, 9);
	}

	private void send0() {

		tapOn(4, 9.9);
	}

	public void senddian() {

		tapOn(7, 9.9);
	}

	public void sendB() {

		tapOn(6, 8.5);
	}

	public void sendA() {

		tapOn(1, 8);
	}

	public void sendP() {

		tapOn(9.5, 7);
	}

	public void sendY() {

		tapOn(5, 7);
	}

	public void sendT() {

		tapOn(4.5, 7);
	}

	public void goToStock() {

		verifyIsShown("跳转行情");
		clickOn("跳转行情");
		verifyIsShown("更多");
		clickOn("更多");
		verifyIsShown("沪深A股");
		clickOn("沪深A股");
		clickOn("操作提示");

	}

	public void storeToLogin() {

		verifyIsShown("帐号");
		setValueTo("帐号", UPuserName);
		verifyIsShown("密码");
		setValueTo("密码", UPpassword);
		verifyIsShown("登录");
		clickOn("登录");
	}

	public void selectValidStock(String elementName, String price) {

		int size = getElementsSize(elementName);
		int item = size;
		for (int i = 0; i < size; i++) {
			String value = getValueOf(price, i);
			if (value.contains(".")) {
				item = i;
				break;
			}
		}
		if (item == size)
			throw new RuntimeException("没有可用的股票可选择.");
		else
			clickOn(elementName, item);
	}

	public String getWeiboAccount() {

		String account = getProperty("app.weibo.username");

		return account;
	}

	public String getWeiboPassword() {

		String password = getProperty("app.weibo.password");

		return password;
	}

	public String getWeiXinAccount() {

		String account = getProperty("app.weixin.username");

		return account;
	}

	public String getWeiXinPassword() {

		String password = getProperty("app.weixin.password");

		return password;
	}

	public void cheDan() {

		verifyIsShown("撤单");
		clickOn("撤单");
		waitByTimeout(5000);
		while (getElementsSize("撤单按钮") != 0) {
			verifyIsShown("撤单1");
			clickOn("撤单1");
			verifyIsShown("确定");
			clickOn("确定");
			verifyIsShown("确定1");
			clickOn("确定1");
		}
	}

	public void aKeyOrder() {

		verifyIsShown("更多");
		clickOn("更多");
		verifyIsShown("更多");
		verifyIsShown("是否一键下单");
		clickOn("是否一键下单");
		verifyIsShown("确定");
		clickOn("确定");
		verifyIsShown("委托");
		clickOn("委托");
	}

	public void ModifyPassword() {

		verifyIsShown("点击登录");
		clickOn("点击登录");

		verifyIsShown("修改密码");
		clickOn("修改密码");

		verifyIsShown("提示");

		verifyIsShown("旧密码");
		setValueTo("旧密码", UPpassword);
		verifyIsShown("新密码");
		setValueTo("新密码", UPnewpassword);
		verifyIsShown("确认新密码");
		setValueTo("确认新密码", UPnewpassword);

		verifyIsShown("保存修改");
		clickOn("保存修改");

		verifyIsShown("密码");
		setValueTo("密码", UPnewpassword);
		clickOn("登录");

		verifyIsShown("修改密码");
		clickOn("修改密码");

		verifyIsShown("旧密码");
		setValueTo("旧密码", UPnewpassword);
		verifyIsShown("新密码");
		setValueTo("新密码", UPpassword);
		verifyIsShown("确认新密码");
		setValueTo("确认新密码", UPpassword);
		verifyIsShown("保存修改");
		clickOn("保存修改");

	}

	public void Plusfree() {
		verifyIsShown("跳转自选");
		clickOn("跳转自选");
		
		clickOn("自选搜索");
		clickOn("搜索框");
		clickOn("0");
		
		clickOn("加自选",1);
		clickOn("加自选",1);
		clickOn("加自选",1);
		
	}
	public void DeleteOptional() {
		clickOn("自选编辑");
		clickOn("勾选股票",1);
		clickOn("勾选股票",2);
		clickOn("勾选股票",3);
		clickOn("删除");
		clickOn("是");
		clickOn("完成");
	}
	public void picture() {

		tapOn(1,3);
	}
}
