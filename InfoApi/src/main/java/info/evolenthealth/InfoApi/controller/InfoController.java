package info.evolenthealth.InfoApi.controller;

import info.evolenthealth.InfoApi.exception.InfoException;
import info.evolenthealth.InfoApi.model.Info;
import info.evolenthealth.InfoApi.model.JsonExceptionPayload;
import info.evolenthealth.InfoApi.service.InfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InfoController {
	
	@Autowired
	InfoService serve;
	
	
	/*List all the contacts*/
	@RequestMapping(value="/contacts",
	method=RequestMethod.GET,	
	produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Info>> getInfo(){
		
		
		return new ResponseEntity<List<Info>>(serve.getContacts(),HttpStatus.OK);
		
	}
	
	/*Adding new contact*/
	@RequestMapping(value="/contact",
			method=RequestMethod.POST,	
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
			ResponseEntity<Info> addInfo(@RequestBody Info info) throws InfoException{
		
		
			return new ResponseEntity<Info>(serve.addContact(info),HttpStatus.CREATED);
				
			}
	/*Updating the contact*/
	@RequestMapping(value="/contact/{contactNo}",
			method=RequestMethod.PUT,	
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
			ResponseEntity<Info> updateInfo(@RequestBody Info info,@PathVariable("contactNo") String contactNo) throws InfoException{
			
			serve.updateContact(info,contactNo);
			
			return new ResponseEntity<Info>(serve.addContact(info),HttpStatus.CREATED);
				
			}
	
	@RequestMapping(value="/contact/{contactNo}/{status}",
			method=RequestMethod.PUT,	
			produces=MediaType.APPLICATION_JSON_VALUE)
			ResponseEntity<Info> updateStatus(@PathVariable("contactNo") String contactNo,@PathVariable("status") String status) throws InfoException{
			Info info=serve.changeStatus(contactNo,status);
			//serve.updateContact(info,contactNo);
			
			return new ResponseEntity<Info>(serve.addContact(info),HttpStatus.CREATED);
				
			}
	
	/*deleting a contact*/
	@RequestMapping(value="/contact/{contactNo}",
			method=RequestMethod.DELETE,	
			produces=MediaType.APPLICATION_JSON_VALUE)
			ResponseEntity<Info> deleteInfo(@PathVariable("contactNo") String contactNo) throws InfoException{
			
			serve.removeContact(contactNo);
			
			return new ResponseEntity<Info>(HttpStatus.OK);
				
			}
	
	@ExceptionHandler(InfoException.class)
    public ResponseEntity<JsonExceptionPayload> exceptionHandler(InfoException ex) {
		JsonExceptionPayload error = new JsonExceptionPayload(ex.getErrorList(),ex.getMessage());
        
        return new ResponseEntity<JsonExceptionPayload>(error, HttpStatus.OK);
    }
	
}
