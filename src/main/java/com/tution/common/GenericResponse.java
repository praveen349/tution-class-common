package com.tution.common;




public class GenericResponse {

	private boolean s;

	private long ci;

	private String ed;

	private String msg;
	
	private String successMsg;
	
	private String errorDetails;


	protected ResponseCode rc;

	private String d;
	
private String status;
	
	private String url;

	
	private String stateName;
	
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

	public ResponseCode getRc() {
		return rc;
	}

	public void setRc(ResponseCode rc) {
		this.rc = rc;
	}

	public static GenericResponse buildUnSecure() {
		GenericResponse gn = new GenericResponse();
		gn.setRc(ResponseCode.UNSECURE);
		gn.setEd("You are not authorised to access this feature!!");
		return gn;
	}

	public static GenericResponse loginUnSecure() {
		GenericResponse gn = new GenericResponse();
		gn.setRc(ResponseCode.UNSECURE_LOGGED_IN);
		gn.setEd("User logged in from another browser");
		return gn;
	}

	public static GenericResponse tokenExpired() {
		GenericResponse gn = new GenericResponse();
		gn.setRc(ResponseCode.UNSECURE_LOGGED_IN);
		gn.setEd("Your session has expired. Please log in again");
		return gn;
	}
	public static GenericResponse restrictedIP(String state) {
		GenericResponse gn = new GenericResponse();
		gn.setRc(ResponseCode.RESTRICTED_IP);
		gn.setEd("RESTRICTED_IP");
		gn.setStateName(state);
		return gn;
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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	
	
	
}

