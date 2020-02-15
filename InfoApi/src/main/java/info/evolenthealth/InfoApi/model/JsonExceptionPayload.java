package info.evolenthealth.InfoApi.model;

import java.util.List;


public class JsonExceptionPayload {
	
	
	private String msg;
	private List<String> errorList;
	
	
	public List<String> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public JsonExceptionPayload(List<String> errorList, String msg) {
		super();
		this.errorList = errorList;
		this.msg = msg;
	}
	public JsonExceptionPayload() {
		super();
	}
	

	

}
