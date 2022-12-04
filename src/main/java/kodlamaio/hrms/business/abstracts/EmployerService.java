package kodlamaio.hrms.business.abstracts;


import java.util.List;

import org.springframework.stereotype.Repository;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@Repository
public interface EmployerService {
	
	public Result signUp(Employer employer);
	public DataResult<List<Employer>> getAll();
	
	public Result pasifyJobAdvertisement(Employer employer,int jobAdvertisementId);
	 

}
