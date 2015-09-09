package tools.socket;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import tools.socket.req.CombReq;
import tools.socket.req.FlowsReq;
import tools.socket.req.KLineReq;
import tools.socket.req.LineChartReq;
import tools.socket.req.MultiReq;


import tools.socket.req.StockUtils;

import com.google.gson.Gson;

public class ClientSock implements Const {

	public short DEFAULT_K_TYPE = 4;// 默认请求K线类型 日K
	public short DEFAULT_K_MULNUM = 0;
	public short DEFALUT_K_STARTXH = 0;// 偏移点
	private static short DEFAUL_CODE = 0;
	private static byte REQ_DEFAULT_VERSION = 12;
	private static byte REQ_DEFALUT_VALUE = 0;
	private String DEFAULT_CODESTR = "000001";
	private short DEFAULT_CODE = 0;
	private String host = "120.26.66.242"; // 120.26.66.242
	private int port = 9999;
	private static int mainID = 0;
	private static int assID = 0;
	private short Short_Len = 2;
	// private static short req = 4201 ; //要监测的协议号
	private static DataOutputStream dos;
	private static DataInputStream dis;
	private byte[] datacache;
	private Socket mSocket = null;
	private static boolean flag = false;// 断开重连请求刷新界面
	private String code;
	private short req; // 协议号

	// 设置协议号
	public void setReq(short req) {

		this.req = req;
	}

	// 返回协议号
	public short getReq() {

		return this.req;
	}

	public String getCode() {

		return this.code;
	}

	public void setCode(String code) {

		this.code = code;
	}

	// 创建包头
	public byte[] getReqPack(int mainID, int assID, byte[] reqBody) {

		ReqHeader head_req = new ReqHeader();
		short len = (short) reqBody.length;
		head_req.setRawLen(len); // 原始数据长度
		head_req.setPacketLen(len); // 压缩之后的数据长度
		head_req.setVersion(REQ_DEFAULT_VERSION); // REQ_DEFAULT_VERSION ？？？？ 默认值12
		head_req.setCompressed(REQ_DEFALUT_VALUE); // REQ_DEFALUT_VALUE ？？？？ 0
		head_req.setEncrypted(REQ_DEFALUT_VALUE); // REQ_DEFALUT_VALUE 0
		head_req.setReserved(REQ_DEFALUT_VALUE); // REQ_DEFALUT_VALUE 0
		head_req.setMainID(mainID);
		head_req.setAssisID(assID);
		head_req.setPriority(REQ_DEFALUT_VALUE);
		// 请求配置包体部分的字节数组,从TagReqHeader_Request类中获取
		byte[] head = head_req.getTagReqHeader();
		// 用包头包体的总长度 初始化发送数据包 字节数组
		byte[] packet = new byte[head.length + reqBody.length];
		// 填充发送数据包
		System.arraycopy(head, 0, packet, 0, head.length);
		System.arraycopy(reqBody, 0, packet, head.length, reqBody.length);
		return packet;
	}

	// 连接服务器
	public boolean connect() {

		// boolean falg ;
		try {
			closeServer();
			mSocket = new Socket();
			mSocket.setReuseAddress(true);
			mSocket.setTcpNoDelay(true);
			// 如果输入流等待5000毫秒还未获得服务端发送数据，则提示超时，0为永不超时
			mSocket.setSoTimeout(5000);
			// 关闭socket时，底层socket不会直接关闭，会延迟一会，直到发送完所有数据
			// 等待10秒再关闭底层socket连接，0为立即关闭底层socket连接
			mSocket.setSoLinger(true, 0);
			// 设置性能参数，可设置任意整数，数值越大，相应的参数重要性越高（连接时间，延迟，带宽）
			mSocket.setPerformancePreferences(3, 2, 1);

			InetSocketAddress isa = new InetSocketAddress(host, port);
			mSocket.connect(isa, 5000);
			dos = SocketIO.getOutput(mSocket);
			dis = SocketIO.getInput(mSocket);

		} catch (Exception e) {
			flag = true;
			return false;
		} finally {
		}
		return true;
	}

	/**
	 * 关闭socket连接
	 */
	private void closeServer() {

		try {
			dos.close();
			dis.close();
			mSocket.close();
		} catch (Exception ex) {
		}
	}

	// 向服务器发送请求包
	public HQResultData buildRequest(byte[] lpBuf) {

		HQResultData hqRD = new HQResultData();
		datacache = lpBuf;

		if (mSocket != null && (!mSocket.isClosed()) && mSocket.isConnected()) {
			try {
				while (mSocket.isConnected()) {
					dos.write(lpBuf);
					dos.flush();
					byte[] head_b = new byte[37];
					dis.read(head_b, 0, 37);

					ResponseHeader head_ans = new ResponseHeader().Parse(head_b);
					int length = head_ans.getPacketLen();
					int recLen = head_ans.getRawLen();
					int m_compressFlag = head_ans.getCompressed();
					hqRD.setMainID(head_ans.getMainID());
					hqRD.setAssID(head_ans.getAssisID());
					byte[] tempByte = new byte[Const.ANSBUFFER_LEN];
					int i = 0;
					int pos = 0; // 读取到qqhq_b数组中的位置
					while ((i = dis.read(tempByte, pos, length - pos)) != -1) {
						// 可能有网络延迟，循环读取完数据
						// Log.d(TAG, "reading.." + "pos..." + pos + "..i.." +
						// i);
						pos += i;
						if (pos == length)
							break;
					}
					if (m_compressFlag == 0) {
						hqRD.setAnsBuf(new byte[recLen]);
						System.arraycopy(tempByte, 0, hqRD.getAnsBuf(), 0, recLen);

					} else if (m_compressFlag == 1) {
						byte[] m_AnsBuffer = new byte[Const.ANSBUFFER_LEN];
						ByteArrayOutputStream bos = new ByteArrayOutputStream(length);
						Inflater decompresser = new Inflater();
						decompresser.setInput(tempByte);
						int resultLength = 0;

						while (!decompresser.finished()) {
							try {
								resultLength = decompresser.inflate(m_AnsBuffer);
								bos.write(m_AnsBuffer, 0, resultLength);
							} catch (DataFormatException e) {
								e.printStackTrace();
							}
						}
						decompresser.end();
						hqRD.setAnsBuf(new byte[resultLength]);
						System.arraycopy(m_AnsBuffer, 0, hqRD.getAnsBuf(), 0, resultLength);
					}
					break;
				}
			} catch (SocketTimeoutException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return hqRD;
	}

	private HQResultData buildJSONREQ(int mainID, int assID, short req, String jsonstr) {

		// if ( mSocket.isClosed() ||!mSocket.isConnected() /*|| mSocket.isInputShutdown() ||
		// mSocket.isOutputShutdown()*/)
		// {
		connect();
		// }
		byte[] jsonbuf = FormatTransfer.stringToBytes(jsonstr);
		byte[] buf = new byte[jsonbuf.length + Short_LEN];
		int pos = 0; // 插入buf数组的位置
		System.arraycopy(FormatTransfer.toLH(req), 0, buf, pos, Short_LEN); // Short_LEN short 长度 2个字节
		pos += Short_LEN;
		System.arraycopy(jsonbuf, 0, buf, pos, jsonbuf.length);
		byte[] result = getReqPack(mainID, assID, buf); // 创建包头
		return buildRequest(result); // 给服务器发送请求
	}

	public HQResultData reqAreaJSON(int mainID, int assID, short req, String code2) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", code2);

		// EMB_HOTAREA_NREQ 4201协议
		return buildJSONREQ(mainID, assID, req, gson.toJson(map));
	}

	// 请求组合行情 codehead 市场代码 + 股票代码
	public HQResultData reqCombJSON(int mainID, int assID, String codehead, short wantnum) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", wantnum);
		map.put("2", codehead);
		return buildJSONREQ(mainID, assID, EMB_COMBHQ_NREQ, gson.toJson(map));
	}

	public HQResultData reqComb(int mainID, int assID, String codehead, short wantnum) {

		CombReq request = new CombReq();
		byte[] buf = new byte[request.size()];
		request.setReq(Const.EMB_COMBHQ_NREQ);
		request.setCodehead(codehead);
		request.setWantnum(wantnum);
		int pos = 0;
		System.arraycopy(FormatTransfer.toLH(request.getReq()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getWantnum()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		writeCodeHead(buf, pos, request.getCodehead());
		pos += CODE_HEAD_LEN;
		byte[] result = getReqPack(mainID, assID, buf);
		return buildRequest(result);
	}

	public void writeCodeHead(byte[] bye, int pos, String code) {

		int length = code.getBytes().length;
		if (length > CODE_HEAD_LEN)
			length = CODE_HEAD_LEN;
		if (length > 0)
			System.arraycopy(code.getBytes(), 0, bye, pos, length);
		for (int i = length; i < CODE_HEAD_LEN; i++)
			bye[pos + i] = 0;
	}

	/**
	 * @function 请求行情列表 4203
	 * @param mainID
	 * @param assID
	 * @param request
	 * @return
	 */
	public HQResultData reqMultiJSON(int mainID, int assID, MultiReq request) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_MULTIHQ_NREQ);
		map.put("2", request.getSetdomain());
		map.put("3", request.getColtype());
		map.put("4", request.getStartxh());
		map.put("5", request.getWantnum());
		map.put("6", request.getSorttype());
		return buildJSONREQ(mainID, assID, EMB_MULTIHQ_NREQ, gson.toJson(map));
	}

	/**
	 * @function 请求行情列表(简)
	 * @param mainID
	 * @param assID
	 * @param request
	 * @return
	 */
	public HQResultData reqMultiSimpleJSON(int mainID, int assID, MultiReq request) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_MULTIHQ_NREQ_SIMPLE);
		map.put("2", request.getSetdomain());
		map.put("3", request.getColtype());
		map.put("4", request.getStartxh());
		map.put("5", request.getWantnum());
		map.put("6", request.getSorttype());
		return buildJSONREQ(mainID, assID, EMB_MULTIHQ_NREQ_SIMPLE, gson.toJson(map));
	}

	/**
	 * 走势图
	 * 
	 * @param mainID
	 * @param assID
	 * @param codestr
	 * @param setcodestr
	 * @return
	 */
	public HQResultData reqLChartJSON(int mainID, int assID, String codestr, String setcodestr) {

		LineChartReq request = new LineChartReq();
		request.setReq(EMB_ZST_NREQ);
		request.setSetcode(!"".equals(setcodestr) ? Short.parseShort(setcodestr) : 0);
		request.setCode(!"".equals(codestr) ? codestr : DEFAULT_CODESTR);
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", request.getSetcode());
		map.put("2", request.getCode());
		return buildJSONREQ(mainID, assID, EMB_ZST_NREQ, gson.toJson(map));
	}

	/**
	 * K线图
	 * 
	 * @param mainID
	 * @param assID
	 * @param codestr
	 * @param setcodestr
	 * @return
	 */
	public HQResultData reqKChartJSON(int mainID, int assID, String codestr, String setcodestr, short ktype, short startxh,
			short reqnum, boolean btg) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_FXT_NREQ);
		map.put("2", !"".equals(setcodestr) ? Short.parseShort(setcodestr) : DEFAULT_CODE);
		map.put("3", !"".equals(codestr) ? codestr : DEFAULT_CODESTR);
		map.put("4", ktype > -1 ? ktype : DEFAULT_K_TYPE);
		map.put("5", DEFAULT_K_MULNUM);
		map.put("6", startxh > 0 ? startxh : DEFALUT_K_STARTXH);
		map.put("7", reqnum);
		map.put("8", btg);
		return buildJSONREQ(mainID, assID, EMB_FXT_NREQ, gson.toJson(map));
	}

	/**
	 * K线图
	 * 
	 * @param mainID
	 * @param assID
	 * @param codestr
	 *            股票代码
	 * @param setcodestr
	 * @param ktype
	 *            K线类型
	 * @param startxh
	 *            序号
	 * @param reqnum
	 *            请求K线的个数
	 * @return
	 */
	public HQResultData reqKChart(int mainID, int assID, String codestr, String setcodestr, short ktype, short startxh,
			short reqnum) {

		KLineReq request = new KLineReq();
		byte[] buf = new byte[request.size()];
		request.setReq(EMB_FXT_NREQ);
		request.setSetcode(!"".equals(setcodestr) ? Short.parseShort(setcodestr) : DEFAULT_CODE);
		request.setCode(!"".equals(codestr) ? codestr : DEFAULT_CODESTR);
		request.setLinetype(ktype > -1 ? ktype : DEFAULT_K_TYPE);
		request.setMulnum(DEFAULT_K_MULNUM);
		request.setStartxh(startxh > 0 ? startxh : DEFALUT_K_STARTXH);
		request.setWantnum(reqnum);// 请求K线个数
		int pos = 0; // 插入buf数组的位置
		System.arraycopy(FormatTransfer.toLH(request.getReq()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getSetcode()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		writeSTKCode(buf, pos, request.getCode());
		pos += SH_CODE_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getLinetype()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getMulnum()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getStartxh()), 0, buf, pos, Short_LEN);
		pos += Short_LEN;
		System.arraycopy(FormatTransfer.toLH(request.getWantnum()), 0, buf, pos, Short_LEN);
		byte[] result = getReqPack(mainID, assID, buf);
		return buildRequest(result);
	}

	public void writeSTKCode(byte[] bye, int pos, String code) {

		int length = code.getBytes().length;
		if (length > SH_CODE_LEN)
			length = SH_CODE_LEN;
		if (length > 0)
			System.arraycopy(code.getBytes(), 0, bye, pos, length);
		for (int i = length; i < SH_CODE_LEN; i++)
			bye[pos + i] = 0;
	}

	/**
	 * @function 请求[明细]数据
	 * @param arg1
	 * @param arg2
	 * @param sETCODE_STR
	 * @param cODE_STR
	 * @param tICK_REQ_STARTXH
	 * @param tICK_REQ_WANTNUM
	 * @return
	 */
	public HQResultData reqTickJSON(int mainID, int assID, short setcode, String code, short startxh, short wantnum) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", setcode);
		map.put("2", code);
		map.put("3", startxh);
		map.put("4", wantnum);
		return buildJSONREQ(mainID, assID, EMB_TICK_NREQ, gson.toJson(map));
	}

	/**
	 * @function 组合行情同时请求几个股票行情时使用(简)
	 * @return
	 */
	public HQResultData reqCombSimpleJSON(int mainID, int assID, String codehead, short wantnum) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", wantnum);
		map.put("2", codehead);
		return buildJSONREQ(mainID, assID, EMB_COMBHQ_NREQ_SIMPLE, gson.toJson(map));
	}

	/**
	 * @functin 查询 键盘精灵
	 * @param mainID
	 * @param assID
	 * @param keyStr
	 * @return
	 */
	public HQResultData reqSearchJSON(int mainID, int assID, String keyStr) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_SEARCH_REQ);
		map.put("2", keyStr);
		map.put("3", 20);
		return buildJSONREQ(mainID, assID, EMB_SEARCH_REQ, gson.toJson(map));
	}

	/**
	 * @functin 单只股票资金流 1802协议
	 * @param mainID
	 * @param assID
	 * @param keyStr
	 * @return
	 */
	public HQResultData reqFlowsJSON(int mainID, int assID, FlowsReq req) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_FLOWS_REQ);
		map.put("2", req.getPeriod());
		map.put("3", req.getSetcode());
		map.put("4", req.getCode());
		map.put("5", req.getOffset());
		map.put("6", req.getNum());
		map.put("7", req.getResrv());
		return buildJSONREQ(mainID, assID, EMB_FLOWS_REQ, gson.toJson(map));
	}

	/**
	 * 请求码表
	 * 
	 * @param mainID
	 * @param assID
	 * @param req
	 * @return
	 */
	public HQResultData reqDicJSON(int mainID, int assID, FlowsReq req) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_DICTIONARY);
		map.put("2", req.getOffset());
		map.put("3", req.getNum());
		return buildJSONREQ(mainID, assID, EMB_DICTIONARY, gson.toJson(map));
	}

	/**
	 * 请求资金流,DDE决策
	 * 
	 * @param mainID
	 * @param assID
	 * @param req
	 * @param flag
	 *            0 资金流向 1 DDE决策
	 * @return
	 */
	public HQResultData reqFundFlowJSON(int mainID, int assID, FlowsReq req, int flag) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("2", req.getSetcode());
		map.put("3", req.getNum());
		map.put("4", req.getStartxh());
		map.put("5", req.getSorttype());
		map.put("6", req.getColtype());
		short reqFlag = FUND_FLOW;
		if (flag == 0) {
			map.put("1", FUND_FLOW);
			map.put("7", req.getDaytype());
			reqFlag = FUND_FLOW;
		} else {
			map.put("1", DDE);
			reqFlag = DDE;
		}
		return buildJSONREQ(mainID, assID, reqFlag, gson.toJson(map));
	}

	/**
	 * @function 多股资金流
	 * @param mainID
	 * @param assID
	 * @param codehead
	 * @param wantnum
	 * @return
	 */
	public HQResultData reqMultiDdeJSON(int mainID, int assID, String codehead, short wantnum) {

		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", MULTI_DDE);
		map.put("2", wantnum);
		map.put("3", codehead);
		return buildJSONREQ(mainID, assID, MULTI_DDE, gson.toJson(map));
	}
	
	
	/**
	 * @function 请求行情列表 4400
	 * @param mainID
	 * @param assID
	 * @param request
	 * @return
	 */
	public HQResultData reqNewMultiJSON(int mainID, int assID, MultiReq request) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != request.getBlockid() && !"".equals(request.getBlockid().trim())) {
			// 有blockid 没setdomain 随便设置一个港美股的setdomain
			request.setSetdomain(SETDOMAIN_HK);
		}
		// （setdomian+blockid）blockid没有的补空
		StringBuffer info = new StringBuffer();
		info.append(request.getSetdomain());
		if (null == request.getBlockid() || "".equals(request.getBlockid().trim())) {
			info.append("          ");
		} else {
			info.append(request.getBlockid());
		}
		map.put("1", StockUtils.getReqid(request.getSetdomain(), request.getBlockid()));
		map.put("2", request.getSetdomain());
		map.put("3", request.getColtype());
		map.put("4", request.getStartxh());
		map.put("5", request.getWantnum());
		map.put("6", request.getSorttype());
		map.put("7", 1);
		map.put("8", info.toString());
		return buildJSONREQ(mainID, assID, EMB_MULTIHQ_NREQ_NEW, gson.toJson(map));
	}
	
	/**
	 * @function 请求行情列表简版 4410
	 * @param mainID
	 * @param assID
	 * @param request
	 * @return
	 */
	public HQResultData reqNewSimpleMultiJSON(int mainID, int assID, MultiReq request) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != request.getBlockid() && !"".equals(request.getBlockid().trim())) {
			// 有blockid 没setdomain 随便设置一个港美股的setdomain
			request.setSetdomain(SETDOMAIN_HK);
		}
		// （setdomian+blockid）blockid没有的补空
		StringBuffer info = new StringBuffer();
		info.append(request.getSetdomain());
		if (null == request.getBlockid() || "".equals(request.getBlockid().trim())) {
			info.append("          ");
		} else {
			info.append(request.getBlockid());
		}
		map.put("1", StockUtils.getReqid(request.getSetdomain(), request.getBlockid()));
		map.put("2", request.getSetdomain());
		map.put("3", request.getColtype());
		map.put("4", request.getStartxh());
		map.put("5", request.getWantnum());
		map.put("6", request.getSorttype());
		map.put("7", 1);
		map.put("8", info.toString());
		return buildJSONREQ(mainID, assID, EMB_MULTIHQ_NREQ_NEW_SIMPLE, gson.toJson(map));
	}
	
	/**
	 * @function 组合行情同时请求几个股票行情时使用(可扩展简版组合行情)4411
	 * @return
	 */
	public HQResultData reqCombExpandJSON(int mainID, int assID, String codehead, short wantnum) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", wantnum);
		map.put("2", codehead);
		return buildJSONREQ(mainID, assID, EMB_MULTIHQ_NREQ_EXPAND, gson.toJson(map));
	}

	/**
	 * 请求自选DDE  4401 （多股DDE查询）
	 * 
	 * @param mainID
	 * @param assID
	 * @param req
	 * @return
	 */
	public HQResultData reqOptionalDDEJSON(int mainID, int assID, FlowsReq req) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", OPTIONAL_DDE);
		map.put("2", req.getNum());
		map.put("3", req.getCodehead());
		return buildJSONREQ(mainID, assID, OPTIONAL_DDE, gson.toJson(map));
	}
	/**
	 * 请求自选资金
	 * 
	 * @param mainID
	 * @param assID
	 * @param req
	 * @return
	 */
	public HQResultData reqOptionalFundJSON(int mainID, int assID, FlowsReq req) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", OPTIONAL_FUND);
		map.put("2", req.getNum());
		map.put("3", req.getCodehead());
		return buildJSONREQ(mainID, assID, OPTIONAL_FUND, gson.toJson(map));
	}

	
	/**
	 * 拖拉机单个股列表
	 * 
	 * @param mainID
	 * @param assID
	 * @param req
	 * @return
	 */
	public HQResultData reqTractorListJSON(int mainID, int assID, MultiReq req) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", TRACTOR_LIST);
		map.put("2", req.getWantnum());
		map.put("3", req.getStartxh());
		map.put("4", req.getSortcol());
		map.put("5", req.getSorttype());
		return buildJSONREQ(mainID, assID, TRACTOR_LIST, gson.toJson(map));
	}
	
	
	
	/**
	 * 个股拖拉机单明细
	 * 
	 * @param mainID
	 * @param assID
	 * @param req
	 * @return
	 */
	public HQResultData reqTractorDetailJSON(int mainID, int assID, MultiReq req) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", TRACTOR_DETAIL);
		map.put("2", req.getSetCode());
		map.put("3", req.getCode());
		map.put("4", req.getWantnum());
		map.put("5", req.getStartxh());
		map.put("6", req.getSortcol());
		map.put("7", req.getSorttype());
		return buildJSONREQ(mainID, assID, TRACTOR_DETAIL, gson.toJson(map));
	}
	
	
	/**
	 * 顶级挂单个股列表
	 * 
	 * @param mainID
	 * @param assID
	 * @param req
	 * @return
	 */
	public HQResultData reqTopBillListJSON(int mainID, int assID, MultiReq req) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", TOP_BILL_LIST);
		map.put("2", req.getWantnum());
		map.put("3", req.getStartxh());
		map.put("4", req.getSortcol());
		map.put("5", req.getSorttype());
		return buildJSONREQ(mainID, assID, TOP_BILL_LIST, gson.toJson(map));
	}

	/**
	 * 个股顶级挂单明细
	 * 
	 * @param mainID
	 * @param assID
	 * @param req
	 * @return
	 */
	public HQResultData reqTopBillDetailJSON(int mainID, int assID, MultiReq req) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", TOP_BILL_DETAIL);
		map.put("2", req.getSetCode());
		map.put("3", req.getCode());
		map.put("4", req.getWantnum());
		map.put("5", req.getStartxh());
		map.put("6", req.getSortcol());
		map.put("7", req.getSorttype());
		return buildJSONREQ(mainID, assID, TOP_BILL_DETAIL, gson.toJson(map));
	}
	
	

	/**
	 * 主力撤单个股列表
	 * 
	 * @param mainID
	 * @param assID
	 * @param req
	 * @return
	 */
	public HQResultData reqCancelBillListJSON(int mainID, int assID, MultiReq req) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", CANCEL_BILL_LIST);
		map.put("2", req.getWantnum());
		map.put("3", req.getStartxh());
		map.put("4", req.getSortcol());
		map.put("5", req.getSorttype());
		return buildJSONREQ(mainID, assID, CANCEL_BILL_LIST, gson.toJson(map));
	}

	/**
	 * 个股主力撤单明细
	 * 
	 * @param mainID
	 * @param assID
	 * @param req
	 * @return
	 */
	public HQResultData reqCancelBillDetailJSON(int mainID, int assID, MultiReq req) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", CANCEL_BILL_DETAIL);
		map.put("2", req.getSetCode());
		map.put("3", req.getCode());
		map.put("4", req.getWantnum());
		map.put("5", req.getStartxh());
		map.put("6", req.getSortcol());
		map.put("7", req.getSorttype());
		return buildJSONREQ(mainID, assID, CANCEL_BILL_DETAIL, gson.toJson(map));
	}
	
	/**
	 * @function 请求行情列表简版 4409
	 * @param mainID
	 * @param assID
	 * @param request
	 * @return
	 */
	public HQResultData reqAHMultiJSON(int mainID, int assID, MultiReq request) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", EMB_MULTIHQ_NREQ_AH);
		map.put("2", request.getStartxh());
		map.put("3", request.getWantnum());
		map.put("4", request.getColtype());
		map.put("5", request.getSorttype());
		return buildJSONREQ(mainID, assID, EMB_MULTIHQ_NREQ_AH, gson.toJson(map));
	}
	
	
}
