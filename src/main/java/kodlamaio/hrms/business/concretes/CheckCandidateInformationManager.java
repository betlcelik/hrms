package kodlamaio.hrms.business.concretes;



import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CheckCandidateInformationService;
import kodlamaio.hrms.business.abstracts.CheckRealPersonService;
import kodlamaio.hrms.business.adapters.MernisAdapter;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CheckCandidateInformationManager implements CheckCandidateInformationService{
	
	
	CandidateDao candidateDao;
	CheckRealPersonService checkRealPersonService;
	

	public CheckCandidateInformationManager(CandidateDao candidateDao,CheckRealPersonService checkRealPersonService) {
		super();
		this.candidateDao = candidateDao;
		this.checkRealPersonService=checkRealPersonService;
	}

	@Override
	public Result checkAreInformationsFull(Candidate candidate) {
		if( candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty() ||
				candidate.getEmail().isEmpty() || candidate.getIdentityNumber().isEmpty() ||
				candidate.getYearOfBirth().isEmpty() || candidate.getEmail().isEmpty() ||
				candidate.getPassword().isEmpty() || candidate.getPasswordRepeat().isEmpty() ) {
			
			return new ErrorResult("Tüm bilgileri eksiksiz girdiğinizden emin olun");
			
		}
		return new SuccessResult();
				
	}

	@Override
	public Result checkIsEmailUniqe(Candidate candidate) {
		
		if(candidateDao.findByEmail(candidate.getEmail()) != null)  {
			return new ErrorResult("Email zaten kayıtlı");
		}
		
		
		return new SuccessResult();
	}

	@Override
	public Result checkIsIdentityNumberUniqe(Candidate candidate) {
		
		if(candidateDao.findByIdentityNumber(candidate.getIdentityNumber()) != null) {
			return new ErrorResult("Kimlik numarası zaten kayıtlı");
		}
		
		return new SuccessResult();
	}

	@Override
	public Result checkIsRealPerson(Candidate candidate) {
		
		
	return	checkRealPersonService.checkIfRealPerson(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getYearOfBirth());
		
	
	}

	@Override
	public Result checkIsPasswordRepeatMatches(Candidate candidate) {
		
	
			if(candidate.getPassword().equals(candidate.getPasswordRepeat())) {
				
				return new SuccessResult();
			}
			
			return new ErrorResult("Girdiğiniz şifreler uyuşmuyor");
	}
	

}
