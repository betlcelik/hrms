package kodlamaio.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CheckCandidateInformationService;
import kodlamaio.hrms.business.abstracts.EmailValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	@Qualifier("checkCandidateInformationManager")
	CheckCandidateInformationService checkCandidateInformationService;
	EmailValidationService emailValidationService;
	CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(@Qualifier("checkCandidateInformationManager")CheckCandidateInformationService checkCandidateInformationService,
			EmailValidationService emailValidationService, CandidateDao candidateDao) {
		super();
		this.checkCandidateInformationService = checkCandidateInformationService;
		this.emailValidationService = emailValidationService;
		this.candidateDao = candidateDao;
	}


	@Override
	public Result signUp(Candidate candidate)  {
	
		
		if(!checkCandidateInformationService.checkAreInformationsFull(candidate).isSuccess()) {
			return new ErrorResult(checkCandidateInformationService.checkAreInformationsFull(candidate).getMessage());
		}  
		if(!checkCandidateInformationService.checkIsEmailUniqe(candidate).isSuccess()) {
			return new ErrorResult(checkCandidateInformationService.checkIsEmailUniqe(candidate).getMessage());
		}
		if(!checkCandidateInformationService.checkIsIdentityNumberUniqe(candidate).isSuccess()) {
			return new ErrorResult(checkCandidateInformationService.checkIsIdentityNumberUniqe(candidate).getMessage());
		}
		
		if(!checkCandidateInformationService.checkIsRealPerson(candidate).isSuccess()) {
			return new ErrorResult(checkCandidateInformationService.checkIsRealPerson(candidate).getMessage());
		}
		if(!checkCandidateInformationService.checkIsPasswordRepeatMatches(candidate).isSuccess()) {
			return new ErrorResult(checkCandidateInformationService.checkIsPasswordRepeatMatches(candidate).getMessage());
		}
		if( !emailValidationService.validateEmail(candidate).isSuccess()) {
			return new ErrorResult( emailValidationService.validateEmail(candidate).getMessage());
		}
		if(!checkCandidateInformationService.checkIsRealPerson(candidate).isSuccess()) {
			return new ErrorResult(checkCandidateInformationService.checkIsRealPerson(candidate).getMessage());
		}

				
			candidateDao.save(candidate);
			return new SuccessResult("Kayıt Başarılı : "+ candidate.getFirstName() + " " + candidate.getLastName());
			
			
		
	}


	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll());
	}

}
