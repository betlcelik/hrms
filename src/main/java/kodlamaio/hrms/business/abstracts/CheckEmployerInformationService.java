package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface CheckEmployerInformationService {
	
	public Result checkAreInformaitonsFull(Employer employer);
	public Result checkIsEmailUniqe(Employer employer);
	public Result checkIsPasswordRepeatMatches(Employer employer);
	//public Result checkEmailViaDomain(Employer employer);
	

}
