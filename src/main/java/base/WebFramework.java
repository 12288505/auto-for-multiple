package base;

import java.io.File;

import junit.framework.AssertionFailedError;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import tools.SmartRobot;
import base.core.UiFramework;

public abstract class WebFramework extends UiFramework {

	protected String getAppName() {

		return "";
	}

	protected String getAppType() {

		return "WebApp";
	}

	protected WebFramework() {

		super();
	}

	protected WebFramework(String SUT) {

		super(SUT);
	}

	@Override
	protected void platformSupportInitiate(String profileName) {

		setProfilePath(profileName);

		startSeleniumServerAndBrowser();

		prepareTestEnvironment();
	}

	private void setProfilePath(String profileName) {

		browserName = getProperty("browser.name");
		browserSize = getProperty("browser.size").toLowerCase();
		browserProfilePath = getProfilePath(profileName);
	}

	private String getProfilePath(String profileName) {

		/*
		 * Define the browserProfilePath according to the browser we are going
		 * to test.
		 */
		if (browserName.matches(".*firefox.*")) {

			return getBrowserProfileProperty("profile.firefox", profileName);

		} else if (browserName.matches(".*iexplore.*")) {
			return getBrowserProfileProperty("profile.iexplore");
		} else if (browserName.matches(".*chrome.*")) {
			return getBrowserProfileProperty("profile.chrome");
		}
		throw new RuntimeException("Can't find any profile property for browser [" + browserName + "] and profile [" + profileName + "]. ");
	}

	protected void startSeleniumServerAndBrowser() {

		if (browserName.matches(".*firefox.*")) {
			log("Loading Firefox Profile and open Firefox...");
			File profileFile = new File(browserProfilePath);
			if (profileFile.exists()) {
				FirefoxProfile profile = new FirefoxProfile(new File(browserProfilePath));
				profile.setEnableNativeEvents(true);
				driver = new FirefoxDriver(profile);
			} else {
				driver = new FirefoxDriver();
			}
		}
		if (browserName.matches(".*chrome.*")) {
			System.setProperty("webdriver.chrome.driver", testDataRoot + "common\\browserProfiles\\drivers\\chromedriver.exe");
			String userProfile = browserProfilePath.replace("/", "\\");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir=" + userProfile, "--disable-prerender-local-predictor", "--incognito", "--start-maximized");
			driver = new ChromeDriver(options);
		}

		main_window = driver.getWindowHandle();
		driver.manage().deleteAllCookies();

	}

	private String getBrowserProfileProperty(String profileType) {

		return getBrowserProfileProperty(profileType, "");
	}

	private String getBrowserProfileProperty(String profileType, String folderName) {

		String returnStr = "";

		if (folderName.isEmpty())
			folderName = getProperty("browser." + browserName + ".profile");
//		if (folderName.isEmpty())
//			folderName = getProperty("browser." + getProperty("application.stackName") + ".profile");
		returnStr = testDataRoot + "common" + getInitialProperty(profileType) + "/" + folderName;
		File profileFolder = new File(returnStr);

		if (!profileFolder.exists() || folderName.isEmpty()) {
			returnStr = returnStr.substring(0, returnStr.length() - folderName.length()) + "default";
			File defaultProfile = new File(returnStr);
			if (defaultProfile.exists()) {
				log("Browser Profile not found for " + appUrl + ", use default profile instead.", 3);
				log("Browser Profile used: " + returnStr);
			} else {
				log("Browser Profile not found for " + appUrl + ", use local profile instead.", 3);
				log("Browser Profile used: Local profile!");
			}
		} else {
			log("Browser Profile used: " + returnStr);
		}

		return returnStr;
	}

	/**
	 * Convenience method for clicking on element locator using java script.
	 * 
	 * Parameters:
	 * 
	 * @param jsScript
	 *            - the java java script that you want to execute .
	 */
	public void clickElement(String jsScript) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String js = null;
		if (!jsScript.contains("=")) {
			throw new AssertionFailedError("The format of the navigate element is incorrect.");
		}
		if (jsScript.contains("id")) {

			jsScript = jsScript.split("=")[1];
			js = "document.getElementById('" + jsScript + "').click()";
			jsExecutor.executeScript(js);
		}

		else if (jsScript.contains("tagname")) {

			jsScript = jsScript.split("=")[1];
			js = "document.getElementsByTagName('" + jsScript + "').click()";
			jsExecutor.executeScript(js);
		} else {
			throw new AssertionFailedError("The parameter jsScript should only be 'id' or 'tagname'.");
		}
	}

	/**
	 * Convenience method for move mouse On specified element. NOTE: Situation
	 * of this method using:Element will be displayed when the mouse moves up
	 * Parameters:
	 * 
	 * @param elementName
	 *            - the name of valid Selenium locator string in uiMap .
	 */
	public void hover(String elementName) {

		waitForArea(getElementLocator(elementName), Long.parseLong(elementTimeout));
		RemoteWebElement element = (RemoteWebElement) getElement(elementName);
		log("Moving mouse to element: " + elementName + ".");

		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	/**
	 * Convenience method for closing the current browser session and clear the
	 * framework history. Then start a new session.
	 * 
	 * @author Bill Wan
	 */
	public void restartBrowser() {

		log("Restarting the browser session.");
		close();
		clearHistory();

		startSeleniumServerAndBrowser();
		log("Restarted.");
	}

	/**
	 * Convenience method for clearing the data structure of uiMap.
	 * 
	 * NOTE: Objects' data will be clear which are existed
	 * in'uiMapViewList','uiMapAreasAlreadyChecked','uiMapViewIndex'.
	 */
	public void clearHistory() {

		uiMapViewList.clear();
		uiMapAreasAlreadyChecked.clear();
		uiMapViewIndex = -1;
	}

	/**
	 * Convenience method for pressing Esc key on keyBoard.
	 */
	public void pressEscKey() {

		SmartRobot robot = new SmartRobot();
		robot.pressESC();
	}

	/**
	 * Convenience method for getting current URL.
	 */
	public String getCurrentUrl() {

		return driver.getCurrentUrl();
	}

	/**
	 * Get the value of a the given attribute of the element. Will return the
	 * current value, even if this has been modified after the page has been
	 * loaded. More exactly, this method will return the value of the given
	 * attribute, unless that attribute is not present, in which case the value
	 * of the property with the same name is returned (for example for the
	 * "value" property of a textarea element). If neither value is set, null is
	 * returned. The "style" attribute is converted as best can be to a text
	 * representation with a trailing semi-colon. The following are deemed to be
	 * "boolean" attributes, and will return either "true" or null:
	 * 
	 * async, autofocus, autoplay, checked, compact, complete, controls,
	 * declare, defaultchecked, defaultselected, defer, disabled, draggable,
	 * ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap,
	 * itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate,
	 * nowrap, open, paused, pubdate, readonly, required, reversed, scoped,
	 * seamless, seeking, selected, spellcheck, truespeed, willvalidate
	 * 
	 * Finally, the following commonly mis-capitalized attribute/property names
	 * are evaluated as expected:
	 * 
	 * <ul>
	 * <li>"class"
	 * <li>"readonly"
	 * </ul>
	 * 
	 * @param name
	 *            The name of the attribute.
	 * @return The attribute/property's current value or null if the value is
	 *         not set.
	 */
	public String getAttributeFromElementLocator(String elementName, String attribute) {

		WebElement element = getElement(elementName);
		String attributeValue = element.getAttribute(attribute);
		return attributeValue;
	}

	/**
	 * Convenience method for switching to frame.
	 * 
	 * Parameters:
	 * 
	 * @param frameElement
	 *            - the valid Selenium locator string in uiMap
	 */
	public void switchIfarme(String frameElement) {

		// String locator = getElementLocator(frameElement);
		WebElement element = getElement(frameElement);
		driver.switchTo().frame(element);
		log("switch to ifarme");
	}

	/**
	 * Convenience method for clicking on element locator in frame.
	 * 
	 * Parameter:
	 * 
	 * @param elementLocator
	 *            - the valid Selenium locator string in uiMap
	 */
	public void clickElementIframe(String elementLocator) {

		boolean verify = driver.findElement(By.xpath(elementLocator)).isDisplayed();
		log("verify element if display=" + verify);
		if (verify) {
			driver.findElement(By.xpath(elementLocator)).click();
		}
	}

	/**
	 * Convenience method for getting elements's size of same style. Example,
	 * get all photos's size on the photos page.
	 * 
	 * @param elementName
	 *            - The name of element in json file.
	 * @return -Size of elements.
	 */
	public int getAllElements(String elementName) {

		waitForElement(elementName);

		return getElements(elementName).size();
	}

	/**
	 * The element display on a computer screen.
	 * 
	 * @param elementLocator
	 *            - the valid Selenium locator string in uiMap
	 * */
	// TODO: Need to modify elementLocator to elementName.
	public void scrollTo(String elementName) {

		waitForElement(elementName);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", getElement(elementName));
	}

	public void scrollTo(int height) {

		String setscroll = "document.documentElement.scrollTop=" + height;
		((JavascriptExecutor) driver).executeScript(setscroll);
	}

	public void scrollTo(WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * Convenience method for clicking on element use JS
	 * 
	 * @param elementName
	 */
	public void clickOnUseJS(String elementName) {

		// String locator = uiMapElementLocator(elementName);
		WebElement element = getElement(elementName);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	/**
	 * Sliding to at the top of the page
	 */
	public void scrollToTop() {

		String Js = "var q=document.documentElement.scrollTop=0";
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(Js);

	}
}
