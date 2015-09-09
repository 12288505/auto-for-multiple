package fwk;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import base.AndroidFramework;

public class UPMetal_Android extends AndroidFramework {

	public String UPuserName = getProperty("app.up.username");
	public String UPpassword = getProperty("app.up.password");
	public String UPuserName1 = getProperty("app.up.username1");
	public String UPpassword1 = getProperty("app.up.password1");
	public String UPuserName2 = getProperty("app.up.username2");
	public String UPpassword2 = getProperty("app.up.password2");
	public String UPuserName3 = getProperty("app.up.username3");
	public String UPpassword3 = getProperty("app.up.password3");
	public String UPuserName4 = getProperty("app.up.username4");
	public String UPpassword4 = getProperty("app.up.password4");
	public String UPuserName5 = getProperty("app.up.username5");
	public String UPpassword5 = getProperty("app.up.password5");

	public String UPnewpassword = getProperty("app.up.newpassword");

	protected String getAppName() {

		return "UP_Metal";
	}

	public void goHomePage() {

		String naviAtt = "";
		try {
			waitByTimeout(3000);
			for (int times = 1; times < 10; times++) {
				naviAtt = getElementAttribute("立刻体验", "clickable");
				if (naviAtt.equalsIgnoreCase("false")) {
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
	public void storeToLogin() {

		verifyIsShown("帐号");
		setValueTo("帐号", UPuserName);
		verifyIsShown("密码");
		setValueTo("密码", UPpassword);
		verifyIsShown("登录");
		clickOn("登录");
	}

	public String getWeiXinAccount() {

		String account = getProperty("app.weixin.username");

		return account;
	}

	public String getWeiXinPassword() {

		String password = getProperty("app.weixin.password");

		return password;
	}
//	public void ModifyPassword() {
//
//		verifyIsShown("点击登录");
//		clickOn("点击登录");
//
//		verifyIsShown("修改密码");
//		clickOn("修改密码");
//
//		verifyIsShown("提示");
//
//		verifyIsShown("旧密码");
//		setValueTo("旧密码", UPpassword);
//		verifyIsShown("新密码");
//		setValueTo("新密码", UPnewpassword);
//		verifyIsShown("确认新密码");
//		setValueTo("确认新密码", UPnewpassword);
//
//		verifyIsShown("保存修改");
//		clickOn("保存修改");
//
//		verifyIsShown("密码");
//		setValueTo("密码", UPnewpassword);
//		clickOn("登录");
//
//		verifyIsShown("修改密码");
//		clickOn("修改密码");
//
//		verifyIsShown("旧密码");
//		setValueTo("旧密码", UPnewpassword);
//		verifyIsShown("新密码");
//		setValueTo("新密码", UPpassword);
//		verifyIsShown("确认新密码");
//		setValueTo("确认新密码", UPpassword);
//		verifyIsShown("保存修改");
//		clickOn("保存修改");
//
//	}
	public void Thelogin(){
		setValueTo("帐号",UPuserName);
		setValueTo("密码",UPpassword);
		clickOn("登录");
	}
	public void Jinmudan(){
		setValueTo("帐号",UPuserName1);
		setValueTo("密码",UPpassword1);
		clickOn("登录");
	}
	public void Jinhudie(){
		setValueTo("帐号",UPuserName2);
		setValueTo("密码",UPpassword2);
		clickOn("登录");
	}
	public void Baichuan(){
		setValueTo("帐号",UPuserName3);
		setValueTo("密码",UPpassword3);
		clickOn("登录");
	}
	public void Huanqiutouzi(){
		setValueTo("帐号",UPuserName4);
		setValueTo("密码",UPpassword4);
		clickOn("登录");
	}
	public void Bohui(){
		setValueTo("帐号",UPuserName5);
		setValueTo("密码",UPpassword5);
		clickOn("登录");
	}
	
	public void listcollection(){
		String a = getValueOf("市场", 7);
		String a1 = getValueOf("市场", 8);
		String a2 = getValueOf("市场", 9);
		String a3 = getValueOf("市场", 10);
		String a4 = getValueOf("市场", 11);
		swipe(9, 3.5, 5, 3.5, 3000);
		String a5 = getValueOf("市场", 11);

		List<String> list = new ArrayList<String>();
		list.add(a);
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
	}
}
