package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import kodlamaio.hrms.business.abstracts.CheckEmployerInformationService;
import kodlamaio.hrms.business.abstracts.EmailValidationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.HRMSConfirmationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class EmployerManager  implements EmployerService{
	
	
	CheckEmployerInformationService checkEmployerInformationService;
	
	HRMSConfirmationService hrmsConfirmationService;
	@Qualifier("emailValidationManager")
	EmailValidationService emailValidationService;
	EmployerDao employerDao;
	JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public EmployerManager(CheckEmployerInformationService checkEmployerInformationService,EmployerDao employerDao,HRMSConfirmationService hrmsConfirmationService,@Qualifier("emailValidationManager")EmailValidationService emailValidationService,JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.checkEmployerInformationService = checkEmployerInformationService;
		this.employerDao=employerDao;
		this.hrmsConfirmationService=hrmsConfirmationService;
		this.emailValidationService=emailValidationService;
		this.jobAdvertisementDao=jobAdvertisementDao;
	}

	@Override
	public Result signUp(Employer employer) {
		
		if(!checkEmployerInformationService.checkAreInformaitonsFull(employer).isSuccess()) {
			return new ErrorResult(checkEmployerInformationService.checkAreInformaitonsFull(employer).getMessage());
		}
		if(!checkEmployerInformationService.checkIsEmailUniqe(employer).isSuccess()) {
			return new ErrorResult(checkEmployerInformationService.checkIsEmailUniqe(employer).getMessage());
		}
		
		/*
		if(!checkEmployerInformationService.checkIsPasswordRepeatMatches(employer).isSuccess()) {
			return new ErrorResult(checkEmployerInformationService.checkIsPasswordRepeatMatches(employer).getMessage());
		}*/
		if(!emailValidationService.validateEmail(employer).isSuccess()) {
			return new ErrorResult(emailValidationService.validateEmail(employer).getMessage());
		}
		if(!hrmsConfirmationService.confirm(employer).isSuccess()) {
			return new ErrorResult(hrmsConfirmationService.confirm(employer).getMessage());
		}
		/*
		if(!checkEmployerInformationService.checkEmailViaDomain(employer).isSuccess()) {
			return new ErrorResult(checkEmployerInformationService.checkEmailViaDomain(employer).getMessage());
		}*/
			employerDao.save(employer);
			return new SuccessResult("Kayıt başarılı : " + employer.getCompanyName());
 	
		
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"List of Employers");
	}

	@Override
	public Result pasifyJobAdvertisement(Employer employer,int jobAdvertisementId) {
		
		JobAdvertisement willBePasified=jobAdvertisementDao.getById(jobAdvertisementId);
		if(willBePasified.getEmployer() == employer) {
			willBePasified.setActive(false);
			return new SuccessResult("İlan kapatıldı");
		}
		return new ErrorResult("Böyle bir ilana sahip değilsiniz");
		
	}
	

}
