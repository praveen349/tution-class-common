package com.tution.common;



public class GenericBackendResponse {

	private boolean s;

	/** The completed in. */
	private long ci;

	/** The error details. */
	private String ed;

	private String msg;

	/** The response code. */

	protected int rc;

	private String d;

	public long getCi() {
		return ci;
	}

	public void setCi(long ci) {
		this.ci = ci;
	}

	public String getEd() {
		return ed;
	}

	public void setEd(String ed) {
		this.ed = ed;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getRc() {
		return rc;
	}

	public void setRc(int rc) {
		this.rc = rc;
	}

	public boolean isS() {
		return s;
	}

	public void setS(boolean s) {
		this.s = s;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}
}


