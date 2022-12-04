package kodlamaio.hrms.business.concretes;



import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CheckEmployerInformationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class CheckEmployerInformatinManager implements CheckEmployerInformationService{
	
	EmployerDao employerDao;
	
	public CheckEmployerInformatinManager(EmployerDao employerDao) {
		this.employerDao=employerDao;
	}
	
	@Override
	public Result checkAreInformaitonsFull(Employer employer) {
		if(employer.getCompanyName().isEmpty() || employer.getWebsite().isEmpty() 
				|| employer.getEmail().isEmpty() || employer.getPassword().isEmpty()
				|| employer.getPasswordRepeat().isEmpty()) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	@Override
	public Result checkIsEmailUniqe(Employer employer) {
		
		if(employerDao.findByEmail(employer.getEmail()) != null) {
			return new ErrorResult("Email zaten kayıtlı");
		}
		
		
		return new SuccessResult();
	}
	
	@Override
	public Result checkIsPasswordRepeatMatches(Employer employer) {
		
		
			if(employer.getPassword().equals(employer.getPasswordRepeat())) {
				
				return new SuccessResult();
			}
			
			return new ErrorResult("Girdiğiniz şifreler uyuşmuyor");
	}

	/*
	@Override
	public Result checkEmailViaDomain(Employer employer) {
		
		//String email="betul@edit.com";
		//String website="edit.com";
		//String domain = email .substring(email .indexOf("@") + 1);
		//domain.compareTo(website) == 0
		//domain.compareTo(website.substring(website.indexOf(domain))) == 0
		
		String domain=employer.getEmail().substring(employer.getEmail().indexOf("@")+1);
		if(domain.compareTo(employer.getWebsite().substring(employer.getWebsite().indexOf(domain))) == 0) {
			return new SuccessResult();
		}
		return new ErrorResult("Email websiteniz ile aynı domaine sahip değil");
	}
*/
	

	
}
