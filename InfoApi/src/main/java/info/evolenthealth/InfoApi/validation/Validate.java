package info.evolenthealth.InfoApi.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import info.evolenthealth.InfoApi.model.Info;

@Component
public class Validate {
	
	private Pattern contactNoPattern=Pattern.compile("^[1-9]\\d{9}$");
	private Pattern namePattern=Pattern.compile("^[(A-Z)(a-z)]*$");
	private Pattern emailPattern=Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	
	private Matcher matcher;
	private boolean validContactNo;
	private boolean validFirstName;
	private boolean validLastName;
	private boolean validEmail;
	private boolean validStatus;
	
	
	
	public boolean validate(Info info){
		
		matcher=contactNoPattern.matcher(info.getContactNo());
		validContactNo=matcher.find();
		
		matcher=namePattern.matcher(info.getFirstName());
		validFirstName=matcher.find();
		
		matcher=namePattern.matcher(info.getLastName());
		validLastName=matcher.find();
		
		matcher=namePattern.matcher(info.getFirstName());
		validFirstName=matcher.find();
		
		matcher=emailPattern.matcher(info.getEmail());
		validEmail=matcher.find();
		
		validStatus=((info.getSTATUS().equalsIgnoreCase("active"))||(info.getSTATUS().equalsIgnoreCase("inactive")))?true:false;
		
		if(validContactNo&&validFirstName&&validLastName&&validEmail&&validStatus)
			return true;
		else 
			return false;
		
		
	}
	
	public List<String> invalidData(){
		List<String> list=new ArrayList<>();
		if(!isValidContactNo())
			list.add("Invalid Contact Number: Number should be 10 digits!");
		if(!isValidEmail())
			list.add("Invalid EmailId!");
		if(!isValidFirstName())
			list.add("Invalid FirstName: Only alphabets are allowed, no spaces!");
		if(!isValidLastName())
			list.add("Invalid LastName: Only alphabets are allowed, no spaces!");
		if(!isValidStatus())
			list.add("Invalid Status Value: allowed values-Active/Inactive");
		
		return list;
	}



	public boolean isValidContactNo() {
		return validContactNo;
	}



	public boolean isValidFirstName() {
		return validFirstName;
	}



	public boolean isValidLastName() {
		return validLastName;
	}



	public boolean isValidEmail() {
		return validEmail;
	}



	public boolean isValidStatus() {
		return validStatus;
	}
	
	
	
		
	

}
