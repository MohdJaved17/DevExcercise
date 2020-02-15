package info.evolenthealth.InfoApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.evolenthealth.InfoApi.dao.InfoDao;
import info.evolenthealth.InfoApi.exception.InfoException;
import info.evolenthealth.InfoApi.model.Info;
import info.evolenthealth.InfoApi.validation.Validate;
@Service
public class InfoServiceImpl implements InfoService {
	
	@Autowired
	InfoDao data;
	@Autowired
	Validate v;

	@Override
	public List<Info> getContacts() {
		
		return (List<Info>) data.findAll();
	}

	@Override
	public Info addContact(Info info) throws InfoException {
		
		if(!v.validate(info))
				throw new InfoException("Contact Information not valid", v.invalidData());
				
		data.save(info);
		return info;
	}

	@Override
	public Info updateContact(Info info,String contactNo) throws InfoException {
		if(!v.validate(info))
			throw new InfoException("Contact Information not valid", v.invalidData());
		info.setContactNo(contactNo);
		data.save(info);
		return info;
	}

	@Override
	public void removeContact(String contactNo) throws InfoException {
		
		if(data.existsById(contactNo))
			data.deleteById(contactNo);
		else
			throw new InfoException("Contact Information doesn't exist", v.invalidData());
		
	}

	@Override
	public Info changeStatus(String contactNo, String status) throws InfoException {
		if(!data.existsById(contactNo))
			throw new InfoException("Contact Information doesn't exist", v.invalidData());
		data.findById(contactNo).get().setSTATUS(status);
		return data.findById(contactNo).get();
	}

}
