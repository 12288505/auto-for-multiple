package fwk;

import base.APIFramework;

public class UP_API extends APIFramework {

	public UP_API(String apiUrl, String method) {
		super(apiUrl, method);
	}

	public UP_API(String apiUrl) {

		super(apiUrl);
	}
	
	public UP_API(short req ,String code ){
		super(req ,code) ;
	}
	public UP_API() {
		// TODO Auto-generated constructor stub
		super() ;
	}

	protected String getAppName() {

		return "UP_China";
	}

	public String getYeasterdayDate() {

		String[] d = getDate().split("-");
		String day = String.valueOf(Integer.parseInt(d[2]) - 1);
		String date = d[0] + "-" + d[1] + "-" + day;

		return date;
	}

}
