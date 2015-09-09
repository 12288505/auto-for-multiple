package testcase.UP_China.API.Mobile.Socket;
import org.testng.annotations.Test;

import fwk.UP_API;
public class test_4406_ZhuLiCheDanGeGuLieBiao {
	private UP_API up ; 
	@Test
	public void Test4406(){
		up = new UP_API() ; 
		up.getSocketBody(4406) ; 
		for( int i = 1 ; i < 17 ;i++){
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
