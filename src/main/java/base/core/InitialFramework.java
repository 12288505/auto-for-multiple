package base.core;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.Reporter;

import tools.GeneralMethods;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class InitialFramework {

	static {
		disableLog4jLogs();
	}
	private static String initialConfigFilePath = "configuration/MainConfig.properties";
	protected static String testRoot = GeneralMethods.getTestRoot();
	protected static String testConfigRoot;
	protected static String testDataRoot;
	protected String sutFileName = "";
	private static String projectLevelSutConfigPath = "";
	protected static String projectLevelBrowserConfigPath = "";
	protected static String projectLevelUiConfigPath = "";

	protected String pageTimeout = "30000";
	protected String viewTimeout = "20000";
	protected String elementTimeout = "15000";
	// protected String playbackSpeed = "200";

	protected String appUrl = "";
	protected String apiUrl = "";
	protected String appLocale = "";

	protected static ObjectMapper jsonMapper = new ObjectMapper();
	protected static JsonNode initialConfig = jsonMapper.createObjectNode();
	protected JsonNode sut = jsonMapper.createObjectNode();

	protected final static String UIMAP_DELIM = ":";

	protected abstract String getAppName();

	protected abstract String getAppType();

	protected InitialFramework() {

		this("");
	}

	protected InitialFramework(String SUT) {

		log(">==================================================<");
		try {
			ITestResult it = Reporter.getCurrentTestResult();
			log("Now Starting: " + it.getTestClass().getName());
		} catch (Exception e) {
			log("None testNG executor detected, test may continue, but highly recommended to migrate your test to testNG.", 3);
		}
		frameworkInitiate(SUT);
		languageSupportInitiate();
		platformSupportInitiate("");
		applicationSupportInitiate();
	}

	private void frameworkInitiate(String indicatedSutFileName) {

		testConfigRoot = testRoot.replace("target/test-classes/", "src/test/resources/configuration/");
		testDataRoot = testRoot.replace("target/test-classes/", "src/test/resources/data/");
		initialConfig = GeneralMethods.getDataFromConfigFile(testRoot + initialConfigFilePath);

		projectLevelSutConfigPath = testConfigRoot + "[appname]/" + "sut/";
		sutFileName = StringUtils.defaultIfEmpty(indicatedSutFileName, getDefaultSutFileName());
		sut = GeneralMethods.getDataFromConfigFile(getSutFullFileName(sutFileName));
		getAdditionalConf(sut);

	}

	private void getAdditionalConf(JsonNode sut) {

		Iterator<String> fieldNames = sut.fieldNames();

		String appName = getAppName();
		appName = (StringUtils.isBlank(appName) ? "" : appName + "/");

		String fieldName;
		String path;
		JsonNode additionalConf = jsonMapper.createObjectNode();
		JsonNode temp;

		while (fieldNames.hasNext()) {
			fieldName = fieldNames.next();

			if (fieldName.contains("conf.") && (fieldName.split("\\.").length == 2)) {
				path = testConfigRoot
						+ appName
						+ StringUtils.defaultIfEmpty(getInitialProperty("path.conf." + fieldName.substring(5)),
								fieldName.substring(5)) + "/" + sut.get(fieldName).textValue();
				temp = getConfProperty(path);
				additionalConf = GeneralMethods.mergeProperties(additionalConf, temp);
			}
		}
		sut = GeneralMethods.mergeProperties(sut, additionalConf);
	}

	protected void languageSupportInitiate() {

	}

	protected void platformSupportInitiate(String profileName) {

	}

	protected void applicationSupportInitiate() {

	}

	protected JsonNode getConfProperty(String fileName) {

		JsonNode returnNode = jsonMapper.createObjectNode();
		File checkFile = new File(fileName);
		if (checkFile.exists() && checkFile.isFile())
			returnNode = GeneralMethods.getDataFromConfigFile(fileName);
		else {
			returnNode = null;
		}
		return returnNode;
	}

	protected void loadContentAndLookupProperties() {

	}

	public String getInitialProperty(String propertyKey) {

		return GeneralMethods.getConfigValue(initialConfig, propertyKey);
	}

	private String getDefaultSutFileName() {

		String sutFileKey = String.format("sut.%s.%s.file", getAppName(), getAppType());

		sutFileKey = StringUtils.replace(sutFileKey, "..", ".", -1);

		String rtn = getInitialProperty(sutFileKey);
		if (rtn == null || StringUtils.isEmpty(rtn)) {
			System.out.println("!Warning: can't find any key " + sutFileKey + " in the initial config file. ");
		}
		return rtn;
	}

	protected String getSutPath() {

		String appName = getAppName();

		return projectLevelSutConfigPath.replace("[appname]/", (StringUtils.isBlank(appName) ? "" : appName + "/"));
	}

	protected String getCurrentSutFullFileName() {

		return getSutPath() + sutFileName;
	}

	protected String getSutFullFileName(String SUT) {

		String fileName = StringUtils.defaultString(SUT, getDefaultSutFileName());
		return getSutPath() + fileName;
	}

	public String getProperty(String propertyKey) {

		return GeneralMethods.getConfigValue(sut, propertyKey);
	}

	protected void prepareTestEnvironment() {

	}

	protected String getAppUrl() {

		return appUrl;
	}

	protected String getAppApiUrl() {

		return apiUrl;
	}

	protected JsonNode getJsonNodeMatching(JsonNode nodesToSearch, String fieldName, String regex) {

		for (JsonNode currentNode : nodesToSearch) {

			if (StringUtils.isNotEmpty(currentNode.path(fieldName).textValue()) && StringUtils.isNotEmpty(regex)) {

				if (StringUtils.isNotEmpty(currentNode.path(fieldName).textValue())
						&& currentNode.path(fieldName).textValue().matches(regex)) {

					return currentNode;
				}
			}
		}

		return jsonMapper.createObjectNode();
	}

	public void log(String content, Integer type) {

		switch (type) {
		case 1: {
			System.out.println(GeneralMethods.getCurrentTime() + " (" + Thread.currentThread().getId() + ") INFO - " + content);
			break;
		}
		case 2: {
			System.err.println(GeneralMethods.getCurrentTime() + " (" + Thread.currentThread().getId() + ") ERROR - " + content);
			break;
		}
		case 3: {
			System.out
					.println(GeneralMethods.getCurrentTime() + " (" + Thread.currentThread().getId() + ") WARNING - " + content);
			break;
		}
		case 4: {
			System.err
					.println(GeneralMethods.getCurrentTime() + " (" + Thread.currentThread().getId() + ") WARNING - " + content);
			break;
		}
		}

	}

	public void log(String content) {

		log(content, 1);
	}

	private static void disableLog4jLogs() {

		@SuppressWarnings("unchecked")
		List<Logger> loggers = Collections.<Logger> list(LogManager.getCurrentLoggers());
		loggers.add(LogManager.getRootLogger());
		for (Logger logger : loggers) {
			logger.setLevel(Level.OFF);
		}
	}

}
