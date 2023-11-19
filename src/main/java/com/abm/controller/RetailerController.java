package com.abm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abm.dto.LoginData;
import com.abm.dto.LoginStatus;
import com.abm.dto.RegistrationStatus;
import com.abm.entity.Retailer;
import com.abm.exception.RetailerException;
import com.abm.repo.RetailerRepository;
import com.abm.service.RetailerService;

@RestController
@RequestMapping("/api/retailer")
@CrossOrigin
public class RetailerController {
	
	
	    @Autowired
	    private RetailerService retailerService;
	    
	    @Autowired
	    private RetailerRepository retailerRepository;
	    
	 
		@PostMapping("/register")
		public RegistrationStatus register(@RequestBody Retailer retailer) {
			try {
				long id = retailerService.register(retailer);
				//return "Customer registered!";
				RegistrationStatus status = new RegistrationStatus();
				status.setStatus(true);
				status.setMessageIfAny("Retailer registered!");
				status.setRetailerId(id);
				return status;
			}
			catch (RetailerException e) {
				RegistrationStatus status = new RegistrationStatus();
				status.setStatus(false);
				status.setMessageIfAny(e.getMessage());
				return status;
			}
		}
		

	    @PostMapping("/login")
		public LoginStatus login(@RequestBody Retailer retailer) {
			try {
				Retailer retailerDetails = retailerService.login(retailer.getEmail(), retailer.getPassword());
				LoginStatus status = new LoginStatus();
				status.setStatus(true);
				status.setName(retailer.getEmail());
				return status;
			}
			catch (RetailerException e) {
				LoginStatus status = new LoginStatus();
				status.setStatus(false);
				status.setMessageIfAny(e.getMessage());
				return status;
			}
		}
	    
	    @GetMapping("/retailerD")
	    public List<Retailer>getAllRetailers() throws RetailerException{
	    	return retailerRepository.findAll();
	    }
	    
	    
	    @DeleteMapping("/delete/{id}")
	    public void deleteRetailer(@PathVariable Long id) {
	    	try {
		    	retailerService.deleteAccountById(id);
	    	}
	    	catch(RetailerException e){
	    		
	    		}
	    	
	    	
	    }

	    	

}
