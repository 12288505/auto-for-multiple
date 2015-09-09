package testcase.UP_China.API.Mobile.Socket;
import org.testng.annotations.Test;

import fwk.UP_API;
public class test_4405_GeGuDingJiGuaDanMingXi {
	private UP_API up ; 
	@Test
	public void Test4405(){
		up = new UP_API() ; 
		up.getSocketBody(4405) ; 
		for( int i = 1 ; i < 12 ;i++){
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
