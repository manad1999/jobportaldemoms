package com.jobdemo.companyms.company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	private CompanyService companyService;
	
	public CompanyController(CompanyService companyService)
	{
		this.companyService = companyService;
	}
	
	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies()
	{
		List<Company> allCompany = companyService.findAllCompanies();
		
		return  new ResponseEntity<>(allCompany, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<String> addCompany(@RequestBody Company company)
	{
		companyService.createCompany(company);
		
		return new ResponseEntity<String>("Company Added Successfully", HttpStatus.CREATED);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable Long id)
	{
		Company company = companyService.getCompany(id);
		if(company == null)
		{
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<Company>(company, HttpStatus.OK);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company)
	{
		Company updatedCompany = companyService.updateCompany(company, id);
		
		return new ResponseEntity<Company>(updatedCompany, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id)
	{
		boolean isDeleted = companyService.deleteCompany(id);
		if(isDeleted)
			return new ResponseEntity<String>("Company Deleted Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Company doesn't exists", HttpStatus.NOT_FOUND);
	}
}
