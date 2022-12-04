package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.HRMSConfirmationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

@Service
public class HRMSValidationManager implements HRMSConfirmationService{

	@Override
	public Result confirm(Employer employer) {
		return new SuccessResult(employer.getCompanyName());
	}
	

}
