package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailValidationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmailValidationManager implements EmailValidationService {

	@Override
	public Result validateEmail(User user) {
		if(user instanceof Candidate) {
			
			return new SuccessResult("Email doğrulandı : " +((Candidate) user).getEmail());
		} 
		if(user instanceof Employer) {
			
			return new SuccessResult("Email doğrulandı " +((Employer) user).getEmail());
		}
			
		return new ErrorResult("Email doğrulama başarısız ");
	}

}
