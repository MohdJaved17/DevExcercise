package info.evolenthealth.InfoApi.exception;

import java.util.List;

public class InfoException extends Exception  {
	
	private String errorMessage;
	private List<String> errorList;
	  
    public String getErrorMessage() {
        return errorMessage;
    }
    
   /* public InfoException(String errorMessage, List<String> list) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }*/

	public List<String> getErrorList() {
		return errorList;
	}

	public InfoException(String errorMessage, List<String> errorList) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorList = errorList;
	}
	

}
