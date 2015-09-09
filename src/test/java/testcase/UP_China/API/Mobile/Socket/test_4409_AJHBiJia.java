package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4409_AJHBiJia {
	private UP_API up ; 
	@Test
	public void Test4409(){
		up = new UP_API() ; 
		up.getSocketBody(4409) ; 
		for( int i = 1 ; i < 20 ;i++){
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
