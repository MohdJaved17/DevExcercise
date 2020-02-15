package info.evolenthealth.InfoApi.service;

import info.evolenthealth.InfoApi.exception.InfoException;
import info.evolenthealth.InfoApi.model.Info;

import java.util.List;



public interface InfoService {

	List<Info> getContacts();

	Info addContact(Info info) throws InfoException;

	Info updateContact(Info info,String contactNo) throws InfoException;

	void removeContact(String contactNo) throws InfoException;

	Info changeStatus(String contactNo, String status) throws InfoException;
	
	

}
