package fwk;

import base.IOSFramework;

public class UP_IOS extends IOSFramework {

	private String BoHaiuserName = getProperty("app.bh.username");
	private String BoHaipassword = getProperty("app.bh.password");

	private String UPuserName = getProperty("app.up.username");
	private String UPpassword = getProperty("app.up.password");

	protected String getAppName() {

		return "UP_China";
	}

	public void goHomePage() {

		swipe("left");
		swipe("left");
		swipe("left");
		tapOn("立刻体验");
	}
}
