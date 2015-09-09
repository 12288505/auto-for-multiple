package tools;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;

import tools.GeneralMethods;


public class ProxyServer {

	private String proxyDomain = "";
	private String proxyPort = "";
	private String systemProxyDomain="";
	private String systemProxyPort="";
	private String proxyUsage="auto";
	
	public ProxyServer(){
		String initialConfigFilePath = StringUtils.defaultString(System.getenv("SeleniumConfigFile"), "conf/AutotestConfig.properties");
		String testRoot = GeneralMethods.getTestRoot();
		JsonNode initialConfig = GeneralMethods.getDataFromConfigFile(testRoot + initialConfigFilePath);
		proxyUsage=GeneralMethods.getConfigValue(initialConfig, "proxyUsage");
		
		try{
			systemProxyDomain=System.getProperty("socksProxyHost").toString();
			systemProxyPort=System.getProperty("socksProxyPort").toString();
		}catch ( Exception e){
			//log("System Proxy Settings Not Found!");
		}
		
		if (proxyUsage.equalsIgnoreCase("manual")){
			proxyDomain=GeneralMethods.getConfigValue(initialConfig, "proxyDomain");
			proxyPort=GeneralMethods.getConfigValue(initialConfig, "proxyPort");
		}
		if (proxyUsage.equalsIgnoreCase("auto")){
			autoProxy();
		}
		if (!proxyDomain.isEmpty()){
			log("Using proxy \""+proxyDomain+":"+proxyPort+"\" to send http calls.");
		}
	}
	
	
	public void setProxy(){
		
		if( proxyUsage.equalsIgnoreCase("disabled") ){
			clearProxy();
		} else {
			
			if (proxyDomain.isEmpty())
			{
				log("No proper Proxy Settings found, Proxy of the system unchanged.",3);
			}
			else
			{
				System.setProperty("socksProxyHost", proxyDomain);
				System.setProperty("socksProxyPort", proxyPort);
				
			}
			
		}
	}
	
	private boolean autoProxy(){
		String testRoot = GeneralMethods.getTestRoot().replace("target/test-classes/", "src/test/resources/data/common/");
		JsonNode proxySettings = GeneralMethods.getDataFromConfigFile(testRoot + "ProxySettings/proxySettings.json");
		
		String ipAddress="";
		try{
			ipAddress= Inet4Address.getLocalHost().getHostAddress();
		}
		catch (UnknownHostException e){
			log("Failed to retrive the ipaddress of the host",3);
			ipAddress="";
		}
		
		if (!ipAddress.isEmpty()){
			String ipPart[] = ipAddress.split("\\.");
			int matchCount = 0;
			int i = 0;
			if(proxySettings.path("configFileType").textValue().equalsIgnoreCase("proxySettings")){
				for(JsonNode currentNode: proxySettings.path("proxyConfigures")){
					String ipPrefixPart[] = currentNode.path("ipPerfix").textValue().split("\\.");
					for (i = 0; i<ipPrefixPart.length; i++)
					{
						if(!ipPrefixPart[i].equalsIgnoreCase(ipPart[i])){
							break;
						}
					}
					if ( i == ipPrefixPart.length && matchCount<i){
						proxyDomain=currentNode.path("proxyDomain").textValue();
						proxyPort=currentNode.path("proxyPort").textValue();
						matchCount = i;
					}
				}
				if (matchCount >0){
					
					return true;
				}
			}
		}
		return false;
	}
	
	public void clearProxy(){
		System.setProperty("socksProxyHost", systemProxyDomain);
		System.setProperty("socksProxyPort", systemProxyPort);
		
	}
	
	private void log(String content, Integer type) {
		switch (type) {
		case 1: {
			System.out.println(GeneralMethods.getCurrentTime() + " INFO - "
					+ content);
			break;
		}
		case 2: {
			System.err.println(GeneralMethods.getCurrentTime() + " ERROR - "
					+ content);
			break;
		}
		case 3: {
			System.out.println(GeneralMethods.getCurrentTime() + " WARNING - "
					+ content);
			break;
		}
		case 4: {
			System.err.println(GeneralMethods.getCurrentTime() + " WARNING - "
					+ content);
			break;
		}
		}

	}

	public void log(String content) {
		log(content, 1);
	}
}
