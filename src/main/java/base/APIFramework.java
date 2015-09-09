package base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import tools.GeneralMethods;
import tools.socket.ClientSock;
import tools.socket.Const;
import tools.socket.FormatTransfer;
import tools.socket.HQResultData;
import tools.socket.req.FlowsReq;
import tools.socket.req.MultiReq;
import base.core.UiFramework;

import com.fasterxml.jackson.databind.JsonNode;

@SuppressWarnings("deprecation")
public abstract class APIFramework extends UiFramework {

	private HttpClient client = null;
	private StringEntity entity = null;
	private HttpResponse response = null;
	private String method = "";
	private String path = "";
	private String param = "";
	private String fragment;
	private int code;
	private String body; // 记录要解析的String，里面存储的是JSON格式
	private String requestBody;
	private Map<String, String> headers = new HashMap<String, String>();

	private String host = "";
	private int port;
	private Socket socket;
	private URL url;
	private StringBuffer sb = new StringBuffer();

	public ClientSock m_clientSock = null;
	public String m_strCode; // 代码
	short m_sReq; // 协议号

	protected APIFramework(short m_sReq, String m_strCode) {

		this.m_strCode = m_strCode;
		this.m_sReq = m_sReq;
		m_clientSock = new ClientSock();
	}

	protected APIFramework() {

		m_clientSock = new ClientSock();
	}

	protected String getAppType() {

		return "API";
	}

	protected APIFramework(String apiUrl, String method) {

		this.apiUrl = apiUrl;
		this.method = method;
	}

	protected APIFramework(String apiUrl) {

		try {
			url = new URL(apiUrl);

		} catch (Exception e) {

		}
		this.host = url.getHost();
		this.port = url.getPort();

	}

	public String path(String path) {

		this.path = path.trim();
		return this.path;
	}

	public String getApiPath(String apiName) {

		String apiPath = "";
		for (JsonNode temp : uiMap.path("path")) {
			if (temp.path("apiName").textValue().equalsIgnoreCase(apiName))
				apiPath = temp.path("apiPath").textValue();
			if (!apiPath.isEmpty())
				break;
		}
		if (apiPath.isEmpty())
			throw new RuntimeException("No API path found in Json file.");

		return apiPath;
	}

	public void param(String key, String value) {

		if (!StringUtils.isBlank(this.param)) {
			this.param += "&";
		}
		this.param += key.trim() + "=" + value.trim();
	}

	public void fragment(String info) {

		sb.append(info);
	}

	public void headers(String key, String value) {

		if (host.isEmpty())
			this.headers.put(key.trim(), value.trim());
		else
			sb.append(key + ":" + value);
	}

	public void body(String requestBody) {

		if (host.isEmpty())
			this.requestBody = requestBody.trim();
		else
			sb.append("POST " + body);
	}

	public boolean sendRequest() {

		boolean flag = false;
		if (host.isEmpty()) {
			try {

				client = new DefaultHttpClient();

				client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 600000);
				client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 600000);

				if (!StringUtils.isBlank(path)) {
					apiUrl += path;
				}

				if (!StringUtils.isBlank(param)) {
					apiUrl += "?" + param;
				}

				if (!StringUtils.isBlank(fragment)) {
					apiUrl += "#" + fragment;
				}
				log("The tested API is '" + apiUrl + "'.");

				if (!StringUtils.isBlank(requestBody)) {
					entity = new StringEntity(requestBody);
				}
				if (method.equalsIgnoreCase("GET")) {
					HttpGet get = new HttpGet(apiUrl);
					if (!this.headers.isEmpty()) {
						for (Entry<String, String> header : headers.entrySet()) {
							get.addHeader(header.getKey(), header.getValue());
						}
					}
					response = client.execute(get);
				} else if (method.equalsIgnoreCase("POST")) {
					HttpPost post = new HttpPost(apiUrl);
					if (!this.headers.isEmpty()) {
						for (Entry<String, String> header : headers.entrySet()) {
							post.addHeader(header.getKey(), header.getValue());
						}
					}
					post.setEntity(entity);
					response = client.execute(post);
				} else if (method.equalsIgnoreCase("PUT")) {
					HttpPut put = new HttpPut(apiUrl);
					if (!this.headers.isEmpty()) {
						for (Entry<String, String> header : headers.entrySet()) {
							put.addHeader(header.getKey(), header.getValue());
						}
					}
					put.setEntity(entity);
					response = client.execute(put);
				} else if (method.equalsIgnoreCase("DELETE")) {
					HttpDelete delete = new HttpDelete(apiUrl);
					if (!this.headers.isEmpty()) {
						for (Entry<String, String> header : headers.entrySet()) {
							delete.addHeader(header.getKey(), header.getValue());
						}
					}
					response = client.execute(delete);

				}
				if (apiUrl.contains(".php")) {
					BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "GBK"));
					StringBuffer result = new StringBuffer();
					String line = "";
					while ((line = rd.readLine()) != null) {
						result.append(line + "\r\n");
					}
					body = result.toString();
				} else {
					HttpEntity entity = response.getEntity();
					body = EntityUtils.toString(entity);
				}
			} catch (Exception e) {
			}

			int code = response.getStatusLine().getStatusCode();
			this.code = code;
			if (response != null)
				flag = true;

			client.getConnectionManager().shutdown();
		} else {
			try {
				socket = new Socket(host, port);

				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				sb = new StringBuffer();
				sb.append("Host:" + host + "\r\n").append("Content-Length:11\r\n").append("\r\n");
				out.write(sb.toString());
				out.flush();

				while ((body = in.readLine()) != null)
					flag = true;
			} catch (Exception e) {
				throw new RuntimeException("Send socket API request failed!");
			}
		}

		return flag;
	}

	public String getResponseBody() {

		log("The response body is " + body);
		return body;
	}

	public int getResponseCode() {

		if (code > 200 && code < 400)
			log("The response code is " + code);
		else
			log("The response code is " + code, 2);
		return code;
	}

	public void assertJsonBody(String key) {

		JsonNode target = parseJson(key);
		Assert.assertNotNull(target, "Incorrect response body. The key '" + key + "' is not exesiting.");

		log("Get the key '" + key + "' from body.");
	}

	public String getJsonValue(String key) {

		JsonNode target = parseJson(key);
		String targetValue = "";
		if (key.equalsIgnoreCase("id"))
			targetValue = target.path("Charts").get(key).asText();
		else
			targetValue = target.get(key).asText();

		return targetValue.replace(" ", "");
	}

	private JsonNode parseJson(String key) {

		JsonNode target = null;
		try {
			if (body.contains("{")) {
				if (!body.startsWith("[") && !body.startsWith("{"))
					body = this.body.split("\\(")[1].split("\\)")[0];
			} else {
				body = decode(body);
			}
			JsonNode bodyNode = jsonMapper.readValue(body, JsonNode.class);
			if (body.startsWith("[")) {
				for (JsonNode temp : bodyNode) {
					if (temp.has(key)) {
						target = temp;

						break;
					}
				}
			} else {
				if (bodyNode.has(key)) {
					target = bodyNode;
				}
			}
			if (target == null) {
				for (JsonNode temp : bodyNode) {
					for (JsonNode tempChild : temp) {
						if (tempChild.has(key)) {
							target = tempChild;
							break;
						}

					}
					if (target != null)
						break;
				}
			}
		} catch (Exception e) {

		}
		Assert.assertNotNull(target, "Incorrect response body. The key '" + key + "' is not exesiting.");
		return target;
	}

	public boolean assertBody(String key) {

		boolean validate = false;
		if (body.contains(key)) {
			log("Get '" + key + "' from body.");
			validate = true;
		}
		Assert.assertTrue(validate, "Incorrect response body.");
		return validate;
	}

	private String decode(String code) {

		String decodeValue = "";
		try {
			byte[] decode = Base64.decodeBase64(code.getBytes());
			decodeValue = new String(decode, GeneralMethods.detectCharset(decode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decodeValue;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ********************************************************************************************************************//
	// ****************************************测试协议接口部分成员变量和成员函数的定义**********************************************//

	public String getSocketBody(int protocol) {

		//String resBody = "";
		String startTime = GeneralMethods.getCurrentTime();
		log("Requst time is " + startTime);
		String resBody = "";
		switch (protocol) {

		case 1802:
			resBody = Protocol1802();
			break;

		case 4200:
			resBody = Protocol4200();
			break;

		case 4201:
			resBody = Protocol4201();
			break;
		case 4202:
			resBody = Protocol4202();
			break;
		case 4203:
			resBody = Protocol4203();
			break;
		case 4205:
			resBody = Protocol4205();
			break;
		case 4206:
			resBody = Protocol4206();
			break;
		case 4207:
			resBody = Protocol4207();
			break;
		case 4212:
			resBody = Protocol4212();
			break;
		case 4213:
			resBody = Protocol4213();
			break;
		case 4220:
			resBody = Protocol4220();
			break;
		case 4223:
			resBody = Protocol4223();
			break;
		case 4225:
			resBody = Protocol4225() ; break;
		case 4226:
			resBody = Protocol4226() ; break;
		case 4400:
			resBody = Protolcol4400(); break;
		case 4410:
			resBody = Protolcol4410() ; break;
		case 4411:
			resBody = Protolcol4411() ; break;
		case 4401:
			resBody = Protolcol4401() ; break; 
		case 4402:
			resBody = Protolcol4402() ; break ;
		case 4403:
			resBody = Protolcol4403() ; break ; 
		case 4404:
			resBody = Protolcol4404() ; break ; 
		case 4405 :
			resBody = Protolcol4405() ; break ;
		case 4406:
			resBody = Protolcol4406() ; break ; 
		case 4407:
			resBody = Protolcol4407() ; break ; 
		case 4408:
			resBody = Protolcol4408() ; break;
		case 4409:
			resBody = Protolcol4409() ; break;
		}
		String endTime = GeneralMethods.getCurrentTime();
		int time = Integer.parseInt(endTime.replace(":", "").replace(".", ""))
				- Integer.parseInt(startTime.replace(":", "").replace(".", ""));
		log("The response time is: " + time + "ms.");
		return resBody;
	}


	// 监控4201协议 热门板块
	public String Protocol4201() {

		m_clientSock.setCode(m_strCode);
		m_clientSock.setReq(m_sReq);
		String resultStr = "";
		HQResultData resultData = m_clientSock.reqAreaJSON(123, 2, m_clientSock.getReq(), m_strCode);
		byte[] temp = resultData.getAnsBuf();
		resultStr = FormatTransfer.bytesToString(temp);
		body = resultStr;
		return resultStr;
	}

	// 请求字段
	// Wantnum 最多200
	// Codehead 7位 市场代码1位+6位股票代码
	// 监控组合行情 4202组合行情
	public String Protocol4202() {

		HQResultData resultData = m_clientSock.reqCombJSON(2, 4, "0002626", (short) 100);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		log(body);
		return body;
	}

	// 请求字段
	// Wantnum 最多200
	// Codehead 7位 市场代码1位+6位股票代码
	public String Protocol4203() {

		// 创建 分类行情请求
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.shSetcode); // 市场分类
		request.setColtype((short) Const.CODE_SZAG); // 股票栏目代码
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // 最多200
		request.setSorttype((short) 1);
		HQResultData resultData = m_clientSock.reqMultiJSON(2, 4, request);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		log(body);
		return body;
	}

	// 测试4205协议 （走势图）
	public String Protocol4205() {

		String codestr = "600586"; // 股票代码
		String setcodestr = "1"; // 市场类型
		HQResultData resultData = m_clientSock.reqLChartJSON(2, 3, codestr, setcodestr);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		log(body);
		return body;
	}

	// ********************************************************************************************************************//

	// 监控4206协议 分析数据
	public String Protocol4206() {

		String codestr = "600586";
		String setcodestr = "1";
		short ktype = 4;
		short startxh = 0;
		short reqnum = 200;
		boolean btg = false; // 这个值含义不明

		HQResultData resultData = m_clientSock.reqKChartJSON(2, 3, codestr, setcodestr, ktype, startxh, reqnum, btg);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		log(body);
		return body;
	}

	// 监控4207协议 (Tick)
	public String Protocol4207() {

		short setcode = 1;
		String code = "600586";
		short startxh = 0;
		short wantnum = 200;
		HQResultData resultData = m_clientSock.reqTickJSON(2, 3, setcode, code, startxh, wantnum);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		log(body);
		return body;
	}

	// 监控4212协议 (组合行情)
	public String Protocol4212() {

		HQResultData resultData = m_clientSock.reqCombJSON(2, 4, "0002626", (short) 100);
		byte[] temp = resultData.getAnsBuf();
		body = FormatTransfer.bytesToString(temp);
		log(body);
		return body;
	}

	// 监控4213 分类行情2
	public String Protocol4213() {

		// 创建 分类行情请求
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.shSetcode); // 市场分类
		request.setColtype((short) Const.CODE_SZAG); // 股票栏目代码
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // 最多200
		request.setSorttype((short) 2);
		HQResultData resultData = m_clientSock.reqMultiSimpleJSON(2, 3, request);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		log(body);

		return body;
	}

	// 监控4200协议 键盘精灵
	public String Protocol4200() {

		String keyStr = "zghd"; // 查询中国核电
		HQResultData resultData = m_clientSock.reqSearchJSON(2, 3, keyStr);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		log("4200 键盘精灵： " + body);
		return body;
	}

	// 监控1802协议 单只股票资金流
	public String Protocol1802() {

		FlowsReq flowsReq = new FlowsReq();
		// 填充结构体flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // 市场代码
		flowsReq.setCode("600586"); // 市场+股票代码？？？
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		HQResultData resultData = m_clientSock.reqFlowsJSON(2, 3, flowsReq);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		return body;
	}

	// 监控4220协议 (码表)
	public String Protocol4220() {

		FlowsReq flowsReq = new FlowsReq();
		// 填充结构体flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // 市场代码
		flowsReq.setCode("600586"); // 市场+股票代码？？？
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		HQResultData resultData = m_clientSock.reqDicJSON(2, 3, flowsReq);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());

		log("4220: " + body);
		return body;
	}

	// 监控4223 （多股资金流）
	public String Protocol4223() {

		short wantnum = 100;
		String codehead = "600586";
		HQResultData resultData = m_clientSock.reqMultiDdeJSON(2, 3, codehead, wantnum);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		log("4223 多股资金: " + body);
		return body;
	}

	// 监控4225 (资金)
	public String Protocol4225() {

		int flag = 0;
		FlowsReq flowsReq = new FlowsReq();
		// 填充结构体flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // 市场代码
		flowsReq.setCode("600586"); // 市场+股票代码？？？
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		flowsReq.setDaytype(1); // 1 当日 3三日 5五日 10十日
		HQResultData resultData = m_clientSock.reqFundFlowJSON(2, 3, flowsReq, flag);

		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		log("4225 资金 ： " + body);
		return body;
	}

	// 监控4226 (DDE)
	public String Protocol4226() {

		int flag = 1;
		FlowsReq flowsReq = new FlowsReq();
		// 填充结构体flowsReq
		flowsReq.setPeriod(0);
		flowsReq.setSetcode(1); // 市场代码
		flowsReq.setCode("600586"); // 市场+股票代码？？？
		flowsReq.setStartxh(1);
		flowsReq.setOffset(1);
		flowsReq.setNum(100);
		flowsReq.setDaytype(10); // 1 当日 3三日 5五日 10十日
		HQResultData resultData = m_clientSock.reqFundFlowJSON(2, 3, flowsReq, flag);

		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		log("4226 DDE ： " + body);
		return body;
	}
	
	// 44开头的协议codehead  : 2位市场代码+股票代码  不足两位的空格补全  
	// 监控4400协议 
	public String Protolcol4400(){
		short gpId = 530 ; 
		// 创建 分类行情请求
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.hkSetcode); // 市场分类
		request.setColtype(Const.SETDOMAIN_HK); // 股票栏目代码
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // 最多200
		request.setSorttype((short) 2);
		request.setBlockid(Const.BLOCKID_SH_HK);
		
		HQResultData resultData = m_clientSock.reqNewMultiJSON(2, 3, request);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		log("4400: " + body);
		return body ; 
	}
	
	// 监控4400协议 
	public String Protolcol4410(){
		short gpId = 530 ; 
		// 创建 分类行情请求
		MultiReq request = new MultiReq();
		request.setSetdomain(Const.hkSetcode); // 市场分类
		request.setColtype(Const.SETDOMAIN_HK); // 股票栏目代码
		request.setStartxh((short) 0);
		request.setWantnum((short) 100); // 最多200
		request.setSorttype((short) 2);
		request.setBlockid(Const.BLOCKID_SH_HK);
		
		HQResultData resultData = m_clientSock.reqNewMultiJSON(2, 3, request);
		body = FormatTransfer.bytesToString(resultData.getAnsBuf());
		log("4400: " + body);
		return body ; 
	}
	
	public String Protolcol4411() {
		// TODO Auto-generated method stub
		
		short wantnum = 100;
		String codehead = " 1603169";
		HQResultData resultData = m_clientSock.reqCombExpandJSON(2, 3, codehead, wantnum) ; 
		body = FormatTransfer.bytesToString(resultData.getAnsBuf()) ;
		log("4411 : " + body ) ; 
		return body;
	}
	
	// 监控4401协议 （多股DDE查询）
	public String Protolcol4401(){
		FlowsReq req = new FlowsReq() ; 
		String codehead = " 1603169" ; 
		req.setCodehead(codehead);
		req.setNum(100);
		HQResultData resultData = m_clientSock.reqOptionalDDEJSON(2, 3, req) ; 
		body = FormatTransfer.bytesToString(resultData.getAnsBuf()) ;
		log("4401 : " + body ) ; 
		return body ; 
	}
	
	// 监控4408多股主力资金流查询 
	public String Protolcol4408(){
		FlowsReq req = new FlowsReq() ; 
		String codehead = "002492" ; 
		req.setCodehead(codehead);
		req.setNum(100);
		HQResultData resultData = m_clientSock.reqOptionalFundJSON(2, 3, req) ; 
		body = FormatTransfer.bytesToString(resultData.getAnsBuf()) ;
		log("4408 : " + body ) ; 
		return body ;
	}
	
	// 监控4402协议：  拖拉机单个股列表  
	public String Protolcol4402(){
		MultiReq req = new MultiReq(); 
		req.setWantnum((short)100);
		req.setStartxh((short)0) ;
		req.setSortcol((short)1) ; 
		req.setSorttype((short)1);
		
		HQResultData resultData = m_clientSock.reqTractorListJSON(2, 3, req) ;
		body = FormatTransfer.bytesToString(resultData.getAnsBuf()) ;
		log(" 4402: " + body ) ; 
		return body ; 
	}
	// 监控4403协议：  个股拖拉机单明细 
	public String Protolcol4403(){
		MultiReq req = new MultiReq() ; 
		String code =  "601991" ; 
		req.setSetCode(Const.shSetcode);
		req.setCode(code);
		req.setWantnum((short)(100));
		req.setStartxh((short)0);
		req.setSortcol((short)1) ;
		req.setSorttype((short)1);
		HQResultData resultData = m_clientSock.reqTractorDetailJSON(2, 3, req) ;
		body = FormatTransfer.bytesToString(resultData.getAnsBuf()) ;
		log(" 4403: " + body ) ; 
		
		return body ;
	}
	
	// 监控4404 顶级挂单个股列表
	public String Protolcol4404(){
		MultiReq req = new MultiReq() ; 
		req.setWantnum((short)(100));
		req.setStartxh((short)0);
		req.setSortcol((short)1) ;
		req.setSorttype((short)1);
		HQResultData resultData = m_clientSock.reqTopBillListJSON(2, 3, req) ; 
		body = FormatTransfer.bytesToString(resultData.getAnsBuf()) ; 
		log("4404: " + body ) ; 
		return body ;
	}
	
	// 监控4405  个股顶级挂单明细
	public String Protolcol4405(){
		MultiReq req = new MultiReq() ; 
		String code =  "603001" ; 
		req.setSetCode(Const.shSetcode);
		req.setCode(code);
		req.setWantnum((short)(100));
		req.setStartxh((short)0);
		req.setSortcol((short)1) ;
		req.setSorttype((short)1);
		HQResultData resultData = m_clientSock.reqTopBillDetailJSON(2, 3, req) ;
		body = FormatTransfer.bytesToString(resultData.getAnsBuf()) ;
		log(" 4405: " + body ) ; 
		
		return body ;
	}
	
	// 监控4406 主力撤单个股列表
	public String Protolcol4406(){
		MultiReq req = new MultiReq() ; 
		req.setWantnum((short)100);
		req.setStartxh((short)0) ;
		req.setSortcol((short)1) ;
		req.setSorttype((short)1);
		HQResultData resultData = m_clientSock.reqCancelBillListJSON(2, 4, req) ; 
		body = FormatTransfer.bytesToString(resultData.getAnsBuf()) ; 
		log(" 4406 :" + body ) ; 
		return body ;
	}
	
	// 监控4407 个股主力撤单明细
	public String Protolcol4407(){
		MultiReq req = new MultiReq() ; 
		String code =  "600757" ; 
		req.setSetCode(Const.shSetcode);
		req.setCode(code);
		req.setWantnum((short)(100));
		req.setStartxh((short)0);
		req.setSortcol((short)1) ;
		req.setSorttype((short)1);
		HQResultData resultData = m_clientSock.reqCancelBillDetailJSON(2, 3, req) ;
		body = FormatTransfer.bytesToString(resultData.getAnsBuf()) ;
		log(" 4407: " + body ) ; 
		return body ; 
	}
	
	// 监控4409 （A+H比价）
	public String Protolcol4409(){
		MultiReq req = new MultiReq() ; 
		int mainID = 2 ; 
		int assID = 3 ; 
		req.setWantnum((short)(100));
		req.setStartxh((short)0);
		req.setSortcol((short)1) ;
		req.setSorttype((short)1);
		HQResultData resultData = m_clientSock.reqAHMultiJSON(mainID, assID, req) ;
		body = FormatTransfer.bytesToString(resultData.getAnsBuf()) ;
		log(" 4407: " + body ) ; 
		return body ;
	}
}
