package tools.socket;

public class ResponseHeader {

	private int dwcrc;
	private int Separator;
	private int PacketLen; // 数据包大小（压缩后）
	private int RawLen; // 数据包原始大小

	private byte Version;
	private byte Compressed;
	private byte Encrypted;
	private byte Reserved;

	private int cookie;
	public int MainID; // 客户端携带的一些信息 --- 验证发包和收包是不是匹配
	private int AssisID; // 客户端携带的一些信息 --- 请求包的类型ID，通过他知道其类型
	public byte Priority; // 客户端携带的一些信息 --- 优先级
	public int req;

	private byte[] array_dwcrc = new byte[4];
	private byte[] array_Separator = new byte[4];
	private byte[] array_PacketLen = new byte[4];
	private byte[] array_RawLen = new byte[4];
	private byte[] array_cookie = new byte[4];
	private byte[] array_MainID = new byte[4];
	private byte[] array_AssisID = new byte[4];
	private byte[] array_req = new byte[4];

	public int getDwcrc() {

		return dwcrc;
	}

	public void setDwcrc(int dwcrc) {

		this.dwcrc = dwcrc;
	}

	public int getSeparator() {

		return Separator;
	}

	public void setSeparator(int separator) {

		Separator = separator;
	}

	public int getPacketLen() {

		return PacketLen;
	}

	public void setPacketLen(int packetLen) {

		PacketLen = packetLen;
	}

	public int getRawLen() {

		return RawLen;
	}

	public void setRawLen(int rawLen) {

		RawLen = rawLen;
	}

	public byte getVersion() {

		return Version;
	}

	public void setVersion(byte version) {

		Version = version;
	}

	public byte getCompressed() {

		return Compressed;
	}

	public void setCompressed(byte compressed) {

		Compressed = compressed;
	}

	public byte getEncrypted() {

		return Encrypted;
	}

	public void setEncrypted(byte encrypted) {

		Encrypted = encrypted;
	}

	public byte getReserved() {

		return Reserved;
	}

	public void setReserved(byte reserved) {

		Reserved = reserved;
	}

	public int getCookie() {

		return cookie;
	}

	public void setCookie(int cookie) {

		this.cookie = cookie;
	}

	public int getMainID() {

		return MainID;
	}

	public void setMainID(int mainID) {

		MainID = mainID;
	}

	public int getAssisID() {

		return AssisID;
	}

	public void setAssisID(int assisID) {

		AssisID = assisID;
	}

	public byte getPriority() {

		return Priority;
	}

	public void setPriority(byte priority) {

		Priority = priority;
	}

	public int getReq() {

		return req;
	}

	public void setReq(int req) {

		this.req = req;
	}

	public ResponseHeader Parse(byte[] head_ans) {

		// 从head_ans读取数据的位置
		int pos = 0;

		System.arraycopy(head_ans, 0, array_dwcrc, 0, array_dwcrc.length);
		dwcrc = FormatTransfer.lBytesToInt(array_dwcrc);
		pos += array_dwcrc.length;

		System.arraycopy(head_ans, pos, array_Separator, 0, array_Separator.length);
		Separator = FormatTransfer.lBytesToInt(array_Separator);
		pos += array_Separator.length;

		System.arraycopy(head_ans, pos, array_PacketLen, 0, array_PacketLen.length);
		PacketLen = FormatTransfer.lBytesToInt(array_PacketLen);
		pos += array_PacketLen.length;

		System.arraycopy(head_ans, pos, array_RawLen, 0, array_RawLen.length);
		RawLen = FormatTransfer.lBytesToInt(array_RawLen);
		pos += array_RawLen.length;

		Version = head_ans[pos];
		pos += 1;

		Compressed = head_ans[pos];
		pos += 1;

		Encrypted = head_ans[pos];
		pos += 1;

		Reserved = head_ans[pos];
		pos += 1;

		System.arraycopy(head_ans, pos, array_cookie, 0, array_cookie.length);
		cookie = FormatTransfer.lBytesToInt(array_cookie);
		pos += array_cookie.length;

		System.arraycopy(head_ans, pos, array_MainID, 0, array_MainID.length);
		MainID = FormatTransfer.lBytesToInt(array_MainID);
		pos += array_MainID.length;

		System.arraycopy(head_ans, pos, array_AssisID, 0, array_AssisID.length);
		AssisID = FormatTransfer.lBytesToInt(array_AssisID);
		pos += array_AssisID.length;

		Priority = head_ans[pos];
		pos += 1;

		System.arraycopy(head_ans, pos, array_req, 0, array_req.length);
		req = FormatTransfer.lBytesToInt(array_req);
		pos += array_req.length;

		return ResponseHeader.this;

	}
}
