package tools.socket.req;

public class MultiReq {
	private short req;
	private short setdomain; // 市场分类
	private short coltype;// 股票栏目代码
	private short startxh;
	private short wantnum;// 最多200
	private short sorttype;// 升降序
	private short sortcol;//
	private String blockid;//  对应的模块代码   港股通：5004230002    A+H股：5004210004   恒生旗舰：5004250011
                           //	红筹股：5004210001    国企股： 5004210003
                           //	中概股：5004310001    道琼斯： 2060008303     标普500：2060008307
	private short setCode;
	private String Code;

	public short getSortcol() {
		return sortcol;
	}

	public void setSortcol(short sortcol) {
		this.sortcol = sortcol;
	}

	public short getSetCode() {
		return setCode;
	}

	public void setSetCode(short setCode) {
		this.setCode = setCode;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public final int size() {
		final int size = 12; // 请求长度
		return size;
	}

	public String getBlockid() {
		return blockid;
	}

	public void setBlockid(String blockid) {
		this.blockid = blockid;
	}

	public short getReq() {
		return req;
	}

	public void setReq(short req) {
		this.req = req;
	}

	public short getSetdomain() {
		return setdomain;
	}

	public void setSetdomain(short setdomain) {
		this.setdomain = setdomain;
	}

	public short getColtype() {
		return coltype;
	}

	public void setColtype(short coltype) {
		this.coltype = coltype;
	}

	public short getStartxh() {
		return startxh;
	}

	public void setStartxh(short startxh) {
		this.startxh = startxh;
	}

	public short getWantnum() {
		return wantnum;
	}

	public void setWantnum(short wantnum) {
		this.wantnum = wantnum;
	}

	public short getSorttype() {
		return sorttype;
	}

	public void setSorttype(short sorttype) {
		this.sorttype = sorttype;
	}
}
