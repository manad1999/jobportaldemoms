package com.jobdemo.companyms.company;

import java.util.List;

public interface CompanyService {
	
	public List<Company> findAllCompanies();
	public Company getCompany(Long id);
	public Company updateCompany(Company company, Long id);
	public void createCompany(Company company);
	public boolean deleteCompany(Long id);

}
